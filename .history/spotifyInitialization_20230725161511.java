import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.net.URI;
import java.io.IOException;
import java.util.HashMap;

public class spotifyInitialization{

    public static void main(String[] args){
        final String clientID = "81cdb9e4481447258288291ce212ea2f";
        final String clientSecret = "dc89d4ab05104367a4761d49b69dfaf4";

        String apiToken = getToken(clientID, clientSecret);
    }

    public static String getToken(String iD, String secret){
        String payload = String.format("""
                data={
                    "grant_type": "client_credentials",
                    "client_id": %s,
                    "client_secret": %s
                }
                """,iD, secret);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://accounts.spotify.com/api/token"))
                .POST(HttpRequest.BodyPublishers.ofString(payload))
                .header("content-type", "application/x-www-form-urlencoded")
                .build();

       
		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(response.body());

        return "ABC";
	}
}