package com.example.testa;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryViewModel extends ViewModel {
    private MutableLiveData<List<Country>> countriesLiveData;

    public LiveData<List<Country>> getCountries() {
        if (countriesLiveData == null) {
            countriesLiveData = new MutableLiveData<>();
            loadCountries();
        }
        return countriesLiveData;
    }

    private void loadCountries() {
        ApiService apiService = RetrofitClient.getApiService();
        Call<CountryResponse> call = apiService.getCountries();

        call.enqueue(new Callback<CountryResponse>() {
            @Override
            public void onResponse(Call<CountryResponse> call, Response<CountryResponse> response) {
                if (response.isSuccessful()) {
                    CountryResponse countryResponse = response.body();
                    if (countryResponse != null && countryResponse.getData() != null) {
                        countriesLiveData.setValue(countryResponse.getData());
                    } else {
                        Log.e("CountryViewModel", "Response body or data is null");
                    }
                } else {
                    Log.e("CountryViewModel", "Failed to get data. Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<CountryResponse> call, Throwable t) {
                Log.e("CountryViewModel", "Network request failed: " + t.getMessage());
            }
        });
    }
}
