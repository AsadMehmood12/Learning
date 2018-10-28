package ims.informationmanagementsystem.Chemistry.CheResult;

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
import ims.informationmanagementsystem.Physics.PhyResult.AddPhyResult;
import ims.informationmanagementsystem.Physics.PhyResult.Main5Activity;
import ims.informationmanagementsystem.R;

public class AddCheResult extends AppCompatActivity {
    final int REQUEST_CODE_GALLERY = 999;
    DatabaseHelper mDatabaseHelper;
    Button btnCR ,btnchooseCR;
    EditText editTextCR;
    ImageView editImageCR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_che_result);
        btnCR = (Button) findViewById(R.id.btnCR);
        btnchooseCR = (Button) findViewById(R.id.chooseCR);
        editTextCR = (EditText) findViewById(R.id.editTextCR);
        editImageCR = (ImageView) findViewById(R.id.imageViewCR);

        mDatabaseHelper = new DatabaseHelper(this);

        btnchooseCR.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ActivityCompat.requestPermissions(
                                AddCheResult.this,
                                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                REQUEST_CODE_GALLERY
                        );
                    }
                });


        btnCR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NewEntry13 = editTextCR.getText().toString();
                byte[] NewEntry14 = imageViewToByte(editImageCR);
                if (editTextCR.length() != 0)
                {
                    AddData7(NewEntry13, NewEntry14);
                    Intent intent = new Intent(AddCheResult.this, Main7Activity.class);
                    startActivity(intent);
                } else {
                    Toast("Field mandatory");
                }
            }


        });

    }
    private void AddData7(String newEntry13,byte[] newEntry14)
    {
        boolean insertPData = mDatabaseHelper.AddData7(newEntry13, newEntry14);
        if(insertPData)
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
    protected void onActivityResult(int requestCode, int resultCode, Intent pdata) {

        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && pdata != null){
            Uri uri = pdata.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                editImageCR.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, pdata);
    }

}
