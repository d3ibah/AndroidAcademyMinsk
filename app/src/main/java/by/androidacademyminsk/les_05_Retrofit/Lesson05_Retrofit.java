package by.androidacademyminsk.les_05_Retrofit;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import by.androidacademyminsk.BaseActivity;
import by.androidacademyminsk.R;
import by.androidacademyminsk.les_05_Retrofit.entity.films.Films;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Lesson05_Retrofit extends BaseActivity {

    private Button searchAction;
    private Button vogellaAction;
    private EditText keywordSource;
    private RecyclerView recyclerView;

    private String keyword;
    private LesO5Adapter adapter;
    private FilmsAPI filmsAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson05_retrofit);

        searchAction = findViewById(R.id.les05_button);
        vogellaAction = findViewById(R.id.les05_vogella);
        keywordSource = findViewById(R.id.les05_editText);
        recyclerView = findViewById(R.id.les05_recycler_view);

        filmsAPI = NetworkService.getInstance()
                                 .getFilmsApi();

        initRecyclerView();

        searchAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInputSymbols();
                if (!TextUtils.isEmpty(keyword)) {
                    getResponse();
                    hideKeyboard();
                }
            }
        });

        vogellaAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Les05VogellaActivity.show(Lesson05_Retrofit.this);
            }
        });
    }

    private void getInputSymbols() {
        keyword = keywordSource.getText()
                               .toString()
                               .trim();
    }

    private void initAdapter(final Films films) {
        adapter = new LesO5Adapter(films, new LesO5Adapter.ClickListener() {
            @Override
            public void onClick(int position) {
                Les05ActivityInfo.show(Lesson05_Retrofit.this, films.getSearch()
                                                                    .get(position)
                                                                    .getTitle());
            }
        });
    }

    private void initRecyclerView() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new GridLayoutManager(Lesson05_Retrofit.this, 2));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(Lesson05_Retrofit.this, 3));
        }
    }

    private void getResponse() {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                callToNetwork();
            }
        });
    }

    private void callToNetwork() {
        Call<Films> call = filmsAPI.getFilms(keyword);
        call.enqueue(new Callback<Films>() {
            @Override
            public void onResponse(@NonNull Call<Films> call, @NonNull Response<Films> response) {
                if (response.isSuccessful()) {
                    Films films = response.body();
                    if (films != null) {
                        initAdapter(films);
                        recyclerView.setAdapter(adapter);
                    } else {
                        Log.e("Success response", "films is null");
                    }
                } else {
                    Log.e("Success response", "Response is not successful");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Films> call, @NonNull Throwable t) {
                Log.e("Failure response", "Response is not successful");
            }
        });
    }
}
