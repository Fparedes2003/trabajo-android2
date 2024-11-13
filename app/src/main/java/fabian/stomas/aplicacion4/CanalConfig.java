package fabian.stomas.aplicacion4;

import android.os.Bundle;
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

    }
}
