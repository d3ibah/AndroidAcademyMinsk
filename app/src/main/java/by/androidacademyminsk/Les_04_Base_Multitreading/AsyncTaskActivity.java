package by.androidacademyminsk.Les_04_Base_Multitreading;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import by.androidacademyminsk.R;

public class AsyncTaskActivity extends AppCompatActivity {

    TextView tvAsync;
    Button btnAsyncCreate, btnAsyncStart, btnAsyncCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        tvAsync = findViewById(R.id.tvAsync);
        btnAsyncCreate = findViewById(R.id.btnAsyncCreate);

        btnAsyncCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CounterAsyncTask counterAsyncTask = new CounterAsyncTask();
                counterAsyncTask.execute();
            }
        });
    }

    class CounterAsyncTask extends AsyncTask<Void, Integer, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                for (int i = 0; i < 11; i++) {
                    publishProgress(i);
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            tvAsync.setText("Ready, steady...");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            tvAsync.setText("Done!");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            tvAsync.setText("" + values[0]);
        }
    }
}
