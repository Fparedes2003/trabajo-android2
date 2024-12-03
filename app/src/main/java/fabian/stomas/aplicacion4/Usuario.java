package fabian.stomas.aplicacion4;
import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {
    private int ID;
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private String Correo;
    private String Password;
    private int id_amigo;
    private ArrayList<Integer> amigos;
    private ArrayList<Integer> canales;
    public static int idActual = 0;

    public Usuario(){

    }
    public Usuario(String Nombre, String Apellido, String Correo, int id_amigo){
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.id_amigo = id_amigo;
    }
    public Usuario(int ID, String Nombre, String Apellido, String Correo){
        this.ID = ID;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
    }
    public Usuario(int ID, String Nombre, String Apellido, String Correo, String Telefono){
        this.ID = ID;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.Telefono = Telefono;
    }
    public Usuario(String Nombre, String Apellido, String Correo, String Telefono){
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.Telefono = Telefono;
    }

    public Usuario(int ID, String Nombre, String Apellido, String Telefono, String Correo, String Pass) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Password = Pass;
    }

    public int getIdUsuarioActual(int id){
        int idActualUsuario = id;
        return  idActualUsuario;
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

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public ArrayList<Integer> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<Integer> amigos) {
        this.amigos = amigos;
    }

    public ArrayList<Integer> getCanales() {
        return canales;
    }

    public void setCanales(ArrayList<Integer> canales) {
        this.canales = canales;
    }

    public int getId_amigo() {
        return id_amigo;
    }

    public void setId_amigo(int id_amigo) {
        this.id_amigo = id_amigo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "ID=" + ID +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Correo='" + Correo + '\'' +
                ", Password='" + Password + '\'' +
                ", amigos=" + amigos +
                ", canales=" + canales +
                '}';
    }
}
