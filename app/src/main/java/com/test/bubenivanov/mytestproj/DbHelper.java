package com.test.bubenivanov.mytestproj;

/**
 * Created by Buben Ivanov on 18.01.2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DbHelper extends SQLiteOpenHelper {
    public static final String TAG=DbHelper.class.getSimpleName();
    public static final String DB_name="person_register.db";
    public static final int DB_version=1;
    public static final String User_Table="Users";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_Email="Email";
    public static final String COLUMN_name="Name";
    public static final String COLUMN_pass="Password";
    public static final String Create_Table_Users="CREATE TABLE "+User_Table+"("+
            COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            COLUMN_Email+" TEXT,"+
            COLUMN_name+" TEXT,"+
            COLUMN_pass+" TEXT);";

public DbHelper(Context context)
{super (context,DB_name,null,DB_version);}

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL(Create_Table_Users);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS "+User_Table);
        onCreate(db);
    }

    public void addUser(String email,String name,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_Email,email);
        values.put(COLUMN_name,name);
        values.put(COLUMN_pass,password);
        long id=db.insert(User_Table,null,values);
        Log.d(TAG,"user inserted"+id);


    }
    public boolean getUser(String pass,String name){
        //HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "select * from  " + User_Table + " where " +
                " and " + COLUMN_pass + " = " + "'"+pass+"'"
                + " and " + COLUMN_name + " = " + "'"+name+"'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {

            return true;
        }
        cursor.close();
        db.close();

        return false;
    }



}
