package com.app.leon.abfa.Infrastructure;

import com.app.leon.abfa.Models.InterCommunation.AppInfo;
import com.app.leon.abfa.Models.InterCommunation.ChangePassword;
import com.app.leon.abfa.Models.InterCommunation.Location;
import com.app.leon.abfa.Models.InterCommunation.LocationUpdateModel;
import com.app.leon.abfa.Models.InterCommunation.LoginFeedBack;
import com.app.leon.abfa.Models.InterCommunation.LoginInfo;
import com.app.leon.abfa.Models.InterCommunation.MobileInput;
import com.app.leon.abfa.Models.InterCommunation.SimpleMessage;
import com.app.leon.abfa.Models.InterCommunation.UploadReadData;
import com.app.leon.abfa.Models.InterCommunation.UploadReadFeedback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by Leon on 12/9/2017.
 */
public interface IAbfaService {

    @GET("/Api1/Apk/GetNewest")
    Call<ResponseBody> getNewestAppVersion(
            @Query("CurrentVersion") int Version);


    @POST("/Auth/Account/login")
    Call<LoginFeedBack> login(@Body LoginInfo logininfo);


    @PATCH("Auth/UserManager/ChangePassword")
    Call<SimpleMessage> changePassword(
            @Body ChangePassword changePassword
    );


    @GET("/Api1/Apk/GetNewestInfo")
    Call<AppInfo> getLastApkInfo();

    @GET("/Api1/Loading/Load")
    Call<MobileInput> downloadOff(
            @Query("currentVersion") int currentVersion
    );

    @GET("/Api1/Loading/Load")
    Call<MobileInput> download(
            @Query("currentVersion") int currentVersion
    );

    @GET("/Api1/Loading/Load")
    Call<MobileInput> downloadSpecial(
            @Query("currentVersion") int currentVersion
    );

    @GET("/Api1/Loading/Reload")
    Call<MobileInput> downloadRetry(
            @Query("trackNumbers[]") List<Integer> trackNumbers
    );

    @POST("/Api1/QeireMojaz/Register")
    Call<SimpleMessage> uploadForbid(
            @Header("Authorization") String token,
            @Query("preEshterak") String preEshterak,
            @Query("nextEshterak") String nextEshterak,
            @Query("expandableTextView") String address,
            @Query("tedadVahed") int tedadVahed,
            @Query("latitude") double latitude,
            @Query("longitude") double longitude,
            @Query("trackNumber") int trackNumber
    );

    @Multipart
    @POST("/Api1/QeireMojaz/Register")
    Call<SimpleMessage> uploadForbid(
            @Header("Authorization") String token,
            @Query("preEshterak") String preEshterak,
            @Query("nextEshterak") String nextEshterak,
            @Query("expandableTextView") String address,
            @Query("tedadVahed") int tedadVahed,
            @Query("latitude") double latitude,
            @Query("longitude") double longitude,
            @Query("trackNumber") int trackNumber,
            @Part MultipartBody.Part file
    );

    @Multipart
    @POST("/Api1/Offloading/RegisterDescription")
    Call<SimpleMessage> uploadDescription(
            @Query("trackNumber") int trackNumber,
            @Query("billId") String billId,
            @Query("description") String description,
            @Part MultipartBody.Part file
    );

    @Multipart
    @POST("/Api1/Offloading/RegisterDescription")
    Call<SimpleMessage> uploadDescription(
            @Query("trackNumber") int trackNumber,
            @Query("billId") String billId,
            @Part MultipartBody.Part file
    );

    @POST("/Api1/Offloading/RegisterDescription")
    Call<SimpleMessage> uploadDescription(
            @Query("trackNumber") int trackNumber,
            @Query("billId") String billId,
            @Query("description") String description
    );

    @Multipart
    @POST("/Api1/Offloading/UploadImage")
    Call<SimpleMessage> uploadImage(
            @Query("trackNumber") int trackNumber,
            @Query("billId") String billId,
            @Part MultipartBody.Part file
    );

    @PATCH("/Api1/Offloading/Offload/")
    Call<ArrayList<UploadReadFeedback>> uploadRead(
            @Body UploadReadData uploadReadData

    );

    @PATCH("/Api1/Offloading/SetCounterPosition")
    Call<SimpleMessage> counterPosition(
            @Body Location location);

    @PATCH("/Api1/Offloading/OffloadEmptyBody")
    Call<SimpleMessage> uploadEmpty(
            @Query("trackNumber") String trackNumber
    );

    @PUT("/Api1/ToziGhabsManager/Add")
    Call<SimpleMessage> toziGhabs(@Body LocationUpdateModel locationUpdateModel);

    @PATCH("/Auth/Account/UpdateDeviceId")
    Call<SimpleMessage> signSerial(
            @Query("deviceId") String deviceId
    );

    @PATCH("/Auth/Account/UpdateDeviceIdAnanymous")
    Call<SimpleMessage> signSerial(
            @Body LoginInfo logininfo);
}

