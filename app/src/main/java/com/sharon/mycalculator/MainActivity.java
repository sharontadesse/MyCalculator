package com.sharon.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.DomainCombiner;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView tvshow;
    int seePicture = R.drawable.dog;
    double num = 0;
    double saveNum = 0;
    String massage = "";
    String operator = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

}

    private void init() {
        tvshow = (TextView)findViewById(R.id.tvshow);
    }

    public void picture (View v){

        ImageView image =  (ImageView) findViewById(R.id.imageView);
        if (seePicture == R.drawable.dog){
            image.setImageResource(R.drawable.cat);
            seePicture=R.drawable.cat;
        }
      else {
            image.setImageResource(R.drawable.dog);
            seePicture=R.drawable.dog;

        }


    }


    public void onClick(View v) {


        Button btn = (Button)v;

        if (v.getId() == R.id.btnPlus) {
            massage += "+";
            tvshow.setText(massage);
            saveNum = num;
            num = 0;
            operator = "+";

        } else if (v.getId() == R.id.btnMinus) {
            massage += "-";
            tvshow.setText(massage);
            saveNum = num;
            num = 0;
            operator = "-";

        } else if (v.getId() == R.id.btnDiv) {
            massage += "/";
            tvshow.setText(massage);
            saveNum = num;
            num = 0;
            operator = "/";

        } else if (v.getId() == R.id.btnMul) {
            massage += "*";
            tvshow.setText(massage);
            saveNum = num;
            num = 0;
            operator = "*";

        } else if (v.getId() == R.id.btnClean) {
            massage = "";
            tvshow.setText(massage);
            saveNum = 0;
            num = 0;

        } else {
            num = (num * 10) + Double.parseDouble(btn.getText().toString());
            massage += btn.getText().toString();
            tvshow.setText(massage);
        }

    }

    public void resultOnClick(View v) {
        double total = 0;
        if (operator.equals("+")) {
            total = saveNum + num;
        }

        if (operator.equals("-")) {
            total = saveNum - num;
        }

        if (operator.equals("/")) {
            total = saveNum / num;
        }
        if (operator.equals("*")) {
            total = saveNum * num;
        }
        if ((total*10) % 10 == 0) {

            tvshow.setText(massage + "=" + (int)total);

        }
        else {
            DecimalFormat decimalFormat = new DecimalFormat("0.0000");
            tvshow.setText(massage + " = " + decimalFormat.format(total)+"..." );
        }
        num = 0;
        saveNum = 0;
        massage = "";



    }

}


