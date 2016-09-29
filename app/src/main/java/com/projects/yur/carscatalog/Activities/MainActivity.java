package com.projects.yur.carscatalog.Activities;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.projects.yur.carscatalog.Adapters.GridViewAdapter;
import com.projects.yur.carscatalog.R;

import static com.projects.yur.carscatalog.R.id.gvMain;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {

    private String[] marks={"Toyota","BMW","Nissan","AUDI","Volkswagen","Aston Martin","Ferrari","Ford"};
    public static int [] logos={R.drawable.toyota,R.drawable.bmw,R.drawable.nissan,R.drawable.audi,R.drawable.volkswagen,R.drawable.aston_martin,R.drawable.ferrari,R.drawable.ford};
    private GridView mGridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGridView=(GridView) findViewById(gvMain);
        mGridView.setAdapter(new GridViewAdapter(this, marks,logos));
        adjustGridView();


    }

    private void adjustGridView() {
        mGridView.setNumColumns(3);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.post:
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
                break;
            case R.id.action_search:
                intent = new Intent(this, SearchActivity.class);
                startActivity(intent);

        }
            return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cars_list, menu);
        return true;
    }
}
