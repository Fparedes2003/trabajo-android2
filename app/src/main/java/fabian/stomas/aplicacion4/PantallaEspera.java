package fabian.stomas.aplicacion4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import fabian.stomas.aplicacion4.databinding.PantallaEsperaBinding;

public class PantallaEspera extends AppCompatActivity {
    int progressStatus = 0;
    int idUsuario;
    DatabaseManager dtbmng = new DatabaseManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState){
        PantallaEsperaBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.pantalla_espera);
        binding = PantallaEsperaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Usuario usuario = (Usuario) getIntent().getSerializableExtra("Usuario");
        idUsuario = usuario.getID();
        Amigos amigos = dtbmng.getAmigos(Usuario.idActual, idUsuario);
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(progressStatus < 100){
                    progressStatus++;
                    binding.progressBar.setProgress(progressStatus);
                    handler.postDelayed(this, 100);
                    if(progressStatus == 100){
                        if(amigos == null){
                            Intent intent = new Intent(PantallaEspera.this, Perfil.class);
                            intent.putExtra("Usuario", usuario);
                            startActivity(intent);
                        }else{
                            Intent intent = new Intent(PantallaEspera.this, Perfilnbtn.class);
                            intent.putExtra("Usuario", usuario);
                            startActivity(intent);

                        }
                    }
                }
            }
        };
        handler.post(runnable);

    }

}
