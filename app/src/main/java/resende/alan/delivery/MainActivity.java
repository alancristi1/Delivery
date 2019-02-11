package resende.alan.delivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnExec1, btnExec2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExec1 = findViewById(R.id.btnExec1);
        btnExec2 = findViewById(R.id.btnExec2);

        btnExec1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Teste1Activity.class);
                startActivity(i);
            }
        });

        btnExec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Teste2Activity.class);
                startActivity(i);
            }
        });
    }
}
