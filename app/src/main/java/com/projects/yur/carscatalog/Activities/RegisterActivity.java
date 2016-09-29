package com.projects.yur.carscatalog.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.projects.yur.carscatalog.Models.User;
import com.projects.yur.carscatalog.R;
import com.projects.yur.carscatalog.Utils.BitmapManager;
import com.projects.yur.carscatalog.Utils.Expression_Checker;

import java.io.FileNotFoundException;
import java.io.InputStream;

import io.realm.Realm;
import io.realm.RealmResults;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mAvatar;
    private EditText mFullNameEdt,mUsernameEdt, mPhoneEdt, mEmailEdt,mConfirmEmailEdt,mPasswordEdt,mConfirmPassEdt;
    private Button mRegisterBtn,mLoginBtn;
    private String mUsername,mFullname,mPassword,mEmail,mPhone,mConfirmPass,mConfirmEmail;
    Realm mRealm;

    public static final int SELECT_PHOTO=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    private void init() {
        mAvatar=(ImageView)findViewById(R.id.avatar);

        mFullNameEdt=(EditText)findViewById(R.id.full_name_edt);
        mUsernameEdt=(EditText)findViewById(R.id.user_name_edt);
        mPhoneEdt=(EditText)findViewById(R.id.phone_number_edt);
        mEmailEdt=(EditText)findViewById(R.id.email_edt);
        mConfirmEmailEdt=(EditText)findViewById(R.id.confirm_email_edt);
        mPasswordEdt=(EditText)findViewById(R.id.password_edt);
        mConfirmPassEdt=(EditText)findViewById(R.id.confirm_pass_edt);

        mRegisterBtn=(Button)findViewById(R.id.register_btn);
        mLoginBtn=(Button)findViewById(R.id.login_btn);

        mRegisterBtn.setOnClickListener(this);
        mLoginBtn.setOnClickListener(this);
        mAvatar.setOnClickListener(this);

        Realm.getDefaultInstance();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.register_btn:
                checkAndSave();
                break;
            case R.id.login_btn:
                Intent intent=new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.avatar:
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, SELECT_PHOTO);
                break;
        }
    }

    private void checkAndSave() {
        Expression_Checker checker = new Expression_Checker();
        mFullname=mFullNameEdt.getText().toString();
        mUsername=mUsernameEdt.getText().toString();
        mEmail=mEmailEdt.getText().toString();
        mPassword=mPasswordEdt.getText().toString();
        mConfirmPass=mConfirmPassEdt.getText().toString();
        mConfirmEmail=mConfirmEmailEdt.getText().toString();
        mPhone=mPhoneEdt.getText().toString();

        if(!checker.nameChecker(mFullname)){
            Toast.makeText(this,"Please enter name and surname correctly",Toast.LENGTH_SHORT).show();
        }else{
            if(!checker.usernameChecker(mUsername)){
                Toast.makeText(this,"the Username must have at least 8 simbols",Toast.LENGTH_SHORT).show();
            }else {
                if (!checker.passwordChecker(mPassword)) {
                    Toast.makeText(this, "the Password must have at least 3 upper and lowercase letters and 3 digits", Toast.LENGTH_SHORT).show();
                }else {
                    if (!checker.EmailChecker(mEmail)) {
                        Toast.makeText(this, "please use the Email client like MAIL.RU, GMAIL.com, Yahoo.com", Toast.LENGTH_SHORT).show();
                    }else{
                        if(!mPassword.equals(mConfirmPass)){
                            Toast.makeText(this,"The passwords doesnt matches",Toast.LENGTH_SHORT).show();
                        }else {
                            if(!mEmail.equals(mConfirmEmail)){
                                Toast.makeText(this,"The Email addresses doesnt matches", Toast.LENGTH_SHORT).show();
                            }
                            else{saveUser(new User(1,mUsername,mPassword,mEmail,mPhone,mFullname));}
                        }
                    }
                }
            }
        }

    }

    private void saveUser(User user) {
        mRealm.beginTransaction();
        RealmResults<User> res= mRealm.where(User.class).contains("username",mUsername).findAll();
        int id=1;
        if(!res.isEmpty()){
            Toast.makeText(this,"the user with this Username is exist, please type another",Toast.LENGTH_SHORT).show();
        }else {
            User lastUser=null;
            RealmResults<User> results = mRealm.where(User.class).findAll();
            if(!results.isEmpty()){
                lastUser=results.last();
                id=lastUser.getId()+1;
            }
        }
        user.setId(id);
        Toast.makeText(this,"The user succesfully added to database",Toast.LENGTH_SHORT).show();
        mRealm.copyToRealm(user);
        mRealm.commitTransaction();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case SELECT_PHOTO:
                if(resultCode == RESULT_OK){
                    try {
                        final Uri imageUri = data.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        mAvatar.setImageBitmap(BitmapManager.getCircullarBitmapWithBorder(selectedImage,5, Color.WHITE));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                }
        }
    }

}
