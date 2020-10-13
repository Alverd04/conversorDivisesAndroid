package com.example.calculadoradivises;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    float yen_value = 0;
    float dolar_value = 0;
    float pound_value = 0;
    float gem_value = 0;
    float current_user_value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        Button btn;


        // Button yen
        btn = findViewById(R.id.btn_yen);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(yen_value == 0){
                    AlertDialog ad = new AlertDialog.Builder(this).create();
                    ad.setTitle("Introdueix el valor de la moneda");
                    ad.setMessage("Introdueix el valor de la moneda");
                }
            }
        });

        // Dolar yen
        btn = findViewById(R.id.btn_dolar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Pound yen
        btn = findViewById(R.id.btn_pounds);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Gem yen
        btn = findViewById(R.id.btn_gem);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Button 1
        btn = findViewById(R.id.btn_one);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeCalculatorNumber("1");
            }
        });

        // Button 2
        btn = findViewById(R.id.btn_two);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeCalculatorNumber("2");
            }
        });

        // Button 3
        btn = findViewById(R.id.btn_three);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeCalculatorNumber("3");
            }
        });

        // Button 4
        btn = findViewById(R.id.btn_four);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeCalculatorNumber("4");
            }
        });

        // Button 5
        btn = findViewById(R.id.btn_five);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeCalculatorNumber("5");
            }
        });

        // Button 6
        btn = findViewById(R.id.btn_six);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeCalculatorNumber("6");
            }
        });

        // Button 7
        btn = findViewById(R.id.btn_seven);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeCalculatorNumber("7");
            }
        });

        // Button 8
        btn = findViewById(R.id.btn_eight);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeCalculatorNumber("8");
            }
        });

        // Button 9
        btn = findViewById(R.id.btn_nine);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeCalculatorNumber("9");
            }
        });

        // Button 0
        btn = findViewById(R.id.btn_zero);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeCalculatorNumber("0");
            }
        });

        // Button ,
        btn = findViewById(R.id.btn_coma);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeCalculatorNumber(",");
            }
        });

        // Equals button
        btn = findViewById(R.id.btn_equals);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView calculator_text = (TextView) findViewById(R.id.input_calculator);
                CharSequence user_value;
                user_value =  convertUserValue(calculator_text.getText());
                Float f = new Float(user_value.toString());
                current_user_value = f;
                calculator_text.setText(f.toString());
                current_user_value = f;
            }

        });

        // Delete button
        btn = findViewById(R.id.btn_c);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteLastNumber();
            }
        });

        // Clear button
        btn = findViewById(R.id.btn_ce);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearCalculator();
            }
        });

    }



    public void changeCalculatorNumber(String value) {
        final TextView calculator_text = (TextView) findViewById(R.id.input_calculator);
        if(calculator_text.getText().toString().equalsIgnoreCase("0")){
            calculator_text.setText(value.toString());
        }
        else{
            calculator_text.setText(calculator_text.getText().toString() + value.toString());
        }
    }

    public void clearCalculator() {
        final TextView calculator_text = (TextView) findViewById(R.id.input_calculator);
        calculator_text.setText("0");
    }

    public void deleteLastNumber() {
        CharSequence return_word = "";
        final TextView calculator_text = (TextView) findViewById(R.id.input_calculator);
        int calculator_lenght = 0;

        CharSequence current_text = calculator_text.getText();

        if(current_text.length() > 1){
            calculator_lenght = current_text.length();
        }
        else if(current_text.length() <= 1){
            calculator_lenght= 2;
        }

        for(int i = 0; i <  calculator_lenght-1; i++){
            if (current_text.length() == 1){
                calculator_text.setText("0");
                break;
            }
            else{
                return_word = return_word + "" + current_text.charAt(i);
                calculator_text.setText(return_word);
            }
        }
    }

    public CharSequence convertUserValue(CharSequence user_value){

        CharSequence converted_user_value = "";

        for(int i = 0; i < user_value.length(); i++){
            if(user_value.charAt(i) == ','){
                converted_user_value = converted_user_value + ".";
                continue;
            }
            else{
                converted_user_value = converted_user_value + "" + user_value.charAt(i);
            }
        }

        return converted_user_value;
    }


}


