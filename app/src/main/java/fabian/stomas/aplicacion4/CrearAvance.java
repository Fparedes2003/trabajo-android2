package fabian.stomas.aplicacion4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import fabian.stomas.aplicacion4.databinding.CrearAvanceBinding;
public class CrearAvance extends AppCompatActivity {
    int idCanal;
    String tituloAvance;
    String descripcionAvance;
    String Fecha_avancedb;
    Avance avance = new Avance();
    DatabaseManager dtmng = new DatabaseManager(this);
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected void onCreate(Bundle savedInstanceState){
        CrearAvanceBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.crear_avance);
        binding = CrearAvanceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Canal canal = (Canal) getIntent().getSerializableExtra("Canal");
        idCanal = canal.getId();
        formatter.setTimeZone(TimeZone.getTimeZone("America/Santiago"));
        Fecha_avancedb = formatter.format(Calendar.getInstance().getTime());
        System.out.println(Fecha_avancedb);
        binding.crearAvancebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tituloAvance = binding.tituloAvance.getText().toString();
                descripcionAvance = binding.descripcionAvance.getText().toString();
                avance.setTitulo(tituloAvance);
                avance.setDescripcion(descripcionAvance);
                avance.setFecha_avancedb(Fecha_avancedb);
                avance.setId_usuario(Usuario.idActual);
                avance.setId_canal(idCanal);
                dtmng.insertAvance(avance);
                Toast.makeText(CrearAvance.this, "SE HA AGREGADO TU AVANCE", Toast.LENGTH_SHORT).show();
            }
        });
        binding.returnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrearAvance.this, MenuCanal.class);
                intent.putExtra("Canal", canal);
                startActivity(intent);
            }
        });

    }
}
