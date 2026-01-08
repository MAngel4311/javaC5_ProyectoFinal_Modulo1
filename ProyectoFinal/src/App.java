import java.util.Scanner;
/*
* PROYECTO FINAL 1 - MÓDULO 1 
* Sistema de Registro de Estudiantes
* Permite registrar estudiantes, mostrar sus datos, calcular promedios y limpiar datos.
*/

public class App {
    static Scanner sc = new Scanner(System.in);
    static String nombre = "N/A"; //Se declara de forma global para que pueda ser usada en otros métodos
    static double nota1 = 0, nota2 = 0, nota3 = 0;
    public static void main(String[] args) throws Exception {
        int opcion;
        //Logica menu de opciones
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1:
                    registrarEstudiante();
                    break;
                case 2:
                    mostrarEstudiante();
                    break;
                case 3:
                    System.out.println("El Promedio de "+ nombre + " es : " + calcularPromedio());
                    break;
                case 4:
                        mostrarResumen();
                    break;
                case 5:
                    limpiarDatos("N/A");
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }
    // Método para mostrar el menú de opciones al usuario
    static void mostrarMenu(){
        var opciones = """
                ---Sistema de Registro de Estudiantes---

                1. Registrar Estudiante
                2. Mostrar Estudiantes
                3. Calcular Promedio de Notas
                4. Mostrar resumen completo del estudiante
                5. Limpiar datos del estudiante actual
                0. Salir
                """;

        System.out.println(opciones);
        System.out.print("Seleccione una opcion: ");
    }
    // Lógica para registrar un estudiante
    static void registrarEstudiante(){
        if(nombre.equals("N/A")){
            pedirDatos();
        } else {
            System.out.println("Ya hay un estudiante registrado: " + nombre);
            System.out.print("¿Desea sobrescribir los datos del estudiante? (S/N): ");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                pedirDatos();
            } else {
                System.out.println("Sobreescribir cancelado");
            }
        }
    }
    //metodo auxiliar para pedir datos
    static void pedirDatos(){
        String nombreAux;
        do {
            System.out.print("Ingrese el nombre del estudiante: ");
            nombreAux = sc.nextLine();
            if(!validarNombre(nombreAux)){
                System.out.println("Nombre inválido. Por favor, ingrese un nombre válido.");
            }
        } while (!validarNombre(nombreAux));
        nombre = nombreAux;
        System.out.print("Ingrese la primera nota: ");
        nota1 = solicitarNota();
        System.out.print("Ingrese la segunda nota: ");
        nota2 = solicitarNota();
        System.out.print("Ingrese la tercera nota: ");
        nota3 = solicitarNota();
        sc.nextLine(); // Limpiar el buffer
    }
    //metodo auxiliar para solicitar nota con validacion
    static double solicitarNota(){
        double nota;
        do {
            System.out.println("Ingrese una nota entre (0-100): ");
            nota = sc.nextDouble();
            if ((!(nota >= 0 && nota <= 100))) {
                System.out.println("Nota inválida. Debe estar entre 0 y 100.");
            }
        } while (!(nota >= 0 && nota <= 100));
        return nota;
    }
    // Lógica para mostrar los datos del estudiante
    static void mostrarEstudiante(){
        if (nombre.equals("N/A")) {
            System.out.println("No hay datos de estudiante registrados");
        } else {
            System.out.println("Nombre del estudiante: " + nombre);
            System.out.println("Notas: " + nota1 + ", " + nota2 + ", " + nota3);
        }
    }
    // Lógica para calcular el promedio de las notas
    static double calcularPromedio(){
        if (nombre.equals("N/A")) {
            System.out.println("No hay datos de estudiante registrados");
        } 
        return (nota1 + nota2 + nota3) / 3;
    }
    // Lógica para mostrar el resumen completo del estudiante
    static void mostrarResumen(){
        if (nombre.equals("N/A")) {
            System.out.println("No hay datos de estudiante registrados");
            } else {
            System.out.println("Resumen del estudiante:");
            System.out.println("Nombre: " + nombre);
            System.out.println("Notas: " + nota1 + ", " + nota2 + ", " + nota3);
            System.out.printf("Promedio: %.2f%n", calcularPromedio());
            String estado = calcularPromedio() >= 60 ? "Aprobado" : "Reprobado";
            System.out.println("Estado: " + estado); 
            }
    }
    // Lógica para limpiar los datos del estudiante actual
    static void limpiarDatos(String estado){
        nombre = "N/A";
        nota1 = 0;
        nota2 = 0;
        nota3 = 0;
        estado = "N/A";
        System.out.println("Datos del estudiante actual han sido borrados exitosamente");
    }
    // Método para validar el nombre del estudiante
    static boolean validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        for (int i = 0; i < nombre.length(); i++) {
            char c = nombre.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }
}
