package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edit_weight, edit_heightf, edit_heighti;
        Button btn_calculate;
        TextView txt_result;
        LinearLayout llMain;

        edit_weight = findViewById(R.id.edit_weight);
        edit_heightf = findViewById(R.id.edit_heightf);
        edit_heighti = findViewById(R.id.edit_heighti);
        btn_calculate = findViewById(R.id.btn_calculate);
        txt_result = findViewById(R.id.txt_result);
        llMain = findViewById(R.id.llMain);
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int wt = Integer.parseInt( edit_weight.getText().toString());
               int htf  = Integer.parseInt( edit_heightf.getText().toString());
               int hti = Integer.parseInt(edit_heighti.getText().toString())       ;

               int totalin = htf*12+hti;
               double totalcm = totalin * 2.53;
               double totalm = totalcm/100;

               double bmi = wt/(totalm*totalm);

               if (bmi>25){
                   txt_result.setText("you are over weight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorHw));
               }
              else if(bmi<18){
                txt_result.setText("you are under weight");
                llMain.setBackgroundColor(getResources().getColor(R.color.colorUw));
            }   else{
                txt_result.setText("you are healthy ");
                llMain.setBackgroundColor(getResources().getColor(R.color.colorRw));
            }

        };
    });
}
}
