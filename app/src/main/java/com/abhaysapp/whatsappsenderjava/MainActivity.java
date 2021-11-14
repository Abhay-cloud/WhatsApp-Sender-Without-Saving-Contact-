package com.abhaysapp.whatsappsenderjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText phoneNumberField, messageField;
    Button sendButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNumberField = findViewById(R.id.phoneNumber);
        messageField = findViewById(R.id.enterMessage);
        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(phoneNumberField.getText().toString()) || TextUtils.isEmpty(messageField.getText().toString())){
                    Toast.makeText(getApplicationContext(), "TextFields can't be empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=+91" + phoneNumberField.getText().toString() +
                            "&text=" + messageField.getText().toString() ));
                    startActivity(intent);
                }


            }
        });

    }


}