package fabian.stomas.aplicacion4;

public class CanalesApuntes {
    int id_apunte;
    int id_canal;

    public CanalesApuntes(){

    }

    public CanalesApuntes(int id_apunte, int id_canal){
        this.id_apunte = id_apunte;
        this.id_canal = id_canal;
    }

    public int getId_apunte() {
        return id_apunte;
    }

    public void setId_apunte(int id_apunte) {
        this.id_apunte = id_apunte;
    }

    public int getId_canal() {
        return id_canal;
    }

    public void setId_canal(int id_canal) {
        this.id_canal = id_canal;
    }
}
