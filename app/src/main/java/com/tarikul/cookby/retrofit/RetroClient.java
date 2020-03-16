package com.tarikul.cookby.retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {
    /********
     * URLS
     *******/
    private static final String ROOT_URL = "https://202.126.127.86:8243/";

    /**
     * Get Retrofit Instance
     */


    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(provideOkHttpClient())
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }

    public static OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder newRequest = request.newBuilder().header("Authorization", "Basic U1NWSDNZSnVXRVc1bDBUSkh5bWdvVXdJOXJvYTpHdlFWdU5tbzVKZEJ5aVhCcmxqQlRIUW5BRjRh");
                return chain.proceed(newRequest.build());
            }
        });

        return okHttpClientBuilder.build();
    }
}
