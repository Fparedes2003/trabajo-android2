package fabian.stomas.aplicacion4;
import java.io.Serializable;
import java.util.ArrayList;

public class Canal implements Serializable {
    private int Id;
    private String Nombre;
    private String Descripcion;
    private int Tipo_canal;
    private String Tipo_canaldb;
    private int admin;
    private int Tarea_ID;
    private ArrayList<Usuario> usuariosCanal;
    public static int idCanal;

    public Canal(){

    }
    public Canal(int Id, String Nombre, String Descripcion, int Tipo_canal, int admin, int Tarea_ID){
        this.Id = Id;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Tipo_canal = Tipo_canal;
        this.admin = admin;
        this.Tarea_ID = Tarea_ID;
    }
    public Canal(int Id, String Nombre, String Descripcion, String Tipo_canaldb, int Tarea_ID, int admin){
        this.Id = Id;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Tipo_canaldb = Tipo_canaldb;
        this.Tarea_ID = Tarea_ID;
        this.admin = admin;
    }
    public Canal(int Id, String Nombre, String Descripcion, String Tipo_canaldb, int Tarea_ID){
        this.Id = Id;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Tipo_canaldb = Tipo_canaldb;
        this.Tarea_ID = Tarea_ID;
    }
    public Canal(int Id, String Nombre, String Descripcion, String Tipo_canaldb, int Tipo_canal, int admin, int Tarea_ID){
        this.Id = Id;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Tipo_canaldb = Tipo_canaldb;
        this.Tipo_canal = Tipo_canal;
        this.admin = admin;
        this.Tarea_ID = Tarea_ID;
    }

    public Canal(int Id, String Nombre, String Descripcion, String Tipo_canaldb){
        this.Id = Id;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Tipo_canaldb = Tipo_canaldb;
    }
    public Canal(String Nombre, String Descripcion, String Tipo_canaldb){
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Tipo_canaldb = Tipo_canaldb;
    }
    public Canal(int Id, String Nombre, String Descripcion, int Tipo_canal, int admin){
        this.Id = Id;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Tipo_canal = Tipo_canal;
        this.admin = admin;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getTipo_canal() {
        return Tipo_canal;
    }

    public void setTipo_canal(int tipo_canal) {
        Tipo_canal = tipo_canal;
    }

    public String getTipo_canaldb() {
        return Tipo_canaldb;
    }

    public void setTipo_canaldb(String tipo_canaldb) {
        Tipo_canaldb = tipo_canaldb;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public int getTarea_ID() {
        return Tarea_ID;
    }

    public void setTarea_ID(int tarea_ID) {
        Tarea_ID = tarea_ID;
    }

    public ArrayList<Usuario> getUsuariosCanal() {
        return usuariosCanal;
    }

    public void setUsuariosCanal(ArrayList<Usuario> usuariosCanal) {
        this.usuariosCanal = usuariosCanal;
    }
}