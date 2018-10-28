package ims.informationmanagementsystem.Event;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import ims.informationmanagementsystem.DataBase.DatabaseHelper;
import ims.informationmanagementsystem.DeleteActivities.Main19Activity;
import ims.informationmanagementsystem.R;

public class AddEvent extends AppCompatActivity {

    final int REQUEST_CODE_GALLERY = 999;
    DatabaseHelper mDatabaseHelper;
    Button btnEvent,btnEchoose,Delete;
    EditText editText1;
    ImageView editImage1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        btnEvent = (Button) findViewById(R.id.btnEvent);
        btnEchoose = (Button) findViewById(R.id.btnchooseEvent);
        editText1 = (EditText) findViewById(R.id.addtext);
        editImage1 = (ImageView) findViewById(R.id.imageView2);
        Delete=(Button)findViewById(R.id.DeleteHome);

        mDatabaseHelper = new DatabaseHelper(this);

        btnEchoose.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ActivityCompat.requestPermissions(
                                AddEvent.this,
                                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                REQUEST_CODE_GALLERY
                        );
                    }
                });


        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NewEntry1 = editText1.getText().toString();
                byte[] NewEntry2 = imageViewToByte(editImage1);
                if (editText1.length() != 0)
                {
                    AddData1(NewEntry1, NewEntry2);
                    Intent intent = new Intent(AddEvent.this, Main2Activity.class);
                    startActivity(intent);
                } else {
                    Toast("Field mandatory");
                }
            }


        });
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AddEvent.this, Main19Activity.class);
                startActivity(intent);
            }
        });

    }
    private void AddData1(String newEntry1,byte[] newEntry2)
    {
        boolean insertEvent = mDatabaseHelper.AddData1(newEntry1, newEntry2);
        if(insertEvent)
        {
            Toast("Data inserted");

        }
        else
        {
            Toast("Data not inserted");
        }
    }
    private  void Toast(String s)
    {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

    public byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }
            else {
                Toast.makeText(getApplicationContext(), "You don't have permission to access file location!", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent event) {

        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && event != null){

            Uri uri = event.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                editImage1.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, event);
    }
}



