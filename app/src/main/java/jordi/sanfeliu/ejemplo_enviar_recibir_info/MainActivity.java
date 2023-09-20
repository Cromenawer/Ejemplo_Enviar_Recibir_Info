package jordi.sanfeliu.ejemplo_enviar_recibir_info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import jordi.sanfeliu.ejemplo_enviar_recibir_info.Modelos.Usuario;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtPassword;
    private Button btnDesencriptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVistas();
        BtnDesencriptar();

    }

    private void BtnDesencriptar() {
        btnDesencriptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtNombre.getText().toString().isEmpty() || txtPassword.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Rellene los campos", Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    Bundle bundle = new Bundle();

                    String nombre = txtNombre.getText().toString();
                    String password = txtPassword.getText().toString();

                    /*
                    bundle.putString("NOMBRE",nombre);
                    bundle.putString("PASSWORD",password);
                     */

                    Usuario u = new Usuario(nombre,password);
                    bundle.putSerializable("OBJETO",u);
                    intent.putExtras(bundle);

                    startActivity(intent);
                }
            }
        });
    }

    private void inicializarVistas() {
        txtNombre = findViewById(R.id.txtNombreUsuarioMain);
        txtPassword = findViewById(R.id.txtPasswordMain);
        btnDesencriptar = findViewById(R.id.btnPasswordMain);
    }
}