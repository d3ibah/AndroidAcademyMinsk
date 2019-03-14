package by.androidacademyminsk.les_03_RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import by.androidacademyminsk.R;

public class Lesson03_RecyclerView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Les03Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson03__recycler_view);

        recyclerView = findViewById(R.id.recyclerView);

        adapter = new Les03Adapter(new Les03Adapter.ClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(Lesson03_RecyclerView.this, Les03FullInfoActivity.class);
                int pos = position;
                intent.putExtra("position", pos);
                startActivity(intent);
            }
        });

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
        recyclerView.setLayoutManager(new GridLayoutManager(Lesson03_RecyclerView.this, 2));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(Lesson03_RecyclerView.this, 4));
        }

        recyclerView.setAdapter(adapter);
    }
}
