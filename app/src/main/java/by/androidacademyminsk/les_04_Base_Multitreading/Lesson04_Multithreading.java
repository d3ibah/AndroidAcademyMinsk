package by.androidacademyminsk.les_04_Base_Multitreading;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import by.androidacademyminsk.R;
import by.androidacademyminsk.les_04_Base_Multitreading.async.Les04AsyncTaskActivity;
import by.androidacademyminsk.les_04_Base_Multitreading.handler.Les04ThreadsActivity;

public class Lesson04_Multithreading extends AppCompatActivity {
    private Button buttonAsync, buttonLoader, buttonThreads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson04);
        buttonAsync = findViewById(R.id.buttonAsync);
        buttonLoader = findViewById(R.id.buttonLoader);
        buttonThreads = findViewById(R.id.buttonThreads);

        buttonAsync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lesson04_Multithreading.this, Les04AsyncTaskActivity.class);
                startActivity(intent);
            }
        });

        buttonLoader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lesson04_Multithreading.this, Les04LoaderActivity.class);
                startActivity(intent);
            }
        });

        buttonThreads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lesson04_Multithreading.this, Les04ThreadsActivity.class);
                startActivity(intent);
            }
        });
    }
}
