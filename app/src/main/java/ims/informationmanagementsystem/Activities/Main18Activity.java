package ims.informationmanagementsystem.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import ims.informationmanagementsystem.Chemistry.CheDate.Main6Activity;
import ims.informationmanagementsystem.Chemistry.CheResult.Main7Activity;
import ims.informationmanagementsystem.R;

public class Main18Activity extends AppCompatActivity {

    ImageView Datesheet5, Result5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main18);

        Datesheet5=(ImageView) findViewById(R.id.Datesheet5);
        Result5  =(ImageView) findViewById(R.id.Result5);


        Datesheet5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Datesheet5();
            }

            private void Datesheet5() {
                Intent intent=new Intent(Main18Activity.this, Main6Activity.class);
                startActivity(intent);

            }
        });

        Result5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Result5();
            }

            private void Result5() {
                Intent intent =new Intent(Main18Activity.this, Main7Activity.class);
                startActivity(intent);
            }
        });

    }
}
