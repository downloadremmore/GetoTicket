package com.example.rim.Geto_Ticket.UI.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.rim.Geto_Ticket.Managers.UsersManager;
import com.example.rim.Geto_Ticket.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by rim on 26/03/17.
 */

public class SignupActivity extends BaseActivity implements View.OnClickListener {

    private EditText mUserName, mEmail, mPassword, mPhoneNumber;
    private ImageView mSignUpButton;
    private FirebaseAuth mAuth;
    private static final String TAG = "SignUpActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);
        mAuth = FirebaseAuth.getInstance();

        //Initialize layout conponent
        mUserName = (EditText) findViewById(R.id.username_text);
        mEmail = (EditText) findViewById(R.id.email_text);
        mPassword = (EditText) findViewById(R.id.pass_text);
        mPhoneNumber = (EditText) findViewById(R.id.num_text);
        mSignUpButton = (ImageView) findViewById(R.id.signup_img);

        findViewById(R.id.back_imageview).setOnClickListener(this);
        mSignUpButton.setOnClickListener(this);
    }

    private boolean validateForm(String nameField) {
        boolean valid = true;
        if (TextUtils.isEmpty(nameField)) {
            mEmail.setError("Required.");
            valid = false;
        } else {
            mEmail.setError(null);
        }

        return valid;
    }

    private void createAccount(final String username, final String email, final String phone_number, String password) {
        Log.d(TAG, "createAccount:" + email);
        if (!validateForm(mUserName.getText().toString()) || !validateForm(mPhoneNumber.getText().toString()) || !validateForm(mEmail.getText().toString()) || !validateForm(mPassword.getText().toString())) {
            return;
        }
        showProgressDialog();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                        if (!task.isSuccessful()) {
                            Toast.makeText(SignupActivity.this, "Create account failed.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            new UsersManager().fisrtUpdateUser(username, email, phone_number);
                            Intent intent = new Intent(SignupActivity.this, ScreenSlideActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            finish();
                        }
                        hideProgressDialog();
                    }
                });


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == mSignUpButton.getId()) {
            createAccount(mUserName.getText().toString(), mEmail.getText().toString(), mPhoneNumber.getText().toString(), mPassword.getText().toString());

        } else if (v.getId() == R.id.back_imageview) {
            Intent intent = new Intent(SignupActivity.this, ChoiceActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    }
}