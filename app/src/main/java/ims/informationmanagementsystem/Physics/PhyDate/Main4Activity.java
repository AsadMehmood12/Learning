package ims.informationmanagementsystem.Physics.PhyDate;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ims.informationmanagementsystem.DataBase.DatabaseHelper;
import ims.informationmanagementsystem.R;

public class Main4Activity extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    public ListView listViewPD;
    ArrayList<MyPhyDate> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        listViewPD = (ListView) findViewById(R.id.MyPDList);
        mDatabaseHelper = new DatabaseHelper(this);
        populateView();
        CustomAdapter adapter = new CustomAdapter(this, R.layout.custom5, listData);
        listViewPD.setAdapter(adapter);
    }

    private void populateView()
    {
        Cursor data = mDatabaseHelper.getData4();
        while(data.moveToNext())
        {
            String name = data.getString(1);
            byte[] image = data.getBlob(2);
            listData.add(new MyPhyDate(name,image));

        }
    }

    public class CustomAdapter extends BaseAdapter {
        private Context context;
        private int layout;
        ArrayList<MyPhyDate> textListPD;

        public CustomAdapter(Context context, int layout, ArrayList<MyPhyDate> textListPD) {
            this.context = context;
            this.layout = layout;
            this.textListPD = textListPD;
        }


        @Override
        public int getCount() {
            return textListPD.size();
        }

        @Override
        public Object getItem(int position) {
            return textListPD.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        private class ViewHolder {
            ImageView imageViewPd;
            TextView textNamePd;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            View row = view;

            ViewHolder holder;

            if (row == null
                    ) {

                LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(layout, null);
                holder = new ViewHolder();
                holder.textNamePd = (TextView) row.findViewById(R.id.textViewPD);
                holder.imageViewPd = (ImageView) row.findViewById(R.id.imageViewPhyD);
                row.setTag(holder);

            } else {
                holder = (ViewHolder) row.getTag();

            }
            final MyPhyDate food = textListPD.get(position);
            holder.textNamePd.setText(food.GetName());
            byte[] foodImage = food.GetImage();
            final Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage, 0, foodImage.length);
            holder.imageViewPd.setImageBitmap(bitmap);
            row.setOnClickListener(new AdapterView.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Cursor data = mDatabaseHelper.getData4ItemId(food.GetName());
                    int eventItemId = -1;
                    String FruitName = "";
                    byte[] FruitImage = null;

                    while (data.moveToNext()) {
                        eventItemId = data.getInt(0);
                        FruitName = data.getString(1);
                        FruitImage = data.getBlob(2);


                    }
                    if (eventItemId > -1) {

                        ToastMessage("On item Click: the id is" + eventItemId + " " + FruitName + " " + FruitImage);
                    } else {

                        ToastMessage("No Data");

                    }

                }



            });
            return row;
        }
    }
    private void ToastMessage(String s)
    {
        Toast.makeText(this, s ,Toast.LENGTH_SHORT).show();
    }
}




