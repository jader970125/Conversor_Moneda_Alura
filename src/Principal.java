import com.google.gson.Gson;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        double resultado=0;
        double cantidadMoneda=0;
        int opcion=0;

        ConsultarMonedas consultarMonedas = new ConsultarMonedas();
        Monedas monedas = new Monedas(consultarMonedas.buscarMonedas().rates());
        System.out.println("******CHALLENGE CONVERSOR DE MOENDAS ALURA******");
        Scanner teclado = new Scanner(System.in);
        while(opcion != 9){
            System.out.println("1) Dólar =>> Peso Argentino." +
                    "\n2) Peso Argentino =>> Dólar."+
                    "\n3) Dólar =>> Real Brasileño." +
                    "\n4) Real Brasileño =>> Dólar" +
                    "\n5) Dólar =>> Peso Colombiano." +
                    "\n6) Peso Colombiano =>> Dolar" +
                    "\n7) Euro ==> Dolar" +
                    "\n8) Dolar ==> Euro" +
                    "\n9) Salir." +
                    "\n\nElija una opción: ");
            opcion=teclado.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese la cantidad de USD: ");
                    cantidadMoneda = teclado.nextDouble();
                    resultado = cantidadMoneda
                            *monedas.getPesoArgentino();
                    System.out.println("El valor de " + cantidadMoneda +" USD es igual a: " + resultado +" " +
                            "ARS.");
                    System.out.println("********************************");
                    break;
                case 2:
                    System.out.println("Ingrese la cantidad de pesos argentinos: ");
                    cantidadMoneda = teclado.nextDouble();
                    resultado = cantidadMoneda
                            /monedas.getPesoArgentino();
                    System.out.println("El valor de " + cantidadMoneda +" ARS es igual a: "
                            + resultado +" USD");
                    System.out.println("********************************");
                    break;
                case 3:
                    System.out.println("Ingrese la cantidad de USD: ");
                    cantidadMoneda = teclado.nextDouble();
                    resultado = cantidadMoneda
                            *monedas.getRealBrasileno();
                    System.out.println("El valor de " + cantidadMoneda + " USD es igual a: "
                            + resultado +" BRL");
                    System.out.println("********************************");
                    break;
                case 4:
                    System.out.println("Ingrese la cantidad de reales Brasileños: ");
                    cantidadMoneda = teclado.nextDouble();
                    resultado = cantidadMoneda
                            /monedas.getRealBrasileno();
                    System.out.println("El valor de " + cantidadMoneda + " BRL es igual a: "
                            + resultado +" USD");
                    System.out.println("********************************");
                    break;
                case 5:
                    System.out.println("Ingrese la cantidad de USD: ");
                    cantidadMoneda = teclado.nextDouble();
                    resultado = cantidadMoneda
                            *monedas.getPesoColombiano();
                    System.out.println("El valor de " + cantidadMoneda +" USD es igual a: "
                            + resultado +" COP");
                    System.out.println("********************************");
                    break;
                case 6:
                    System.out.println("Ingrese la cantidad de Pesos Colombianos: ");
                    cantidadMoneda = teclado.nextDouble();
                    resultado = cantidadMoneda
                            /monedas.getPesoColombiano();
                    System.out.println("El valor de " + cantidadMoneda + " COP es igual a: "
                            + resultado +" USD");
                    System.out.println("********************************");
                    break;
                case 7:
                    System.out.println("Ingrese la cantidad de USD: ");
                    cantidadMoneda = teclado.nextDouble();
                    resultado = cantidadMoneda
                            *monedas.getEuros();
                    System.out.println("El valor de " + cantidadMoneda +" USD es igual a: "
                            + resultado +" EUR");
                    System.out.println("********************************");
                    break;
                case 8:
                    System.out.println("Ingrese la cantidad de Euros: ");
                    cantidadMoneda = teclado.nextDouble();
                    resultado = cantidadMoneda
                            /monedas.getEuros();
                    System.out.println("El valor de " + cantidadMoneda + " EUR es igual a: "
                            + resultado +" USD");
                    System.out.println("********************************");
                    break;

                case 9:
                    System.out.println("Programa finalizado.");
                    break;


                default:
                    System.out.println("Opcion Invalida. \n");
                    break;

            }
        }
    }
}
