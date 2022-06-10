package com.example.expapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.expapi.adapter.userAdapter;
import com.example.expapi.api.ApiService;
import com.example.expapi.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView tvId,tvName,tvAddress,tvPhone,tvEmail,tvWebsite;
    Button btnCall;
    List<User> users;
    userAdapter useadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvId=findViewById(R.id.tv_id);
        tvName=findViewById(R.id.tv_name);
        tvAddress=findViewById(R.id.tv_address);
        tvEmail=findViewById(R.id.tv_email);
        tvPhone=findViewById(R.id.tv_phone);
        tvWebsite=findViewById(R.id.tv_website);
        btnCall=findViewById(R.id.btn_call);
        recyclerView=findViewById(R.id.recy);

        btnCall.setOnClickListener(v ->clickcall());
    }

    private void clickcall() {

        ApiService.apiService.listUser().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                users=response.body();
                User user= new User();
                if(users!=null && response.isSuccessful()){
                    useadapter=new userAdapter(users);
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(useadapter);



                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }


}