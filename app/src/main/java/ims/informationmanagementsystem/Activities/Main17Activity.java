package ims.informationmanagementsystem.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import ims.informationmanagementsystem.Physics.PhyDate.Main4Activity;
import ims.informationmanagementsystem.Physics.PhyResult.Main5Activity;
import ims.informationmanagementsystem.R;

public class Main17Activity extends AppCompatActivity {

    ImageView Datesheet4, Result4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);

        Datesheet4=(ImageView) findViewById(R.id.Datesheet4);
        Result4  =(ImageView) findViewById(R.id.Result4);


        Datesheet4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Datesheet4();
            }

            private void Datesheet4() {
                Intent intent=new Intent(Main17Activity.this, Main4Activity.class);
                startActivity(intent);
            }
        });

        Result4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Result4();
            }

            private void Result4() {
                Intent intent =new Intent(Main17Activity.this, Main5Activity.class);
                startActivity(intent);
            }
        });
    }
}
