package fabian.stomas.aplicacion4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import fabian.stomas.aplicacion4.databinding.CrearApunteBinding;

public class CrearApunte extends AppCompatActivity {
    CrearApunteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.crear_apunte);

        binding = CrearApunteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.returnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrearApunte.this, Editar.class);
                startActivity(intent);
            }
        });
    }
}
