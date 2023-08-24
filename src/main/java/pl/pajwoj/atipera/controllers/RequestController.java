package pl.pajwoj.atipera.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping(path = "/api")
public class RequestController {
    @GetMapping(
            produces = "application/json"
    )
    public String generateRequest(@RequestParam String username, HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();

        //does not really work due to "produces" annotation, still returns 406
        if(request.getHeader("Accept").equals("application/xml")) {
            result.put("Message", "Request does not produce XML.");
            result.put("status", 406);
            response.setStatus(406);
            return result.toString();
        }

        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest gitRequest = HttpRequest.newBuilder(URI.create("https://api.github.com/users/" + username + "/repos"))
                .GET()
                .build();

        try {
            HttpResponse<String> gitResponse = client.send(gitRequest, HttpResponse.BodyHandlers.ofString());

            if(gitResponse.statusCode() == 404) {
                result.put("Message", "User not found.");
                result.put("status", 404);
                response.setStatus(404);
            }

            if(gitResponse.statusCode() == 403) {
                JSONObject responseJSON = new JSONObject(gitResponse.body());
                result.put("Message", responseJSON.get("message"));
                result.put("status", 403);
                response.setStatus(403);
            }

            else {
                //user exists
                result.put("status", 200);
                response.setStatus(200);

                JSONArray responseJSON = new JSONArray(gitResponse.body());
                JSONArray reposArray = new JSONArray();

                for(int i=0; i<responseJSON.length(); i++) {
                    JSONObject current = responseJSON.getJSONObject(i);
                    if(current.get("fork").equals("true")) continue;

                    else {
                        JSONObject repo = new JSONObject();

                        repo.put("name", current.get("name"));
                        repo.put("owner", current.getJSONObject("owner").get("login"));

                        HttpRequest branchRequest = HttpRequest.newBuilder(URI.create("https://api.github.com/repos/" + username + "/" + current.get("name") + "/branches"))
                                .GET()
                                .build();

                        HttpResponse<String> branchResponse = client.send(branchRequest, HttpResponse.BodyHandlers.ofString());
                        JSONArray branchResponseJSON = new JSONArray(branchResponse.body());
                        JSONArray branchArray = new JSONArray();

                        for(int j=0; j<branchResponseJSON.length(); j++) {
                            JSONObject branch = branchResponseJSON.getJSONObject(j);
                            JSONObject branchInfo = new JSONObject();

                            branchInfo.put("name", branch.get("name"));
                            branchInfo.put("sha", branch.getJSONObject("commit").get("sha"));

                            branchArray.put(branchInfo);
                        }

                        repo.put("branches", branchArray);

                        reposArray.put(repo);
                    }

                }

                result.put("repos", reposArray);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}
