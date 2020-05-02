package com.example.laundry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laundry.Model.Laundry;
import com.example.laundry.Model.Transaction;

import java.util.List;

public class Ambil2 extends AppCompatActivity {
    DataHelper dataHelper;
    List<Laundry> laundries;
    TextView nama, tanggal, jenis, detail, total;
    EditText pengambil;
    Button btnAmbil;
    String b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambil2);
        dataHelper = new DataHelper(this);
        laundries = dataHelper.getAllLaundry();
        nama = findViewById(R.id.tv_user);
        tanggal = findViewById(R.id.tv_tgl);
        jenis = findViewById(R.id.jenislaundry);
        detail = findViewById(R.id.detaillaundry);
        total = findViewById(R.id.totallaundry);
        pengambil = findViewById(R.id.pengambil);
        btnAmbil = findViewById(R.id.button_ambil);

        final String idLaundry = getIntent().getStringExtra("id");
        SQLiteDatabase dbr= dataHelper.getReadableDatabase();
        final Cursor cursor = dbr.rawQuery("SELECT * FROM laundry WHERE laundryId='"+idLaundry+"'", null);
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                String a = cursor.getString(7).replace("[","");
                b = a.replace("]","");
                nama.setText(cursor.getString(3));
                tanggal.setText(cursor.getString(1));
                jenis.setText(cursor.getString(4));
                detail.setText(b);
                total.setText("Total Bayar : Rp"+cursor.getString(5));
            }
        }

        btnAmbil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = pengambil.getText().toString();
                if (nama.isEmpty()){
                    Toast.makeText(Ambil2.this, "Nama Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }else {
                    SQLiteDatabase dbw= dataHelper.getWritableDatabase();
                    dbw.execSQL("DELETE FROM laundry WHERE laundryId='"+idLaundry+"'");
                    ambil(nama, cursor);
                }
            }
        });
    }

    private void ambil(String nama, Cursor cursor) {

        dataHelper.insertTransaction(new Transaction(cursor.getString(0), cursor.getString(2), nama,
                cursor.getString(3), cursor.getString(4), cursor.getString(5), b));

        Toast.makeText(this, "Laundry Diambil", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent();
        setResult(10001, intent);
        finish();
    }
}
