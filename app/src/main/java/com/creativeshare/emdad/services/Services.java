package com.creativeshare.emdad.services;




import com.creativeshare.emdad.Model.UserModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface Services {


    @FormUrlEncoded
    @POST("api/loginRe")
    Call<UserModel> login(@Field("email") String email,
                          @Field("password") String password
    );

    @FormUrlEncoded
    @POST("api/registerClient")
    Call<UserModel> register(
            @Field("name") String name,
            @Field("user_name") String user_name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("phone_code") String phone_code,
            @Field("phone") String phone,
            @Field("software_type") int software_type
    );



}
