package com.example.testjava.activites;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testjava.R;
import com.example.testjava.myInterface.MyEndPoint;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_password,et_username;
    Button btn_register,btn_login;

    public static final String TAG="testag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        new Async("5").execute("ahmad", "ali", "mohamad", "rahim");

        workingWithRetrofit();


        //log





/*        Button button1 = findViewById(R.id.btn_login);
        Button button2 =  findViewById(R.id.btn_register);



        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        Internet internet = new Internet();

        internet.getDataFromMySite(new ReceivedDataListener() {

            @Override
            public void ReceivedData(String text) {
                Toast.makeText(LoginActivity.this, text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failed() {

            }
        });*/



        /*button.setOnClickListener(v -> {
           Toast.makeText(this, "f", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        });*/


    }

    private void workingWithRetrofit() {

        final String myURL="http://doublen.ir/";



        OkHttpClient.Builder okHttpBuilder=new OkHttpClient.Builder();           // TODO: 7/8/20        به این خط گیر میده

        Retrofit.Builder retrofitBuilder=new Retrofit.Builder().baseUrl(myURL);

        Retrofit retrofit=retrofitBuilder.client(okHttpBuilder.build()).build();

        MyEndPoint myEndPoint=retrofit.create(MyEndPoint.class);
        Call<ResponseBody> call=myEndPoint.getData();

        call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                   // Log.i(TAG,"response; "+response.message().toString());
                    try {
                        Log.i(TAG,"response; "+response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Log.i(TAG,"failure; "+t.getMessage());
                }
            });


    }

    private void init() {
        et_username=findViewById(R.id.et_username);
        et_password=findViewById(R.id.et_password);
        btn_login=findViewById(R.id.btn_login);
        btn_register=findViewById(R.id.btn_register);

    }

    public void myOnClick(View view) {
        if (view==btn_login){

            myLogin();
            startActivity(new Intent(LoginActivity.this,MainActivity.class));

        }else if (view==btn_register){
            startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        }
    }

    private void myLogin() {


    }

    @Override
    public void onClick(View v) {

/*        switch (v.getId()){
            case R.id.btn_login:
                Toast.makeText(this, "login", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_register:
                Toast.makeText(this, "register", Toast.LENGTH_SHORT).show();
        }*/

    }

    private class Async extends AsyncTask<String,Void,String>{

        private String date ;

        public Async(String date) {
            this.date = date ;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.i(TAG, "onPreExecute: ");
            //progress show
        }

        // in background thread
        @Override
        protected String doInBackground(String... strings) {
           String esme1 =  strings[0];
           String esme2 =  strings[1];

            Log.i(TAG, "doInBackground: "+esme1);
            Log.i(TAG, "doInBackground: "+date);

           // do work

            String received = "success";

            return received;
        }


        //in main thread
        @Override
        protected void onPostExecute(String received) {
            super.onPostExecute(received);
            Log.i(TAG, "onPostExecute: " + received);
            Toast.makeText(LoginActivity.this, received + " changed", Toast.LENGTH_SHORT).show();
            //progress bar dismiss
        }

    }


}
