package com.example.tugas2_105218050_farhannazarauma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class KeranjangBelanjaActivity extends AppCompatActivity {

    private RecyclerView rvOrder;
    private OrderFotoListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keranjang_belanja);

        rvOrder = findViewById(R.id.rv_order_foto);
        adapter = new OrderFotoListAdapter(this);

        rvOrder.setAdapter(adapter);
        rvOrder.setLayoutManager(new LinearLayoutManager(this));
    }
}