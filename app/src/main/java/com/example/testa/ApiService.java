package com.example.testa;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("mylocalbusiness/getCountries")
    Call<CountryResponse> getCountries();
}
