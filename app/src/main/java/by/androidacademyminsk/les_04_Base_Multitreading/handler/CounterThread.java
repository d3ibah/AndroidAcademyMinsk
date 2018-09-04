package by.androidacademyminsk.les_04_Base_Multitreading.handler;

import android.os.SystemClock;
import android.support.annotation.NonNull;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class CounterThread extends MySimpleAsyncTask<Integer> {

    @NonNull
    private final Reference<IAsyncTaskEvents> iAsyncTaskEventsReference;

    public CounterThread(@NonNull IAsyncTaskEvents iAsyncTaskEventsReference) {
        this.iAsyncTaskEventsReference = new WeakReference<>(iAsyncTaskEventsReference);
    }

    @Override
    protected void onPreExecute() {
        IAsyncTaskEvents asyncTaskEvents = iAsyncTaskEventsReference.get();
        if (asyncTaskEvents != null) {
            asyncTaskEvents.onPreExecute();
        }
    }

    @Override
    protected Integer doInBackground() {
        int end = 10;
        for (int i = 0; i <= end; i++) {
            if (isCanceled()) {
                return i;
            }
            publishProgress(i);
            SystemClock.sleep(1000);
        }
        return end;
    }

    @Override
    protected void onPostExecute() {
        IAsyncTaskEvents asyncTaskEvents = iAsyncTaskEventsReference.get();
        if(asyncTaskEvents != null){
            asyncTaskEvents.onPostExecute();
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        IAsyncTaskEvents asyncTaskEvents = iAsyncTaskEventsReference.get();
        if (asyncTaskEvents != null){
            asyncTaskEvents.onProgressUpdate(values[0]);
        }
    }
}
