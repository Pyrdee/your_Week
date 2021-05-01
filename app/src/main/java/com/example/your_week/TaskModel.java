package com.example.your_week;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Mallintaa tehtävämallin.
 * Tässä kerrotaan tiedot jotka vaaditaan uuden taskin tallennukseen.
 */
public class TaskModel {

    Integer id;
    String taskName;
    String taskDate;
    String taskTime;

    /**
     * Luo tehtävämallin kaikkien paitsi id-muuttujan kanssa.
     * @param taskName
     * @param taskDate
     * @param taskTime
     */
    //rakentaja ilman id-kenttää
    public TaskModel(String taskName, String taskDate, String taskTime) {
        this.taskName = taskName;
        this.taskDate = taskDate;
        this.taskTime = taskTime;

    }

    /**
     * Luo tehtävämallin kaikkien muuttujien kanssa.
     * @param id
     * @param taskName
     * @param taskDate
     * @param taskTime
     */
    //rakentaja
    public TaskModel(int id, String taskName, String taskDate, String taskTime) {
        this.id = id;
        this.taskName = taskName;
        this.taskDate = taskDate;
        this.taskTime = taskTime;

    }


    //Getterit ja setterit
    public int getId() {
        return id;
    }

    /**
     * Hankitaan id
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Palautetaan taskin/tehtävän nimi.
     * @return
     */
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * Kerrotaan tehtävän päivämäärä.
     * @return
     */
    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    /**
     * Kerrotaan tehtävän kellonaika.
     * @return
     */
    public String getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(String taskTime) {
        this.taskTime = taskTime;
    }
}
