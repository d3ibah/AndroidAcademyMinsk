package by.androidacademyminsk.les_01_Intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;
import by.androidacademyminsk.R;

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
