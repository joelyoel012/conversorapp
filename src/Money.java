import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Money {
    private String result;
    int option;
    public String[] pair;
    String ApiKey = "26fef7293f8be0cfbc56fd2d";

    public Money(int option) {
        this.option = option;
        pair = CURRENCY_PAIRS.get(option);
    }

    static final Map<Integer, String[]> CURRENCY_PAIRS = Map.of(
            1, new String[]{"USD", "ARS"},  // Dólar => Peso argentino
            2, new String[]{"ARS", "USD"},  // Peso argentino => Dólar
            3, new String[]{"USD", "BRL"},  // Dólar => Real brasileño
            4, new String[]{"BRL", "USD"},  // Real brasileño => Dólar
            5, new String[]{"USD", "COP"},  // Dólar => Peso colombiano
            6, new String[]{"COP", "USD"}   // Peso colombiano => Dólar
    );


    public ExchangeRateApi getExchangeRate(String apiKey) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + pair[0] + "/" + pair[1]))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        return gson.fromJson(response.body(), ExchangeRateApi.class);
    }

    public double cantidadConvertida(double valorIngresado) throws IOException, InterruptedException {
        return getExchangeRate(ApiKey).conversion_rate() * valorIngresado;
    }
    @Override
    public String toString() {
        return "Result: " + result + ", Conversion Rate: ";
    }
}
