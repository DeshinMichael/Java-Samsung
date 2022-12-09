package com.example.novella;

public class Situation {
    public Situation[] direction;
    public String subject;
    public String text;
    public int dH;
    public int dK;
    public int dS;
    public Situation (String subject, String text, int variants, int dh, int dk, int
            ds) {
        this.subject=subject;
        this.text=text;
        dH=dh;
        dK=dk;
        dS=ds;
        direction=new Situation[variants];
    }
}
