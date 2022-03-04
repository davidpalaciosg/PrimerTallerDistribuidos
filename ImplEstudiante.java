import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ImplEstudiante extends UnicastRemoteObject implements IntEstudiante {

    ArrayList<Estudiante> estudiantes;

    public ImplEstudiante(String name) throws RemoteException {
        super();
        estudiantes = new ArrayList<>();

    }

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

    @Override
    public String getNombreEstudiante(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public float getPromedioNotasEstudiante(String nombre) throws RemoteException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getPromedioNotasEstudiante(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getGrupoEstudiante(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ArrayList<Estudiante> getMiembrosGrupo(String grupo) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    public Estudiante getEstudianteById(int id) {
        Estudiante e;
        try{
            e= estudiantes.stream().filter(es -> es.getId() == id).findFirst().get(); 
        }catch(Exception e1){
            //Print error
            System.out.println("Error al buscar el estudiante");
            e=null;
        }
        return e;
    }

}
