package com.example.mapsku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mapsku.R;
import com.example.mapsku.adapter.RecMainAdapter;

public class ListKota extends AppCompatActivity {

    RecyclerView recyclerView;

    String[] listKota = {"Jakarta", "Bandung", "Depok", "Bogor", "Tangerang"};
    int[] listImage = {R.drawable.jakarta,
            R.drawable.bandung,
            R.drawable.depok, R.drawable.bogor, R.drawable.tangerang};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_kota);

        RecMainAdapter adapter = new RecMainAdapter(listKota, listImage);

        recyclerView = findViewById(R.id.rec_main);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}
