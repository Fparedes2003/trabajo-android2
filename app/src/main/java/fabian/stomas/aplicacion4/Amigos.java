package fabian.stomas.aplicacion4;

public class Amigos {
    int id_usuario;
    int id_amigo;
    String amigoNombre;
    String amigoApellido;
    String amigoCorreo;

    public Amigos(){

    }

    public Amigos(String amigoNombre, String amigoApellido, String amigoCorreo, int id_amigo){
        this.amigoNombre = amigoNombre;
        this.amigoApellido = amigoApellido;
        this.amigoCorreo = amigoCorreo;
        this.id_amigo = id_amigo;
    }

    public Amigos(int id_usuario, int id_amigo){
        this.id_usuario = id_usuario;
        this.id_amigo = id_amigo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_amigo() {
        return id_amigo;
    }

    public void setId_amigo(int id_amigo) {
        this.id_amigo = id_amigo;
    }
}
