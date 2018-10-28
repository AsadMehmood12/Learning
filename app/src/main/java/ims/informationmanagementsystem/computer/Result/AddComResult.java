package ims.informationmanagementsystem.computer.Result;

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
import ims.informationmanagementsystem.Event.AddEvent;
import ims.informationmanagementsystem.Event.Main2Activity;
import ims.informationmanagementsystem.R;

public class AddComResult extends AppCompatActivity {

    final int REQUEST_CODE_GALLERY = 999;
    DatabaseHelper mDatabaseHelper;
    Button btncomresult,btnchoosecomresult;
    EditText editTextcomresult;
    ImageView editImagecomresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_com_result);

        btncomresult = (Button) findViewById(R.id.addcomResult);
        btnchoosecomresult = (Button) findViewById(R.id.choosecomResult);
        editTextcomresult = (EditText) findViewById(R.id.editTextcomResult);
        editImagecomresult = (ImageView) findViewById(R.id.imageViewcomResult);

        mDatabaseHelper = new DatabaseHelper(this);

        btnchoosecomresult.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ActivityCompat.requestPermissions(
                                AddComResult.this,
                                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                REQUEST_CODE_GALLERY
                        );
                    }
                });


        btncomresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NewEntry = editTextcomresult.getText().toString();
                byte[] NewEntry1 = imageViewToByte(editImagecomresult);
                if (editTextcomresult.length() != 0)
                {
                    AddData3(NewEntry, NewEntry1);
                    Intent intent = new Intent(AddComResult.this, Main3Activity.class);
                    startActivity(intent);
                } else {
                    Toast("Field mandatory");
                }
            }


        });

    }
    private void AddData3(String newEntry,byte[] newEntry1)
    {
        boolean insertcomresult = mDatabaseHelper.AddData3(newEntry, newEntry1);
        if(insertcomresult)
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
    protected void onActivityResult(int requestCode, int resultCode, Intent comresult) {

        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && comresult != null){

            Uri uri = comresult.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                editImagecomresult.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, comresult);
    }
}

