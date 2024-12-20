package fabian.stomas.aplicacion4;
import static fabian.stomas.aplicacion4.Usuarios.usuarios;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import fabian.stomas.aplicacion4.databinding.EditarBinding;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Editar extends AppCompatActivity {
    String usuarioNombre;
    String usuarioApellido;
    String usuarioCorreo;
    String usuarioTelefono;
    protected void onCreate(Bundle savedInstanceState){
        EditarBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.editar);
        binding = EditarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        for(Usuario i: usuarios){
            System.out.println(i.getNombre());
            System.out.println(i.getCorreo());
            binding.profileText.setText(i.getNombre());
            binding.emailText.setText(i.getCorreo());
        }
        binding.usereditBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Editar.this, editarUsuario.class);
                startActivity(intent);
            }
        });
        binding.returnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Editar.this, Menu.class);
                startActivity(intent);
            }
        });
        binding.CrearApuntes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Editar.this, CrearApunte.class);
                startActivity(intent);
            }
        });
        binding.verSolicitudes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Editar.this, SolicitudesAmistad.class);
                startActivity(intent);
            }
        });
        binding.FriendList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Editar.this, VerAmigos.class);
                startActivity(intent);
            }
        });
        binding.VerApuntes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Editar.this, VerApuntes.class);
                startActivity(intent);
            }
        });
    }
}
