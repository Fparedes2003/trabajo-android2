package fabian.stomas.aplicacion4;
import fabian.stomas.aplicacion4.databinding.VerApuntesBinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class VerApuntes extends AppCompatActivity {
    DatabaseManager dtbmng = new DatabaseManager(this);
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String Fecha_avancef;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        VerApuntesBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ver_apuntes);
        binding = VerApuntesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<Apuntes> listaApuntes = dtbmng.getApuntesDelUsuario(Usuario.idActual);
        RecyclerView recyclerView = binding.recyclerVerApuntes;
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
                Intent intent = new Intent(VerApuntes.this, Editar.class);
                startActivity(intent);
            }
        });


    }
}












