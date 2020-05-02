package com.example.laundry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.DatePickerDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laundry.Model.Laundry;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class LaundryBaru extends AppCompatActivity {
    DataHelper dataHelper;
    EditText namaPelanggan, tgl_masuk, tgl_ambil, totalKg, totalBayar;
    Spinner jenisCuci;
    String val_pelanggan, val_tglmasuk, val_tglambil, pilihSpinner;
    int val_hargaKg, val_totalkg, valBayar, val_total;
    final Calendar myCalendar = Calendar.getInstance();
    String myFormat = "dd/MM/yyyy";
    SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
    ArrayList<String> jenis = new ArrayList<>();
    ArrayList<String> tambahan = new ArrayList<>();
    Button simpan;
    CheckBox checkBox1, checkBox2;
    RadioGroup radio;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laundry_baru);
        dataHelper = new DataHelper(this);
        namaPelanggan = findViewById(R.id.nama_value);
        tgl_masuk = findViewById(R.id.tgl_masuk);
        tgl_ambil = findViewById(R.id.tgl_jadi);
        totalKg = findViewById(R.id.berat);
        jenisCuci = findViewById(R.id.spinner_jenis);
        simpan = findViewById(R.id.button_simpan);
        totalBayar = findViewById(R.id.totalBayar);
        checkBox1 = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        radio = findViewById(R.id.radio);

        val_hargaKg = 3500;

        tgl_masuk.setText(sdf.format(Calendar.getInstance().getTime()));

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                tgl_ambil.setText(sdf.format(myCalendar.getTime()));
            }

        };

        tgl_ambil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(LaundryBaru.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        setSpinner();

        totalKg.setText("1");

        totalBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val_totalkg = Integer.parseInt(totalKg.getText().toString());
                int total;
                if (checkBox1.isChecked() && checkBox2.isChecked()){
                    tambahan.add("Selimut");
                    tambahan.add("Sprei");
                    total = (val_hargaKg*val_totalkg)+17000;
                } else if (checkBox1.isChecked()){
                    tambahan.add("Selimut");
                    total = (val_hargaKg*val_totalkg)+10000;
                } else if (checkBox2.isChecked()){
                    tambahan.add("Sprei");
                    total = (val_hargaKg*val_totalkg)+7000;
                }else {
                    total = val_hargaKg*val_totalkg;
                }
                totalBayar.setText(String.valueOf(total));
            }
        });

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radio.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                val_pelanggan = namaPelanggan.getText().toString();
                val_tglmasuk = tgl_masuk.getText().toString();
                val_tglambil = tgl_ambil.getText().toString();
                val_total = Integer.parseInt(totalBayar.getText().toString());
                String byr = String.valueOf(radioButton.getText());
                if (byr.equals("Bayar Sekarang")){
                    valBayar = 1;
                }else {
                    valBayar = 0;
                }

                saveAllValue(val_pelanggan, val_tglmasuk, val_tglambil, valBayar,val_total, val_totalkg, tambahan);
            }
        });
    }

    private void setSpinner() {
        jenis.add("Cuci Kering");
        jenis.add("Cuci Kering Setrika");
        jenis.add("Cuci Ekspress");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, jenis) {
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                Typeface externalFont= ResourcesCompat.getFont(LaundryBaru.this, R.font.poppins);
                ((TextView) v).setTypeface(externalFont);
                ((TextView) v).setTextSize(12f);
                return v;
            }};
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jenisCuci.setAdapter(dataAdapter);

        jenisCuci.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                pilihSpinner = parent.getItemAtPosition(position).toString();
                if (pilihSpinner.equals("Cuci Kering")){
                    val_hargaKg = 3500;
                } else if (pilihSpinner.equals("Cuci Kering Setrika")){
                    val_hargaKg = 4500;
                }else {
                    val_hargaKg = 6000;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void saveAllValue(String val_pelanggan, String val_tglmasuk, String val_tglambil, int valBayar, int val_total, int val_totalkg, ArrayList tambahan) {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        String detail = "";
        if (tambahan.equals("")){
           detail = val_totalkg + "Kg";
        } else {
            detail = val_totalkg + "Kg + "+tambahan.toString();
        }

        dataHelper.insertLaundry(new Laundry(id, val_tglmasuk, val_tglambil,val_pelanggan,pilihSpinner, val_total, valBayar,detail));
        Toast.makeText(this, "Laundry Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
        finish();
    }
}
