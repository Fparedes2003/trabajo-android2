package fabian.stomas.aplicacion4;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import fabian.stomas.aplicacion4.databinding.PasswordBinding;

public class Password extends AppCompatActivity {
    protected void onCreate(Bundle savedIntanceState){
        super.onCreate(savedIntanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.password);
        PasswordBinding binding;
        binding = PasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
