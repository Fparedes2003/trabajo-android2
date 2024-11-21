package fabian.stomas.aplicacion4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import fabian.stomas.aplicacion4.databinding.AgregarApunteCanalBinding;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class AgregarApunteCanal extends AppCompatActivity {
    DatabaseManager dtbmng = new DatabaseManager(this);
    CanalesApuntes canalesApuntesvf;
    int id_canal;
    int id_apunte;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        AgregarApunteCanalBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.agregar_apunte_canal);
        binding = AgregarApunteCanalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Apuntes apuntes = (Apuntes) getIntent().getSerializableExtra("Apuntes");
        Canal canal = (Canal) getIntent().getSerializableExtra("Canal");
        id_canal = canal.getId();
        id_apunte = apuntes.getID();
        binding.returnVistas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AgregarApunteCanal.this, AgregarApunte.class);
                intent.putExtra("Canal", canal);
                startActivity(intent);
            }
        });
        binding.btnAgregarApunte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canalesApuntesvf = dtbmng.verificarApunteEnCanal(id_apunte, id_canal);
                if(canalesApuntesvf == null){
                    dtbmng.insertCanales_apuntes(id_apunte, id_canal);
                    Toast.makeText(AgregarApunteCanal.this, "SE HA AGREGADO TU APUNTE AL CANAL", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AgregarApunteCanal.this, AgregarApunte.class);
                    intent.putExtra("Canal", canal);
                    startActivity(intent);
                }else{
                    Toast.makeText(AgregarApunteCanal.this, "ESTE APUNTE YA SE ENCUENTRA EN EL CANAL", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
