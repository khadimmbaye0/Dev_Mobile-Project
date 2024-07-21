package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ListView listViewArticles;
    private ArrayList<Article> listOfArticles = new ArrayList<>();
    private DataBaseManagement dataBaseManagement;
    private ArticleAdapter articleAdapter;
    private Button addArticleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        dataBaseManagement = new DataBaseManagement(getApplicationContext());

        listViewArticles = findViewById(R.id.ListViewArticles);

        addArticleButton = findViewById(R.id.addArticleButton);

        listOfArticles = dataBaseManagement.getAllArticles();

        articleAdapter = new ArticleAdapter(this, listOfArticles);

        listViewArticles.setAdapter(articleAdapter);

        listViewArticles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Article selectedArticle = listOfArticles.get(position);

                Intent intent = new Intent(MainActivity.this, ArticleDetails.class);
                intent.putExtra("article", selectedArticle);
                startActivity(intent);
            }
        });


        addArticleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startAddArticle = new Intent(getApplicationContext(), AddArticleActivity.class);
                startActivity(startAddArticle);
            }
        });



    }
}