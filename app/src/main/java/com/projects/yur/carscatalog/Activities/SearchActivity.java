package com.projects.yur.carscatalog.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.projects.yur.carscatalog.Adapters.CustomSpinnerAdapter;

import com.projects.yur.carscatalog.R;

public class SearchActivity extends AppCompatActivity {

    private Spinner mSpin, mModelSpinner, mPriceSpinner;
    private ArrayAdapter<String> mAdapter,mPriceAdapter,mModelAdapter;


    private String[] marks={"Audi","Toyota", "BMW","Nissan", "VolksWagen",};
    private int flags[]={R.drawable.audi,R.drawable.toyota,R.drawable.bmw,R.drawable.nissan,R.drawable.volkswagen};
    private String[] prices={"Price: 1000-20000", "Price: 20000-50000","Price: 50000-100000","Price: 100000>"};
    private String[] models={"Model: 1970-2000","Model: 2000-2005","Model: 2005-2010","Model: 2010-2011","Model: 2011-2012","Model: 2012-2013","Model: 2013-2014"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(R.string.search_vehicles);

        init();

        mPriceSpinner.setAdapter(mPriceAdapter);
        mModelSpinner.setAdapter(mModelAdapter);

        mSpin.setAdapter(mAdapter);
    }

    private void init() {
        mSpin = (Spinner) findViewById(R.id.logo_spinner);
        mModelSpinner =(Spinner)findViewById(R.id.model_spinner);
        mPriceSpinner =(Spinner)findViewById(R.id.price_spinner);

        mAdapter=new CustomSpinnerAdapter(getApplicationContext(),R.id.textView,marks,flags);
        mPriceAdapter =new CustomSpinnerAdapter(getApplicationContext(),R.id.spinner_item, prices);
        mModelAdapter =new CustomSpinnerAdapter(getApplicationContext(),R.id.spinner_item, models);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            default:
                Intent intent=new Intent(this,LoginActivity.class);
                startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

}
