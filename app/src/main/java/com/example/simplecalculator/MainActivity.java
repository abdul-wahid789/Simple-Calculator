package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView primaryView,secondaryView;
double num1=0,num2=0,result=0,memory=0;
char operator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        primaryView=findViewById(R.id.primaryView);
        secondaryView=findViewById(R.id.secondaryView);

    }
    public void numBtnFunction(View view) {
        String primary=primaryView.getText().toString();
        if (primary.equals("0")){
            display(view,"");
        }
        else{
            display(view,primary);
        }
    }
    public void cleanFunction(View view){
        if(view.getId()==R.id.cBtnID){
            primaryView.setText("0");
            secondaryView.setText("");
            operator='0';
            num1=num2=result=0;
        }
        else if (view.getId()==R.id.ceBtnID){
            primaryView.setText("0");
        }
        else{
            String str=primaryView.getText().toString();
            primaryView.setText(str.substring(0,str.length()-1));
        }
    }
    public void operationFunction(View view){
        num1=Double.parseDouble(primaryView.getText().toString());
        String primary=primaryView.getText().toString();
        if(view.getId()==R.id.sumBtnID){
            operator='+';
        }
        else if(view.getId()==R.id.subBtnID){
            operator='-';
        }
        else if(view.getId()==R.id.multiBtnID){
            operator='*';
        }
        else if (view.getId()==R.id.divBtnID){
            operator='/';
        }

        secondaryView.setText(primary+""+operator);
        primaryView.setText("0");

    }
    public void resultFunction(View view) {
        num2=Double.parseDouble(primaryView.getText().toString());
        if(view.getId()==R.id.persentBtnID){
            num2=num2/100;
        }
        if (operator=='+'){
            result=num1+num2;
        }
        else if (operator=='-'){
            result=num1-num2;
        }
        else if (operator=='*'){
            result=num1*num2;
        }
        else if (operator=='/'){
            result=num1/num2;
        }
        primaryView.setText(result+"");
        secondaryView.setText(num1+""+operator+""+num2+"=");
    }

    public void display(View view, String primary){
        if(view.getId()==R.id.zeroBtnID){
            primaryView.setText(primary+0);
        }
        else if(view.getId()==R.id.oneBtnID){
            primaryView.setText(primary+1);
        }
        else if(view.getId()==R.id.twoBtnID){
            primaryView.setText(primary+2);
        }
        else if(view.getId()==R.id.threeBtnID){
            primaryView.setText(primary+3);
        }
        else if(view.getId()==R.id.fourBtnID){
            primaryView.setText(primary+4);
        }
        else if(view.getId()==R.id.fiveBtnID){
            primaryView.setText(primary+5);
        }
        else if(view.getId()==R.id.sixBtnID){
            primaryView.setText(primary+6);
        }
        else if(view.getId()==R.id.sevenBtnID){
            primaryView.setText(primary+7);
        }
        else if(view.getId()==R.id.eightBtnID){
            primaryView.setText(primary+8);
        }
        else if (view.getId()==R.id.nineBtnID){
            primaryView.setText(primary+9);
        }
        else if (view.getId()==R.id.invertBtnID){
            if(primary.charAt(0)!='-'){
                primaryView.setText("-"+primary);
            }
            else{

                primaryView.setText(primary.substring(0+1));
            }
        }
        else{
            if(primary.contains(".")){
                primaryView.setText(primary);
            }
            else{
                primaryView.setText(primary+".");
            }
        }
    }
    public void extraFunction(View view) {
        double primaryValue=Double.parseDouble(primaryView.getText().toString());
        if(view.getId()==R.id.squareBtnID){
            primaryView.setText((primaryValue*primaryValue)+"");
            secondaryView.setText("Sqr("+primaryValue+")");
        }
        else if (view.getId()==R.id.rootBtnID){
            primaryView.setText(Math.sqrt(primaryValue)+"");
            secondaryView.setText("√("+primaryValue+")");
        }
        else if (view.getId()==R.id.oneByXBtnID){
            primaryView.setText((1/primaryValue)+"");
            secondaryView.setText("1/("+primaryValue+")");
        }

    }
    public void memoryFunction(View view) {
        double temp=Double.parseDouble(primaryView.getText().toString());
        if(view.getId()==R.id.mcBtnID){
            memory=0;
        }
        else if(view.getId()==R.id.mrBtnID){
            primaryView.setText(""+memory);
        }
        else if(view.getId()==R.id.mPlusBtnID){
            memory=memory+temp;
        }
        else if(view.getId()==R.id.mMinusBtnID){
            memory=memory-temp;
        }
        else{
            memory=temp;
        }
    }

}