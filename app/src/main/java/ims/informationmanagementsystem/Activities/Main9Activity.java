package ims.informationmanagementsystem.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import ims.informationmanagementsystem.Event.AddEvent;
import ims.informationmanagementsystem.Home.AddForm;
import ims.informationmanagementsystem.R;

public class Main9Activity extends AppCompatActivity {

    ImageView Home,Departments,Events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        Home=(ImageView) findViewById(R.id.Home);
        Departments=(ImageView) findViewById(R.id.Departments);
        Events=(ImageView) findViewById(R.id.Events);


        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Home();
            }

            private void Home() {
                Intent intent=new Intent(Main9Activity.this, AddForm.class);
                startActivity(intent);
            }
        });
        Departments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Departments();
            }

            private void Departments() {
                Intent intent=new Intent(Main9Activity.this,Main10Activity.class);
                startActivity(intent);
            }
        });
        Events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Events();
            }

            private void Events() {
                Intent intent = new Intent(Main9Activity.this, AddEvent.class);
                startActivity(intent);
            }
        });
    }
}
