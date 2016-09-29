package com.projects.yur.carscatalog.Activities;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.projects.yur.carscatalog.R;

public class ForgotPassword extends AppCompatActivity implements View.OnClickListener {
    private Button mSendEmailBtn;
    private EditText mSenemailEdt;
    private String mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        init();
        Toolbar toolbar = (Toolbar) findViewById(R.id.forget_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(R.string.reset_password);


    }

    private void init() {
        mSendEmailBtn=(Button)findViewById(R.id.send_email);
        mSenemailEdt=(EditText)findViewById(R.id.send_email_edt);

        mSendEmailBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mEmail=mSenemailEdt.getText().toString();

       Intent intent= new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto",mEmail, null));
        intent.putExtra(Intent.EXTRA_SUBJECT, "@reset_password");
        try {
            startActivity(Intent.createChooser(intent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ForgotPassword.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
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
}
