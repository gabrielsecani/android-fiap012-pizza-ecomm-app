package br.com.fiap.rm72468.pizzaecommerceapp;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PizzaActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rgPizzas;
    private CheckBox cbBorda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        rgPizzas = (RadioGroup)findViewById(R.id.rgPizzas);

        rgPizzas.setOnCheckedChangeListener(this);
        cbBorda = (CheckBox)findViewById(R.id.cbBorda);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {


        if (checkedId == R.id.rbMucarela) {
            cbBorda.setEnabled(false);
            cbBorda.setChecked(false);
        }else {
            cbBorda.setEnabled(true);
        }

    }

    public void calcular(View view) {

        double valorPizza = 0;

        switch (rgPizzas.getCheckedRadioButtonId()){
            case R.id.rbMucarela:
                valorPizza=10;
                break;
            case R.id.rbCalabresa:
                valorPizza=15;
                break;
            case R.id.rbPortuguesa:
                valorPizza=20;
                break;
        }

        if (cbBorda.isChecked()){
            valorPizza += 5;
        }
        AlertDialog.Builder msg = new AlertDialog.Builder(this)
                .setTitle("Pedido")
                .setMessage("O valor da pizza é: " + valorPizza);
        msg.show();
    }
}

