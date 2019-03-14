package by.androidacademyminsk.les_05_Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    public static final String BASE_URL = "https://www.omdbapi.com";
    private static NetworkService instance;
    private FilmsAPI filmsAPI;

    private NetworkService() {
        init();
    }

    public static NetworkService getInstance() {
        if (instance == null) {
            instance = new NetworkService();
        }
        return instance;
    }

    public FilmsAPI getFilmsApi() {
        return filmsAPI;
    }

    private void init() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().readTimeout(20, TimeUnit.SECONDS)
                                                              .connectTimeout(10, TimeUnit.SECONDS)
                                                              .addInterceptor(loggingInterceptor)
                                                              .build();

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                                                  .addConverterFactory(
                                                          GsonConverterFactory.create(gson))
                                                  .client(okHttpClient)
                                                  .build();

        filmsAPI = retrofit.create(FilmsAPI.class);
    }
}
