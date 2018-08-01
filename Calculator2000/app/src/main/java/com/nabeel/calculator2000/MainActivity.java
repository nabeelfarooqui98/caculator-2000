package com.nabeel.calculator2000;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button plus;
    private Button sub;
    private Button mul;
    private Button div;
    private Button equal;
    private Button deci;
    private Button clear;
    private TextView input;
    private TextView result;
    private double val1 = Double.NaN;
    private double val2;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;


    //DecimalFormat decimalFormat =new DecimalFormat("#.##########");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setbuttons();


        zero.setOnClickListener(new View.OnClickListener() {
            //overrided i dont know from where!!!
            public void onClick(View v) {
                input.setText(input.getText().toString() + "0");
            }

        });
        one.setOnClickListener(new View.OnClickListener() {
            //overrided i dont know from where!!!
            public void onClick(View v) {
                input.setText(input.getText().toString() + "1");
            }

        });
        two.setOnClickListener(new View.OnClickListener() {
            //overrided i dont know from where!!!
            public void onClick(View v) {
                input.setText(input.getText().toString() + "2");
            }

        });
        three.setOnClickListener(new View.OnClickListener() {
            //overrided i dont know from where!!!
            public void onClick(View v) {
                input.setText(input.getText().toString() + "3");
            }

        });
        four.setOnClickListener(new View.OnClickListener() {
            //overrided i dont know from where!!!
            public void onClick(View v) {
                input.setText(input.getText().toString() + "4");
            }

        });
        five.setOnClickListener(new View.OnClickListener() {
            //overrided i dont know from where!!!
            public void onClick(View v) {
                input.setText(input.getText().toString() + "5");
            }

        });
        six.setOnClickListener(new View.OnClickListener() {
            //overrided i dont know from where!!!
            public void onClick(View v) {
                input.setText(input.getText().toString() + "6");
            }

        });
        seven.setOnClickListener(new View.OnClickListener() {
            //overrided i dont know from where!!!
            public void onClick(View v) {
                input.setText(input.getText().toString() + "7");
            }

        });
        eight.setOnClickListener(new View.OnClickListener() {
            //overrided i dont know from where!!!
            public void onClick(View v) {
                input.setText(input.getText().toString() + "8");
            }

        });
        nine.setOnClickListener(new View.OnClickListener() {
            //overrided i dont know from where!!!
            public void onClick(View v) {
                input.setText(input.getText().toString() + "9");
            }

        });
        deci.setOnClickListener(new View.OnClickListener() {
            //overrided i dont know from where!!!
            public void onClick(View v) {
                input.setText(input.getText().toString() + ".");
            }

        });
        clear.setOnClickListener(new View.OnClickListener() {
            //overrided i dont know from where!!!
            public void onClick(View v) {


                input.setText(input.getText().length() - 1);
            }

        });


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                result.setText(val1 + "+");
                input.setText(null);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                result.setText(val1 + "-");
                input.setText(null);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                result.setText(val1 + "*");
                input.setText(null);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                result.setText(val1 + "/");
                input.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                //binding.infoTextView.setText(binding.infoTextView.getText().toString() + val2 + " = " + val1);
                String s = Double.toString(val1);
                result.setText(s);
                input.setText(null);
                val1 = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });

    }

    private void setbuttons() {
        //binding nam ke koi chez hoti h usse yeh sab hojata h
        zero = (Button) findViewById(R.id.btn0);
        one = (Button) findViewById(R.id.btn1);
        two = (Button) findViewById(R.id.btn2);
        three = (Button) findViewById(R.id.btn3);
        four = (Button) findViewById(R.id.btn4);
        five = (Button) findViewById(R.id.btn5);
        six = (Button) findViewById(R.id.btn6);
        seven = (Button) findViewById(R.id.btn7);
        eight = (Button) findViewById(R.id.btn8);
        nine = (Button) findViewById(R.id.bnt9);
        plus = (Button) findViewById(R.id.btnplus);
        mul = (Button) findViewById(R.id.btnmul);
        div = (Button) findViewById(R.id.btndiv);
        sub = (Button) findViewById(R.id.btnsub);
        equal = (Button) findViewById(R.id.btneq);
        deci = (Button) findViewById(R.id.btndot);
        clear = (Button) findViewById(R.id.Clear);
        input = (TextView) findViewById(R.id.input);
        result = (TextView) findViewById(R.id.Result);

    }

    private void computeCalculation() {
        if (!Double.isNaN(val1)) {
            val2 = Double.parseDouble(input.getText().toString());
            input.setText(null);

            if (CURRENT_ACTION == ADDITION)
                val1 = this.val1 + val2;
            else if (CURRENT_ACTION == SUBTRACTION)
                val1 = this.val1 - val2;
            else if (CURRENT_ACTION == MULTIPLICATION)
                val1 = this.val1 * val2;
            else if (CURRENT_ACTION == DIVISION)
                val1 = this.val1 / val2;
        } else {
            try {
                val1 = Double.parseDouble(input.getText().toString());
            } catch (Exception e) {
            }


        }
    }
}


