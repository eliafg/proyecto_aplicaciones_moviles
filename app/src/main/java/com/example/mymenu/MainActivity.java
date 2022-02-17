package com.example.mymenu;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

        //DECLARACION DE VARIABLES
    TextView tview_intro;
    TextView tview_error;
    EditText text_Name;
    EditText text_Password;
    Button button_Login;
    Button button_Exit;
    Button button_Dial;
    Button button_Directory;
    Button button_openWeb;
    EditText editText_Dial;
    public static final String EXTRA_MESSAGE = "com.example.mymenu.MESSAGE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            //XML principal - LOGIN
        setContentView(R.layout.activity_main);

            //SECCION DE CASTEO POR ENLAZAMIENTO
        text_Name = (EditText)findViewById(R.id.text_Name);
        text_Password  = (EditText)findViewById(R.id.text_Password);
        button_Login = (Button)findViewById(R.id.button_Login);
        button_Exit = (Button)findViewById(R.id.button_Reset);
        tview_intro = (TextView)findViewById(R.id.tview_intro);
        tview_error = (TextView)findViewById(R.id.tview_error);
        button_Dial = (Button)findViewById(R.id.button_Dial);
        button_Directory = (Button)findViewById(R.id.button_Directory);
        editText_Dial = (EditText)findViewById(R.id.editText_Dial);
        button_openWeb = (Button)findViewById(R.id.button_openWeb);


            //Listener de eventos por los botones
        button_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = text_Name.getText().toString();
                String password = text_Password.getText().toString();

                if(name.equals("Vinki") && password.equals("Vinki")){
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    EditText editText = (EditText) findViewById(R.id.text_Name);
                    String message = editText.getText().toString();
                    intent.putExtra(EXTRA_MESSAGE, message);
                    startActivity(intent);

                }
                else{
                    tview_error.setText(getString(R.string.error));
                }

            }
        });

        button_Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_Name.setText("");
                text_Password.setText("");
            }
        });

        button_Dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editText_Dial.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+"+message));
                startActivity(intent);
            }
        });

        button_Directory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                startActivity(intent);
            }
        });

        button_openWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
                startActivity(intent);
            }
        });
    }
}