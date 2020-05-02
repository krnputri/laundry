package com.example.laundry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.laundry.Adapter.ListAdapter;
import com.example.laundry.Model.Laundry;

import java.util.ArrayList;
import java.util.List;

public class AmbilLaundry extends AppCompatActivity {
    DataHelper dataHelper;
    List<Laundry> laundries;
    RecyclerView recyclerView;
    ListAdapter listAdapter;
    EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambil_laundry);
        dataHelper = new DataHelper(this);
        laundries = dataHelper.getAllLaundry();

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        listAdapter = new ListAdapter(laundries);
        recyclerView.setAdapter(listAdapter);
        listAdapter.setOnCustomerClickListener(new ListAdapter.OnCustomerClickListener() {
            @Override
            public void onItemClick(int position) {
                String idLaundry = laundries.get(position).getLaundryId();
                finish();
                Intent i = new Intent(AmbilLaundry.this, Ambil2.class);
                i.putExtra("id",idLaundry);
                startActivity(i);
            }
        });

        search = findViewById(R.id.search);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }

            private void filter(String text) {
                List<Laundry> filteredlist = new ArrayList<>();
                for (Laundry item : laundries){
                    if (item.getLaundryName().toLowerCase().contains(text.toLowerCase())){
                        filteredlist.add(item);
                    }
                }
                listAdapter = new ListAdapter(filteredlist);
                recyclerView.setAdapter(listAdapter);

                listAdapter.setOnCustomerClickListener(new ListAdapter.OnCustomerClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        String idLaundry = laundries.get(position).getLaundryId();
                        Intent i = new Intent(AmbilLaundry.this, Ambil2.class);
                        i.putExtra("id",idLaundry);
                        startActivityForResult(i, 10001);
                    }
                });
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 10001) && (resultCode == Activity.RESULT_OK))
            recreate();
    }
}
