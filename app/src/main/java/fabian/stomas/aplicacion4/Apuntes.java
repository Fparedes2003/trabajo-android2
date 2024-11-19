package fabian.stomas.aplicacion4;
import java.util.Date;

public class Apuntes {
    int ID;
    String Titulo;
    String Contenido;
    Date Fecha_creacion;
    String Fecha_creaciondb;
    Date Fecha_modificacion;
    int id_propietario;
    String usuarioNombre;
    String usuarioApellido;

    public Apuntes(){

    }

    public Apuntes(int ID, String Titulo, String Contenido, String Fecha_creaciondb, String usuarioNombre, String usuarioApellido){
        this.ID = ID;
        this.Titulo = Titulo;
        this.Contenido = Contenido;
        this.Fecha_creaciondb = Fecha_creaciondb;
        this.usuarioNombre = usuarioNombre;
        this.usuarioApellido = usuarioApellido;
    }

    public Apuntes(int ID, String Titulo, String Contenido, Date Fecha_creacion, int id_propietario){
        this.ID = ID;
        this.Titulo = Titulo;
        this.Contenido = Contenido;
        this.Fecha_creacion = Fecha_creacion;
        this.id_propietario = id_propietario;
    }

    public Apuntes(int ID, String Titulo, String Contenido, Date Fecha_creacion, String usuarioNombre, String usuarioApellido){
        this.ID = ID;
        this.Titulo = Titulo;
        this.Contenido = Contenido;
        this.Fecha_creacion = Fecha_creacion;
        this.usuarioNombre = usuarioNombre;
        this.usuarioApellido = usuarioApellido;
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

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String contenido) {
        Contenido = contenido;
    }

    public Date getFecha_creacion() {
        return Fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        Fecha_creacion = fecha_creacion;
    }

    public String getFecha_creaciondb() {
        return Fecha_creaciondb;
    }

    public void setFecha_creaciondb(String fecha_creaciondb) {
        Fecha_creaciondb = fecha_creaciondb;
    }

    public Date getFecha_modificacion() {
        return Fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        Fecha_modificacion = fecha_modificacion;
    }

    public int getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(int id_propietario) {
        this.id_propietario = id_propietario;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getUsuarioApellido() {
        return usuarioApellido;
    }

    public void setUsuarioApellido(String usuarioApellido) {
        this.usuarioApellido = usuarioApellido;
    }
}
