import java.util.ArrayList;

/**
 * @author David Palacios García
 * @author José Fernando Zuluaga
 * @author Daniel Morales
 */
public interface IntEstudiante extends java.rmi.Remote {

    /**
     * Lee un archivo de texto para ser procesado como sea requerido.
     * @param nombreArchivo el nombre del archivo de texto a procesar
     * @return true si logro abrir el archivo exitosamente, de lo contrario false.
     * @throws java.rmi.RemoteException
     */
    public boolean leerArchivo(String nombreArchivo)
            throws java.rmi.RemoteException;
    /**
     * Dado un id de estudiante, busca en el archivo de texto el nombre correspondiente.
     * @param id el registro numerico del estudiante en el archivo
     * @return el nombre del estudiante asociado al id ingresado
     * @throws java.rmi.RemoteException
     */
    public String getNombreEstudiante(int id)
            throws java.rmi.RemoteException;
    /**
     * Obtiene el promedio de notas de un estudiante dado su nombre.
     * @param nombre el nombre del estudiante para el cual se obtendra el promedio.
     * @return el promedio de notas del estudiante.
     * @throws java.rmi.RemoteException
     */
    public float getPromedioNotasEstudiante(String nombre)
            throws java.rmi.RemoteException;
    /**
     * Obtiene el promedio de notas de un estudiante dado su id.
     * @param id registro numerico del estudiante para el cual se obtendra el promedio de notas.
     * @return el promedio de notas del estudiante.
     * @throws java.rmi.RemoteException
     */
    public float getPromedioNotasEstudiante(int id)
            throws java.rmi.RemoteException;
    /**
     * Muestra el grupo de trabajo al que un estudiante pertenece.
     * @param id el registro numerico del estudiante sobre el cual se buscara su grupo.
     * @return el identificador del grupo de trabajo del estudiante
     * @throws java.rmi.RemoteException
     */
    public String getGrupoEstudiante(int id)
            throws java.rmi.RemoteException;
    /**
     * Retorna los miembros participantes de un grupo de trabajo
     * @param grupo el identificador del grupo de trabajo a buscar.
     * @return los nombres de los integrantes del grupo.
     * @throws java.rmi.RemoteException
     */
    public String getMiembrosGrupo(String grupo)
            throws java.rmi.RemoteException;

}