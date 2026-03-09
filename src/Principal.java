import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args)  {
        Scanner lectura = new Scanner(System.in);


        System.out.println("""
                **************************************************
                Sea bienvenido/a al Conversor de Moneda =]
                
                1) Dólar ==> Peso argentino
                2) Peso argentino ==> Dólar
                3) Dólar ==> Real brasileño
                4) Real brasileño ==> Dólar
                5) Dólar ==> Peso colombiano
                6) Peso colombiano ==> Dólar
                7) Salir
                
                Elija una opción válida:
                **************************************************
                """);



        try {
            Money money = new Money(lectura.nextInt());

            System.out.println("Ingrese la cantidad que desea convertir: ");

            double valorIngresado = lectura.nextDouble();

            double valorDeCambio = money.cantidadConvertida(valorIngresado);

            System.out.println("El valor: " + valorIngresado + " ["+ money.pair[0] +"]" + " corresponde el valor final de =>>> " + valorDeCambio + " [" +money.pair[1]+ "]");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}


