package fabian.stomas.aplicacion4;

import java.util.Date;

public class Tarea {
    int ID;
    String Titulo;
    String Descripcion;
    String Estado;
    Date Fecha_expiracion;
    String Fecha_expiraciondb;

    public Tarea(){

    }

    public Tarea(int ID, String Titulo, String Descripcion, String Estado, Date Fecha_expiracion){
        this.ID = ID;
        this.Titulo = Titulo;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
        this.Fecha_expiracion = Fecha_expiracion;
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

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public Date getFecha_expiracion() {
        return Fecha_expiracion;
    }

    public void setFecha_expiracion(Date fecha_expiracion) {
        Fecha_expiracion = fecha_expiracion;
    }
}
