import java.util.ArrayList;

public class Estudiante {

    private String grupo;
    private int id;
    private String nombre;
    private ArrayList<Float> notas;

  
    public Estudiante(String grupo, int id, String nombre, ArrayList<Float> notas) {
        this.grupo = grupo;
        this.id = id;
        this.nombre = nombre;
        this.notas = notas;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Float> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Float> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Estudiante [grupo=" + grupo + ", id=" + id + ", nombre=" + nombre + ", notas=" + notas + "]";
    }

    

    

    
    
}
