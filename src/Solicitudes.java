import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Solicitudes {

    public void recibeMoneda(String moneda){




        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/549624902b81bb923503bc26/latest/" + moneda);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();







    }
}
