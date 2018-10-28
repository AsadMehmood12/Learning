package ims.informationmanagementsystem.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Asad Mehmood on 09/01/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String Database_Name = "names.db";
    public static final String Table_Home = "home";
    public static final String Table_Event = "event";
    public static final String Table_ComDate = "ComDate";
    public static final String Table_ComResult = "ComResult";
    public static final String Table_PhyDate = "phydate";
    public static final String Table_PhyResult = "phyresult";
    public static final String Table_CheDate = "chedate";
    public static final String Table_CheResult = "cheresult";

    public DatabaseHelper(Context context) {

        super(context, Database_Name, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+ Table_Home + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, newimage blob)");
        db.execSQL("CREATE TABLE "+ Table_Event + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, newimage blob)");
        db.execSQL("CREATE TABLE "+ Table_ComDate + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, newimage blob)");
        db.execSQL("CREATE TABLE "+ Table_ComResult + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, newimage blob)");
        db.execSQL("CREATE TABLE "+ Table_PhyDate + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, newimage blob)");
        db.execSQL("CREATE TABLE "+ Table_PhyResult + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, newimage blob)");
        db.execSQL("CREATE TABLE "+ Table_CheDate + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, newimage blob)");
        db.execSQL("CREATE TABLE "+ Table_CheResult + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, newimage blob)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS " +Table_Home);
        db.execSQL(" DROP TABLE IF EXISTS " +Table_Event);
        db.execSQL(" DROP TABLE IF EXISTS " +Table_ComDate);
        db.execSQL(" DROP TABLE IF EXISTS " +Table_ComResult);
        db.execSQL(" DROP TABLE IF EXISTS " +Table_PhyDate);
        db.execSQL(" DROP TABLE IF EXISTS " +Table_PhyResult);
        db.execSQL(" DROP TABLE IF EXISTS " +Table_CheDate);
        db.execSQL(" DROP TABLE IF EXISTS " +Table_CheResult);
        onCreate(db);

    }

    public boolean AddData(String name,byte[] img)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("newimage",img);


        long result = db.insert(Table_Home ,null,contentValues);
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public Cursor getdata()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from " + Table_Home;
        Cursor data = db.rawQuery(query,null);
        return data;
    }

    public Cursor getItemId(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from "+ Table_Home + " Where Name"  + " = '" +  name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public boolean AddData1(String name,byte[] img)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("newimage",img);


        long result = db.insert(Table_Event ,null,contentValues);
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public Cursor getData1()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from " + Table_Event;
        Cursor data = db.rawQuery(query,null);
        return data;
    }
    public void DeletData1(String name){

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Table_Event," name = '"+name+"'",null);


    }

    public Cursor getData1ItemId(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from "+ Table_Event + " Where Name"  + " = '" +  name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public boolean AddData2(String name,byte[] img)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("newimage",img);


        long result = db.insert(Table_ComDate ,null,contentValues);
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public Cursor getData2()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from " + Table_ComDate;
        Cursor data = db.rawQuery(query,null);
        return data;
    }

    public Cursor getData2ItemId(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from "+ Table_ComDate + " Where Name"  + " = '" +  name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }
    public boolean AddData3(String name,byte[] img)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("newimage",img);


        long result = db.insert(Table_ComResult ,null,contentValues);
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public Cursor getData3()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from " + Table_ComResult;
        Cursor data = db.rawQuery(query,null);
        return data;
    }

    public Cursor getData3ItemId(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from "+ Table_ComResult + " Where Name"  + " = '" +  name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public boolean AddData4(String name,byte[] img)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("newimage",img);


        long result = db.insert(Table_PhyDate ,null,contentValues);
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public Cursor getData4()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from " + Table_PhyDate;
        Cursor data = db.rawQuery(query,null);
        return data;
    }

    public Cursor getData4ItemId(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from "+ Table_PhyDate + " Where Name"  + " = '" +  name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public boolean AddData5(String name,byte[] img)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("newimage",img);


        long result = db.insert(Table_PhyResult ,null,contentValues);
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public Cursor getData5()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from " + Table_PhyResult;
        Cursor data = db.rawQuery(query,null);
        return data;
    }

    public Cursor getData5ItemId(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from "+ Table_PhyResult + " Where Name"  + " = '" +  name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }


    public boolean AddData6(String name,byte[] img)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("newimage",img);


        long result = db.insert(Table_CheDate ,null,contentValues);
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public Cursor getData6()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from " + Table_CheDate;
        Cursor data = db.rawQuery(query,null);
        return data;
    }

    public Cursor getData6ItemId(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from "+ Table_CheDate + " Where Name"  + " = '" +  name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public boolean AddData7(String name,byte[] img)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("newimage",img);


        long result = db.insert(Table_CheResult ,null,contentValues);
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public Cursor getData7()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from " + Table_CheResult;
        Cursor data = db.rawQuery(query,null);
        return data;
    }

    public Cursor getData7ItemId(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from "+ Table_CheResult + " Where Name"  + " = '" +  name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

}
