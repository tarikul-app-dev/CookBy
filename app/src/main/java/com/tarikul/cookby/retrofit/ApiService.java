package com.tarikul.cookby.retrofit;

import com.tarikul.cookby.model.PostResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("token")
    Call<PostResponse> getToken(@Field("grant_type") String grant_type, @Field("username") String user_name, @Field("password") String password);
}
