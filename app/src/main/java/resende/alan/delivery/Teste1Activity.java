package resende.alan.delivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Teste1Activity extends AppCompatActivity {

    Button btnRandom;
    TextView txtLista, txtValorResultado;
    EditText input1, input2, inputSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste1);

        txtLista = findViewById(R.id.txtLista);
        btnRandom = findViewById(R.id.btnRandom);
        txtValorResultado = findViewById(R.id.txtValorResultado);
        input1 = findViewById(R.id.inputInter1);
        input2 = findViewById(R.id.inputInter2);
        inputSum = findViewById(R.id.inputSum);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String v1 = input1.getText().toString();
                String v2 = input2.getText().toString();
                String sum = inputSum.getText().toString();

                if(v1.isEmpty()){
                    input1.setError("Digite um valor");
                    input1.setFocusable(true);
                }

                if(v2.isEmpty()){
                    input2.setError("Digite um valor");
                    input2.setFocusable(true);
                }

                if(sum.isEmpty()){
                    inputSum.setError("Digite um valor");
                    inputSum.setFocusable(true);
                }else{

                    int[] lista = new int[8];
                    StringBuilder stringBuilder = new StringBuilder();

                    for (int i = 0; i < 8; i++) {
                        int inteiro = ThreadLocalRandom.current().nextInt(Integer.parseInt(v1),
                                Integer.parseInt(v2));
                        lista[i] = inteiro;
                        stringBuilder.append(" ").append(inteiro);
                    }

                    txtLista.setText(stringBuilder);
                    FindRequiredSumArray(lista, Integer.parseInt(sum));
                    txtValorResultado.setText(String.valueOf(lista[0] + "," + lista[lista.length -1]));
                }
            }
        });
    }

    private static void FindRequiredSumArray(int[] arr, int sum){
        ArrayList<Integer> sub = new ArrayList<>(arr.length);

        int temp = 0;
        int total = 0;
        for (int i = 0; i <= arr.length -1; i++){
            for (int j = 0; j <= arr.length -1; j++){
                temp += arr[j];
                sub.add(arr[j]);
                if(temp == sum){
                    for (int k = 0; k < sub.size(); k++){
                        total += sub.get(k);
                    }
                }
            }

            if(temp > sum){
                sub.clear();
                break;
            }
        }
    }
}