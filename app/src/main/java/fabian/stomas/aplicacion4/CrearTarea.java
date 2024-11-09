package fabian.stomas.aplicacion4;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import fabian.stomas.aplicacion4.databinding.CrearTareaBinding;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CrearTarea extends AppCompatActivity {
    int tarea_id;
    String Titulo;
    String Descripcion;
    String Estado = "Pendiente";
    String Fecha_expiracion;
    Date Fecha_parseada;
    Tarea tarea = new Tarea();
    DatabaseManager dtbmng = new DatabaseManager(this);
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    protected void onCreate(Bundle savedInstanceState){
        CrearTareaBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.crear_tarea);
        binding = CrearTareaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        System.out.println(Canal.idCanal);
        binding.crearTareaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Titulo = binding.editTextText.getText().toString();
                Descripcion = binding.editText.getText().toString();
                Fecha_expiracion = binding.eFecha.getText().toString();
                tarea.setTitulo(Titulo);
                tarea.setDescripcion(Descripcion);
                try{
                    Fecha_parseada = formatter.parse(Fecha_expiracion);
                    tarea.setFecha_expiracion(Fecha_parseada);
                    tarea.setEstado(Estado);
                    tarea_id = dtbmng.insertTarea(tarea);
                    dtbmng.updateCanalTarea_ID(Canal.idCanal, tarea_id);
                    Toast.makeText(CrearTarea.this, "SE HA CREADO LA TAREA", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CrearTarea.this, Menu.class);
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(CrearTarea.this, "LA FECHA INGRESADA NO COINCIDE CON EL FORMATO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
