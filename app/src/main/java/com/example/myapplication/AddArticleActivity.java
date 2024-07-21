package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddArticleActivity extends AppCompatActivity {
    private String articleName;
    private String articleContent;
    private DataBaseManagement dataBaseManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_article);

        dataBaseManagement = new DataBaseManagement(getApplicationContext());

        Button addBtn = findViewById(R.id.addArticleButton);
        Button returnBtn = findViewById(R.id.returnButtun);
        EditText articleNameEditText = findViewById(R.id.editTextTitre);
        EditText articleContentEditText = findViewById(R.id.editTextContenu);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                articleName = articleNameEditText.getText().toString();
                articleContent = articleContentEditText.getText().toString();

                dataBaseManagement.insertArticleBlog(articleName,articleContent);

                Intent startArticleActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startArticleActivity);
            }
        });

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startArticleActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startArticleActivity);
            }
        });
    }
}