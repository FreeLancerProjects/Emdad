package com.creativeshare.emdad.services;


import com.creativeshare.emdad.models.CityModel;
import com.creativeshare.emdad.models.ContainerSizeModel;
import com.creativeshare.emdad.models.ContainerTypeModel;
import com.creativeshare.emdad.models.ContainersModel;
import com.creativeshare.emdad.models.Equipment_Model;
import com.creativeshare.emdad.models.OrderIdModel;
import com.creativeshare.emdad.models.OtherServiceContainerSizeModel;
import com.creativeshare.emdad.models.PlaceGeocodeData;
import com.creativeshare.emdad.models.PlaceMapDetailsData;
import com.creativeshare.emdad.models.Rental_equipment_Model;
import com.creativeshare.emdad.models.ServicesModel;
import com.creativeshare.emdad.models.SliderDataModel;
import com.creativeshare.emdad.models.TermsModel;
import com.creativeshare.emdad.models.UserModel;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;


public interface Services {

    @FormUrlEncoded
    @POST("api/register")
    Call<UserModel> sign_up(
            @Field("username") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("phone_code") String phone_code,
            @Field("phone") String phone,
            @Field("software_type") int software_type
    );


    @FormUrlEncoded
    @POST("api/login")
    Call<UserModel> sign_in(
            @Field("email") String email,
            @Field("password") String password

    );

    @GET("api/all-sliders")
    Call<SliderDataModel> getSliders();

    @GET("place/findplacefromtext/json")
    Call<PlaceMapDetailsData> searchOnMap(@Query(value = "inputtype") String inputtype,
                                          @Query(value = "input") String input,
                                          @Query(value = "fields") String fields,
                                          @Query(value = "language") String language,
                                          @Query(value = "key") String key
    );

    @GET("geocode/json")
    Call<PlaceGeocodeData> getGeoData(@Query(value = "latlng") String latlng,
                                      @Query(value = "language") String language,
                                      @Query(value = "key") String key);

    @GET("api/all-cities")
    Call<List<CityModel>> getCities();

    @GET("api/all-services")
    Call<List<ServicesModel>> getServices();

    @FormUrlEncoded
    @POST("api/contact-us")
    Call<ResponseBody> contact_us(@Field("username") String name,
                                  @Field("email") String email,
                                  @Field("message") String message
    );

    @GET("api/terms-and-conditions")
    Call<TermsModel> getTerms();

    @GET("api/about-us")
    Call<TermsModel> getAboutUs();

    @GET("api/all-wide-sizes")
    Call<List<ContainerSizeModel>> getContainerSize();

    @Multipart
    @POST("/api/upgrade")
    Call<ResponseBody> upgradeToCompany(@Part("company_email") RequestBody company_email,
                                        @Part("title") RequestBody title,
                                        @Part("company_information") RequestBody company_information,
                                        @Part("latitude") RequestBody latitude,
                                        @Part("longitude") RequestBody longitude,
                                        @Part("city") RequestBody city_id,
                                        @Part("address") RequestBody address,
                                        @Part("user_id") RequestBody user_id,
                                        @Part("services_ids[]") List<RequestBody> services_ids,
                                        @Part MultipartBody.Part commercial_register_image

    );


    @GET("api/type-of-truck")
    Call<List<ContainersModel>> getContainers();

    @FormUrlEncoded
    @POST("api/order/connect-water")
    Call<OrderIdModel> sendDeliveryWaterOrder(@Field("user_id") String user_id,
                                              @Field("order_type") String order_type,
                                              @Field("arrival_time") long arrival_time,
                                              @Field("latitude") double latitude,
                                              @Field("longitude") double longitude,
                                              @Field("city") String city_id,
                                              @Field("address") String address,
                                              @Field("wide_size") String wide_size

    );


