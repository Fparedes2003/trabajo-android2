package fabian.stomas.aplicacion4;
import fabian.stomas.aplicacion4.databinding.BuscarUsuariosBinding;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BuscarUsuarios extends AppCompatActivity implements SearchView.OnQueryTextListener{
    SearchView buscar;
    MyAdapter3 adapter3;
    DatabaseManager dtbmng = new DatabaseManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState){
        BuscarUsuariosBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.buscar_usuarios);
        binding = BuscarUsuariosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        buscar = binding.buscar;
        buscar.setOnQueryTextListener(this);
        ArrayList<Usuario> usuarios = dtbmng.getAllUsuarios();
        RecyclerView recyclerView = binding.recyclerUsuarios;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter3 = new MyAdapter3(usuarios);
        recyclerView.setAdapter(adapter3);
        adapter3.setOnClickListener(view -> {
            int position = recyclerView.getChildAdapterPosition(view);
            Usuario clickedItem = usuarios.get(position);
            //Intent intent = new Intent(BuscarUsuarios.this, Prueba.class);
            //intent.putExtra("Usuario", clickedItem);
            //startActivity(intent);
        });
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter3.filtrado(s);
        return false;
    }
}
