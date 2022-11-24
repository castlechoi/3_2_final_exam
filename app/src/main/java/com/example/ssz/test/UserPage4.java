package com.example.ssz.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ssz.AppData;
import com.example.ssz.R;
import com.example.ssz.db.DBConnect;
import com.example.ssz.db.DBStringCallback;

public class UserPage4 extends AppCompatActivity {
    private Button done;
    private static String comment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.ssz.R.layout.activity_user_pg4);

        TextView textView = findViewById(R.id.textView5);
        setComment();
        textView.setText(((AppData)getApplication()).getComment());

        done = findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserPage4.this, Home.class);
                startActivity(intent);
            }
        });
    }

    private void setComment() {
        Intent intent = getIntent();
        DBConnect.readComment(new DBStringCallback() {
            @Override
            public void onCallback(String comment) {
                ((AppData) getApplication()).setComment(comment);
            }
        }, intent.getIntExtra("routeId", 0));
    }
}