package fabian.stomas.aplicacion4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fabian.stomas.aplicacion4.databinding.MenuCanalApuntesBinding;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MenuCanalApuntes extends AppCompatActivity {
    int id_canal;
    String Nombre;
    String Descripcion;
    int admin;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String Fecha_avancef;
    DatabaseManager dtbmng = new DatabaseManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState){
        MenuCanalApuntesBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menu_canal_apuntes);
        binding = MenuCanalApuntesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Canal canal = (Canal) getIntent().getSerializableExtra("Canal");
        id_canal = canal.getId();
        Nombre = canal.getNombre();
        admin = canal.getAdmin();
        binding.tituloDelCanal.setText(Nombre);
        ArrayList<Apuntes> listaApuntes = dtbmng.getApuntesDelCanal(id_canal);
        RecyclerView recyclerView = binding.recyclerApuntesDelCanal;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Apuntes> apuntesList = new ArrayList<>();
        for(Apuntes i: listaApuntes){
            Fecha_avancef = formatter.format(i.Fecha_creacion);
            apuntesList.add(new Apuntes(i.ID, i.Titulo, i.Contenido, Fecha_avancef, i.usuarioNombre, i.usuarioApellido));
        }
        MyAdapter5 myAdapter5 = new MyAdapter5(apuntesList);
        recyclerView.setAdapter(myAdapter5);
        binding.returnVistas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuCanalApuntes.this, Menu.class);
                startActivity(intent);
            }
        });
        binding.opciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Usuario.idActual == admin){
                    Intent intent = new Intent(MenuCanalApuntes.this, CanalConfig.class);
                    intent.putExtra("Canal", canal);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(MenuCanalApuntes.this, CanalConfigUsuario.class);
                    intent.putExtra("Canal", canal);
                    startActivity(intent);
                }
            }
        });
        binding.agregarApunteAlCanal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuCanalApuntes.this, AgregarApunte.class);
                intent.putExtra("Canal", canal);
                startActivity(intent);
            }
        });



    }
}
