package fabian.stomas.aplicacion4;

import java.io.Serializable;

public class Solicitudes implements Serializable {
    int ID;
    String Estado;
    int id_remitente;
    int id_receptor;
    String NombreRemitente;
    String ApellidoRemitente;
    String CorreoRemitente;

    public Solicitudes(){

    }

    public Solicitudes(int ID, String Estado, int id_remitente, int id_receptor){
        this.ID = ID;
        this.Estado = Estado;
        this.id_remitente = id_remitente;
        this.id_receptor = id_receptor;
    }

    public Solicitudes(int ID, int id_remitente, String NombreRemitente, String ApellidoRemitente, String CorreoRemitente, String Estado){
        this.ID = ID;
        this.id_remitente = id_remitente;
        this.NombreRemitente = NombreRemitente;
        this.ApellidoRemitente = ApellidoRemitente;
        this.CorreoRemitente = CorreoRemitente;
        this.Estado = Estado;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public int getId_remitente() {
        return id_remitente;
    }

    public void setId_remitente(int id_remitente) {
        this.id_remitente = id_remitente;
    }

    public int getId_receptor() {
        return id_receptor;
    }

    public void setId_receptor(int id_receptor) {
        this.id_receptor = id_receptor;
    }

    public String getNombreRemitente() {
        return NombreRemitente;
    }

    public void setNombreRemitente(String nombreRemitente) {
        NombreRemitente = nombreRemitente;
    }

    public String getApellidoRemitente() {
        return ApellidoRemitente;
    }

    public void setApellidoRemitente(String apellidoRemitente) {
        ApellidoRemitente = apellidoRemitente;
    }

    public String getCorreoRemitente() {
        return CorreoRemitente;
    }

    public void setCorreoRemitente(String correoRemitente) {
        CorreoRemitente = correoRemitente;
    }
}
