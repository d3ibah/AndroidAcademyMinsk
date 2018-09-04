package by.androidacademyminsk.les_04_Base_Multitreading.handler;

public abstract class SimpleAsyncTask<Param> {

    protected volatile boolean  isCanceled = false;

    protected abstract void onPreExecute();

    protected abstract Param doInBackground();

    protected abstract void onPostExecute();

    protected abstract void execute();

    protected void onProgressUpdate(Param... values) {
    }

    protected abstract void publishProgress(Param... values);

    public abstract void cancel();

    public boolean isCanceled() {
        return isCanceled;
    }


}
