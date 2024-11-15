package fabian.stomas.aplicacion4;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import fabian.stomas.aplicacion4.databinding.PerfilBinding;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Perfil extends AppCompatActivity {
    int idUsuario;
    String Nombre;
    String Apellido;
    String Correo;
    DatabaseManager dtbmng = new DatabaseManager(this);
    Amigos amigos = new Amigos();
    Amigos amigos2 = new Amigos();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        PerfilBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.perfil);
        binding = PerfilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Usuario usuario = (Usuario) getIntent().getSerializableExtra("Usuario");
        idUsuario = usuario.getID();
        Nombre = usuario.getNombre();
        Apellido = usuario.getApellido();
        Correo = usuario.getCorreo();
        binding.descripcionCorreo.setText(Correo);
        binding.nombreUsuario.setText(Nombre);
        binding.apellidoUsuario.setText(Apellido);
        binding.returnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Perfil.this, BuscarUsuarios.class);
                startActivity(intent);
            }
        });
        binding.agregarAmigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amigos.setId_usuario(Usuario.idActual);
                amigos.setId_amigo(idUsuario);
                amigos2.setId_usuario(idUsuario);
                amigos2.setId_amigo(Usuario.idActual);
                dtbmng.insertAmigos(amigos);
                dtbmng.insertAmigos(amigos2);
                Toast.makeText(Perfil.this, "SE HA AGREGADO A: "+Nombre+ "COMO TU AMIGO", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Perfil.this, BuscarUsuarios.class);
                startActivity(intent);
            }
        });


    }



}
