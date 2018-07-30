package com.example.rfgr.komunikator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class ReceiveMessageActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "message"; //nazwa wartości którą przekazuje w intencji

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        Intent intent = getIntent();

        String messageText = intent.getStringExtra(EXTRA_MESSAGE); //te dwa wiersze pobierają intencję z klasy CreateMessageActivity
        TextView messageView = (TextView) findViewById(R.id.message);

        messageView.setText(messageText); //wyświetla odebranego stringa w polu tekstowym
    }
}
