package fabian.stomas.aplicacion4;
public class Tipo_canal {
    private int ID;
    private String Nombre;

    public Tipo_canal(int ID, String Nombre){
        this.ID = ID;
        this.Nombre = Nombre;
    }

    public Tipo_canal(String Nombre){
        this.Nombre = Nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}