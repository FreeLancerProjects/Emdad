package com.creativeshare.emdad.services;


import com.creativeshare.emdad.Model.Bank_Model;
import com.creativeshare.emdad.Model.Contact_us_model;
import com.creativeshare.emdad.Model.Information_Model;
import com.creativeshare.emdad.Model.Shipping_wide_Model;
import com.creativeshare.emdad.Model.Slider_Model;
import com.creativeshare.emdad.Model.UserModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


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

    @GET("api/slider")
    Call<Slider_Model> get_slider();

    @GET("api/page/2")
    Call<Information_Model>
    gettermscondition();


    @GET("api/page/1")
    Call<Information_Model>
    about_us();

    @GET("api/accounts")
    Call<Bank_Model> get_bank_accounts();

    @FormUrlEncoded
    @POST("api/callus")
    Call<Contact_us_model> contact_us(
            @Field("name") String name,
            @Field("email") String email,
            @Field("message") String message
    );

    @FormUrlEncoded
    @POST("api/logout")
    Call<ResponseBody> logout(
            @Field("user_id") int user_id
    );

    @GET("api/shipp")
    Call<Shipping_wide_Model> get_shipp();
    @GET("api/wide")
    Call<Shipping_wide_Model> get_Wide();
}
