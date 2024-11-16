package fabian.stomas.aplicacion4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fabian.stomas.aplicacion4.databinding.SolicitudesOpcionesBinding;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SolicitudesOpciones extends AppCompatActivity {
    int id_solicitud;
    int id_remitente;
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
        System.out.println("id solicitud: "+id_solicitud);
        System.out.println("id remitente: "+id_remitente);
        binding.returnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SolicitudesOpciones.this, SolicitudesAmistad.class);
                startActivity(intent);
            }
        });


    }
}
