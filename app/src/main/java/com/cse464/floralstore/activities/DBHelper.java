package com.cse464.floralstore.activities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cse464.floralstore.Models.OrdersModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String db_name = "FloralStore.db";

    private static final String userTable = "users";
    private static final String orderTable = "orders";



    public DBHelper(Context context) {
        super(context, db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        String query = "CREATE TABLE " + userTable + " ("
                + "email" + " TEXT PRIMARY KEY, "
                + "password" + " TEXT)";

        myDB.execSQL(query);

        myDB.execSQL("CREATE TABLE orders (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone TEXT, price INT, image INT, quantity INT, description TEXT, flowername TEXT)");
    }

    @Override
    public void onUpgrade(@NonNull SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("DROP TABLE IF EXISTS " + db_name);


    }

    public Boolean insertData(String email, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues dbValues = new ContentValues();
        dbValues.put("email",email);
        dbValues.put("password",password);

        long result = myDB.insert("users",null, dbValues);
        //if the result variable returns -1 then it means that the insertion operation failed and values were not inserted

        if(result == -1) return false;
        else return true;

    }

    public Boolean insertOrder(String name, String phone, int price, int image, int quantity, String desc, String flowername){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues Values = new ContentValues();
        Values.put("name",name);
        Values.put("phone",phone);
        Values.put("price",price);
        Values.put("image",image);
        Values.put("quantity",quantity);
        Values.put("description",desc);
        Values.put("flowername",flowername);
        long result = myDB.insert("orders",null,Values);

        if (result==-1){
            return false;
        }
        else {
            return true;
        }

    }

    public Boolean SignUpVerification(String email){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor verificationCursor = myDB.rawQuery("SELECT * FROM users WHERE email = ?",new String[] {email});
        if(verificationCursor.getCount()>0){
            verificationCursor.close();
            return true;
        }
        else {
            verificationCursor.close();
            return false;
        }

    }

    public Boolean SignInVerification(String email, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor verificationCursor = myDB.rawQuery("SELECT * FROM users WHERE email = ? and password = ?",new String[] {email,password});
        if(verificationCursor.getCount()>0) {
            verificationCursor.close();
            return true;
        }
        else {
            verificationCursor.close();
            return false;
        }
    }

    public ArrayList<OrdersModel> getOrders(){
        ArrayList<OrdersModel> orders = new ArrayList<>();
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT id,flowername,image,price FROM orders",null);
        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                OrdersModel model = new OrdersModel();
                model.setOrderNumber(cursor.getInt(0)+"");
                model.setSoldItemName(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3)+"");
                orders.add(model);
            }
        }
        cursor.close();
        myDB.close();
        return orders;
    }

    public int deleteOrder(String id){
        SQLiteDatabase myDB = this.getWritableDatabase();
        return myDB.delete("orders","id="+id,null);
    }
}
