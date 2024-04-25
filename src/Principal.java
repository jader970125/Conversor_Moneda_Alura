import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {

        double resultado=0;
        double cantidadMoneda=0;
        int opcion=0;
        String textoHistorial = "";
        String mensajeConversion;


        ConsultarMonedas consultarMonedas = new ConsultarMonedas();
        Monedas monedas = new Monedas(consultarMonedas.buscarMonedas().rates());
        System.out.println("******CHALLENGE CONVERSOR DE MOENDAS ALURA******");
        Scanner teclado = new Scanner(System.in);
        while(opcion != 9){
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String horaConFormato = now.format(formatter);

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
            try{
                opcion=teclado.nextInt();
                switch (opcion){
                    case 1:
                        System.out.println("Ingrese la cantidad de USD: ");
                        cantidadMoneda = teclado.nextDouble();
                        resultado = cantidadMoneda
                                *monedas.getPesoArgentino();
                        mensajeConversion = "El valor de " + cantidadMoneda +" USD es igual a: " + resultado +" " +
                                "ARS.";
                        textoHistorial += "\n"+horaConFormato+" ------ "+mensajeConversion;
                        System.out.println(mensajeConversion);
                        System.out.println("********************************");
                        break;
                    case 2:
                        System.out.println("Ingrese la cantidad de pesos argentinos: ");
                        cantidadMoneda = teclado.nextDouble();
                        resultado = cantidadMoneda
                                /monedas.getPesoArgentino();
                        mensajeConversion="El valor de " + cantidadMoneda +" ARS es igual a: "
                                + resultado +" USD";
                        textoHistorial += "\n"+horaConFormato+" ------ "+mensajeConversion;
                        System.out.println(mensajeConversion);
                        System.out.println("********************************");
                        break;
                    case 3:
                        System.out.println("Ingrese la cantidad de USD: ");
                        cantidadMoneda = teclado.nextDouble();
                        resultado = cantidadMoneda
                                *monedas.getRealBrasileno();
                        mensajeConversion="El valor de " + cantidadMoneda + " USD es igual a: "
                                + resultado +" BRL";
                        textoHistorial += "\n"+horaConFormato+" ------ "+mensajeConversion;
                        System.out.println(mensajeConversion);
                        System.out.println("********************************");
                        break;
                    case 4:
                        System.out.println("Ingrese la cantidad de reales Brasileños: ");
                        cantidadMoneda = teclado.nextDouble();
                        resultado = cantidadMoneda
                                /monedas.getRealBrasileno();
                        mensajeConversion="El valor de " + cantidadMoneda + " BRL es igual a: "
                                + resultado +" USD";
                        textoHistorial += "\n"+horaConFormato+" ------ "+mensajeConversion;
                        System.out.println(mensajeConversion);
                        System.out.println("********************************");
                        break;
                    case 5:
                        System.out.println("Ingrese la cantidad de USD: ");
                        cantidadMoneda = teclado.nextDouble();
                        resultado = cantidadMoneda
                                *monedas.getPesoColombiano();
                        mensajeConversion="El valor de " + cantidadMoneda +" USD es igual a: "
                                + resultado +" COP";
                        textoHistorial += "\n"+horaConFormato+" ------ "+mensajeConversion;
                        System.out.println(mensajeConversion);
                        System.out.println("********************************");
                        break;
                    case 6:
                        System.out.println("Ingrese la cantidad de Pesos Colombianos: ");
                        cantidadMoneda = teclado.nextDouble();
                        resultado = cantidadMoneda
                                /monedas.getPesoColombiano();
                        mensajeConversion="El valor de " + cantidadMoneda + " COP es igual a: "
                                + resultado +" USD";
                        textoHistorial += "\n"+horaConFormato+" ------ "+mensajeConversion;
                        System.out.println(mensajeConversion);
                        System.out.println("********************************");
                        break;
                    case 7:
                        System.out.println("Ingrese la cantidad de USD: ");
                        cantidadMoneda = teclado.nextDouble();
                        resultado = cantidadMoneda
                                *monedas.getEuros();
                        mensajeConversion="El valor de " + cantidadMoneda +" USD es igual a: "
                                + resultado +" EUR";
                        textoHistorial += "\n"+horaConFormato+" ------ "+mensajeConversion;
                        System.out.println(mensajeConversion);
                        System.out.println("********************************");
                        break;
                    case 8:
                        System.out.println("Ingrese la cantidad de Euros: ");
                        cantidadMoneda = teclado.nextDouble();
                        resultado = cantidadMoneda
                                /monedas.getEuros();
                        mensajeConversion="El valor de " + cantidadMoneda + " EUR es igual a: "
                                + resultado +" USD";
                        textoHistorial += "\n"+horaConFormato+" ------ "+mensajeConversion;
                        System.out.println(mensajeConversion);
                        System.out.println("********************************");
                        break;

                    case 9:
                        System.out.println("Programa finalizado.");
                        break;


                    default:
                        System.out.println("Opcion Invalida. \n");
                        break;

                }
            } catch (InputMismatchException e){
                System.out.println("Ingrese solo numeros que esten disponibles en el menu.");
                break;
            }
            FileWriter historialCambios =new FileWriter("historialCambios.txt");
            historialCambios.write(textoHistorial);
            historialCambios.close();
        }
    }
}
