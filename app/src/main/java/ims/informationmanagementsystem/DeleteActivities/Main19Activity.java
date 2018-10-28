package ims.informationmanagementsystem.DeleteActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ims.informationmanagementsystem.DataBase.DatabaseHelper;
import ims.informationmanagementsystem.R;

public class Main19Activity extends AppCompatActivity {


    DatabaseHelper mDatabaseHelper;
    Button DeleteEventData;
    EditText EnterEventData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main19);
        DeleteEventData=(Button)findViewById(R.id.DeletHomeData);
        EnterEventData=(EditText)findViewById(R.id.nameEventData);
        mDatabaseHelper=new DatabaseHelper(this);

        DeleteEventData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabaseHelper.DeletData1(EnterEventData.getText().toString());

            }
        });
    }
}
