package by.androidacademyminsk.les_05_Retrofit;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import by.androidacademyminsk.R;

public class Lesson05_Retrofit extends AppCompatActivity {

    private Button searchAction;
    private EditText keywordSource;
    private String keyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson05_retrofit);

        searchAction = findViewById(R.id.les05_button);
        keywordSource = findViewById(R.id.les05_editText);

        searchAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInputSymbols();
                if (TextUtils.isEmpty(keyword)) {
//                    TODO: Waiting implementation
                }
            }
        });
    }

    private void getInputSymbols() {
        keyword = keywordSource.getText().toString().trim();
    }
}
