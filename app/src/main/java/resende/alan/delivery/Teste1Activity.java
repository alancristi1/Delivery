package resende.alan.delivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Teste1Activity extends AppCompatActivity {

    Button btnRandom;
    TextView txtLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste1);

        txtLista = findViewById(R.id.txtLista);
        btnRandom = findViewById(R.id.btnRandom);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ArrayList<Integer> lista = new ArrayList<>();
                int[] lista = new int[8];
                StringBuilder stringBuilder = new StringBuilder();

                for (int i = 0; i < 8; i++) {
                    int inteiro = ThreadLocalRandom.current().nextInt(-10, 10);
                    //lista.add(inteiro);
                    //int[] lista = new int[7];

                    lista[i] = inteiro;
                    stringBuilder.append(" ").append(inteiro);
                }

                txtLista.setText(stringBuilder);
                Log.i("log lista", String.valueOf(lista.length));
                FindRequiredSumArray(lista, 5);
            }
        });
    }

    private static void FindRequiredSumArray(int[] arr, int sum){
        int[] sub = new int[arr.length];
        int temp = 0, col = -1;
        for (int i = 0; i <= arr.length; i++){
            for (int j = 0; j <= arr.length; j++){
                col ++;
                temp += arr[j];
                Log.i("log col", String.valueOf(col));
                Log.i("log j", String.valueOf(j));
                sub[col] = arr[j];

                if(temp == sum){
                    int total = 0;
                    for (int k = 0; k < sub.length; k++){
                        total += sub[k];
                        Log.i("sub", String.valueOf(sub[k]));

                        if(total == sum){
                            Log.i("log null", "null");
                            break;
                        }
                    }
                }

                if(temp > sum){

                    sub[j] = 0;
                    Log.i("log sub clear", String.valueOf(sub[j]));
                    temp = 0;
                    break;
                }
            }
        }
    }
}