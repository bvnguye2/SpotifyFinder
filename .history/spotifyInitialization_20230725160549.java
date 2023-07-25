import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.io.IOException;
import java.util.HashMap;
package com.zetcode;

import com.fasterxml.jackson.databind.ObjectMapper;

public class spotifyInitialization{

    public static void spotifyInitialization(String[] args){
        final String clientID = "81cdb9e4481447258288291ce212ea2f";
        final String clientSecret = "dc89d4ab05104367a4761d49b69dfaf4";

        String apiToken = getToken(clientID, clientSecret);
    }

    public static String getToken(String iD, String secret){
        var values = new HashMap<String, String>() {{
            put("grant_type", "client_credentials");
            put("client_id", iD);
            put("client_secret", secret);
        }};

        var objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writeValueAsString(values);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://accounts.spotify.com/api/token"))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("content-type", "application/x-www-form-urlencoded")
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

    }

}