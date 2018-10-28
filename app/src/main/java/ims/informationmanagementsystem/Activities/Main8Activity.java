package ims.informationmanagementsystem.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import ims.informationmanagementsystem.R;

public class Main8Activity extends AppCompatActivity {

    ImageView Admin, Students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        Admin=(ImageView) findViewById(R.id.admin);
        Students=(ImageView) findViewById(R.id.Students);

        Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                admin();
            }

            private void admin() {
                Intent intent = new Intent(Main8Activity.this,Main9Activity.class);
                startActivity(intent);
            }
        });

        Students.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Students();
            }

            private void Students() {
                Intent intent=new Intent(Main8Activity.this,Main14Activity.class);
                startActivity(intent);
            }
        });

    }
}
