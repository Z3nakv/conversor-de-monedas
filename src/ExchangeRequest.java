import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRequest {
    public ExchangeType requestExchange ( String exchange ) {
        var YOUR_API_KEY = "4e9634a8fb0728dfb00ebda9";
        String url_str = "https://v6.exchangerate-api.com/v6/" + YOUR_API_KEY + "/latest/";
        URI direccion = URI.create(url_str + exchange);

        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ExchangeType.class);
        } catch (Exception e){
            throw new RuntimeException("No se encontro esa moneda");
        }
    }
}
