package pl.pajwoj.atipera.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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

        HttpRequest gitRequest = HttpRequest.newBuilder(URI.create("https://developer.github.com/v3/users/" + username))
                .GET()
                .build();

        try {
            System.out.println(client.send(gitRequest, HttpResponse.BodyHandlers.ofString()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //user does not exist
        System.out.println();

        //user exists
        System.out.println(username);
        result.put("Message", username);
        result.put("status", 200);
        response.setStatus(200);

        return result.toString();
    }
}
