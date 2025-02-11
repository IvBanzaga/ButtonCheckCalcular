package com.vanzaga.buttoncheckcalcular;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1, etNum2;
    private TextView tvResultado;
    private CheckBox cbSuma, cbResta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.txt_num1);
        etNum2 = findViewById(R.id.txt_num2);
        tvResultado = findViewById(R.id.textView_resultado);
        cbSuma = findViewById(R.id.checkBox_suma);
        cbResta = findViewById(R.id.checkBox_resta);
    }

    public void calcular(View view) {
        String num1 = etNum1.getText().toString();
        String num2 = etNum2.getText().toString();
        String resultado = "";
        int opcion = 0;

        if (!num1.isEmpty() && !num2.isEmpty()) {
            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);

            if (cbSuma.isChecked() && cbResta.isChecked()) {
                opcion = 3;
            } else if (cbSuma.isChecked()) {
                opcion = 1;
            } else if (cbResta.isChecked()) {
                opcion = 2;
            }

            switch (opcion) {
                case 1:
                    double suma = n1 + n2;
                    resultado = String.format("%.2f", suma);
                    break;

                case 2:
                    double resta = n1 - n2;
                    if (n2 > n1) {
                        resta = n2 - n1;
                    }
                    resultado = String.format("%.2f", resta);
                    break;

                case 3:
                    resultado = "1 sola opción SUMAR o RESTAR";
                    break;

                default:
                    resultado = "Selecciona una opción SUMAR o RESTAR";
                    break;
            }
            tvResultado.setText(resultado);
        } else {
            tvResultado.setText(HtmlCompat.fromHtml(getString(R.string.mensaje), HtmlCompat.FROM_HTML_MODE_LEGACY));
        }
    }
}