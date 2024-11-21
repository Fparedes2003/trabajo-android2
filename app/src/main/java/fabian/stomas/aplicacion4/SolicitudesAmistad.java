package fabian.stomas.aplicacion4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fabian.stomas.aplicacion4.databinding.SolicitudesAmistadBinding;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SolicitudesAmistad extends AppCompatActivity {
    DatabaseManager dtbmng = new DatabaseManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState){
        SolicitudesAmistadBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.solicitudes_amistad);
        binding = SolicitudesAmistadBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<Solicitudes> solicitudes = dtbmng.getSolicitudesDelUsuario(Usuario.idActual);
        RecyclerView recyclerView = binding.recyclerSolicitudes;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Solicitudes> items = new ArrayList<>();
        for(Solicitudes i: solicitudes){
            items.add(new Solicitudes(i.ID, i.id_remitente, i.NombreRemitente, i.ApellidoRemitente, i.CorreoRemitente, i.Estado));
        }
        MyAdapter4 myAdapter4 = new MyAdapter4(items);
        recyclerView.setAdapter(myAdapter4);
        myAdapter4.setOnClickListener(view ->{
            int position = recyclerView.getChildAdapterPosition(view);
            Solicitudes clickedItem = items.get(position);
            Intent intent = new Intent(SolicitudesAmistad.this, SolicitudesOpciones.class);
            intent.putExtra("Solicitudes", clickedItem);
            startActivity(intent);
        });
        binding.returnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SolicitudesAmistad.this, Editar.class);
                startActivity(intent);
            }
        });





    }
}
