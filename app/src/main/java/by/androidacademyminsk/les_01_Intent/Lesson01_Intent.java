package by.androidacademyminsk.les_01_Intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import by.androidacademyminsk.R;

public class Lesson01_Intent extends AppCompatActivity {

    private EditText editText;
    private Button buttonActivity;
    private Button buttonEmail;
    private String text;
    private  String message = "We love Android";
    private final String SUBJECT = "The message I wrote on my app";
    private final String [] ADDRESS = {"buae@ya.ru"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson01__intent);

        editText = findViewById(R.id.editText);
        buttonActivity = findViewById(R.id.buttonActivity);
        buttonEmail = findViewById(R.id.buttonEmail);
    }

    @Override
    protected void onStart() {
        super.onStart();

        clickButtonActivity();
        clickButtonEmail();
    }

    private void clickButtonActivity(){
        buttonActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = editText.getText().toString();
                Intent intent = new Intent(Lesson01_Intent.this, TextViewActivity.class);
                intent.putExtra("text", text);
                startActivity(intent);
            }
        });
    }

    private void clickButtonEmail(){
        buttonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().length() > 0) {
                    message = editText.getText().toString();
                }
                composeEmail(ADDRESS, SUBJECT, message);
            }
        });
    }

    private void composeEmail(String[] address, String subject, String message){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, address);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
}
