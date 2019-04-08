package by.androidacademyminsk.les_04_Base_Multitreading.loader;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public abstract class BaseAsyncTaskLoader<D> extends AsyncTaskLoader<D> {

    private D data;
    private boolean isLoaded;

    public BaseAsyncTaskLoader(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        if (isLoaded){
            deliverResult(data);
        } else {
            forceLoad();
        }
    }

    @Override
    public void deliverResult(@Nullable D data) {
        this.data = data;
        isLoaded = true;

        super.deliverResult(data);
    }

    @Override
    protected void onReset() {
        data = null;
        isLoaded = false;

        super.onReset();
    }
}
