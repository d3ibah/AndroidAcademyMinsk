package by.androidacademyminsk.les_05_Retrofit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import by.androidacademyminsk.R;
import by.androidacademyminsk.les_05_Retrofit.entity.Film.Film;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Les05ActivityInfo extends AppCompatActivity {

    private static final String EXTRA_ID = "id";
    private ImageView posterImage;
    private TextView title;
    private TextView year;

    private FilmsAPI filmsAPI;
    private String filmTitle;

    public static void show(@NonNull final Context context, String imdbID) {
        Intent intent = new Intent(context, Les05ActivityInfo.class);
        intent.putExtra(EXTRA_ID, imdbID);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les05_info);

        filmTitle = getIntent().getStringExtra(EXTRA_ID);

        posterImage = findViewById(R.id.les05_info_poster_imageview);
        title = findViewById(R.id.les05_info_title_textview);
        year = findViewById(R.id.les05_info_year_textview);

        filmsAPI = NetworkService.getInstance()
                                 .getFilmsApi();

        getResponse();
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
        Call<Film> call = filmsAPI.getFilm(filmTitle);
        call.enqueue(new Callback<Film>() {
            @Override
            public void onResponse(@NonNull Call<Film> call, @NonNull Response<Film> response) {
                if (response.isSuccessful()) {
                    Film film = response.body();
                    if (film != null) {
                        Glide.with(Les05ActivityInfo.this)
                             .load(film.getPoster())
                             .into(posterImage);
                        title.setText(film.getTitle());
                        year.setText(film.getYear());
                    } else {
                        Log.e("Success response", "films is null");
                    }
                } else {
                    Log.e("Success response", "Response is not successful");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Film> call, Throwable t) {
                Log.e("Failure response", "Response is not successful");
            }
        });
    }
}
