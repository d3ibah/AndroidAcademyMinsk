package by.androidacademyminsk.les_04_Base_Multitreading.handler;

import android.os.Handler;
import android.os.Looper;

public abstract class MySimpleAsyncTask <Param> extends SimpleAsyncTask<Param>{

    private Thread backgroundThread;

    @Override
    protected void execute() {
        runOnUIThread(new Runnable() {
            @Override
            public void run() {
                onPreExecute();
                backgroundThread = new Thread("Handler_executor_thread"){
                    @Override
                    public void run() {
                        doInBackground();
                        runOnUIThread(new Runnable() {
                            @Override
                            public void run() {
                                onPostExecute();
                            }
                        });
                    }
                };
                backgroundThread.start();
            }
        });
    }

    private void runOnUIThread (Runnable runnable){
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    @Override
    public void cancel() {
        isCanceled = true;

        if (backgroundThread != null){
            backgroundThread.interrupt();
        }
    }

    @SafeVarargs
    @Override
    protected final void publishProgress(final Param... values) {
        runOnUIThread(new Runnable() {
            @Override
            public void run() {
                onProgressUpdate(values);
            }
        });
    }
}
