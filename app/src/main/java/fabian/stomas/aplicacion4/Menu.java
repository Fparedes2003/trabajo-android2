package fabian.stomas.aplicacion4;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import fabian.stomas.aplicacion4.databinding.MenuBinding;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {
    DatabaseManager dbmng = new DatabaseManager(this);
    String nombreCanal;
    String descripcionCanal;
    String tipoCanal;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        MenuBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menu);
        binding = MenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<Canal> canales = dbmng.getAllCanalesDelUsuario(Usuario.idActual);
        binding.buttonCrearCanales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, CrearCanal.class);
                startActivity(intent);
            }
        });
        RecyclerView recyclerView = binding.recycler;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Canal> itemList = new ArrayList<>();
        for(Canal i: canales){
            itemList.add(new Canal( i.Id,i.Nombre,i.Descripcion,i.Tipo_canaldb, i.Tipo_canal, i.Tarea_ID, i.admin));
        }
        MyAdapter adapter = new MyAdapter(itemList);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(view -> {
            int position = recyclerView.getChildAdapterPosition(view);
            Canal clickedItem = itemList.get(position);
            Intent intent = new Intent(Menu.this, PantallaEsperaCanal.class);
            intent.putExtra("Canal", clickedItem);
            startActivity(intent);
        });
        binding.usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Editar.class);
                startActivity(intent);
            }
        });
        binding.lupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, BuscarUsuarios.class);
                startActivity(intent);
            }
        });

    }
}
