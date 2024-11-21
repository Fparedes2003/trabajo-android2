package fabian.stomas.aplicacion4;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import fabian.stomas.aplicacion4.databinding.AgregarBinding;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Agregar extends AppCompatActivity {
    int idUsuarioAgregar;
    int id_canal;
    UsuariosCanales usuariosCanales = new UsuariosCanales();
    DatabaseManager dtbmng = new DatabaseManager(this);
    UsuariosCanales usuariosCanalesvf;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        AgregarBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.agregar);
        binding = AgregarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Usuario usuario = (Usuario) getIntent().getSerializableExtra("Usuario");
        Canal canal = (Canal) getIntent().getSerializableExtra("Canal");
        id_canal = canal.getId();
        idUsuarioAgregar = usuario.getId_amigo();
        binding.agregarAmigoAlCanal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuariosCanalesvf = dtbmng.verificarSiElUsuarioEstaEnCanal(idUsuarioAgregar, id_canal);
                if(usuariosCanalesvf == null){
                    usuariosCanales.setId_usuario(idUsuarioAgregar);
                    usuariosCanales.setId_canal(id_canal);
                    dtbmng.insertUsuarios_canales(usuariosCanales);
                    Toast.makeText(Agregar.this, "SE HA AGREGADO AL USUARIO AL CANAL", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Agregar.this, VerAmigosCanal.class);
                    intent.putExtra("Canal", canal);
                    startActivity(intent);

                }else{
                    Toast.makeText(Agregar.this, "EL USUARIO YA SE ENCUENTRA EN ESTE CANAL", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.returnVistas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Agregar.this, VerAmigosCanal.class);
                intent.putExtra("Canal", canal);
                startActivity(intent);
            }
        });
    }
}
