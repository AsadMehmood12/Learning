package ims.informationmanagementsystem.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import ims.informationmanagementsystem.Event.Main2Activity;
import ims.informationmanagementsystem.Home.MainActivity;
import ims.informationmanagementsystem.R;

public class Main14Activity extends AppCompatActivity {

    ImageView Home1, Departments1,Events1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);

        Home1=(ImageView)findViewById(R.id.Home1);
        Departments1=(ImageView)findViewById(R.id.Depart1);
        Events1  =(ImageView)findViewById(R.id.Events1);

        Home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Home1();
            }

            private void Home1() {
                Intent intent =new Intent(Main14Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Departments1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Departments1();
            }

            private void Departments1() {
                Intent intent=new Intent(Main14Activity.this,Main15Activity.class);
                startActivity(intent);
            }
        });

        Events1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Events1();
            }

            private void Events1() {
                Intent intent =new Intent(Main14Activity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
