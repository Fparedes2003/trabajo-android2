package fabian.stomas.aplicacion4;
import java.sql.Timestamp;
import java.util.Date;

public class Avance {
    int ID;
    String Titulo;
    String Descripcion;
    Date Fecha_avance;
    String Fecha_avancedb;
    int id_usuario;
    int id_canal;

    public Avance(){

    }

    public Avance(int ID, String Titulo, String Descripcion, Date Fecha_avance, int id_usuario, int id_canal){
        this.ID = ID;
        this.Titulo = Titulo;
        this.Descripcion = Descripcion;
        this.Fecha_avance = Fecha_avance;
        this.id_usuario = id_usuario;
        this.id_canal = id_canal;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Date getFecha_avance() {
        return Fecha_avance;
    }

    public void setFecha_avance(Date fecha_avance) {
        Fecha_avance = fecha_avance;
    }

    public String getFecha_avancedb() {
        return Fecha_avancedb;
    }

    public void setFecha_avancedb(String fecha_avancedb) {
        Fecha_avancedb = fecha_avancedb;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_canal() {
        return id_canal;
    }

    public void setId_canal(int id_canal) {
        this.id_canal = id_canal;
    }
}

