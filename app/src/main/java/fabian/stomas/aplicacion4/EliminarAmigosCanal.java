package fabian.stomas.aplicacion4;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fabian.stomas.aplicacion4.databinding.EliminarAmigosCanalBinding;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EliminarAmigosCanal extends AppCompatActivity {
    DatabaseManager dtbmng = new DatabaseManager(this);
    int id_canal;
    int admin;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        EliminarAmigosCanalBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.eliminar_amigos_canal);
        binding = EliminarAmigosCanalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Canal canal = (Canal) getIntent().getSerializableExtra("Canal");
        id_canal = canal.getId();
        admin = canal.getAdmin();
        System.out.println("EL ID DEL ADMIN DEL CANAL ES: "+admin);
        binding.returnVistas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EliminarAmigosCanal.this, CanalConfig.class);
                intent.putExtra("Canal", canal);
                startActivity(intent);
            }
        });
        ArrayList<Usuario> usuariosCanal = dtbmng.getUsuariosDelCanal(id_canal);
        RecyclerView recyclerView = binding.recyclerEliminarUsuario;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Usuario> itemList = new ArrayList<>();
        for(Usuario i: usuariosCanal){
            if(admin != i.ID){
                itemList.add(new Usuario(i.ID, i.Nombre, i.Apellido, i.Correo));
            }
        }
        MyAdapter3 myAdapter3 = new MyAdapter3(itemList);
        recyclerView.setAdapter(myAdapter3);
        myAdapter3.setOnClickListener(view -> {
            int position = recyclerView.getChildAdapterPosition(view);
            Usuario clickedItem = itemList.get(position);
            Intent intent = new Intent(EliminarAmigosCanal.this, EliminarUsuarioDeCanal.class);
            intent.putExtra("Usuario", clickedItem);
            intent.putExtra("Canal", canal);
            startActivity(intent);
        });


    }

}
