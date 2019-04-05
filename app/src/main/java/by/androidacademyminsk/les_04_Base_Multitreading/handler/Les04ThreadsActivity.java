package by.androidacademyminsk.les_04_Base_Multitreading.handler;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import by.androidacademyminsk.R;

public class Les04ThreadsActivity extends AppCompatActivity implements IAsyncTaskEvents{

    private TextView tvAsync;
    private Button btnAsyncCreate, btnAsyncStart, btnAsyncCancel;
    private MySimpleAsyncTask mySimpleAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson04_threads);

        tvAsync = findViewById(R.id.tvThreads);
        btnAsyncCreate = findViewById(R.id.btnThreadsCreate);
        btnAsyncStart = findViewById(R.id.btnThreadsStart);
        btnAsyncCancel = findViewById(R.id.btnThreadsCancel);

        onClickCreate();
        onClickStart();
        onClickCancel();
    }

    @Override
    public void onPreExecute() {
        Toast.makeText(this, getString(R.string.les04_on_pre_execute), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPostExecute() {
        Toast.makeText(this, getString(R.string.les04_on_post_execute), Toast.LENGTH_SHORT).show();
        tvAsync.setText(getString(R.string.les04_done));
    }

    @Override
    public void onProgressUpdate(Integer integer) {
        if (integer != null) {
            tvAsync.setText(String.valueOf(integer));
        }
    }

    @Override
    public void onCancel() {
        Toast.makeText(this, getString(R.string.les04_cancel), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        if (mySimpleAsyncTask != null) {
            mySimpleAsyncTask.cancel();
            mySimpleAsyncTask = null;
        }
        super.onDestroy();
    }

    private void onClickCancel() {
        btnAsyncCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doThreadsCancel();
            }
        });
    }

    private void onClickStart() {
        btnAsyncStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doThreadsStart();
            }
        });
    }

    private void onClickCreate() {
        btnAsyncCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doThreadsCreate();
            }
        });
    }

    private void doThreadsCreate() {
        Toast.makeText(this, getString(R.string.les04_create), Toast.LENGTH_SHORT).show();
        mySimpleAsyncTask = new CounterThread(this);
    }

    private void doThreadsStart() {
        if(mySimpleAsyncTask == null || mySimpleAsyncTask.isCanceled()){
            Toast.makeText(this, getString(R.string.les04_warning), Toast.LENGTH_SHORT).show();
        } else {
            mySimpleAsyncTask.execute();
        }
    }

    private void doThreadsCancel() {
            mySimpleAsyncTask.cancel();
    }
}
