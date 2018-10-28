package ims.informationmanagementsystem.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import ims.informationmanagementsystem.R;

public class Main10Activity extends AppCompatActivity {

    ImageView Computer, Physics,Chemistry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        Computer=(ImageView) findViewById(R.id.computer);
        Physics=(ImageView) findViewById(R.id.Physics);
        Chemistry=(ImageView) findViewById(R.id.Chemistry);

        Computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Computer();
            }

            private void Computer() {
                Intent intent=new Intent(Main10Activity.this,Main11Activity.class);
                startActivity(intent);

            }
        });

        Physics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Physics();
            }

            private void Physics() {

                Intent intent=new Intent(Main10Activity.this,Main12Activity.class);
                startActivity(intent);
            }
        });

        Chemistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chemistry();
            }

            private void Chemistry() {
                Intent i=new Intent(Main10Activity.this,Main13Activity.class);
                startActivity(i);
            }
        });


    }
}
