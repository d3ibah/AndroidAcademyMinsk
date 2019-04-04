package by.androidacademyminsk.les_04_Base_Multitreading.async;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import by.androidacademyminsk.R;

public class Les04AsyncTaskActivity extends AppCompatActivity implements IAsyncTaskEvents {

    private TextView tvAsync;
    private Button btnAsyncCreate, btnAsyncStart, btnAsyncCancel;
    private CounterAsyncTask counterAsyncTask;
    private ProgressBar progressBar;
    private final int start = 0;
    private final int end = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson04_asynctask);

        initView();
        clickCreate();
        clickStart();
        clickCancel();
    }

    private void clickCancel() {
        btnAsyncCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doCancel();
            }
        });
    }

    private void clickStart() {
        btnAsyncStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doStart();
                btnAsyncStart.setEnabled(false);
            }
        });
    }

    private void clickCreate() {
        btnAsyncCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doCreate();
                btnAsyncCreate.setEnabled(false);
                tvAsync.setText("0");
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(0);
            }
        });
    }

    private void initView() {
        tvAsync = findViewById(R.id.tvAsync);
        btnAsyncCreate = findViewById(R.id.btnAsyncCreate);
        btnAsyncStart = findViewById(R.id.btnAsyncStart);
        btnAsyncCancel = findViewById(R.id.btnAsyncCancel);
        progressBar = findViewById(R.id.pbAsyncTask);
    }

    @Override
    public void onPreExecute() {

    }

    @Override
    public void onPostExecute() {
        tvAsync.setText(getString(R.string.done));
        btnAsyncCreate.setEnabled(true);
        btnAsyncStart.setEnabled(true);
    }

    @Override
    public void onProgressUpdate(Integer integer) {
        tvAsync.setText(String.valueOf(integer));
        progressBar.setProgress(integer);
    }

    @Override
    public void onCancel() {
        btnAsyncCreate.setEnabled(true);
        btnAsyncStart.setEnabled(true);
        progressBar.setProgress(0);
        progressBar.setVisibility(View.GONE);
        tvAsync.setText("");
    }

    public void doCreate() {
        counterAsyncTask = new CounterAsyncTask(this);
        Toast.makeText(this, "Create AsyncTask", Toast.LENGTH_SHORT).show();
    }

    public void doStart() {
            if ((counterAsyncTask == null) || (counterAsyncTask.isCancelled())) {
                Toast.makeText(this, "First you must create AsyncTask", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "AsyncTask started!", Toast.LENGTH_SHORT).show();
                counterAsyncTask.execute(start, end);
            }
    }

    public void doCancel() {
        counterAsyncTask.cancel(true);
        Toast.makeText(this, "AsyncTask is canceled", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        if (counterAsyncTask != null) {
            counterAsyncTask.cancel(true);
            counterAsyncTask = null;
        }
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

