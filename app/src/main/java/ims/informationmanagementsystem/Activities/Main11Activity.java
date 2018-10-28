package ims.informationmanagementsystem.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import ims.informationmanagementsystem.R;
import ims.informationmanagementsystem.computer.Datesheet.AddDateCom;
import ims.informationmanagementsystem.computer.Result.AddComResult;

public class Main11Activity extends AppCompatActivity {


    ImageView DATESHEET, RESULT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);

        DATESHEET=(ImageView) findViewById(R.id.DATESheet);

        RESULT=(ImageView) findViewById(R.id.RESULT);

        DATESHEET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DATESHEET();
            }

            private void DATESHEET() {

                Intent intent=new Intent(Main11Activity.this, AddDateCom.class);
                startActivity(intent);
            }
        });

        RESULT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RESULT();
            }

            private void RESULT() {

                Intent i=new Intent(Main11Activity.this, AddComResult.class);
                startActivity(i);
            }
        });
    }
}
