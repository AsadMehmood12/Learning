package ims.informationmanagementsystem.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ims.informationmanagementsystem.Chemistry.CheDate.AddCheDate;
import ims.informationmanagementsystem.Chemistry.CheResult.AddCheResult;
import ims.informationmanagementsystem.R;

public class Main13Activity extends AppCompatActivity {

    Button Datesheet2, Result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);

        Datesheet2=(Button)findViewById(R.id.DateSheet2);
        Result2   =(Button)findViewById(R.id.Result2);

        Datesheet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Datesheet2();
            }

            private void Datesheet2() {
                Intent intent=new Intent(Main13Activity.this, AddCheDate.class);
                startActivity(intent);
            }
        });
        Result2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Result2();
            }

            private void Result2() {
                Intent intent=new Intent(Main13Activity.this, AddCheResult.class);
                startActivity(intent);
            }
        });
    }
}
