package fabian.stomas.aplicacion4;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fabian.stomas.aplicacion4.databinding.VerUsuariosCanalBinding;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VerUsuariosCanal extends AppCompatActivity {
    DatabaseManager dtbmng = new DatabaseManager(this);
    int id_canal;
    int admin;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        VerUsuariosCanalBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ver_usuarios_canal);
        binding = VerUsuariosCanalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Canal canal = (Canal) getIntent().getSerializableExtra("Canal");
        id_canal = canal.getId();
        admin = canal.getAdmin();
        binding.returnVistas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Usuario.idActual == admin){
                    Intent intent = new Intent(VerUsuariosCanal.this, CanalConfig.class);
                    intent.putExtra("Canal", canal);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(VerUsuariosCanal.this, CanalConfigUsuario.class);
                    intent.putExtra("Canal", canal);
                    startActivity(intent);
                }
            }
        });
        ArrayList<Usuario> usuarios = dtbmng.getUsuariosDelCanal(id_canal);
        RecyclerView recyclerView = binding.recyclerUsuariosCanal;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Usuario> itemList = new ArrayList<>();
        for(Usuario i: usuarios){
            itemList.add(new Usuario(i.getID(), i.getNombre(), i.getApellido(), i.getCorreo()));
        }
        MyAdapter3 myAdapter3 = new MyAdapter3(itemList);
        recyclerView.setAdapter(myAdapter3);
    }

}
