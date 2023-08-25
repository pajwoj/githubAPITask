package pl.pajwoj.atipera.responses;

import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class NotFound {
    public static ResponseEntity<String> response(HttpServletResponse response) {
        JSONObject body = new JSONObject();
        HttpHeaders headers = new HttpHeaders();

        body.put("Message", "User not found.");
        body.put("status", 404);
        response.setStatus(404);

        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(body.toString(), headers, HttpStatus.NOT_FOUND);
    }
}
