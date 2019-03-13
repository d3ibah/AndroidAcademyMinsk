package by.androidacademyminsk.les_03_RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import by.androidacademyminsk.R;

public class Les03FullInfoActivity extends AppCompatActivity {

    ImageView ivInfo;
    TextView tvInfo;

    List<Actor> actorList;
    int position;
    Actor actor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson03_full_info);

        ivInfo = findViewById(R.id.iv_les03_info);
        tvInfo = findViewById(R.id.tv_les03_info);

        Intent intent = new Intent();

        position = getIntent().getIntExtra("position", 0);

        actorList = DataUri.generateActors();
        actor = actorList.get(position);


        Glide.with(this)
                .load(actor.getFullImage())
                .into(ivInfo);
        tvInfo.setText(actor.getInfo());
    }
}
