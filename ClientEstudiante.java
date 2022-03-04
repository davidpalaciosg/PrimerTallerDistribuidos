import java.rmi.*;

public class ClientEstudiante {
    public static void main(String[] args) {

        /*
         * Lista de argumentos
         * args[0] -> ip y puerto del servidor
         * args[1] -> método remoto a ejecutar
         * args[2] -> parámetro del método
         */
        if (args.length !=3) {
            System.out.println("Error en la cantidad de argumentos");
            System.exit(0);
        }
        String ip = args[0];
        String metodo = args[1];
        String parametro = args[2];

        try {
            System.out.println("Buscando Objeto ");
            IntEstudiante miEstudiante = (IntEstudiante) Naming.lookup("rmi://" +
                    ip + "/" + "MiServidorEstudiante");
            menu(miEstudiante, metodo, parametro);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private static void menu(IntEstudiante miEstudiante, String metodo, String parametro) {
        try {

            switch (metodo) {
                case "getNombreEstudiante":
                    System.out.println(miEstudiante.getNombreEstudiante(Integer.parseInt(parametro)));
                    break;
                case "getPromedioNotasEstudiante":
                    // Verifica si es ID o nombre
                    if (isNumeric(parametro))
                        System.out.println(miEstudiante.getPromedioNotasEstudiante(Integer.parseInt(parametro)));
                    else
                        System.out.println(miEstudiante.getPromedioNotasEstudiante(parametro));
                    break;
                case "getGrupoEstudiante":
                    System.out.println(miEstudiante.getGrupoEstudiante(Integer.parseInt(parametro)));
                    break;
                case "getMiembrosGrupo":
                    System.out.println(miEstudiante.getMiembrosGrupo(parametro));
                    break;
                default:
                    System.out.println("Método no encontrado");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
