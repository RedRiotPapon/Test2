package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LOGIN extends AppCompatActivity implements View.OnClickListener{
    private TextView register;
    private Button login;
    private EditText Editemail;
    private EditText Editpassword;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login =(Button)findViewById(R.id.loginbtn);
        login.setOnClickListener(this);
        register =(TextView) findViewById(R.id.reg1);
        register.setOnClickListener(this);
        Editemail =(EditText)findViewById(R.id.email);
        Editpassword = (EditText)findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reg1:
                startActivity(new Intent(this,REGISTER.class));
                break;
            case R.id.loginbtn:
                userLogin();
                break;
        }
    }

    private void userLogin() {
        String email=Editemail.getText().toString().trim();
        String password=Editpassword.getText().toString().trim();
        if(email.isEmpty())
        {
            Editemail.setError("Email is Required");
            Editemail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Editemail.setError("Incorrect Email");
            Editemail.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            Editpassword.setError("Password field cant be empty");
            Editpassword.requestFocus();
            return;
        }
        if(password.length() < 6)
        {
            Editpassword.setError("Min_pass length is 6 characters");
            Editpassword.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    startActivity(new Intent(LOGIN.this,homeActivity2.class));
                }
                else
                {
                    Toast.makeText(LOGIN.this, "failed To login!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}