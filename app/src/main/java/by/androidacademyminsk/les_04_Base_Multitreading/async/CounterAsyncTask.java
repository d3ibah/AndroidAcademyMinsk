package by.androidacademyminsk.les_04_Base_Multitreading.async;

import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class CounterAsyncTask extends AsyncTask<Integer, Integer, Integer>{
    private IAsyncTaskEvents iAsyncTaskEvents;

    public CounterAsyncTask(IAsyncTaskEvents iAsyncTaskEvents) {
        this.iAsyncTaskEvents = iAsyncTaskEvents;
    }

    @Override
    protected Integer doInBackground(Integer... integers) {
        int start, end;
        start = integers[0];
        end = integers[1];
        Log.e("doInBackground", "start = " + start + ", end = " + end);
        try {
            for (int i = start; i <= end; i++) {
                if (isCancelled()){
                    Log.e("doInBackground", " result is" + i);
                    return i;
                }
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
        super.onPreExecute();
        if(iAsyncTaskEvents != null){
            iAsyncTaskEvents.onPreExecute();
        }
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);

        if(iAsyncTaskEvents != null){
            iAsyncTaskEvents.onPostExecute();
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.e("onProgressUpdate", values[0].toString() + "/10");
        if(iAsyncTaskEvents != null){
            iAsyncTaskEvents.onProgressUpdate(values[0]);
        }
    }

    @Override
    protected void onCancelled(Integer integer) {
        super.onCancelled(integer);
        Log.e("onCancelled", "onCancelled with integer");
        if(iAsyncTaskEvents != null){
            iAsyncTaskEvents.onCancel();
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.e("onCancelled", "onCancelled without integer");
        if(iAsyncTaskEvents != null){
            iAsyncTaskEvents.onCancel();
        }
    }
}
