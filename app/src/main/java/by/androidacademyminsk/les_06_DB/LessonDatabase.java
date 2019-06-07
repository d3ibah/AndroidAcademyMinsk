package by.androidacademyminsk.les_06_DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {NoteEntity.class}, version = 1)
public abstract class LessonDatabase extends RoomDatabase {

    private static volatile LessonDatabase singleton;
    private static final String DATABASE_NAME = "NotesDB.db";

    public abstract NotesDao notesDao();

    public static LessonDatabase getInstanceDB(Context context){
        if (singleton == null) {
            synchronized (LessonDatabase.class){
                if (singleton == null) {
                    singleton = Room.databaseBuilder(context.getApplicationContext(),
                                                     LessonDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
                }
            }
        }
        return  singleton;
    }
}
