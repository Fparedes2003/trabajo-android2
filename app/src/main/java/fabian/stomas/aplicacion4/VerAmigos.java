package fabian.stomas.aplicacion4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fabian.stomas.aplicacion4.databinding.VerAmigosBinding;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VerAmigos extends AppCompatActivity {
    DatabaseManager dtbmn = new DatabaseManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState){
        VerAmigosBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ver_amigos);
        binding = VerAmigosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<Usuario> amigos = dtbmn.getAmigosDelUsuario(Usuario.idActual);
        RecyclerView recyclerView = binding.recyclerAmigos;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Usuario> itemlist = new ArrayList<>();
        for(Usuario i: amigos){
            itemlist.add(new Usuario(i.getNombre(), i.getApellido(), i.getCorreo(), i.getId_amigo()));
        }
        MyAdapter3 adapter3 = new MyAdapter3(itemlist);
        recyclerView.setAdapter(adapter3);
        binding.returnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VerAmigos.this, Editar.class);
                startActivity(intent);
            }
        });
    }

}
