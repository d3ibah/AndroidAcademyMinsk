package by.androidacademyminsk.les_05_Retrofit;

import by.androidacademyminsk.les_05_Retrofit.entity.films.Films;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmsAPI {

    @GET("/")
    Call<Films> getFilms(@Query("apikey") String apikey, @Query("s") String keyword);
}
