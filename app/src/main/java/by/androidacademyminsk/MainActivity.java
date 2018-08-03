package by.androidacademyminsk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button buttonLes01, buttonLes02;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLes01 = findViewById(R.id.buttonLesson01);
        buttonLes02 = findViewById(R.id.buttonLesson02);
        imageView = findViewById(R.id.logo);
    }

    @Override
    protected void onStart() {
        super.onStart();

        clickLesson01();
        clickLesson02();
    }

    private void clickLesson01(){
        buttonLes01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Lesson01_Intent.class);
                startActivity(intent);
            }
        });
    }

    private void clickLesson02(){
        buttonLes02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("AAAA", "AAAA");
                Intent intent = new Intent(MainActivity.this, Lesson02_Layout.class);
                startActivity(intent);
            }
        });
    }



}
