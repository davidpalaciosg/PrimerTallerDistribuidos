import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * @author David Palacios García
 * @author José Fernando Zuluaga
 * @author Daniel Morales
 */ 
public class ImplEstudiante extends UnicastRemoteObject implements IntEstudiante {

    ArrayList<Estudiante> estudiantes;
    /**
     * Constructor principal de la implementacion del estudiante, inicializa la lectura del archivo de texto.
     * @param name
     * @throws RemoteException
     */
    public ImplEstudiante(String name) throws RemoteException {
        super();
        estudiantes = new ArrayList<>();
        try {
            leerArchivo("Estudiantes.txt");
            System.out.println("Rebind Object " + name);
            Naming.rebind(name, this);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }


    /**
     * Lee un archivo de texto para ser procesado como sea requerido. adicionalmente llena el arraylist estudiante
     * con los registros del archivo de texto.
     * @param nombreArchivo el nombre del archivo de texto a procesar
     * @return true si logro abrir el archivo exitosamente, de lo contrario false.
     * @throws java.rmi.RemoteException
     */
    @Override
    public boolean leerArchivo(String nombreArchivo) throws RemoteException {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("./" + nombreArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                // Partir la línea por ;

                // Crear Estudiante
                String[] lineaEstudiante = linea.split(";");
                String grupo = lineaEstudiante[0];
                int id = Integer.parseInt(lineaEstudiante[1]);
                String nombre = lineaEstudiante[2];
                ArrayList<Float> notas = new ArrayList<>();

                float nota1 = Float.parseFloat(lineaEstudiante[3]);
                float nota2 = Float.parseFloat(lineaEstudiante[4]);
                notas.add(nota1);
                notas.add(nota2);

                // Crear Estudiante
                Estudiante e = new Estudiante(grupo, id, nombre, notas);
                estudiantes.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return true;
    }

    /**
     * Dado un id de estudiante, busca en el ArrayList de Estudiantes el nombre correspondiente mediante la funcion auxiliar
     * getEstudianteById.
     * @param id el registro numerico del estudiante en el archivo
     * @return el nombre del estudiante asociado al id ingresado
     * @throws java.rmi.RemoteException
     */
    @Override
    public String getNombreEstudiante(int id) throws RemoteException {
        Estudiante e = getEstudianteById(id);
        if (e != null)
            return e.getNombre();
        return "Estudiante no encontrado";
    }

    /**
     * Obtiene el promedio de notas de un estudiante dado su nombre mediante la funcion auxiliar
     * getEstudianteByName.
     * @param nombre el nombre del estudiante para el cual se obtendra el promedio.
     * @return el promedio de notas del estudiante.
     * @throws java.rmi.RemoteException
     */
    @Override
    public float getPromedioNotasEstudiante(String nombre) throws RemoteException {
        Estudiante e = getEstudianteByName(nombre);
        if (e != null) {
            float promedio = 0;
            for (Float nota : e.getNotas()) {
                promedio += nota;
            }
            return promedio / e.getNotas().size();
        }
        return 0;
    }

    /**
     * Recorre el arraylist de estudiantes para obtener el promedio de notas de un estudiante en particular.
     * @param id registro numerico del estudiante para el cual se obtendra el promedio de notas.
     * @return el promedio de notas del estudiante
     * @throws java.rmi.RemoteException
     */
    @Override
    public float getPromedioNotasEstudiante(int id) throws RemoteException {
        Estudiante e = getEstudianteById(id);
        if (e != null) {
            float promedio = 0;
            for (Float nota : e.getNotas()) {
                promedio += nota;
            }
            return promedio / e.getNotas().size();
        }
        return 0;
    }

    /**
     * Muestra el grupo de trabajo al que un estudiante pertenece.
     * @param id el registro numerico del estudiante sobre el cual se buscara su grupo.
     * @return el identificador del grupo de trabajo del estudiante
     * @throws java.rmi.RemoteException
     */
    @Override
    public String getGrupoEstudiante(int id) throws RemoteException {
        Estudiante e = getEstudianteById(id);
        if (e != null)
            return e.getGrupo();
        return "Estudiante no encontrado";
    }

    /**
     * Almacena en un arraylist auxiliar, los miembros de un grupo de trabajo en particular, luego concatena su información en una cadena.
     * @param grupo el identificador del grupo de trabajo a buscar.
     * @return la cadena que contiene los nombres de los integrantes
     * @throws java.rmi.RemoteException
     */
    @Override
    public String getMiembrosGrupo(String grupo) throws RemoteException {
        ArrayList<Estudiante> miembros = new ArrayList<>();
        for (Estudiante e : estudiantes) {
            if (e.getGrupo().equalsIgnoreCase(grupo)) {
                miembros.add(e);
            }
        }
        String cadena="";
        int i=1;
        for (Estudiante e : miembros) {
            cadena += "Miembro #" +i + "\n"
                    + " Nombre: " + e.getNombre() + "\n"
                    + " Grupo: " + e.getGrupo() + "\n"
                    + " Notas: " + e.getNotas().toString() + "\n\n";
            i++;
        }
        return cadena;
    }
    
    /**
     * Funcion auxiliar que filtra el arraylist de estudiantes, para buscar el estudiante que posea el id de entrada
     * @param id el id del estudiante a buscar
     * @return el estudiante encontrado
     */
    public Estudiante getEstudianteById(int id) {
        Estudiante e;
        try {
            e = estudiantes.stream().filter(es -> es.getId() == id).findFirst().get();
        } catch (Exception e1) {
            // Print error
            //System.err.println("Error al buscar el estudiante");
            e = null;
        }
        return e;
    }

    /**
     * Funcion auxiliar que filtra el arraylist de estudiantes, para buscar el estudiante que posea el nombre de entrada
     * @param name el nombre del estudiante a buscar
     * @return el estudiante encontrado
     */
    public Estudiante getEstudianteByName(String name) {
        Estudiante e;
        try {
            e = estudiantes.stream().filter(es -> es.getNombre().equals(name)).findFirst().get();
        } catch (Exception e1) {
            // Print error
            //System.err.println("Error al buscar el estudiante");
            e = null;
        }
        return e;
    }

}
