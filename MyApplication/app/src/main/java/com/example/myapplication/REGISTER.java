package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class REGISTER extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    private TextView login;
    private TextView res;
    private Button regbutton;
    private EditText editTextName, editTextAge, editTextBloodGroup, editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        res =  findViewById(R.id.showReg);

        regbutton = (Button) findViewById(R.id.registerUser) ;
        regbutton.setOnClickListener(this);

        login =(TextView) findViewById(R.id.login1);
        login.setOnClickListener(this);

        editTextName = (EditText) findViewById(R.id.email);
        editTextAge = (EditText) findViewById(R.id.age);
        editTextBloodGroup = (EditText) findViewById(R.id.bgroup);
        editTextPassword = (EditText) findViewById(R.id.password);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login1:
                startActivity(new Intent(this,LOGIN.class));
                break;
            case R.id.registerUser:
                registerUser();
                break;
        }
    }

    private void registerUser() {
        String age= editTextAge.getText().toString().trim();
        String bgroup= editTextBloodGroup.getText().toString().trim();
        String Name=editTextName.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();

        if(Name.isEmpty())
        {
            editTextName.setError("Name is Required");
            editTextName.requestFocus();
            return;
        }
        if(age.isEmpty())
        {
            editTextAge.setError("Age is Required");
            editTextAge.requestFocus();
            return;
        }
        if(bgroup.isEmpty())
        {
            editTextBloodGroup.setError("BloodGroup is Required");
            editTextBloodGroup.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            editTextPassword.setError("BloodGroup is Required");
            editTextPassword.requestFocus();
            return;
        }
        if(password.length()<6)
        {
            editTextPassword.setError("Min_pass length is 6 characters");
            editTextPassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(Name,password)
                .addOnCompleteListener(REGISTER.this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(REGISTER.this,"User Registered Successfully!",Toast.LENGTH_LONG).show();
                            User user= new User(Name,password,bgroup);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @SuppressLint("SetTextI18n")
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful())
                                            {
                                                startActivity(new Intent(REGISTER.this,LOGIN.class));
                                            }
                                            else
                                            {
                                                Toast.makeText(REGISTER.this, "1 failed To register!", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });
                        }else{
                            Toast.makeText(REGISTER.this, "2 failed To register!", Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }
}