package com.example.taschenrechner;

import android.view.View;
import android.widget.TextView;

public class Globals {
    private static final Globals instance = new Globals();

    private int textValue;
    private int zwischenErgebnis;
    private String lastAction;
    private String text;

    private Globals() {
        this.textValue = 0;
        this.zwischenErgebnis = 0;
        this.lastAction = "";
        this.text = this.zwischenErgebnis + "";
    }

    public static Globals getInstance() {
        return instance;
    }

    public int getZwischenErgebnis() {
        return this.zwischenErgebnis;
    }

    public void setZwischenErgebnis(int value) {
        this.zwischenErgebnis = value;
    }

    public String getLastAction() {
        return this.lastAction;
    }

    public void setLastAction(String action) {
        this.lastAction = action;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTextValue(){
        return this.textValue;
    }

    public void setTextValue(int textValue){
        this.textValue = textValue;
    }

}
