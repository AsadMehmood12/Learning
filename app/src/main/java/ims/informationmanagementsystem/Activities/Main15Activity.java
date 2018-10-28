package ims.informationmanagementsystem.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import ims.informationmanagementsystem.R;

public class Main15Activity extends AppCompatActivity {

    ImageView Computer1,Physics1,Chemistry1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main15);

        Computer1=(ImageView)findViewById(R.id.com1);
        Physics1 =(ImageView)findViewById(R.id.PHy1);
        Chemistry1=(ImageView)findViewById(R.id.Che1);

        Computer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Computer1();
            }

            private void Computer1() {
                Intent intent =new Intent(Main15Activity.this,Main16Activity.class);
                startActivity(intent);
            }
        });

        Physics1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Physics1();
            }

            private void Physics1() {

                Intent intent =new Intent(Main15Activity.this,Main17Activity.class);
                startActivity(intent);
            }
        });

        Chemistry1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chemistry1();
            }

            private void Chemistry1() {
                Intent intent = new Intent(Main15Activity.this,Main18Activity.class);
                startActivity(intent);
            }
        });


    }
}
