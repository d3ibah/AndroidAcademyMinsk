package by.androidacademyminsk.les_02_Layout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import by.androidacademyminsk.R;

public class Lesson02_Layout extends AppCompatActivity {

    private Button buttonUri;
    private final String LINK = "https://en.wikipedia.org/wiki/Minsk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson02);

        buttonUri = findViewById(R.id.lesson02_button_uri);
    }

    @Override
    protected void onStart() {
        super.onStart();
        buttonUri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(LINK));
                startActivity(browserIntent);
            }
        });
    }
}
