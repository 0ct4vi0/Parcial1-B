package org.example;
import java.util.Scanner;
public class GenerarPc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [][] componentesPc = {{"AAA","Placa Madre", "20000", "S"} , {"BBB","Procesador" ,
                "25000" , "S"} , {"CCC","Memoria RAM", "5000" , "S"} , {"DDD","Placa de Red", "3000" , "N"}
                , {"EEE","Disco Rigido SSD", "22000" , "S"} , {"FFF"," Placa de Video", "42000" , "N"} , {"GGG",
                "Monitor Led 21", "32000" , "N"} , {"HHH","Monitor Led 25", "41000" , "N"} , {"JJJ","Kit"+
                "Teclado - Mouse", "9000", "N"} , {"KKK","Gabinete", "6500" , "S"}, {"LLL","Fuente" +
                "Alimentación", "6500" , "S"}, {"MMM","Placa de Sonido", "16500" ,"N"}};

        Computadora computadora = new Computadora();
        menu(componentesPc,sc,computadora);
    }

    public static void menu(String[][] componentesPc, Scanner sc, Computadora computadora){
        System.out.println("-------------------------------------------");
        System.out.println("Ingrese los componentes de la computadora");
        System.out.println("-------------------------------------------");
        System.out.println("Ingrese la marca de la computadora ");
        String marca= sc.nextLine();
        System.out.println("Ingrese el modelo de la computadora: ");
        String modelo = sc.nextLine();
        System.out.println("Ingrese el codigo de barra: ");
        long codigoDeBarra = sc.nextLong();

        validarCodigoDeBarra(codigoDeBarra);

        System.out.println("------------------------------------");
        System.out.println("ingrese la cantidad de componentes de la computadora");
        int cantidad = sc.nextInt();

        validarCantidadComponentes(cantidad);
    }

    public static void  validarCodigoDeBarra(long codigoDeBarra){
        if (codigoDeBarra > 7 || codigoDeBarra <15){
            System.out.println("El codigo de barra fue ingresada correctamente");
        }else {
            System.out.println("codigo de barra incorrecto, tiene que ingresear un codigo que corresponda");
        }
    }

    public static void validarCantidadComponentes(int cantidad){
        if (cantidad >= 5 || cantidad <=12){
            System.out.println("Cantidad ingresada correctamente");
        }else {
            System.out.println("Cantidad de componentes erronea, por favor ingrese nuevamente");
        }
    }
}
//import java.util.Scanner;
//
//public class GeneraPC {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        // Array de componentes disponibles
//        String[][] componentesPc = {
//                {"AAA", "Placa Madre", "20000", "S"},
//                {"BBB", "Procesador", "25000", "S"},
//                {"CCC", "Memoria RAM", "5000", "S"},
//                {"DDD", "Placa de Red", "3000", "N"},
//                {"EEE", "Disco Rigido SSD", "22000", "S"},
//                {"FFF", "Placa de Video", "42000", "N"},
//                {"GGG", "Monitor Led 21", "32000", "N"},
//                {"HHH", "Monitor Led 25", "41000", "N"},
//                {"JJJ", "Kit Teclado - Mouse", "9000", "N"},
//                {"KKK", "Gabinete", "6500", "S"},
//                {"LLL", "Fuente Alimentación", "6500", "S"},
//                {"MMM", "Placa de Sonido", "16500", "N"}
//        };
//
//        // Instancia de la clase Computadora
//        Computadora computadora = new Computadora();
//
//        // a) Pedir datos al usuario
//        System.out.print("Ingrese la marca de la computadora: ");
//        computadora.setMarca(sc.nextLine());
//
//        System.out.print("Ingrese el modelo de la computadora: ");
//        computadora.setModelo(sc.nextLine());
//
//        long codigoBarras;
//        do {
//            System.out.print("Ingrese el código de barras (7-15 caracteres): ");
//            codigoBarras = sc.nextLong();
//        } while (String.valueOf(codigoBarras).length() < 7 || String.valueOf(codigoBarras).length() > 15);
//        computadora.setCodigoBarras(codigoBarras);
//
//        // b) Validar cantidad de componentes
//        int cantidadComponentes;
//        do {
//            System.out.print("Ingrese la cantidad de componentes (entre 5 y 12): ");
//            cantidadComponentes = sc.nextInt();
//        } while (cantidadComponentes < 5 || cantidadComponentes > 12);
//
//        computadora.inicializarComponentes(cantidadComponentes);
//
//        // c) Agregar componentes
//        sc.nextLine(); // Limpiar buffer
//        for (int i = 0; i < cantidadComponentes; i++) {
//            System.out.println("Componentes de la Computadora:");
//            System.out.print("Ingrese el código del componente: ");
//            String codigo = sc.nextLine();
//
//            boolean encontrado = false;
//            for (String[] componente : componentesPc) {
//                if (componente[0].equalsIgnoreCase(codigo)) {
//                    computadora.getComponentes()[i] = componente;
//                    encontrado = true;
//                    break;
//                }
//            }
//            if (!encontrado) {
//                System.out.println("El código ingresado es incorrecto. Intente de nuevo.");
//                i--; // Repetir iteración
//            }
//        }
//
//        // e) Verificar componentes obligatorios
//        boolean faltaObligatorio = false;
//        for (String[] componente : componentesPc) {
//            if (componente[3].equals("S")) {
//                boolean encontrado = false;
//                for (String[] agregado : computadora.getComponentes()) {
//                    if (agregado != null && agregado[0].equals(componente[0])) {
//                        encontrado = true;
//                        break;
//                    }
//                }
//                if (!encontrado) {
//                    faltaObligatorio = true;
//                    break;
//                }
//            }
//        }
//
//        if (faltaObligatorio) {
//            System.out.println("Atención, 1 o más componentes obligatorios no fueron agregados. Se cobrará un recargo del 20%.");
//        }
//
//        // f) Calcular monto final
//        double total = 0;
//        for (String[] componente : computadora.getComponentes()) {
//            if (componente != null) {
//                total += Double.parseDouble(componente[2]);
//            }
//        }
//
//        double recargo = faltaObligatorio ? total * 0.2 : 0;
//        double montoFinal = total + recargo;
//
//        // g) Mostrar resultados
//        System.out.println("\nLa computadora especificada es:");
//        System.out.println("Marca: " + computadora.getMarca());
//        System.out.println("Modelo: " + computadora.getModelo());
//        System.out.println("Código de Barras: " + computadora.getCodigoBarras());
//        System.out.println("\nComponentes:");
//        for (String[] componente : computadora.getComponentes()) {
//            if (componente != null) {
//                System.out.printf("%s %s %s\n", componente[0], componente[1], componente[2]);
//            }
//        }
//        System.out.println("Total Componentes: " + total);
//        System.out.println("Recargo: " + recargo);
//        System.out.println("Monto Final: " + montoFinal);
//    }
//}
//public class Computadora {
//    private String marca;
//    private String modelo;
//    private long codigoBarras;
//    private double precioTotal;
//    private double porcentajeAumento;
//    private double montoFinal;
//    private String[][] componentes;
//
//    // Getters y setters
//    public String getMarca() { return marca; }
//    public void setMarca(String marca) { this.marca = marca; }
//    public String getModelo() { return modelo; }
//    public void setModelo(String modelo) { this.modelo = modelo; }
//    public long getCodigoBarras() { return codigoBarras; }
//    public void setCodigoBarras(long codigoBarras) { this.codigoBarras = codigoBarras; }
//    public String[][] getComponentes() { return componentes; }
//    public void setComponentes(String[][] componentes) { this.componentes = componentes; }
//
//    // Método para inicializar la matriz de componentes
//    public void inicializarComponentes(int cantidad) {
//        componentes = new String[cantidad][4]; // Código, Denominación, Precio, Obligatorio
//    }
//}


