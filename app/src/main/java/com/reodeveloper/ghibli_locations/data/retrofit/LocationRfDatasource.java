package com.reodeveloper.ghibli_locations.data.retrofit;

import com.reodeveloper.common.DataSource;
import com.reodeveloper.common.Specification;
import com.reodeveloper.ghibli_locations.data.Mapper;
import com.reodeveloper.ghibli_locations.data.retrofit.model.RfLocation;
import com.reodeveloper.ghibli_locations.model.Location;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class LocationRfDatasource extends RetrofitDatasource implements DataSource<Location> {

    private final Mapper<RfLocation, Location> mapper;
    private final Service service;

    public LocationRfDatasource(Mapper<RfLocation, Location> mapper){
        this.mapper = mapper;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        service = retrofit.create(Service.class);
    }

    @Override
    public List<Location> getAll() {
        Call<List<RfLocation>> call = service.getAllLocations();
        Response<List<RfLocation>> callResponse = null;
        try{
            callResponse = call.execute();
        }catch (IOException e){
            e.printStackTrace();
        }
        if ((callResponse != null) && callResponse.isSuccessful()) {
            List<RfLocation> result = callResponse.body();
            return mapper.map(result);
        }
        // If response is not successful, we return an empty list
        return new ArrayList<>();
    }

    @Override
    public List<Location> queryList(Specification specification) {
        return null;
    }

    @Override
    public Location queryItem(Specification specification) {
        return null;
    }

    private interface Service {
        @GET("locations") Call<List<RfLocation>> getAllLocations();
    }

}
