package com.example.laundry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.laundry.Model.Laundry;
import com.example.laundry.Model.Transaction;

import java.util.ArrayList;

public class DataHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "DATABASE_BARU.db";
    private static final int DATABASE_VERSION = 1;

    //LAUNDRY DATA
    private static final String DATA_LAUNDRY = "laundry";
    private static final String LAUNDRYID = "laundryId";
    private static final String LAUNDRYTANGGAL = "laundryTanggal";
    private static final String LAUNDRYAMBIL = "laundryAmbil";
    private static final String LAUNDRYNAME = "laundryName";
    private static final String LAUNDRYJENIS = "laundryJenis";
    private static final String LAUNDRYTOTAL = "laundryTotal";
    private static final String LAUNDRYBAYAR = "laundryBayar";
    private static final String LAUNDRYDETAIL = "laundryDetail";
    private static final String CREATE_TABLE_LAUNDRY = "CREATE TABLE " + DATA_LAUNDRY + "("
            + LAUNDRYID + " TEXT PRIMARY KEY,"
            + LAUNDRYTANGGAL + " String(50),"
            + LAUNDRYAMBIL + " String(50),"
            + LAUNDRYNAME + " String(50),"
            + LAUNDRYJENIS + " String(10),"
            + LAUNDRYTOTAL + " String(10),"
            + LAUNDRYBAYAR + " INTEGER,"
            + LAUNDRYDETAIL + " String(100));";

    //TRANSACTION DATA
    private static final String DATA_TRANSACTION = "transactions";
    private static final String TRANSACTIONID = "transactionsId";
    private static final String TRANSACTIONAMBIL = "transactionsAmbil";
    private static final String TRANSACTIONNAME = "transactionsName";
    private static final String TRANSACTIONNAMEAMBIL = "transactionsNameambil";
    private static final String TRANSACTIONJENIS = "transactionsJenis";
    private static final String TRANSACTIONDETAIL = "transactionsDetail";
    private static final String TRANSACTIONBAYAR = "transactionsBayar";
    private static final String CREATE_TABLE_TRANSACTION = "CREATE TABLE " + DATA_TRANSACTION + "("
            + TRANSACTIONID + " TEXT PRIMARY KEY,"
            + TRANSACTIONAMBIL + " String(50),"
            + TRANSACTIONNAME + " String(50),"
            + TRANSACTIONNAMEAMBIL + " String(50),"
            + TRANSACTIONJENIS + " String(10),"
            + TRANSACTIONDETAIL + " String(10),"
            + TRANSACTIONBAYAR + " INTEGER);";

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_LAUNDRY);
        db.execSQL(CREATE_TABLE_TRANSACTION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertLaundry(Laundry laundry){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(LAUNDRYID, laundry.getLaundryId());
        values.put(LAUNDRYTANGGAL, laundry.getLaundryTanggal());
        values.put(LAUNDRYAMBIL, laundry.getLaundryAmbil());
        values.put(LAUNDRYNAME, laundry.getLaundryName());
        values.put(LAUNDRYJENIS, laundry.getLaundryJenis());
        values.put(LAUNDRYTOTAL, laundry.getLaundryTotal());
        values.put(LAUNDRYBAYAR, laundry.getLaundryBayar());
        values.put(LAUNDRYDETAIL, laundry.getLaundryDetail());

        db.insert(DATA_LAUNDRY,null,values);
    }

    public ArrayList<Laundry> getAllLaundry(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM laundry",null);
        ArrayList<Laundry> laundries = new ArrayList<>();
        Laundry laundry;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                laundry = new Laundry();
                laundry.setLaundryId(cursor.getString(cursor.getColumnIndex(LAUNDRYID)));
                laundry.setLaundryTanggal(cursor.getString(cursor.getColumnIndex(LAUNDRYTANGGAL)));
                laundry.setLaundryAmbil(cursor.getString(cursor.getColumnIndex(LAUNDRYAMBIL)));
                laundry.setLaundryName(cursor.getString(cursor.getColumnIndex(LAUNDRYNAME)));
                laundry.setLaundryJenis(cursor.getString(cursor.getColumnIndex(LAUNDRYJENIS)));
                laundry.setLaundryTotal(Integer.parseInt(cursor.getString(cursor.getColumnIndex(LAUNDRYTOTAL))));
                laundry.setLaundryBayar(Integer.parseInt(cursor.getString(cursor.getColumnIndex(LAUNDRYBAYAR))));
                laundry.setLaundryDetail(cursor.getString(cursor.getColumnIndex(LAUNDRYDETAIL)));
                laundries.add(laundry);
            }
        }
        cursor.close();
        db.close();
        return laundries;
    }

    public void insertTransaction(Transaction transaction){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(TRANSACTIONID, transaction.getTransactionId());
        values.put(TRANSACTIONAMBIL, transaction.getTransactionAmbil());
        values.put(TRANSACTIONNAME, transaction.getTransactionName());
        values.put(TRANSACTIONNAMEAMBIL, transaction.getTransactionNameAmbil());
        values.put(TRANSACTIONJENIS, transaction.getTransactionJenis());
        values.put(TRANSACTIONDETAIL, transaction.getTransactionDetail());
        values.put(TRANSACTIONBAYAR, transaction.getTransactionBayar());

        db.insert(DATA_TRANSACTION,null,values);
    }



}
