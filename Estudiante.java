import java.util.ArrayList;

public class Estudiante {

    private String grupo;
    private int id;
    private String nombre;
    private ArrayList<Integer> notas;

    public Estudiante(String grupo, int id, String nombre) {
        this.grupo = grupo;
        this.id = id;
        this.nombre = nombre;
        this.notas = new ArrayList<>();
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

    public ArrayList<Integer> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Integer> notas) {
        this.notas = notas;
    }

    

    
    
}
