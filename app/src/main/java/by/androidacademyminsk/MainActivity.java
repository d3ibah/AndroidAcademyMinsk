package by.androidacademyminsk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import by.androidacademyminsk.Les_01_Intent.Lesson01_Intent;
import by.androidacademyminsk.Les_02_Layout.Lesson02_Layout;
import by.androidacademyminsk.Les_03_RecyclerView.Lesson03_RecyclerView;
import by.androidacademyminsk.Les_04_Base_Multitreading.Lesson04_Multithreading;

public class MainActivity extends AppCompatActivity {

    private Button buttonLes01, buttonLes02, buttonLes03, buttonLes04, buttonLes05;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLes01 = findViewById(R.id.buttonLesson01);
        buttonLes02 = findViewById(R.id.buttonLesson02);
        buttonLes03 = findViewById(R.id.buttonLesson03);
        buttonLes04 = findViewById(R.id.buttonLesson04);
        buttonLes05 = findViewById(R.id.buttonLesson05);
        imageView = findViewById(R.id.logo);
    }

    @Override
    protected void onStart() {
        super.onStart();

        clickLesson01();
        clickLesson02();
        clickLesson03();
        clickLesson04();
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

    private void clickLesson03(){
        buttonLes03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("AAAA", "AAAA");
                Intent intent = new Intent(MainActivity.this, Lesson03_RecyclerView.class);
                startActivity(intent);
            }
        });
    }

    private void clickLesson04() {
        buttonLes04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Lesson04_Multithreading.class);
                startActivity(intent);
            }
        });
    }

}
