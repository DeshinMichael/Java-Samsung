package com.company;

import java.util.Comparator;

public class DayOfCalendar implements Comparable<DayOfCalendar>{
    int day;
    int month;
    String reason = "";

    public DayOfCalendar(int day, int month, String reason) {
        this.day = day;
        this.month = month;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return day + " " + month + " " + reason + "\n";
    }

    @Override
    public int compareTo(DayOfCalendar o) {
        if(day > o.day)
            return 1;
        if(day < o.day)
            return -1;
        return 0;
    }
}

class MyComparator implements Comparator<DayOfCalendar> {

    @Override
    public int compare(DayOfCalendar o1, DayOfCalendar o2) {
        return o1.reason.compareTo(o2.reason);
    }
}