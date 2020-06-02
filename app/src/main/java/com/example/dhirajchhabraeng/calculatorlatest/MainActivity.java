package com.example.dhirajchhabraeng.calculatorlatest;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "MainActivity";

    private DrawerLayout calculatorButtonDrawer;
    private SlidingPaneLayout slidingPaneLayout;
    private NoKeyBoardEditText userInputEditText;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnDot, btn0, btnEquals;
    private Button btnDelete, btnDivide, btnMultiply, btnSubtract, btnAdd;
    private Button btnInv, btnRad, btnPercentage, btnSin, btnCos, btnTan, btnLn, btnLog, btnRoot, btnPie, btnEpsilon, btnPower, btnLeftPar, btnRightPar, btnExc;
    private TextView outputTextView;
    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tool_bar_main_screen);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        slidingPaneLayout = findViewById(R.id.sliding_pane_layout);
        slidingPaneLayout.setSliderFadeColor(getResources().getColor(android.R.color.transparent));
        slidingPaneLayout.openPane();

        userInputEditText = findViewById(R.id.user_input_edit_text);

        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);

        btnDot = findViewById(R.id.btn_dot);
        btn0 = findViewById(R.id.btn_0);
        btnEquals = findViewById(R.id.btn_equals);

        btnDelete = findViewById(R.id.btn_delete);
        btnDivide = findViewById(R.id.btn_divide);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnSubtract = findViewById(R.id.btn_subtract);
        btnAdd = findViewById(R.id.btn_add);

        btnInv = findViewById(R.id.btn_inv);
        btnRad = findViewById(R.id.btn_rad);
        btnPercentage = findViewById(R.id.btn_percentage);
        btnSin = findViewById(R.id.btn_sin);
        btnCos = findViewById(R.id.btn_cos);
        btnTan = findViewById(R.id.btn_tan);
        btnLn = findViewById(R.id.btn_ln);
        btnLog = findViewById(R.id.btn_log);
        btnRoot = findViewById(R.id.btn_root);
        btnPie = findViewById(R.id.btn_pie);
        btnEpsilon = findViewById(R.id.btn_epsilon);
        btnPower = findViewById(R.id.btn_power);
        btnLeftPar = findViewById(R.id.btn_left_par);
        btnRightPar = findViewById(R.id.btn_right_par);
        btnExc = findViewById(R.id.btn_exc);

        outputTextView = findViewById(R.id.output_text_view);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btnDot.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnEquals.setOnClickListener(this);

        btnDelete.setOnClickListener(this);
        btnDelete.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.delete(0, stringBuilder.length() - 1);
                    userInputEditText.setText("");
                    outputTextView.setText("");
                }
                return false;
            }
        });
        btnDivide.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnAdd.setOnClickListener(this);

        btnInv.setOnClickListener(this);
        btnRad.setOnClickListener(this);
        btnPercentage.setOnClickListener(this);
        btnSin.setOnClickListener(this);
        btnCos.setOnClickListener(this);
        btnTan.setOnClickListener(this);
        btnLn.setOnClickListener(this);
        btnLog.setOnClickListener(this);
        btnRoot.setOnClickListener(this);
        btnPie.setOnClickListener(this);
        btnEpsilon.setOnClickListener(this);
        btnPower.setOnClickListener(this);
        btnLeftPar.setOnClickListener(this);
        btnRightPar.setOnClickListener(this);
        btnExc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

//        if (stringBuilder.length() > 10) {
//            userInputEditText.setTextSize(R.dimen.display_digit_size_lengthy);
//        }


        if (v.getId() != R.id.btn_equals && v.getId() != R.id.btn_delete) {
            stringBuilder.append(((Button) v).getText().toString());
         k   userInputEditText.setText(stringBuilder.toString());

        } else if (v.getId() == R.id.btn_delete && stringBuilder.length() != 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//                        if (stringBuilder.length() <= 10 && userInputEditText.getTextSize() != R.dimen.display_digit_size_lengthy) {
//                            userInputEditText.setTextSize(R.dimen.display_digit_size_normal);
//                        }
            userInputEditText.setText(stringBuilder.toString());

        } else if (v.getId() == R.id.btn_equals && stringBuilder.length() > 0) {
            String inputString = stringBuilder.toString();
            inputString = inputString.replace("&#37;", "%").
                    replace("&#8730;", "r").
                    replace("sin", "s").
                    replace("cos", "c").
                    replace("tan", "t").
                    replace("log", "l").
                    replace("ln", "n").
                    replace("&#928;", "p").
                    replace("e", "e").
                    replace("pow", "x");
            Log.e(TAG, "onClick: " + inputString);
            String outputString = "" + outputFunction(inputString);
            outputTextView.setText(outputString);
        }

    }

    public static int evaluate(String expression) {
        char[] tokens = expression.toCharArray();

        // Stack for numbers: 'values'
        Stack<Integer> values = new Stack<Integer>();

        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {
            // Current token is a whitespace, skip it
            if (tokens[i] == ' ')
                continue;

            // Current token is a number, push it to stack for numbers
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                i--; // RUn kar bhai!!!!!!!!!!!
                values.push(Integer.parseInt(sbuf.toString()));
            }

            // Current token is an opening brace, push it to 'ops'
            else if (tokens[i] == '(')
                ops.push(tokens[i]);

                // Closing brace encountered, solve entire brace
            else if (tokens[i] == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' ||
                    tokens[i] == '/' || tokens[i] == '%' || tokens[i] == 's' ||
                    tokens[i] == 'c' || tokens[i] == 't' || tokens[i] == 'n' ||
                    tokens[i] == 'l' || tokens[i] == 'r' || tokens[i] == 'p' ||
                    tokens[i] == 'e' || tokens[i] == 'x') {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }

        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        // Top of 'values' contains result, return it
        return values.pop();
    }

    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    // A utility method to apply an operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
            case '%':
                return (a * b) / 100;
            case 's':
                return (int) Math.sin(a);
            case 'c':
                return (int) Math.cos(a);
            case 't':
                return (int) Math.tan(a);
            case 'n':
                return (int) Math.log(a);
            case 'l':
                return (int) Math.log10(a);
            case 'r':
                return (int) Math.log10(a);
            case 'p':
                return (int) Math.PI;
            case 'e':
                return (int) Math.E;
            case 'x':
                return (int) Math.pow(a, b);
        }
        return 0;
    }

    public String outputFunction(String outputString) {

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        double result = 0;
        try {
            result = (double) engine.eval(outputString);
        } catch (Exception e) {

        }

        return "" + result;
    }
}

