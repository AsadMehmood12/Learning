package ims.informationmanagementsystem.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;

import ims.informationmanagementsystem.R;
import ims.informationmanagementsystem.computer.Datesheet.MainDateComputerActivity;
import ims.informationmanagementsystem.computer.Result.Main3Activity;

public class Main16Activity extends AppCompatActivity {

     ImageView DATESHEET3, RESULT3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16);


        DATESHEET3=(ImageView)findViewById(R.id.DateSheet3);
        RESULT3  =(ImageView)findViewById(R.id.Result3);


        DATESHEET3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DATESHEET3();
            }

            private void DATESHEET3() {
                Intent intent =new Intent(Main16Activity.this, MainDateComputerActivity.class);
                startActivity(intent);
            }
        });

        RESULT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RESULT3();
            }

            private void RESULT3() {

                Intent intent =new Intent(Main16Activity.this, Main3Activity.class);
                startActivity(intent);
            }
        });
    }
}
