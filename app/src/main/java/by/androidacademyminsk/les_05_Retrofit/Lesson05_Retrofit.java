package by.androidacademyminsk.les_05_Retrofit;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import by.androidacademyminsk.BaseActivity;
import by.androidacademyminsk.R;
import by.androidacademyminsk.les_05_Retrofit.entity.Film;

public class Lesson05_Retrofit extends BaseActivity {

    private Button searchAction;
    private EditText keywordSource;
    private RecyclerView recyclerView;

    private String keyword;
    private LesO5Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson05_retrofit);

        searchAction = findViewById(R.id.les05_button);
        keywordSource = findViewById(R.id.les05_editText);
        recyclerView = findViewById(R.id.les05_recycler_view);
        initRecyclerView();

        searchAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInputSymbols();
                if (!TextUtils.isEmpty(keyword)) {
                    //                    TODO: Waiting implementation
                    hideKeyboard();
                    showSnackbar(searchAction, keyword);
                }
            }
        });
    }

    private void getInputSymbols() {
        keyword = keywordSource.getText()
                               .toString()
                               .trim();
    }

    private void setAdapter(List<Film> filmList) {
        adapter = new LesO5Adapter(filmList);
    }

    private void initRecyclerView() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new GridLayoutManager(Lesson05_Retrofit.this, 2));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(Lesson05_Retrofit.this, 3));
        }
    }
}
