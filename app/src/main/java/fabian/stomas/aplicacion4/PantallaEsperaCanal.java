package fabian.stomas.aplicacion4;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import fabian.stomas.aplicacion4.databinding.PantallaEsperaCanalBinding;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class PantallaEsperaCanal extends AppCompatActivity {
    int progressStatus = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        PantallaEsperaCanalBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.pantalla_espera_canal);
        binding = PantallaEsperaCanalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Canal canal = (Canal) getIntent().getSerializableExtra("Canal");
        Handler handler = new Handler();
        System.out.println("id tipocanal: "+canal.getTipo_canal());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(progressStatus < 50){
                    progressStatus++;
                    binding.progressBar2.setProgress(progressStatus);
                    handler.postDelayed(this, 50);
                    if(progressStatus == 50){
                        if(canal.getTipo_canal() == 1 || canal.getTipo_canal() == 2){
                            Intent intent = new Intent(PantallaEsperaCanal.this, MenuCanal.class);
                            intent.putExtra("Canal", canal);
                            startActivity(intent);
                        }else{
                            Intent intent = new Intent(PantallaEsperaCanal.this, MenuCanalApuntes.class);
                            intent.putExtra("Canal", canal);
                            startActivity(intent);
                        }
                    }
                }
            }
        };
        handler.post(runnable);

    }
}
