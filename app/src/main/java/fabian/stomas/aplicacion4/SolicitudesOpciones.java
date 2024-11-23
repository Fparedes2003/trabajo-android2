package fabian.stomas.aplicacion4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import fabian.stomas.aplicacion4.databinding.SolicitudesOpcionesBinding;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SolicitudesOpciones extends AppCompatActivity {
    int id_solicitud;
    int id_remitente;
    String nombreRemitente;
    DatabaseManager dtbmng = new DatabaseManager(this);
    Amigos amigos = new Amigos();
    Amigos amigos2 = new Amigos();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        SolicitudesOpcionesBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.solicitudes_opciones);
        binding = SolicitudesOpcionesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Solicitudes solicitudes = (Solicitudes) getIntent().getSerializableExtra("Solicitudes");
        id_solicitud = solicitudes.getID();
        id_remitente = solicitudes.getId_remitente();
        nombreRemitente = solicitudes.getNombreRemitente();
        System.out.println("id solicitud: "+id_solicitud);
        System.out.println("id remitente: "+id_remitente);
        binding.returnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SolicitudesOpciones.this, SolicitudesAmistad.class);
                startActivity(intent);
            }
        });
        binding.aceptarSolicitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dtbmng.updateEstadoSolicitudAceptada(id_solicitud);
                amigos.setId_usuario(id_remitente);
                amigos.setId_amigo(Usuario.idActual);
                dtbmng.insertAmigos(amigos);
                amigos2.setId_usuario(Usuario.idActual);
                amigos2.setId_amigo(id_remitente);
                dtbmng.insertAmigos(amigos2);
                Toast.makeText(SolicitudesOpciones.this, "EL USUARIO " +nombreRemitente + " AHORA ES TU AMIGO", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SolicitudesOpciones.this, SolicitudesAmistad.class);
                startActivity(intent);
            }
        });
        binding.rechazarSolicitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dtbmng.updateEstadoSolicitudRechazada(id_solicitud);
                Toast.makeText(SolicitudesOpciones.this, "SE HA RECHAZADO LA SOLICITUD DE AMISTAD", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SolicitudesOpciones.this, SolicitudesAmistad.class);
                startActivity(intent);
            }
        });


    }
}
