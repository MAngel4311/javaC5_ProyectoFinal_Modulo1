public class App {
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
}
