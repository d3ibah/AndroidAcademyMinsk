package by.androidacademyminsk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class TextViewActivity extends AppCompatActivity {

    TextView textView, textDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        textView = findViewById(R.id.textView);
        textDate = findViewById(R.id.textDate);
    }

    @Override
    protected void onStart() {
        super.onStart();
        printText();
    }

    private void printText(){
        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("text"));

        textDate.setText(Calendar.getInstance().getTime().toString());
    }
}
