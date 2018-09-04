package by.androidacademyminsk.les_04_Base_Multitreading.handler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import by.androidacademyminsk.R;

public class Les04ThreadsActivity extends AppCompatActivity implements IAsyncTaskEvents{

    TextView tvAsync;
    Button btnAsyncCreate, btnAsyncStart, btnAsyncCancel;
    MySimpleAsyncTask mySimpleAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons04_threads);

        tvAsync = findViewById(R.id.tvAsync);
        btnAsyncCreate = findViewById(R.id.btnThreadsCreate);
        btnAsyncStart = findViewById(R.id.btnThreadsStart);
        btnAsyncCancel = findViewById(R.id.btnThreadsCancel);

        Toast.makeText(this, "Create!", Toast.LENGTH_SHORT).show();

        btnAsyncCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doThreadsCreate();
            }
        });

        btnAsyncStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doThreadsStart();
            }
        });

        btnAsyncCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doThreadsCancel();
            }
        });
    }



//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.btnThreadsCreate:
//                Toast.makeText(this, "Create!", Toast.LENGTH_SHORT).show();
//                doThreadsCreate();
//                break;
//
//            case R.id.btnThreadsStart:
//                doThreadsStart();
//                break;
//
//            case R.id.btnThreadsCancel:
//                doThreadsCancel();
//                break;
//        }
//    }

    private void doThreadsCreate() {
        Toast.makeText(this, "Create!", Toast.LENGTH_SHORT).show();
        mySimpleAsyncTask = new CounterThread(this);
    }

    private void doThreadsStart() {
        if(mySimpleAsyncTask == null || mySimpleAsyncTask.isCanceled()){
            Toast.makeText(this, "First create!", Toast.LENGTH_SHORT).show();
        } else {
            mySimpleAsyncTask.execute();
        }
    }

    private void doThreadsCancel() {
            mySimpleAsyncTask.cancel();
    }

    @Override
    public void onPreExecute() {
        Toast.makeText(this, "onPreExecute", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPostExecute() {
        Toast.makeText(this, "onPostExecute", Toast.LENGTH_SHORT).show();
        tvAsync.setText("Done!");
    }

    @Override
    public void onProgressUpdate(Integer integer) {
        tvAsync.setText(String.valueOf(integer));
    }

    @Override
    public void onCancel() {
        Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        if (mySimpleAsyncTask != null) {
            mySimpleAsyncTask.cancel();
            mySimpleAsyncTask = null;
        }
        super.onDestroy();
    }
}
