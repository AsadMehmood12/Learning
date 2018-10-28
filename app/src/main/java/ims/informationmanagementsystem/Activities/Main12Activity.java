package ims.informationmanagementsystem.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ims.informationmanagementsystem.Physics.PhyDate.AddPhyDate;
import ims.informationmanagementsystem.Physics.PhyResult.AddPhyResult;
import ims.informationmanagementsystem.R;

public class Main12Activity extends AppCompatActivity {

    Button DATESHEET1, Result1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        DATESHEET1=(Button)findViewById(R.id.DATESHEET1);
        Result1   =(Button)findViewById(R.id.RESULT1);

        DATESHEET1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DATESHEET1();

            }

            private void DATESHEET1() {
                Intent intent=new Intent(Main12Activity.this, AddPhyDate.class);
                startActivity(intent);



            }
        });

        Result1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Result1();

            }

            private void Result1() {

                Intent i=new Intent(Main12Activity.this, AddPhyResult.class);
                startActivity(i);
            }
        });
    }
}
