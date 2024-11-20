package fabian.stomas.aplicacion4;
import fabian.stomas.aplicacion4.databinding.AgregarApunteBinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AgregarApunte extends AppCompatActivity {
    String Fecha_creacionf;
    DatabaseManager dtbmng = new DatabaseManager(this);
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    protected void onCreate(Bundle savedInstanceState){
        AgregarApunteBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.agregar_apunte);
        binding = AgregarApunteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Canal canal = (Canal) getIntent().getSerializableExtra("Canal");
        ArrayList<Apuntes> listaApuntes = dtbmng.getApuntesDelUsuario(Usuario.idActual);
        RecyclerView recyclerView = binding.recyclerApunteAgregar;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Apuntes> apuntesList = new ArrayList<>();
        for(Apuntes i: listaApuntes){
            Fecha_creacionf = formatter.format(i.Fecha_creacion);
            apuntesList.add(new Apuntes(i.ID, i.Titulo, i.Contenido, Fecha_creacionf, i.usuarioNombre, i.usuarioApellido));
        }
        MyAdapter5 myAdapter5 = new MyAdapter5(apuntesList);
        recyclerView.setAdapter(myAdapter5);
        myAdapter5.setOnClickListener(view -> {
            int position = recyclerView.getChildAdapterPosition(view);
            Apuntes clickedItem = apuntesList.get(position);
            Intent intent = new Intent(AgregarApunte.this, AgregarApunteCanal.class);
            intent.putExtra("Apuntes", clickedItem);
            intent.putExtra("Canal", canal);
            startActivity(intent);
        });
        binding.returnVistas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AgregarApunte.this, MenuCanalApuntes.class);
                intent.putExtra("Canal", canal);
                startActivity(intent);
            }
        });

    }
}
