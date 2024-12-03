package fabian.stomas.aplicacion4;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fabian.stomas.aplicacion4.databinding.VerAmigosCanalBinding;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class VerAmigosCanal extends AppCompatActivity {
    DatabaseManager dtbmng = new DatabaseManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState){
        VerAmigosCanalBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ver_amigos_canal);
        binding = VerAmigosCanalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Canal canal = (Canal) getIntent().getSerializableExtra("Canal");
        ArrayList<Usuario> usuarios = dtbmng.getAmigosDelUsuario(Usuario.idActual);
        RecyclerView recyclerView = binding.amigoCanal;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Usuario> itemList = new ArrayList<>();
        for(Usuario i: usuarios){
            itemList.add(new Usuario(i.getNombre(), i.getApellido(), i.getCorreo(), i.getId_amigo()));
        }
        MyAdapter3 myAdapter3 = new MyAdapter3(itemList);
        recyclerView.setAdapter(myAdapter3);
        myAdapter3.setOnClickListener(view -> {
            int position = recyclerView.getChildAdapterPosition(view);
            Usuario clicketItem = itemList.get(position);
            Intent intent = new Intent(VerAmigosCanal.this, Agregar.class);
            intent.putExtra("Usuario", clicketItem);
            intent.putExtra("Canal", canal);
            startActivity(intent);
        });
        binding.returnVistas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VerAmigosCanal.this, CanalConfig.class);
                intent.putExtra("Canal", canal);
                startActivity(intent);
            }
        });
    }

}
