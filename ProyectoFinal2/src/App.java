import java.util.Scanner;

public class App {

/** $%,.2f%n
 * $ = símbolo de moneda
 * % = indica que se va usar un formato
 * , = separador de miles
 * .2f = número de decimales (2 en este caso)
 * %n = nueva línea o salto de línea
*/
    static Scanner sc = new Scanner(System.in);
    static String nombreProducto = "N/A";
    static double precioUnitario = 0.0;
    static int cantidadEnInventario = 0;

    public static void main(String[] args) throws Exception {
        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea
            switch (opcion) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    mostrarInfoProducto(nombreProducto, precioUnitario, cantidadEnInventario);
                    break;
                case 3:
                    if(nombreProducto.equals("N/A")) {
                        System.out.println("No hay datos de producto registrados actualmente");
                    } else {
                       double valorTotal = calcularValorTotalInventario(precioUnitario, cantidadEnInventario);
                       System.out.println("El valor total del inventario es: $" + valorTotal);
                       System.out.println(" ");
                    }
                    break;
                case 4:
                    mostrarFacturaProducto(nombreProducto, precioUnitario, cantidadEnInventario);
                    break;
                case 5:
                    // Limpiar datos del producto actual
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    
    }

    static void mostrarMenu() {
        System.out.println("""
        --- Sistema de Gestión de Productos ---
        1. Registrar nuevo producto
        2. Mostrar información del producto actual
        3. Calcular valor total del inventario
        4. Mostrar resumen completo del producto
        5. Limpiar datos del producto actual
        0. Salir
        ---------------------------------------""");
        System.out.print("Seleccione una opción: ");
        
    }

    static void registrarProducto() {
        if(nombreProducto.equals("N/A")) {
            leerDatosProducto();
        } else {
            System.out.print("Ya existe un producto registrado. Desea sobrescribirlo? (S/N): ");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("S")) {
                leerDatosProducto();
                System.out.println("Producto actualizado exitosamente.");
            } else {
                System.out.println("Operación cancelada. El producto no fue modificado.");
            }
        }
    }

    static void leerDatosProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        nombreProducto = sc.nextLine();
        
        do {
            System.out.print("Ingrese el precio unitario del producto: ");
            precioUnitario = sc.nextDouble();
            if(precioUnitario<=0){
                System.out.println("El precio debe ser un número positivo. Intente de nuevo.");
            }
        } while (precioUnitario<=0);
        
        do {
            System.out.print("Ingrese la cantidad en inventario del producto: ");
            while(!sc.hasNextInt()){
                System.out.print("Error: Debe ingresar un número entero: ");
                sc.next();
            } 
            cantidadEnInventario = sc.nextInt();
            if(cantidadEnInventario <0){
                System.out.println("La cantidad no puede ser negativa. Intente de nuevo.");
            }
        } while (cantidadEnInventario<0);
        sc.nextLine();
        System.out.println(" ");
    }

    static void mostrarInfoProducto(String nombreProducto, double precioUnitario, int cantidadEnInventario) {
        if(nombreProducto.equals("N/A")) {
            System.out.println("No hay datos de producto registrados actualmente");
            System.out.println("");
        } else {
            System.out.println("Nombre del producto: " + nombreProducto);
            System.out.println("Precio unitario: $" + precioUnitario);
            System.out.println("Cantidad en inventario: " + cantidadEnInventario);
        }
    }

    static double calcularValorTotalInventario(double precioUnitario, int cantidadEnInventario) {
        return precioUnitario * cantidadEnInventario;
    }

    static void mostrarFacturaProducto(String nombreProducto, double precioUnitario, int cantidadEnInventario) {
        if(nombreProducto.equals("N/A")) {
            System.out.println("No hay datos de producto registrados actualmente");
            System.out.println("");
        } else {
            double valorTotal = calcularValorTotalInventario(precioUnitario, cantidadEnInventario);
            System.out.println("----- Resumen Completo del Producto -----");
            System.out.println("Nombre del producto: " + nombreProducto);
            System.out.printf("Precio unitario: $%,.2f%n", precioUnitario);
            System.out.println("Cantidad en inventario: " + cantidadEnInventario);
            System.out.printf("Valor total del inventario: $%,.2f%n", valorTotal);
            System.out.println("Estado: "+ validarEstado(cantidadEnInventario));
            System.out.println("-----------------------------------------");
        }
    }

    static String validarEstado(int cantidadEnInventario) {
        if(cantidadEnInventario < 5){
            return "Stock bajo";
        } else if(5<=cantidadEnInventario && cantidadEnInventario <=20){
            return "Stock medio";
        } else {
            return "Stock alto";
        }
    }

    static void limpiarDatosProducto() {
        nombreProducto = "N/A";
        precioUnitario = 0.0;
        cantidadEnInventario = 0;
        System.out.println("Los datos del producto actual han sido borrados exitosamente.");
    }
}
    


    



