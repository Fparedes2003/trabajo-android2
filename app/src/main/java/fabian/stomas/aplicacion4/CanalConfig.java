package fabian.stomas.aplicacion4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fabian.stomas.aplicacion4.databinding.CanalConfigBinding;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CanalConfig extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        CanalConfigBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.canal_config);
        binding = CanalConfigBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Canal canal = (Canal) getIntent().getSerializableExtra("Canal");
        binding.returnVistas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(canal.getTipo_canal() == 1 || canal.getTipo_canal() == 2){
                    Intent intent = new Intent(CanalConfig.this, MenuCanal.class);
                    intent.putExtra("Canal", canal);
                    startActivity(intent);

                }else{
                    Intent intent = new Intent(CanalConfig.this, MenuCanalApuntes.class);
                    intent.putExtra("Canal", canal);
                    startActivity(intent);
                }
            }
        });
        binding.BtnVerUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CanalConfig.this, VerUsuariosCanal.class);
                intent.putExtra("Canal", canal);
                startActivity(intent);
            }
        });
        binding.BtnAgregarUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CanalConfig.this, VerAmigosCanal.class);
                intent.putExtra("Canal", canal);
                startActivity(intent);
            }
        });
        binding.BtnQuitarUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CanalConfig.this, EliminarAmigosCanal.class);
                intent.putExtra("Canal", canal);
                startActivity(intent);
            }
        });

    }

}
