package com.example.taschenrechner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView text;
    // int zwischenErgebnis;
    // String lastAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Globals.getInstance().setText(findViewById(R.id.textView));
        try {
            this.text = findViewById(R.id.textView);
            this.text.setText(Globals.getInstance().getZwischenErgebnis() + "");
        } catch (ExceptionInInitializerError e) {
            this.text = findViewById(R.id.textView);
            this.text.setText(0 + "");
            System.out.println("Try catch function!");
        }

        //this.text = findViewById(R.id.textView);
        //this.text.setText(0 + "");

        //Globals.getInstance().setZwischenErgebnis(0);
        //Globals.getInstance().setLastAction("");
        //this.zwischenErgebnis = 0;
        //this.lastAction = "";

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);

        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        Button buttonSub = (Button) findViewById(R.id.buttonSub);
        Button buttonCE = (Button) findViewById(R.id.buttonCE);
        Button buttonGleich = (Button) findViewById(R.id.buttonGleich);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Globals.getInstance().getLastAction() == "plus") {
                    int number = Integer.valueOf(Globals.getInstance().getText());
                    Globals.getInstance().setZwischenErgebnis(Globals.getInstance().getZwischenErgebnis() + number);
                } else if (Globals.getInstance().getLastAction() == "minus") {
                    int number = Integer.valueOf(text.getText().toString());
                    Globals.getInstance().setZwischenErgebnis(Globals.getInstance().getZwischenErgebnis() - number);
                } else {
                    //zwischenErgebnis = Integer.valueOf(text.getText().toString());
                    Globals.getInstance().setZwischenErgebnis(Integer.valueOf(text.getText().toString()));
                }
                text.setText(0 + "");
                Globals.getInstance().setLastAction("plus");
                // lastAction = "plus";
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Globals.getInstance().getLastAction() == "plus") {
                    int number = Integer.valueOf(text.getText().toString());
                    Globals.getInstance().setZwischenErgebnis(Globals.getInstance().getZwischenErgebnis() + number);
                    //zwischenErgebnis = zwischenErgebnis + number;
                } else if (Globals.getInstance().getLastAction() == "minus") {
                    int number = Integer.valueOf(text.getText().toString());
                    Globals.getInstance().setZwischenErgebnis(Globals.getInstance().getZwischenErgebnis() - number);
                    //zwischenErgebnis = zwischenErgebnis - number;
                } else {
                    Globals.getInstance().setZwischenErgebnis(Integer.valueOf(text.getText().toString()));
                    //zwischenErgebnis = Integer.valueOf(text.getText().toString());

                }
                text.setText(0 + "");
                Globals.getInstance().setLastAction("minus");
                // lastAction = "minus";
            }
        });

        buttonCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(0 + "");
                Globals.getInstance().setLastAction("");
                //lastAction = "";
            }
        });

        buttonGleich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Globals.getInstance().getLastAction() == "plus") {
                    int number = Integer.valueOf(text.getText().toString());
                    Globals.getInstance().setZwischenErgebnis(Globals.getInstance().getZwischenErgebnis() + number);
                    //zwischenErgebnis = zwischenErgebnis + number;
                } else if (Globals.getInstance().getLastAction() == "minus") {
                    int number = Integer.valueOf(text.getText().toString());
                    Globals.getInstance().setZwischenErgebnis(Globals.getInstance().getZwischenErgebnis() - number);
                    //zwischenErgebnis = zwischenErgebnis - number;
                } else {
                    Globals.getInstance().setZwischenErgebnis(Integer.valueOf(text.getText().toString()));
                    //zwischenErgebnis = Integer.valueOf(text.getText().toString());
                }

                text.setText(Globals.getInstance().getZwischenErgebnis() + "");
                Globals.getInstance().setLastAction("");
                // lastAction = "";
            }
        });

    }

    @Override
    public void onClick(View v) {
        String textField = this.text.getText().toString();
        String number = ((Button) v).getText().toString();
        int textFieldInt = Integer.valueOf(textField);

        if (textFieldInt == 0) {
            this.text.setText(number);
        } else {
            this.text.setText(textField + "" + number);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.text.setText(this.text.getText().toString() + "");
    }
}
