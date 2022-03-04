public class ServerEstudiante {
    public static void main(String[] args) {
        try {
            ImplEstudiante implEstudiante = new ImplEstudiante("rmi://localhost:1099" + "/MiServidorEstudiante");
            System.out.println(implEstudiante.leerArchivo("Estudiantes.txt"));
            System.out.println(implEstudiante.getEstudianteById(684685));
        } catch (Exception e) {
            System.err.println("System exception" + e);
        }
        
    }
    
}
