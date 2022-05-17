package com.example.retrofitakmaralabdylmanapkyzyakmaralain_2_20;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.retrofitakmaralabdylmanapkyzyakmaralain_2_20.data.DoApi;
import com.example.retrofitakmaralabdylmanapkyzyakmaralain_2_20.data.ModelDo;
import com.example.retrofitakmaralabdylmanapkyzyakmaralain_2_20.data.RetrofitBuilder;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.retrofitakmaralabdylmanapkyzyakmaralain_2_20.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    private TextView Activity;
    private TextView Price;
    private TextView Type;
    private TextView Link;
    private ImageView heart;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        onBtnClick();
    }

    private void init(){
        Activity = findViewById(R.id.activity);
        Price = findViewById(R.id.price);
        Type = findViewById(R.id.type);
        Link = findViewById(R.id.link);
        heart = findViewById(R.id.heart);
        btn = findViewById(R.id.btn);
    }

    private void onBtnClick(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DoApi doHolderApi = RetrofitBuilder.getInstance();

                Call<ModelDo> modelDoCall = doHolderApi.getActivities();
                modelDoCall.enqueue(new Callback<ModelDo>() {
                    @Override
                    public void onResponse(Call<ModelDo> call, Response<ModelDo> response) {
                        if (response.isSuccessful()){
                            ModelDo modelDo = response.body();
                            Activity.setText("Do: " + modelDo.getActivity());
                            Price.setText("Price: " + modelDo.getPrice()+"dollars");
                            Type.setText("Type: " + modelDo.getType());
                            Link.setText("Link: " + modelDo.getLink());
                        }
                    }

                    @Override
                    public void onFailure(Call<ModelDo> call, Throwable t) {

                    }
                });
            }
        });

        Link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = Link.getText().toString();
                Log.i("vhukl", value);

                if (value.length() > 6){
                    String link = value.split(" ")[1];
                    Log.i("vhukl", value);

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(link));
                    startActivity(intent);
                }
            }
        });

    }

}