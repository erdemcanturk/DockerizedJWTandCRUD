package com.erdem.dockerizedcrud.request;

import com.google.gson.JsonElement;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.*;


import java.util.List;


public interface ICustomerServiceRequest {

    @POST("/api/customers")
    Call<JsonElement> saveCustomer(@Body JsonElement requestBody);

    @DELETE("/api/customers/{id}")
    Call<Void> deleteById(@Path("id") Long id);

    @GET("/api/customers")
    Call<List<JsonElement>> findAllCustomer();

    @PUT("/api/customers/{id}")
    Call<List<JsonElement>> updateCustomer();
}
