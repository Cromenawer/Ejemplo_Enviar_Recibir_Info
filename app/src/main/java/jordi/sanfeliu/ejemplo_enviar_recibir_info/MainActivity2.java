package jordi.sanfeliu.ejemplo_enviar_recibir_info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import jordi.sanfeliu.ejemplo_enviar_recibir_info.Modelos.Usuario;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        /*
        if (bundle != null){
            Toast.makeText(this, bundle.getString("NOMBRE") + " " + bundle.getString("PASSWORD"), Toast.LENGTH_SHORT).show();
        }
         */

        if (bundle != null){
            Usuario u = (Usuario) bundle.getSerializable("OBJETO");

            Toast.makeText(this, u.toString(), Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Bundle es null", Toast.LENGTH_SHORT).show();
        }

    }

}