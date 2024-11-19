package fabian.stomas.aplicacion4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fabian.stomas.aplicacion4.databinding.MenuCanalApuntesBinding;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MenuCanalApuntes extends AppCompatActivity {
    int id_canal;
    String Nombre;
    String Descripcion;
    int admin;

    DatabaseManager dtbmng = new DatabaseManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState){
        MenuCanalApuntesBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menu_canal_apuntes);
        binding = MenuCanalApuntesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Canal canal = (Canal) getIntent().getSerializableExtra("Canal");
        id_canal = canal.getId();
        Nombre = canal.getNombre();
        admin = canal.getAdmin();
        binding.tituloDelCanal.setText(Nombre);
        binding.returnVistas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuCanalApuntes.this, Menu.class);
                startActivity(intent);
            }
        });
        binding.opciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Usuario.idActual == admin){
                    Intent intent = new Intent(MenuCanalApuntes.this, CanalConfig.class);
                    intent.putExtra("Canal", canal);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(MenuCanalApuntes.this, CanalConfigUsuario.class);
                    intent.putExtra("Canal", canal);
                    startActivity(intent);
                }
            }
        });



    }
}