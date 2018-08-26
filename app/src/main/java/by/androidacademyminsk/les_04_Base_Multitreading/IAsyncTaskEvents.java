package by.androidacademyminsk.les_04_Base_Multitreading;

public interface IAsyncTaskEvents {

    void onPreExecute();
    void onPostExecute();
    void onProgressUpdate(Integer integer);
    void onCancel();
}