    @Multipart
    @POST("/api/order/shipping")
    Call<OrderIdModel> sendShippingOrder(@Part("user_id") RequestBody user_id,
                                         @Part("order_type") RequestBody order_type,
                                         @Part("description") RequestBody description,
                                         @Part("transportation_id") RequestBody transportation_id,
                                         @Part("delivery_number") RequestBody delivery_number,
                                         @Part("num_of_tran") RequestBody num_of_tran,
                                         @Part("load_type") RequestBody load_type,
                                         @Part("phone_code_from") RequestBody phone_code_from,
                                         @Part("phone_from") RequestBody phone_from,
                                         @Part("company_name_from") RequestBody company_name_from,
                                         @Part("responsible_from") RequestBody responsible_from,
                                         @Part("email_from") RequestBody email_from,
                                         @Part("city_from") RequestBody city_from,
                                         @Part("address_from") RequestBody address_from,
                                         @Part("lat_from") RequestBody lat_from,
                                         @Part("long_from") RequestBody long_from,
                                         @Part("load_date_from") RequestBody load_date_from,
                                         @Part("phone_to") RequestBody phone_to,
                                         @Part("phone_code_to") RequestBody phone_code_to,
                                         @Part("company_name_to") RequestBody company_name_to,
                                         @Part("responsible_to") RequestBody responsible_to,
                                         @Part("city_to") RequestBody city_to,
                                         @Part("address_to") RequestBody address_to,
                                         @Part("email_to") RequestBody email_to,
                                         @Part("lat_to") RequestBody lat_to,
                                         @Part("long_to") RequestBody long_to,
                                         @Part("value") RequestBody value,
                                         @Part("Weight") RequestBody Weight,
                                         @Part("payment_method") RequestBody payment_method,
                                         @Part("arrival_time") RequestBody arrival_time,

                                         @Part MultipartBody.Part image1,
                                         @Part MultipartBody.Part image2


    );

    @FormUrlEncoded
    @POST("api/token/update")
    Call<ResponseBody> updateToken(@Field("user_id") int user_id,
                                   @Field("firebase_token") String firebase_token
    );


    @FormUrlEncoded
    @POST("api/single-equipment")
    Call<Equipment_Model> getequipsize(@Field("equipment_id") Integer equipment_id);


    @FormUrlEncoded
    @POST("api/order/rental-equipment")
    Call<Rental_equipment_Model> equipmentorder(
            @Field("order_type") Integer order_type,
            @Field("user_id") int user_id,
            @Field("equ_type") int equ_type,
            @Field("equ_size") int equ_size,
            @Field(value = "latitude") double latitude,
            @Field(value = "longitude") double longitude,
            @Field(value = "city") String city,

            @Field(value = "address") String address,

            @Field(value = "start_time") long start_time,

            @Field(value = "used_time") String used_time,
            @Field(value = "num_of_equ") int num_of_equ


    );

    @GET("api/all-equipments")
    Call<List<Equipment_Model>> get_equipments();

    @GET("api/all-containers-type")
    Call<List<ContainerTypeModel>> getContainerType();


    @GET("api/all-containers-sizes")
    Call<OtherServiceContainerSizeModel> getOtherContainerSize(@Query("containerType_id") int containerType_id);


    @FormUrlEncoded
    @POST("api/order/container_order")
    Call<OrderIdModel> sendContainerOrder(@Field("user_id") String user_id,
                                          @Field("order_type") String order_type,
                                          @Field("latitude") double latitude,
                                          @Field("longitude") double longitude,
                                          @Field("address") String address,
                                          @Field("type") int type,
                                          @Field("size") int size

    );


    @Multipart
    @POST("api/order/customs_clearances")
    Call<OrderIdModel> sendCustomerOrder(
            @Part("user_id") RequestBody user_id_part,
            @Part("order_type")RequestBody order_type_part,
            @Part("description") RequestBody description_part,
            @Part MultipartBody.Part image1_part,
            @Part MultipartBody.Part image2_part,
            @Part MultipartBody.Part image3_part,
            @Part MultipartBody.Part image4_part,
            @Part MultipartBody.Part image5_part);
}
