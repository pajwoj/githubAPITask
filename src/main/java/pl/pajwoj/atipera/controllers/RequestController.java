package pl.pajwoj.atipera.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.pajwoj.atipera.responses.Forbidden;
import pl.pajwoj.atipera.responses.NotAcceptable;
import pl.pajwoj.atipera.responses.NotFound;
import pl.pajwoj.atipera.responses.OK;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping(path = "/api")
public class RequestController {
    @GetMapping()
    public ResponseEntity<String> generateRequest(@RequestParam String username, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if (request.getHeader("Accept").equals("application/xml")) return NotAcceptable.response(response);

        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest gitRequest = HttpRequest.newBuilder(URI.create("https://api.github.com/users/" + username + "/repos")).GET().build();

        String reposJSONString = null;

        try {
            HttpResponse<String> gitResponse = client.send(gitRequest, HttpResponse.BodyHandlers.ofString());
            reposJSONString = gitResponse.body();

            if (gitResponse.statusCode() == 404) return NotFound.response(response);

            if (gitResponse.statusCode() == 403) return Forbidden.response(response);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return OK.response(response, new JSONArray(reposJSONString), username);
    }
}
