package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ArticleDetails extends AppCompatActivity {

    private Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_article_details);

        Intent intent = getIntent();
        Article article = intent.getParcelableExtra("article");

        TextView textViewArticleName = findViewById(R.id.articleDetail_nomArticle);
        TextView textViewArticleContent = findViewById(R.id.articleDetail_content);

        textViewArticleName.setText(article.getNomArticle());
        textViewArticleContent.setText(article.getContent());

        returnButton = findViewById(R.id.returnButtun);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}