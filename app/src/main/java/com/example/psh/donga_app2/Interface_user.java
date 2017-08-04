package com.example.psh.donga_app2;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by psh on 17. 7. 29.
 */

public interface Interface_user {
    @POST("reg")
    @FormUrlEncoded
    Call<User_VO> SignUp(@Field("email") String user_id, @Field("pw") String user_pw);
}
