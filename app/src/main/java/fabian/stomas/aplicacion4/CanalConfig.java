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
                Intent intent = new Intent(CanalConfig.this, MenuCanal.class);
                intent.putExtra("Canal", canal);
                startActivity(intent);
            }
        });

    }
}
