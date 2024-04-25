import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMonedas {

    public MonedaApi buscarMonedas (){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =HttpRequest.newBuilder()
                .uri(URI.create("https://openexchangerates.org/api/latest.json?app_id=be90c266fbeb4616a01e69d51f2a82f5"))
                .build();
        HttpResponse<String> response= null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            MonedaApi json = new Gson().fromJson(response.body(), MonedaApi.class);
            return json;



        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
