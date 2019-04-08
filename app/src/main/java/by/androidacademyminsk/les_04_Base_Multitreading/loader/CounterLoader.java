package by.androidacademyminsk.les_04_Base_Multitreading.loader;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CounterLoader extends BaseAsyncTaskLoader<Integer>{

    public CounterLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public Integer loadInBackground() {
        int end = 10;

        for (int i = 0; i <= end; i++) {
            if (isAbandoned()) {
                return i;
            }
            SystemClock.sleep(500);
            Log.e("counter", "" + i);
        }
        return end;
    }
}
