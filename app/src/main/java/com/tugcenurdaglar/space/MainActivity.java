package com.tugcenurdaglar.space;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.res.Configuration;
import android.os.Bundle;

import com.tugcenurdaglar.space.adapter.Adapter;
import com.tugcenurdaglar.space.client.ApiClient;
import com.tugcenurdaglar.space.client.RestInterface;
import com.tugcenurdaglar.space.pojomodels.Repo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;

    private ArrayList<Repo> repoArrayList;

    private Adapter adapter;
    
    RestInterface restInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);

        rv.setHasFixedSize(true);

        rv.setLayoutManager(new GridLayoutManager(rv.getContext(), 3));


        restInterface = ApiClient.getClient().create(RestInterface.class);

        Call<List<Repo>> call=restInterface.getRepo();

        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> repoList=new ArrayList<>();
                repoList=response.body();

                for (int i=0;i<repoList.size();i++){
                    System.out.println(""+repoList.get(i).rocket.rocketId+"\n");
                }

                adapter = new Adapter(MainActivity.this,repoList);

                rv.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });

    }

}