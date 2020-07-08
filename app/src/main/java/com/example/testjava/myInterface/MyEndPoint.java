package com.example.testjava.myInterface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MyEndPoint {

@GET("mydoublen/dataretrofit.php")
Call<ResponseBody> getData();

}
