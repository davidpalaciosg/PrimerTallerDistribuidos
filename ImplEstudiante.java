import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ImplEstudiante extends UnicastRemoteObject implements IntEstudiante {

    protected ImplEstudiante() throws RemoteException {
        super();
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean leerArchivo(String nombreArchivo) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
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
    public List<Estudiante> getMiembrosGrupo(String grupo) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }
    
}
