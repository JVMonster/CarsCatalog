package com.projects.yur.carscatalog.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.projects.yur.carscatalog.Models.User;
import com.projects.yur.carscatalog.R;
import com.projects.yur.carscatalog.Utils.Expression_Checker;

import io.realm.Realm;
import io.realm.RealmResults;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mLoginBtn;
    private EditText mUsernameEdt, mPasswordEdt;
    private TextView mRememberTxt,mForgotPass,mRegister;
    private CheckBox mRemeberBox;
    private String mUsername,mPassword;
    private Realm mRealm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

    }

    private void init() {
        mLoginBtn =(Button)findViewById(R.id.loginBtn);
        mUsernameEdt =(EditText)findViewById(R.id.usernameEdt);
        mPasswordEdt =(EditText)findViewById(R.id.passwordEdt);
        mRememberTxt=(TextView)findViewById(R.id.rememberTxt);
        mForgotPass=(TextView)findViewById(R.id.forgot_pass);
        mRegister=(TextView)findViewById(R.id.register_now);
        mRemeberBox=(CheckBox)findViewById(R.id.rememberBox);

        mRegister.setOnClickListener(this);
        mForgotPass.setOnClickListener(this);
        mRememberTxt.setOnClickListener(this);
        mLoginBtn.setOnClickListener(this);

        Realm.getDefaultInstance();

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.register_now:
                startActivity(RegisterActivity.class);
                break;
            case R.id.rememberTxt:
                if(mRemeberBox.isChecked()){
                    mRemeberBox.setChecked(false);
                }else
                    mRemeberBox.setChecked(true);
                break;
            case R.id.forgot_pass:
                startActivity(ForgotPassword.class);
                break;
            case R.id.loginBtn:
                mUsername=mUsernameEdt.getText().toString();
                mPassword=mPasswordEdt.getText().toString();
                check();
                break;
        }
    }

    private void check() {
        mRealm.beginTransaction();
        RealmResults<User> results=mRealm.where(User.class).contains("username",mUsername).contains("password",mPassword).findAll();
        if(results.isEmpty()){
            Toast.makeText(this,"Sorry  the user with this username and password doesnt exists",Toast.LENGTH_SHORT).show();
        }
        mRealm.commitTransaction();
    }

    private void startActivity(Class activity) {
        Intent intent=new Intent(this,activity);
        startActivity(intent);
    }
}
