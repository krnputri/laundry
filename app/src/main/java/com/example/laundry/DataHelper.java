package com.example.laundry;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.laundry.Model.Transaction;

import java.sql.SQLDataException;

public class DataHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "DATABASE_BARU.db";
    private static final int DATABASE_VERSION = 1;

    //TRANSACTION DATA
    private static final String DATA_TRANSACTION = "transactions";
    private static final String TRANSACTIONID = "transactionId";
    private static final String TRANSACTIONTANGGAL = "transactionTanggal";
    private static final String TRANSACTIONAMBIL = "transactionAmbil";
    private static final String TRANSACTIONNAME = "transactionName";
    private static final String TRANSACTIONJENIS = "transactionJenis";
    private static final String TRANSACTIONTOTAL = "transactionTotal";
    private static final String TRANSACTIONBAYAR = "transactionBayar";
    private static final String CREATE_TABLE_TRANSACTION = "CREATE TABLE " + DATA_TRANSACTION + "("
            + TRANSACTIONID + " TEXT PRIMARY KEY,"
            + TRANSACTIONTANGGAL + " String(50),"
            + TRANSACTIONAMBIL + " String(50),"
            + TRANSACTIONNAME + " String(50),"
            + TRANSACTIONJENIS + " String(10),"
            + TRANSACTIONTOTAL + " INTEGER,"
            + TRANSACTIONBAYAR + " INTEGER);";

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TRANSACTION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertTransaction(Transaction transaction){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(TRANSACTIONID, transaction.getTransactionId());
        values.put(TRANSACTIONTANGGAL, transaction.getTransactionTanggal());
        values.put(TRANSACTIONAMBIL, transaction.getTransactionAmbil());
        values.put(TRANSACTIONNAME, transaction.getTransactionName());
        values.put(TRANSACTIONJENIS, transaction.getTransactionJenis());
        values.put(TRANSACTIONTOTAL, transaction.getTransactionTotal());
        values.put(TRANSACTIONBAYAR, transaction.getTransactionBayar());

        db.insert(DATA_TRANSACTION,null,values);
    }





}
