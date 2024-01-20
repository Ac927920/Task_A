package com.example.testa;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private Adapter adapter;
    private CountryViewModel countryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new Adapter();
        recyclerView.setAdapter(adapter);

        countryViewModel = new ViewModelProvider(this).get(CountryViewModel.class);

        // Observe the LiveData and update the RecyclerView
        countryViewModel.getCountries().observe(this, countries -> {
            if (countries != null) {
                // Update the adapter with the new data
                adapter.setCountryList(countries);
            }
        });
    }
}
