package com.tarikul.cookby.activities;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.tarikul.cookby.R;
import com.tarikul.cookby.model.PostResponse;
import com.tarikul.cookby.retrofit.ApiService;
import com.tarikul.cookby.retrofit.RetroClient;
import com.tarikul.cookby.utils.UICONTENT;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    UICONTENT uicontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uicontent = new UICONTENT(MainActivity.this);

        if(uicontent.isOnline()){
            getToken();
        }
    }



    public void getToken(){
//        spinDialog = new SpinDialog(LogMachineDownAct.this, false);
//        spinDialog.show();

        //Creating an object of our api interface
        ApiService api = RetroClient.getApiService();

        /**
         * Calling JSON
         */
        Call<PostResponse> call = api.getToken("password","AFMLITPLANET","PfGm@Afh897");

        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<PostResponse>() {
            @TargetApi(Build.VERSION_CODES.N)
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                //Dismiss Dialog


                if(response.isSuccessful()) {

                    Log.d("response",response.body().toString());

                } else {

                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                Log.d("failed_msg",t.getMessage());
            }
        });
    }
}
