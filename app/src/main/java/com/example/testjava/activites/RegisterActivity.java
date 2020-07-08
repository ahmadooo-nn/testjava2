package com.example.testjava.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testjava.R;
import com.example.testjava.utils.Utils;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private final static String TAG="doublen";

    EditText et_password,et_username,et_password_config,et_text;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();


    }


    private void init() {
        et_username=findViewById(R.id.et_username);
        et_password=findViewById(R.id.et_password);
        et_password_config=findViewById(R.id.et_password_config);
        et_text=findViewById(R.id.et_text);
        btn_register=findViewById(R.id.btn_register);

    }

    public void myOnClick(View view) {

        if (view==btn_register){
          //  new MyRegister("", "", "", "", getApplicationContext()).execute();


        }

    }

  /*  public class MyRegister extends AsyncTask<Void,Void,String>{

        String username,password,mytext,phone;
        Context context;

        public MyRegister(String username, String password, String mytext, String phone, Context context) {
            this.username = username;
            this.password = password;
            this.mytext = mytext;
            this.phone = phone;
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            Log.i(TAG,"onPrexecute");
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {

            Log.i(TAG,"doinbackground");

            String registerurl="http://doublen.ir/mydoublen/myregister.php";
            HashMap hashMap=new HashMap();
            hashMap.put("username",username);
            hashMap.put("password",password);
            hashMap.put("mytext",mytext);
            hashMap.put("phone",phone);

            return Utils.sendData(registerurl,hashMap);
        }

        @Override
        protected void onPostExecute(String s) {
            Log.i(TAG,"onPostExecute:  "+s);
            Toast.makeText(context, ""+s, Toast.LENGTH_SHORT).show();
        }
    }  */
}