/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Vector;

/**
 *
 * @author Tarik
 */
public class Alarm {
    private int idAlarm=0;
    private String nom;
    private String days;
    private int hour;
    private int min;
    private int snooze_temps;
    private boolean active;
    private String path;
    private int snoozedHour;
    private int snoozedMin;
    private String memo;

    public Alarm() {
    }

    public Alarm(String nom, String days, int hour, int min, int snooze_temps, boolean active, String path, int snoozedHour, int snoozedMin, String memo) {
        this.nom = nom;
        this.days = days;
        this.hour = hour;
        this.min = min;
        this.snooze_temps = snooze_temps;
        this.active = active;
        this.path = path;
        this.snoozedHour = snoozedHour;
        this.snoozedMin = snoozedMin;
        this.memo = memo;
    }

   
    public int getSnoozedHour() {
        return snoozedHour;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setSnoozedHour(int snoozedHour) {
        this.snoozedHour = snoozedHour;
    }

    public int getSnoozedMin() {
        return snoozedMin;
    }

    public void setSnoozedMin(int snoozedMin) {
        this.snoozedMin = snoozedMin;
    }

    

    public int getIdAlarm() {
        return idAlarm;
    }

    public void setIdAlarm(int idAlarm) {
        this.idAlarm = idAlarm;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSnooze_temps() {
        return snooze_temps;
    }

    public void setSnooze_temps(int snooze_temps) {
        this.snooze_temps = snooze_temps;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    

   
   
}
