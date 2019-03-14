package by.androidacademyminsk.les_05_Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static final String BASE_URL = "https://www.omdbapi.com";
    private static final String APIKEY = "d36caaa2";
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

        Interceptor apikeyInterceptor = getApikeyInterceptor();

        OkHttpClient okHttpClient = new OkHttpClient.Builder().readTimeout(20, TimeUnit.SECONDS)
                                                              .connectTimeout(10, TimeUnit.SECONDS)
                                                              .addInterceptor(loggingInterceptor)
                                                              .addInterceptor(apikeyInterceptor)
                                                              .build();

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                                                  .addConverterFactory(
                                                          GsonConverterFactory.create(gson))
                                                  .client(okHttpClient)
                                                  .build();

        filmsAPI = retrofit.create(FilmsAPI.class);
    }

    private Interceptor getApikeyInterceptor(){
        return new Interceptor() {
            @NonNull
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();
                HttpUrl url = originalHttpUrl.newBuilder()
                                             .addQueryParameter("apikey", APIKEY)
                                             .build();
                Request.Builder requestBuilder = original.newBuilder()
                                                         .url(url);
                return chain.proceed(requestBuilder.build());
            }
        };
    }
}
