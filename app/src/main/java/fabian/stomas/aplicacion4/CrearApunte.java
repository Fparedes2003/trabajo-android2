package fabian.stomas.aplicacion4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import fabian.stomas.aplicacion4.databinding.CrearApunteBinding;

public class CrearApunte extends AppCompatActivity {
    CrearApunteBinding binding;
    String tituloApunte;
    String contenidoApunte;
    String fecha_creacion;
    Apuntes apunte = new Apuntes();
    DatabaseManager dtbmng = new DatabaseManager(this);
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.crear_apunte);
        binding = CrearApunteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        formatter.setTimeZone(TimeZone.getTimeZone("America/Santiago"));
        fecha_creacion = formatter.format(Calendar.getInstance().getTime());
        binding.returnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrearApunte.this, Editar.class);
                startActivity(intent);
            }
        });
        binding.GuardarApunte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tituloApunte = binding.tituloApunte.getText().toString();
                contenidoApunte = binding.ContenidoApunte.getText().toString();
                apunte.setTitulo(tituloApunte);
                apunte.setContenido(contenidoApunte);
                apunte.setFecha_creaciondb(fecha_creacion);
                apunte.setId_propietario(Usuario.idActual);
                dtbmng.insertApunte(apunte);
                Toast.makeText(CrearApunte.this, "TU APUNTE SE HA GUARDADO", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CrearApunte.this, Editar.class);
                startActivity(intent);
            }
        });

    }
}
