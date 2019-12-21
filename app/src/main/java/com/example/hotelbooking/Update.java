package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Update extends AppCompatActivity {
    private EditText username, email;
    private ArrayList<User> userarray = new ArrayList<User>();
    private User user = new User();
    private String uname, em;
    private Button button;
    private dphelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        setDatabase();

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        button = findViewById(R.id.button);

        uname = getIntent().getStringExtra("username");
        em = getIntent().getStringExtra("email");

        username.setText(uname);
        email.setText(em);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user.setName(username.getText().toString());
                user.setEmail(email.getText().toString());
                dbHelper.updateContact(user);
            }
        });
    }

    private void setDatabase() {
        dbHelper = new dphelper(Update.this);
    }
}
