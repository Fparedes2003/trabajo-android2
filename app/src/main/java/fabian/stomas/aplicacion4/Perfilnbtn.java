package fabian.stomas.aplicacion4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import fabian.stomas.aplicacion4.databinding.PerfilNbtnBinding;

public class Perfilnbtn extends AppCompatActivity {
    int idUsuario;
    String Nombre;
    String Apellido;
    String Correo;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        PerfilNbtnBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.perfil_nbtn);
        binding = PerfilNbtnBinding.inflate(getLayoutInflater());
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
                Intent intent = new Intent(Perfilnbtn.this, BuscarUsuarios.class);
                startActivity(intent);
            }
        });

    }

}
