public class ServerEstudiante {
    public static void main(String[] args) {
        try {
            ImplEstudiante implEstudiante = new ImplEstudiante("rmi://localhost:1099" + "/MiServidorEstudiante");
            System.out.println("Servidor iniciado");
        } catch (Exception e) {
            System.err.println("System exception" + e);
        }
        
    }
    
}
