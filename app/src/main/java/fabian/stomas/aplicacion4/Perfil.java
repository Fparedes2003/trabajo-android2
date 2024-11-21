package fabian.stomas.aplicacion4;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import fabian.stomas.aplicacion4.databinding.PerfilBinding;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Perfil extends AppCompatActivity {
    int idUsuario;
    int idRemitente;
    int idReceptor;
    String Nombre;
    String Apellido;
    String Correo;
    DatabaseManager dtbmng = new DatabaseManager(this);
    Solicitudes solicitudes = new Solicitudes();
    Solicitudes solicitudV;
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
                solicitudV = dtbmng.getSolicitudVerificacion(Usuario.idActual, idUsuario);
                if(solicitudV == null){
                    solicitudes.setEstado("PENDIENTE");
                    solicitudes.setId_remitente(Usuario.idActual);
                    solicitudes.setId_receptor(idUsuario);
                    dtbmng.insertSolicitud(solicitudes);
                    Toast.makeText(Perfil.this, "SE HA ENVIADO UNA SOLICITUD A : "+Nombre, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Perfil.this, BuscarUsuarios.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Perfil.this, "YA LE ENVIASTE UNA SOLICITUD A ESTE USUARIO", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }



}
