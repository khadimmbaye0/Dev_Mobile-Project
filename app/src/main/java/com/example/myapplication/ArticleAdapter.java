package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ArticleAdapter extends ArrayAdapter<Article> {
    public ArrayList<Article> articleArrayList;
    public ArticleAdapter(Context context, ArrayList<Article> articleArrayList){
        super(context,0,articleArrayList);
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @ NonNull ViewGroup parent){
        return initView(position,convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.article_list_view_row, parent, false
            );
        }

        TextView textViewArticleName = convertView.findViewById(R.id.articleView_nomArticle_row);
        TextView textViewArticleContent = convertView.findViewById(R.id.articleView_ContentArticle_row);

        Article currentArticle = getItem(position);
        if (convertView != null){
            textViewArticleName.setText(currentArticle.getNomArticle());
            textViewArticleContent.setText(currentArticle.getContent());
        }

        return convertView;
    }
}
