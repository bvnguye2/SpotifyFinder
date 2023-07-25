import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.io.IOException;

public class Main{

    public static void spotifyInitialization(String[] args){
        final String clientID = "81cdb9e4481447258288291ce212ea2f";
        final String clientSecret = "dc89d4ab05104367a4761d49b69dfaf4";

        String apiToken = getToken(clientID, clientSecret);
    }

    public String getToken(String iD, String secret){
        Map<Object, Object> data = new HashMap<>();
        data.put("grant_type","client_credentials");
        data.put("client_id", iD);
        data.put("client_secret", secret);

        HttpClient httpClient = HttpClients.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://accounts.spotify.com/api/token"))
            .header("Content-Type", "application/x-www-form-urlencoded")
            .POST(buildFormDataFromMap(data))
            .build();

    }

}