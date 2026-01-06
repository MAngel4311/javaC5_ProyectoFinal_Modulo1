import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    static String nombre = "N/A"; //Se declara de forma global para que pueda ser usada en otros métodos
    static double nota1 = 0, nota2 = 0, nota3 = 0;
    public static void main(String[] args) throws Exception {
        imprimir();
    }
    static void imprimir(){
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
        System.out.println("Seleccione una opcion: ");
    }
    
    // Lógica para registrar un estudiante
    static void registrarEstudiante(){
        if(!nombre.equals("N/A")){
            pedirDatos();
    } else if (nombre.equals("N/A")){
        System.out.println("Ya hay un estudiante registrado, desea sobreescribirlo? (s/n): ");
        String respuesta = sc.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            pedirDatos();
        } else {
            System.out.println("Registro cancelado.");
        }

}
    }

    static void pedirDatos(){
        System.out.print("Ingrese el nombre del estudiante: ");
        nombre = sc.nextLine();
        System.out.print("Ingrese la primera nota: ");
        nota1 = solicitarNota();
        System.out.print("Ingrese la segunda nota: ");
        nota2 = solicitarNota();
        System.out.print("Ingrese la tercera nota: ");
        nota3 = solicitarNota();
        sc.nextLine(); // Limpiar el buffer
    }

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

    static void mostrarEstudiante(){
        if (nombre.equals("N/A")) {
            System.out.println("No hay datos de estudiante registrados");
        } else {
            System.out.println("Nombre del estudiante: " + nombre);
            System.out.println("Notas: " + nota1 + ", " + nota2 + ", " + nota3);
        }
    }

    static void calcularPromedio(){
        if (nombre.equals("N/A")) {
            System.out.println("No hay datos de estudiante registrados");
        } else {
            System.out.println("Promedio del estudiante: " + (nota1 + nota2 + nota3) / 3);
        }
    }
}