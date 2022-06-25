package com.example.tugas2_105218050_farhannazarauma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements KerajangBelanjaListener{

    private RecyclerView rvKatalogFotg;
    private katalogFotoLostAdapter adapter;
    private Button btnkeranjang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        KatalogFotoUtil.init();
        OrderFotoUtil.init();

        rvKatalogFotg = findViewById(R.id.rv_katalog_foto);
        adapter = new katalogFotoLostAdapter(this);

        rvKatalogFotg.setAdapter(adapter);
        rvKatalogFotg.setLayoutManager(new LinearLayoutManager(this));

        btnkeranjang = findViewById(R.id.keranjangbtn);
        OrderChanged();
        btnkeranjang.setOnClickListener(view -> {
                Intent intent = new Intent(this, KeranjangBelanjaActivity.class);
                startActivity(intent);

        });
        OrderFotoUtil.addkbListener(this);
    }

    @Override
    public void OrderChanged() {
        String kbCountStr = "Keranjang Belanja:" + OrderFotoUtil.getOrderCount();
        btnkeranjang.setText(kbCountStr);
    }
}