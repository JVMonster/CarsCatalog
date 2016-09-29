package com.projects.yur.carscatalog.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.projects.yur.carscatalog.Models.Car;
import com.projects.yur.carscatalog.Models.CarDetailsRequest;
import com.projects.yur.carscatalog.Models.CarList;
import com.projects.yur.carscatalog.Models.CarsListRequest;
import com.projects.yur.carscatalog.R;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class CarsListActivity extends AppCompatActivity {
    private RecyclerView mRecycler;
    private String url="http://109.75.38.152/fixit/rest/";
    private TextView carsList,carDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_list);
        init();
        String key=getIntent().getStringExtra("mark");


    }

    private void init() {
        carDetails=(TextView)findViewById(R.id.carDetails);
        carsList=(TextView)findViewById(R.id.carsList);
       // mRecycler=(RecyclerView)findViewById(R.id.recycler);

        Toolbar toolbar = (Toolbar) findViewById(R.id.listToolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(R.string.car_brands);
    }


    void getCarDetails() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CarDetailsRequest service = retrofit.create(CarDetailsRequest.class);

        Call<Car> call = service.getCarDetails(1);

        call.enqueue(new Callback<Car>() {
            @Override
            public void onResponse(Response<Car> response, Retrofit retrofit) {

                try {

                   carDetails.setText(response.body().toString());

                    Log.i("KOT",response.body().toString());
                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }

    void getListOfCars() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CarsListRequest service = retrofit.create(CarsListRequest.class);

        Call<CarList> call = service.getCarsList();

        call.enqueue(new Callback<CarList>() {
            @Override
            public void onResponse(Response<CarList> response, Retrofit retrofit) {

                try {

                    if(response.equals(null)){Toast.makeText(getApplicationContext(),"response is null",Toast.LENGTH_LONG).show();}
                    CarList carData = response.body();
                    String carModel=null;

                    if(carData.equals(null)){
                        Toast.makeText(getApplicationContext(),"LIST IS EMPTY",Toast.LENGTH_LONG).show();
                    }
                    else Toast.makeText(getApplicationContext(),"List is Full",Toast.LENGTH_LONG).show();
                    carModel=carData.toString();
                    carsList.setText(carModel);


                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }

    public void click(View view) {
        switch (view.getId()){
            case R.id.detailsButton:
                getCarDetails();
                break;
            case R.id.listButton:
                getListOfCars();
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_cars_list,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.action_search:
                Intent intent=new Intent(this,SearchActivity.class);
                startActivity(intent);
                break;
            default:
                intent=new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
