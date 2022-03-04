import java.util.ArrayList;

public interface IntEstudiante extends java.rmi.Remote {

    //Métodos remotos
    public boolean leerArchivo(String nombreArchivo)
            throws java.rmi.RemoteException;

    public String getNombreEstudiante(int id)
            throws java.rmi.RemoteException;

    public float getPromedioNotasEstudiante(String nombre)
            throws java.rmi.RemoteException;

    public float getPromedioNotasEstudiante(int id)
            throws java.rmi.RemoteException;

    public String getGrupoEstudiante(int id)
            throws java.rmi.RemoteException;

    public ArrayList<Estudiante> getMiembrosGrupo(String grupo)
            throws java.rmi.RemoteException;

}