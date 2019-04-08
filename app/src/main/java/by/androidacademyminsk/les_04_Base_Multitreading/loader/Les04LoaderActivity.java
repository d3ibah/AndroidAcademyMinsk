package by.androidacademyminsk.les_04_Base_Multitreading.loader;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import by.androidacademyminsk.R;

public class Les04LoaderActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<Integer> {

    private Button buttonStart;
    private Button buttonCancel;
    private TextView textViewResult;
    private ProgressBar progressBar;

    private static final int LOADER_COUNTER = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson04_loader);

        buttonStart = findViewById(R.id.btnLoaderStart);
        buttonCancel = findViewById(R.id.btnLoaderCancel);
        textViewResult = findViewById(R.id.tvLoader);
        progressBar = findViewById(R.id.progress_loader);

        clickOnStatr();
        clickOnCancel();
    }

    @NonNull
    @Override
    public Loader<Integer> onCreateLoader(int id, @Nullable Bundle args) {
        if (id == LOADER_COUNTER) {
            CounterLoader counterLoader = new CounterLoader(this);
            textViewResult.setText(getString(R.string.les04_wip));
            return counterLoader;
        } else {
            throw new IllegalArgumentException(getString(R.string.les04_illegal_argument_exception));
        }
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Integer> loader, Integer data) {
        if (loader.getId() == LOADER_COUNTER) {
            Toast.makeText(this, getString(R.string.les04_message_on_post_execute), Toast.LENGTH_SHORT)
                 .show();
            textViewResult.setText(getText(R.string.les04_done));
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Integer> loader) {
        if (loader.getId() == LOADER_COUNTER) {
            textViewResult.setText("");
            progressBar.setVisibility(View.GONE);
        }
    }

    private void clickOnStatr() {
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAsyncTaskStart();
                buttonStart.setEnabled(false);
            }
        });
    }

    private void clickOnCancel() {
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAsyncTaskCancel();
                buttonStart.setEnabled(true);
            }
        });
    }

    private void doAsyncTaskStart() {
        LoaderManager.getInstance(this).initLoader(LOADER_COUNTER, null, this);
        progressBar.setVisibility(View.VISIBLE);
    }

    private void doAsyncTaskCancel() {
        LoaderManager.getInstance(this).destroyLoader(LOADER_COUNTER);
        textViewResult.setText(getString(R.string.les04_work_interrupted));
        progressBar.setVisibility(View.GONE);
    }
}
