package com.vanzaga.buttoncheckcalcular;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.text.HtmlCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private EditText etNum1, etNum2;
    private TextView tvResultado;
    private CheckBox rbSuma, rbResta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        etNum1 = findViewById(R.id.txt_num1);
        etNum2 = findViewById(R.id.txt_num2);
        tvResultado = findViewById(R.id.textView_resultado);
        rbSuma = findViewById(R.id.checkBox_suma);
        rbResta = findViewById(R.id.checkBox_resta);
    }

    public void calcular(View view) {
        String num1 = etNum1.getText().toString();
        String num2 = etNum2.getText().toString();
        String resultado = "";
        int opcion = 0;

        if (!num1.isEmpty() && !num2.isEmpty()) {
            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);

            if (rbSuma.isChecked()) {
                opcion = 1;
            } else if (rbResta.isChecked()) {
                opcion = 2;
            }

            switch (opcion) {
                case 1:
                    double suma = n1 + n2;
                    resultado = String.format("%.2f", suma);
                    break;

                case 2:
                    double resta = n1 - n2;
                    resultado = String.format("%.2f", resta);
                    break;

                default:
                    resultado = "Selecciona una opción";
                    break;
            }
            tvResultado.setText(resultado);
        } else {
            tvResultado.setText(HtmlCompat.fromHtml(getString(R.string.mensaje), HtmlCompat.FROM_HTML_MODE_LEGACY));
        }
    }
}