package com.nabeel.calculator2000;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText number1;
    EditText number2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.calculateButton);
        number1 = (EditText) findViewById(R.id.num1);
        number2 = (EditText) findViewById(R.id.num2);
        result = (TextView) findViewById(R.id.result);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateButton();
            }
        });

    }



    public void calculateButton()
    {
        if(number1.getText().toString().trim().length() > 0 && number2.getText().toString().trim().length() > 0) {

            int a = Integer.parseInt(number1.getText().toString());
            int b = Integer.parseInt(number2.getText().toString());
            int r = a + b;
            result.setText(String.valueOf(r));
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Enter values",Toast.LENGTH_SHORT).show();
        }
    }
}
