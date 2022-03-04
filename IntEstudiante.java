import java.util.List;

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

    public float getGrupoEstudiante(int id)
            throws java.rmi.RemoteException;

    public List<Estudiante> getMiembrosGrupo(String grupo)
            throws java.rmi.RemoteException;

}