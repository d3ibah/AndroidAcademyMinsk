package by.androidacademyminsk.les_06_DB;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addNote (NoteEntity note);

    @Query("SELECT * FROM notes")
    List<NoteEntity> getListNotes();
}
