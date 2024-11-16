package fabian.stomas.aplicacion4;

import android.content.Intent;
import android.os.Bundle;
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
            itemlist.add(new Usuario(i.Nombre, i.Apellido, i.Correo, i.id_amigo));
        }
        MyAdapter3 adapter3 = new MyAdapter3(itemlist);
        recyclerView.setAdapter(adapter3);
    }

}
