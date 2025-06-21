package com.example.itscollegerlist;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MhsAdaptor adaptor;
    private String[] dataNama;
    private String[] dataNim;
    private String[] dataProdi;
    private TypedArray dataPhoto;
    private ArrayList<Mahasiswa> mhsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.lv_list);
        adaptor = new MhsAdaptor(this);
        listView.setAdapter(adaptor);
        persiapan();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, mhsList.get(i).getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void persiapan(){
        dataNama = getResources().getStringArray(R.array.data_nama);
        dataNim = getResources().getStringArray(R.array.data_nim);
        dataProdi = getResources().getStringArray(R.array.data_prodi);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }
    private void addItem(){
        mhsList= new ArrayList<>();

        for (int i = 0; i < dataNama.length; i++) {
            Mahasiswa mhs = new Mahasiswa();
            mhs.setPhoto(dataPhoto.getResourceId(i, -1));
            mhs.setNama(dataNama[i]);
            mhs.setNim(dataNim[i]);
            mhs.setProdi(dataProdi[i]);
            mhsList.add(mhs);
        }
        adaptor.setMember(mhsList);
    }
}