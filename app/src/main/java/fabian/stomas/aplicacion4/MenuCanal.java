package fabian.stomas.aplicacion4;
import android.os.Bundle;
import fabian.stomas.aplicacion4.databinding.MenuCanalBinding;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MenuCanal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        MenuCanalBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menu_canal);
        binding = MenuCanalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

}
