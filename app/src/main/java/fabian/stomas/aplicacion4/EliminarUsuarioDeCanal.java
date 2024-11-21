package fabian.stomas.aplicacion4;
import fabian.stomas.aplicacion4.databinding.EliminarUsuarioCanalBinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class EliminarUsuarioDeCanal extends AppCompatActivity {
    DatabaseManager dtbmng = new DatabaseManager(this);
    int id_canal;
    int id_usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        EliminarUsuarioCanalBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.eliminar_usuario_canal);
        binding = EliminarUsuarioCanalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Canal canal = (Canal) getIntent().getSerializableExtra("Canal");
        Usuario usuario = (Usuario) getIntent().getSerializableExtra("Usuario");
        id_usuario = usuario.getID();
        id_canal = canal.getId();
        binding.returnVistas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EliminarUsuarioDeCanal.this, EliminarAmigosCanal.class);
                intent.putExtra("Canal", canal);
                startActivity(intent);
            }
        });
        binding.eliminarUsuarioDelCanal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dtbmng.deleteUsuariosDelCanal(id_usuario, id_canal);
                Toast.makeText(EliminarUsuarioDeCanal.this, "EL USUARIO SE HA ELIMINADO DEL CANAL", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EliminarUsuarioDeCanal.this, EliminarAmigosCanal.class);
                intent.putExtra("Canal", canal);
                startActivity(intent);

            }
        });
    }
}
