package by.androidacademyminsk.les_06_DB;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import by.androidacademyminsk.R;

public class Lesson06_Activity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson06__db);

        button = findViewById(R.id.btn_add_note);
        editText = findViewById(R.id.et_note);
        textView = findViewById(R.id.textView6);

        addNote();
    }

    private void addNote() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                LessonDatabase.getInstanceDB(Lesson06_Activity.this).notesDao().addNote(new NoteEntity(s, s, s));
                textView.setText(LessonDatabase.getInstanceDB(Lesson06_Activity.this).notesDao().getListNotes().get(0).getNote());
            }
        });
    }
}
