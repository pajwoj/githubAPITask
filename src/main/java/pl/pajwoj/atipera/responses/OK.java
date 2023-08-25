package pl.pajwoj.atipera.responses;

import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OK {
    public static ResponseEntity<String> response(HttpServletResponse response, JSONArray repos, String username) {
        HttpClient client = HttpClient.newBuilder().build();
        JSONObject body = new JSONObject();
        HttpHeaders headers = new HttpHeaders();

        response.setStatus(200);
        body.put("status", 200);

        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONArray reposArray = new JSONArray();

        for (int i = 0; i < repos.length(); i++) {
            JSONObject current = repos.getJSONObject(i);
            if (current.get("fork").equals("true")) continue;

            else {
                JSONObject repo = new JSONObject();

                repo.put("name", current.get("name"));
                repo.put("owner", current.getJSONObject("owner").get("login"));

                HttpRequest branchRequest = HttpRequest.newBuilder(URI.create("https://api.github.com/repos/" + username + "/" + current.get("name") + "/branches")).GET().build();

                String branchesJSONString = null;

                try {
                    HttpResponse<String> branchResponse = client.send(branchRequest, HttpResponse.BodyHandlers.ofString());
                    branchesJSONString = branchResponse.body();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                JSONArray branches = new JSONArray(branchesJSONString);
                JSONArray branchArray = new JSONArray();

                for (int j = 0; j < branches.length(); j++) {
                    JSONObject branch = branches.getJSONObject(j);
                    JSONObject branchInfo = new JSONObject();

                    branchInfo.put("name", branch.get("name"));
                    branchInfo.put("sha", branch.getJSONObject("commit").get("sha"));

                    branchArray.put(branchInfo);
                }

                repo.put("branches", branchArray);

                reposArray.put(repo);
            }
        }

        body.put("repos", reposArray);

        return new ResponseEntity<>(body.toString(), headers, HttpStatus.OK);
    }
}
