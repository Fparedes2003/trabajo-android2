package fabian.stomas.aplicacion4;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import fabian.stomas.aplicacion4.databinding.MenuCanalBinding;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MenuCanal extends AppCompatActivity {
    int idCanal;
    String Nombre;
    String Descripcion;
    int idTareaDelCanal;
    String TituloTarea;
    String descripcionTarea;
    String estadoTarea;
    Date fechaTarea;
    String fechaTareaf;
    String Fecha_avancef;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    protected void onCreate(Bundle savedInstanceState){
        DatabaseManager dtbmng = new DatabaseManager(this);
        MenuCanalBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menu_canal);
        binding = MenuCanalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Canal canal = (Canal) getIntent().getSerializableExtra("Canal");
        idCanal = canal.getId();
        Nombre = canal.getNombre();
        Descripcion = canal.getDescripcion();
        idTareaDelCanal = canal.getTarea_ID();
        binding.nombreCanal.setText(Nombre);
        Tarea tarea = dtbmng.getTareaDelCanal(idTareaDelCanal);
        TituloTarea = tarea.getTitulo();
        descripcionTarea = tarea.getDescripcion();
        estadoTarea = tarea.getEstado();
        fechaTarea = tarea.getFecha_expiracion();
        fechaTareaf = formatter.format(fechaTarea);
        binding.tituloTarea.setText(TituloTarea);
        binding.descripcionTarea.setText(descripcionTarea);
        binding.estadoTarea.setText(estadoTarea);
        binding.fechaTarea.setText(fechaTareaf);
        ArrayList<Avance> listaAvances = dtbmng.getAvancesDelCanal(idCanal);
        RecyclerView recyclerView = binding.recyclerAvances;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Avance> avancesList = new ArrayList<>();
        for(Avance i: listaAvances){
            Fecha_avancef = formatter.format(i.Fecha_avance);
            avancesList.add(new Avance(i.Titulo, i.Descripcion, Fecha_avancef, i.nombreUsuariodb));
        }
        MyAdapter2 myAdapter2 = new MyAdapter2(avancesList);
        recyclerView.setAdapter(myAdapter2);
        binding.returnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuCanal.this, Menu.class);
                startActivity(intent);
            }
        });
        binding.Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuCanal.this, CrearAvance.class);
                intent.putExtra("Canal", canal);
                startActivity(intent);
            }
        });
        binding.opciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuCanal.this, CanalConfig.class);
                intent.putExtra("Canal", canal);
                startActivity(intent);

            }
        });
        binding.cambiarEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dtbmng.updateEstadoTarea(idTareaDelCanal);
                Toast.makeText(MenuCanal.this, "SE HA CAMBIADO EL ESTADO DE LA TAREA", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
