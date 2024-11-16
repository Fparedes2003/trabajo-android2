package fabian.stomas.aplicacion4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fabian.stomas.aplicacion4.databinding.CanalConfigUsuarioBinding;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CanalConfigUsuario extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        CanalConfigUsuarioBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.canal_config_usuario);
        binding = CanalConfigUsuarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Canal canal = (Canal) getIntent().getSerializableExtra("Canal");
        binding.BtnVerUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CanalConfigUsuario.this, VerUsuariosCanal.class);
                intent.putExtra("Canal", canal);
                startActivity(intent);
            }
        });
        binding.returnVistas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CanalConfigUsuario.this, MenuCanal.class);
                intent.putExtra("Canal", canal);
                startActivity(intent);
            }
        });
    }
}
