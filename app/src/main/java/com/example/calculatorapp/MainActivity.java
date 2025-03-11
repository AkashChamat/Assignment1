package com.example.calculatorapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView output, val;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,
            btnAdd, btnSub, btnMulti, btnDiv, btnclear, btnEqual;
    ButtonListener btnListener = new ButtonListener();

    String actualInput = "";
    String operator = "";
    double initialN0 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        val = findViewById(R.id.val);
        output = findViewById(R.id.output);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btn0 = findViewById(R.id.btn_0);
        btnAdd = findViewById(R.id.btn_Add);
        btnSub = findViewById(R.id.btn_Sub);
        btnMulti = findViewById(R.id.btn_Multi);
        btnDiv = findViewById(R.id.btn_Div);
        btnclear = findViewById(R.id.btn_clear);
        btnEqual = findViewById(R.id.btn_equal);

        btn0.setOnClickListener(btnListener);
        btn1.setOnClickListener(btnListener);
        btn2.setOnClickListener(btnListener);
        btn3.setOnClickListener(btnListener);
        btn4.setOnClickListener(btnListener);
        btn5.setOnClickListener(btnListener);
        btn6.setOnClickListener(btnListener);
        btn7.setOnClickListener(btnListener);
        btn8.setOnClickListener(btnListener);
        btn9.setOnClickListener(btnListener);
        btnAdd.setOnClickListener(btnListener);
        btnSub.setOnClickListener(btnListener);
        btnMulti.setOnClickListener(btnListener);
        btnDiv.setOnClickListener(btnListener);
        btnclear.setOnClickListener(btnListener);
        btnEqual.setOnClickListener(btnListener);
    }

    class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Button b = (Button) v;
            String btnText = b.getText().toString();

            if (v.getId() == R.id.btn_0) {
                val.append("0");
                actualInput = actualInput + "0";
            } else if (v.getId() == R.id.btn_1) {
                val.append("1");
                actualInput = actualInput + "1";
            } else if (v.getId() == R.id.btn_2) {
                val.append("2");
                actualInput = actualInput + "2";
            } else if (v.getId() == R.id.btn_3) {
                val.append("3");
                actualInput = actualInput + "3";
            } else if (v.getId() == R.id.btn_4) {
                val.append("4");
                actualInput = actualInput + "4";
            } else if (v.getId() == R.id.btn_5) {
                val.append("5");
                actualInput = actualInput + "5";
            } else if (v.getId() == R.id.btn_6) {
                val.append("6");
                actualInput = actualInput + "6";
            } else if (v.getId() == R.id.btn_7) {
                val.append("7");
                actualInput = actualInput + "7";
            } else if (v.getId() == R.id.btn_8) {
                val.append("8");
                actualInput = actualInput + "8";
            } else if (v.getId() == R.id.btn_9) {
                val.append("9");
                actualInput = actualInput + "9";
            }
//             Clear Button
            else if (v.getId() == R.id.btn_clear) {
                val.setText("");
                output.setText("");
                actualInput = "";
                operator = "";
                initialN0 = 0;
            }

//            operators
            else if (v.getId() == R.id.btn_Add || v.getId() == R.id.btn_Sub || v.getId() == R.id.btn_Multi || v.getId() == R.id.btn_Div) {
                if (!actualInput.isEmpty()) {
                    initialN0 = Double.parseDouble(actualInput);

                    // Convert symbols to correct operator values
                    if (v.getId() == R.id.btn_Add) {
                        operator = "+";
                    } else if (v.getId() == R.id.btn_Sub) {
                        operator = "-";
                    } else if (v.getId() == R.id.btn_Multi) {
                        operator = "x";
                    } else if (v.getId() == R.id.btn_Div) {
                        operator = "/";
                    }

                    val.setText(actualInput + " " + operator);
                    actualInput = "";
                }


            }
//             Equals BUtton
            if (v.getId() == R.id.btn_equal) {
                if (!actualInput.isEmpty()) {
                    double SecondNumber = Double.parseDouble(actualInput);
                    double result = 0.0;

                    switch (operator) {
                        case "+":
                            result = initialN0 + SecondNumber;
                            break;
                        case "-":
                            result = initialN0 - SecondNumber;
                            break;
                        case "x":
                            Log.e("x", initialN0+""+SecondNumber );
                            result = initialN0 * SecondNumber;
                            break;
                        case "/":
                            if (SecondNumber == 0) {
                                output.setText("Invalid! Division by zero.");
                                return;
                            } else {
                                Log.e("/", initialN0+""+SecondNumber );
                                result = initialN0 / SecondNumber;
                            }
                            break;
                    }
                    output.setText("Answer = " + String.format("%.2f", result));

                    actualInput = String.valueOf(result);
                    val.setText(actualInput);
                    operator = "";
                }
            }
        }
    }
}