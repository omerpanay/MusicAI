package com.omerpanay.anew.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.omerpanay.anew.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private ActivityLoginBinding binding;
   // Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //loginButton=findViewById(R.id.signInLogin);
        firebaseAuth = FirebaseAuth.getInstance();
        /*
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =binding.editTextlogin.getText().toString();
                String password = binding.editText2login.getText().toString();
                mainActivity(email,password);
            }
        });




    }*/
    }
    public void register(View view){
        startActivity(new Intent(LoginActivity.this,MainActivity.class));


    }


    public void mainActivity(View view) {
        String email = binding.editTextlogin.getText().toString();
        String password = binding.editText2login.getText().toString();
        if (email.equals("")||password.equals("")){
            Toast.makeText(LoginActivity.this,"Please fill email and password",Toast.LENGTH_LONG).show();

        }else{

            firebaseAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Toast.makeText(LoginActivity.this,"Log in success !",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(LoginActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();

                }
            });
        }

    }
}
