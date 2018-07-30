package com.example.rfgr.komunikator;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    public void onSendMessage(View view) {
        EditText messageView = (EditText) findViewById(R.id.message);
        String messageText = messageView.getText().toString(); //te dwa wiersze pobierają wpisaną wiadomość z pola EditText
        Intent intent = new Intent(this, ReceiveMessageActivity.class); //utworzona intencja i wskazanie gdzie chcemy ją przesłać
        intent.putExtra("message", messageText); //ten fragment kodu dodaje do intencji coś Extra- w tym przypadku pobraną wartość messageText
        startActivity(intent); //wykonanie przesłanej intencji
    }

    public void onSendMessageSMS(View view) {

        EditText messageView = (EditText) findViewById(R.id.message);//pobierają wiadomść z pola EditText
        String messageText = messageView.getText().toString();

        Uri uri = Uri.parse("smsto:515111222"); //określam adres pod który chcę wysłać wiadomość
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri); //wybieramy aktywność jaką chcemy zainicjować + dodaje adres określony wyżej
        //intent.setType("text/plain"); //określamy co będzie jej elementem/ jakie dane
        intent.putExtra("sms_body", messageText); //dodajemy coś EXTRA- zawartość wiadomości

        String chooserTitle = getString(R.string.choser); //dzięki tym dwóm linijkom kodu za każdym razem aplikacja będzie
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle); // pytała jakiej innej aplikacji chce użyć do wysłania wiadomości

        startActivity(chosenIntent); //odpalamy aktywność
    }
}
