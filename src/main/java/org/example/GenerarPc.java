package org.example;
import java.util.Arrays;
import java.util.Scanner;
public class GenerarPc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Computadora computadora = new Computadora();
        String [][] componentesPc = new String[][]{{"AAA", "Placa Madre", "20000", "S"},
                                                    {"BBB", "Procesador","25000", "S"},
                                                    {"CCC", "Memoria RAM", "5000", "S"},
                                                    {"DDD", "Placa de Red", "3000", "N"},
                                                    {"EEE", "Disco Rigido SSD", "22000", "S"},
                                                    {"FFF", " Placa de Video", "42000", "N"},
                                                    {"GGG","Monitor Led 21", "32000", "N"},
                                                    {"HHH", "Monitor Led 25", "41000", "N"},
                                                    {"JJJ", "Kit" + "Teclado - Mouse", "9000", "N"},
                                                    {"KKK", "Gabinete", "6500", "S"},
                                                    {"LLL", "Fuente" + "Alimentación", "6500", "S"},
                                                    {"MMM", "Placa de Sonido", "16500", "N"}};


        menu(componentesPc,sc,computadora);
    }

    public static void menu(String[][] componentesPc, Scanner sc, Computadora computadora){

        System.out.println(Arrays.deepToString(componentesPc));

        System.out.println("-------------------------------------------");
        System.out.println("Ingrese los componentes de la computadora");
        System.out.println("-------------------------------------------");
        System.out.println("Ingrese la marca de la computadora ");
        computadora.setMarca(sc.nextLine());
        System.out.println("Ingrese el modelo de la computadora: ");
        computadora.setModelo(sc.nextLine());

        System.out.println("------------------------------------");

        cargaCodigoDeBarra(computadora,sc);

        System.out.println("------------------------------------");

        cargaCantidadComponentes(computadora,sc);


        System.out.println("---- Componentes de la Computadora ---- ");

        solicitarComponentes(computadora,componentesPc,sc);

        System.out.println("Componentes cargados:");

        for (String[] componente : computadora.getComponentes()) {
            System.out.println(String.join(", ", componente));
        }
    }

    public static void  cargaCodigoDeBarra(Computadora computadora, Scanner sc){
        long codigoDeBarra;

        System.out.print("Ingrese el código de barras (de 7 a 15 caracteres): ");
        codigoDeBarra = sc.nextLong();
        if (String.valueOf(codigoDeBarra).length() >= 7 && String.valueOf(codigoDeBarra).length() <= 15){
            computadora.setCodigoBarras(codigoDeBarra);
            System.out.println("------------------------------------------");
            System.out.println("codigo ingresado con exito");
            System.out.println("------------------------------------------");
        }else {
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("ERROR; el codigo ingresado es erroneo, por vafor ingreselo nuevamente");
            System.out.println("----------------------------------------------------------------------------------------");
            cargaCodigoDeBarra(computadora,sc);
        }
    }

    public static void cargaCantidadComponentes( Computadora computadora, Scanner sc){
        int cantidad;

        System.out.println("ingrese la cantidad de componentes de la computadora ( de 5 a 12 max)");
        cantidad = sc.nextInt();
        if (cantidad >= 5 && cantidad <= 12) {
            computadora.agregarComponentes(cantidad);
            System.out.println("------------------------------------------");
            System.out.println("Se a  ingresado la cantidad correctamente");
            System.out.println("------------------------------------------");
        } else {
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("ERROR; la cantidad ingresada no coincide con los parametros, por vafor ingreselo nuevamente");
            System.out.println("----------------------------------------------------------------------------------------");
            cargaCantidadComponentes(computadora, sc);
        }
    }


    public  static  void  solicitarComponentes(Computadora computadora, String[][] componentesPc, Scanner sc){

        for (int i = 0; i < computadora.getComponentes().length;i++){
            System.out.println("Ingrese el codigo del componente");
            int codigo = sc.nextInt();

            String[] resultado= buscarCodigo(componentesPc, String.valueOf(codigo));

            if (resultado== null){
                System.out.println("El codigo ingresado no existe, por favor intetnelo de nuevo");
                solicitarComponentes(computadora,componentesPc,sc);
            } else if (yaAgregado(computadora.getComponentes(),codigo)) {
                System.out.println("ERROR;El codigo ingresado ya exsite");
            } else {
                computadora.getComponentes()[i]=resultado;
                System.out.println("el codigo fue encontrado "+ resultado[i]);
            }

        }
    }

    public static String[] buscarCodigo(String[][] componentesPc, String codigoBuscado) {
        for (String[] c : componentesPc) {
            if (c[0].equalsIgnoreCase(codigoBuscado)) {
                return c;
            }
        }
        return null;
    }

    public static boolean yaAgregado(String[][] componentes, int codigo){
        for (String[] componente : componentes) {
            if (componente != null && componente[0].equalsIgnoreCase(String.valueOf(codigo))) {
                return true;
            }
        }
        return false;
    }
}