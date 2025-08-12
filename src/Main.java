import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner prompt = new Scanner(System.in);
        ExchangeRequest request = new ExchangeRequest();

        System.out.println("Ingrese el tipo de moneda");
        var tipoDeMoneda = prompt.nextLine();

        System.out.println("Ingrese la cantidad que dese convertir");
        var cantidad = Integer.valueOf(prompt.nextInt());
        prompt.nextLine();
        System.out.println("Ingrese el tipo de moneda a la que deseas convertirlo");
        var tipoDeConversion = prompt.nextLine();

        ExchangeType exchangeType = request.requestExchange(tipoDeMoneda);

        Double tasa = exchangeType.conversionRates().get(tipoDeConversion.toUpperCase());
        System.out.println("Tipo de cambio:");
        System.out.println(tipoDeMoneda.toUpperCase() + cantidad + " equivale a " + "s/" + cantidad * tasa);

    }
}