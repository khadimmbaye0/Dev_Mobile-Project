package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseManagement extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "BlogArticleApp.db";
    private static final int DATABASE_VERSION = 1;

    public DataBaseManagement(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String requete1 = "CREATE TABLE Articles("
                + "id integer PRIMARY KEY AUTOINCREMENT,"
                + "nomArticle text NOT NULL,"
                + "contenuArticle text NOT NULL"
                + ")";
        db.execSQL(requete1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<Article> getAllArticles(){
        ArrayList<Article> listArticles = new ArrayList<Article>();

        String requete2 = "SELECT * FROM Articles";
        Cursor cursor = this.getWritableDatabase().rawQuery(requete2,null);

        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String nomArticle = cursor.getString(cursor.getColumnIndex("nomArticle"));
                @SuppressLint("Range") String contenu = cursor.getString(cursor.getColumnIndex("contenuArticle"));
                nomArticle = nomArticle.replace("((%))", "'");

                Article articleObj = new Article();
                articleObj.setId(id);
                articleObj.setNomArticle(nomArticle);
                articleObj.setContent(contenu);

                listArticles.add(articleObj);
                cursor.moveToNext();
            }
        }
        return listArticles;
    }

    public void insertArticleBlog(String articleName, String content){
        String name = articleName.replace("'","((%))");
        String contenu = content.replace("'","((%))");

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nomArticle",name);
        values.put("contenuArticle",contenu);
        db.insert("Articles",null,values);
    }
}
