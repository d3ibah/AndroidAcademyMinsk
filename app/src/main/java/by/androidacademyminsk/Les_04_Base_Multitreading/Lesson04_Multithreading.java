package by.androidacademyminsk.Les_04_Base_Multitreading;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import by.androidacademyminsk.R;

public class Lesson04_Multithreading extends AppCompatActivity {
    private Button buttonAsync, buttonLoader, buttonThreads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        buttonAsync = findViewById(R.id.buttonAsync);
        buttonLoader = findViewById(R.id.buttonLoader);
        buttonThreads = findViewById(R.id.buttonThreads);

        buttonAsync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lesson04_Multithreading.this, AsyncTaskActivity.class);
                startActivity(intent);
            }
        });

        buttonLoader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lesson04_Multithreading.this, LoaderActivity.class);
                startActivity(intent);
            }
        });

        buttonThreads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lesson04_Multithreading.this, ThreadsActivity.class);
                startActivity(intent);
            }
        });
    }
}
