package com.example.laundry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    EditText email, pass;
    Button btnLogin;
    private FirebaseAuth mAuth;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        btnLogin = findViewById(R.id.button_login);
        mAuth = FirebaseAuth.getInstance();
        sharedPrefManager = new SharedPrefManager(this);

        if (sharedPrefManager.getSPSudahLogin()){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().equals("")){
                    Toast.makeText(Login.this, "Email Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                } else if (pass.getText().toString().equals("")){
                    Toast.makeText(Login.this, "Password Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                } else {
                    masuk(email.getText().toString(),pass.getText().toString());
                }
            }
        });
    }

    private void masuk(String email, String pass) {
        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
                            Toast.makeText(Login.this, "Login Sukses", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Login.this, MainActivity.class);
                            startActivity(i);
                        }
                        else {
                            Log.w("TAG", "signInWithEmail:failure", task.getException());
                            Toast.makeText(Login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
