package com.maths.mycalculator;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView  result;
    AppCompatButton btnleftbrac, btnrightbrac, btnc;
    AppCompatButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    AppCompatButton  btnmod, btndiv, btnmul, btnplus, btnminus, btnequal;
    AppCompatButton  btnac, btndot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        // Initialize TextViews
        result = findViewById(R.id.result);
        // Display greeting toast
        Toast.makeText(this, "Hello my calculator", Toast.LENGTH_SHORT).show();
        // Initialize buttons
        assignId(btnc , R.id.btnc2);
        assignId(btnleftbrac , R.id.btnleftbrac);
        assignId(btnrightbrac , R.id.btnrightbrac);
        assignId(btn0 , R.id.btn0);
        assignId(btn1 , R.id.btn1);
        assignId(btn2 , R.id.btn2);
        assignId(btn3 , R.id.btn3);
        assignId(btn4 , R.id.btn4);
        assignId(btn5 , R.id.btn5);
        assignId(btn6 , R.id.btn6);
        assignId(btn7 , R.id.btn7);
        assignId(btn8 , R.id.btn8);
        assignId(btn9 , R.id.btn9);
        assignId(btnmod , R.id.btnmod);
        assignId(btnmul , R.id.btnmul);
        assignId(btnplus , R.id.btnplus);
        assignId(btnminus , R.id.btnminus);
        assignId(btndiv , R.id.btndiv);
        assignId(btnequal , R.id.btnequal);
        assignId(btnac , R.id.btnac);
        assignId(btndot , R.id.btndot);

    }

    void assignId(View btn , int Id){
        btn = findViewById(Id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        AppCompatButton button = (AppCompatButton) v;
        String buttontext = button.getText().toString();
        String datatocalculate = result.getText().toString();

        if(buttontext.equals("AC")){
            result.setText("");
            result.setText("0");
            return;
        }
        if(buttontext.equals("=")) {
            result.setText(getResult(datatocalculate));
            return;
        }

        if(buttontext.equals("c")) {
            if (datatocalculate.length() > 0) {
                datatocalculate = datatocalculate.substring(0, datatocalculate.length() - 1);
            }
            if(datatocalculate.isEmpty()){
                result.setText("0");
                return;
            }
            else{
                result.setText(datatocalculate);
                return;
            }
        }

        else {
            if (datatocalculate.equals("0")) {
                datatocalculate = buttontext;
            } else {
                datatocalculate = datatocalculate + buttontext;
            }
        }

        result.setText(datatocalculate);


}

 String getResult(String data){
     try{
         Context context  = Context.enter();
         context.setOptimizationLevel(-1);
         Scriptable scriptable = context.initStandardObjects();
         String finalResult =  context.evaluateString(scriptable,data,"Javascript",1,null).toString();
         if(finalResult.endsWith(".0")){
             finalResult = finalResult.replace(".0","");

         }
         return finalResult;
     }catch (Exception e){
         return "Err";
     }
 }
}
