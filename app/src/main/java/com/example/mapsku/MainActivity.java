package com.example.mapsku;

import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.mapsku.fragments.FragMaps;
import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends AppCompatActivity {

    private BottomAppBar toolBar;
    private FragMaps fragMaps;

    String[] listKota = {"Jakarta", "Bandung", "Depok", "Bogor", "Tangerang"};
    int[] listImage = {R.drawable.jakarta,
            R.drawable.bandung,
            R.drawable.depok, R.drawable.bogor, R.drawable.tangerang};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        setSupportActionBar(toolBar);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frag_container, fragMaps)
                .commit();

        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);

                View sheetView = LayoutInflater
                        .from(MainActivity.this)
                        .inflate(R.layout.list_kota, null, false);

                RecyclerView recyclerView = sheetView.findViewById(R.id.rec_kota);

                RecAdapter adapter = new RecAdapter(listKota, listImage);

                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(adapter);

                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();
            }
        });

    }

    private void initView() {
        toolBar = findViewById(R.id.bottom_appbar);
        fragMaps = new FragMaps();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_normal:
                fragMaps.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.action_terrain:
                fragMaps.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            case R.id.action_satellite:
                fragMaps.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
        }

        return true;
    }
}
