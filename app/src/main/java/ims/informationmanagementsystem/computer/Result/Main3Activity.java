package ims.informationmanagementsystem.computer.Result;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import ims.informationmanagementsystem.Event.Main2Activity;
import ims.informationmanagementsystem.Event.MyEvent;
import ims.informationmanagementsystem.R;

public class Main3Activity extends AppCompatActivity {


    DatabaseHelper mDatabaseHelper;
    public ListView listViewcomResult;
    ArrayList<MycomResult> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        listViewcomResult = (ListView) findViewById(R.id.MycomResult);
        mDatabaseHelper = new DatabaseHelper(this);
        populateView();
        CustomAdapter adapter = new CustomAdapter(this, R.layout.custom4, listData);
        listViewcomResult.setAdapter(adapter);
    }

    private void populateView()
    {
        Cursor data = mDatabaseHelper.getData3();
        while(data.moveToNext())
        {
            String name = data.getString(1);
            byte[] image = data.getBlob(2);
            listData.add(new MycomResult(name,image));

        }
    }

    public class CustomAdapter extends BaseAdapter
    {
        private Context context;private int layout;
        ArrayList<MycomResult> textList3;
        public CustomAdapter(Context context, int layout, ArrayList<MycomResult> textList3)
        {
            this.context = context;
            this.layout = layout;
            this.textList3 = textList3;
        }
        @Override
        public int getCount()
        {
            return textList3.size();
        }

        @Override
        public Object getItem(int position) {
            return textList3.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        private class ViewHolder
        {
            ImageView imageViewcomResult;
            TextView textcomResult;
        }
        @Override
        public View getView(int position, View view, ViewGroup parent)
        {
            View row = view;

            ViewHolder holder;

            if (row == null
                    ) {

                LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(layout, null);
                holder = new ViewHolder();
                holder.textcomResult = (TextView) row.findViewById(R.id.tvcomResult);
                holder.imageViewcomResult = (ImageView) row.findViewById(R.id.imcomResult);
                row.setTag(holder);

            }
            else
            {
                holder =(ViewHolder) row.getTag();

            }
            final MycomResult food = textList3.get(position);
            holder.textcomResult.setText(food.GetName());
            byte[] foodImage = food.GetImage();
            final Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage, 0 , foodImage.length);
            holder.imageViewcomResult.setImageBitmap(bitmap);
            row.setOnClickListener(new AdapterView.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Cursor data = mDatabaseHelper.getData3ItemId(food.GetName());
                    int eventItemId = -1;
                    String FruitName = "";
                    byte[] FruitImage = null;
                    while(data.moveToNext())
                    {
                        eventItemId = data.getInt(0);
                        FruitName = data.getString(1);
                        FruitImage = data.getBlob(2);


                    }
                    if(eventItemId > -1)
                    {
                        ToastMessage("On item Click: the id is" + eventItemId + " " + FruitName + " " + FruitImage);
                    }
                    else
                    {
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


