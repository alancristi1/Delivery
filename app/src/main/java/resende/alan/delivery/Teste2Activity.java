package resende.alan.delivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Teste2Activity extends AppCompatActivity {

    EditText inputPalavra;
    TextView txtResultado;
    Button btnExecutar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste2);

        btnExecutar = findViewById(R.id.btnExecutar);
        txtResultado = findViewById(R.id.txtResultado);
        inputPalavra = findViewById(R.id.inputPalavra);

        btnExecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String palavra = inputPalavra.getText().toString();

                String resultado = verificarPalavra(palavra, (char) 0);
                txtResultado.setText(resultado);
            }
        });
    }

    public String verificarPalavra(String palavra, char temp){
        ArrayList<String> letras = new ArrayList<>(palavra.length());
        for (int i = 0; i < palavra.length(); i++){
            if(palavra.charAt(i) == temp){
                letras.add(String.valueOf(temp));
            }
            temp = palavra.charAt(i);
        }
        return String.valueOf(letras);
    }
}
