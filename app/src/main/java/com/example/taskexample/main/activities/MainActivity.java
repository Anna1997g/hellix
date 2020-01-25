package com.example.taskexample.main.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskexample.R;
import com.example.taskexample.base.adapters.OnItemClickListener;
import com.example.taskexample.details.DetailsActivity;
import com.example.taskexample.main.adapters.MetadatumAdapter;
import com.example.taskexample.network.entities.Metadatum;
import com.example.taskexample.network.retrofit.MainViewModel;
import com.example.taskexample.utils.ConnectivityUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    public static final String METADATUM = "metadatum";

    private MetadatumAdapter metadatumAdapter;
    private MainViewModel mainViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvMain = findViewById(R.id.rv_main);

        metadatumAdapter = new MetadatumAdapter();

        metadatumAdapter.setOnItemClickListener(this);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setAdapter(metadatumAdapter);


        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        if (ConnectivityUtils.isConnected(this)) {
            mainViewModel.search();
            MutableLiveData<List<Metadatum>> metadatumsList = mainViewModel.getMetadatums();

            metadatumsList.observe(this, metadata -> {

                List<Metadatum> cachedList = mainViewModel.getAllResultsFromDB().getValue();
                if (cachedList != null && metadata.containsAll(cachedList) && cachedList.containsAll(metadata))
                    return;

                mainViewModel.insertOrders(metadata);
            });
        }

        mainViewModel.getAllResultsFromDB().observe(this, metadata -> metadatumAdapter.setMetadatumList(metadata));
    }


    @Override
    public void onItemClicked(int position) {
        Metadatum metadatum = metadatumAdapter.getItem(position);
        metadatum.setSeen(true);
        mainViewModel.update(metadatum);

        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra(METADATUM, metadatum);
        startActivity(intent);
    }

}




