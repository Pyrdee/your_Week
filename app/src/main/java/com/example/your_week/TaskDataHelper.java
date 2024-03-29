package com.example.your_week;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class TaskDataHelper extends SQLiteOpenHelper {


    //Tietokanta-asiat: Esitellään kaikki käytettävät nimet valmiiksi.
    // Jos niitä tarvitsee toistaa, on ne helpompi kirjoittaa.
    //Tietokannan versio
    private static final int DATABASE_VERSION = 1;
    //Tietokannan nimi
    private static final String DATABASE_NAME = "tasks_database";
    //Database Table -nimi
    private static final String TABLE_NAME = "TASKS";
    //Taulun muodot:
    public static final String ID = "id";
    public static final String TASKNAME = "task";
    public static final String DATE = "date";
    public static final String TIME = "time";
    private SQLiteDatabase sqLiteDatabase;


    //Luodaan muuttuja, johon on tallennettu valmiiksi kaikki tiedot taulun luomiseen.
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT," + TASKNAME + " TEXT NOT NULL," + DATE + " TEXT NOT NULL," + TIME + " TEXT NOT NULL);";

    //Rakentaja
    public TaskDataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    //Luodaan uusi taulu, kun onCreate suoritetaan. Jos samanniminen taulu on jo olemassa, mitään ei tehdä.
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    //ei luoda uutta taulua, jos TASKS-niminen taulu on jo olemassa.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Lisää/tallenna taski
    /**
     *
     * @param taskModel
     */
    public void addTask(TaskModel taskModel) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TaskDataHelper.TASKNAME, taskModel.getTaskName());
        contentValues.put(TaskDataHelper.DATE, taskModel.getTaskDate());
        contentValues.put(TaskDataHelper.TIME, taskModel.getTaskTime());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(TaskDataHelper.TABLE_NAME, null, contentValues);
    }

    //Hae taulusta tietyt kolumnit.
    /**
     * Hae taulusta "TABLE_NAME" tietyltä riviltä muodot indekseistä 0,1,2 ja 3
     * Tämän jälkeen aseta tiedot näistä merkkijono muuttujiin.
     * @return
     */
    public List<TaskModel> getTaskList() {
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<TaskModel> storeTasks = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String task = cursor.getString(1);
                String date = cursor.getString(2);
                String time = cursor.getString(3);
                storeTasks.add(new TaskModel(id, task, date, time));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return storeTasks;
    }

    /**
     * Toiminto, jolla voidaan päivittää/muokata rivin tietoja.
     * @param taskModel
     */
    public void updateTask(TaskModel taskModel) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TaskDataHelper.TASKNAME, taskModel.getTaskName());
        contentValues.put(TaskDataHelper.DATE, taskModel.getTaskDate());
        contentValues.put(TaskDataHelper.TIME, taskModel.getTaskTime());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME, contentValues, ID + " = ?", new String[]
                {String.valueOf(taskModel.getId())});
    }

    /**
     * Tällä voidaan poistaa koko rivi tietokannasta.
     * Metodille kerrotaan ID ja sitten tämä rivi hävitetään.
     * @param id
     */
    public void deleteTask(int id) {
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ID + " = ? ", new String[]
                {String.valueOf(id)});

    }


}
