package by.androidacademyminsk.les_05_Retrofit;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import by.androidacademyminsk.R;

public class CredentialsDialog extends DialogFragment {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private ICredentialsDialogListener listener;

    public interface ICredentialsDialogListener {
        void onDialogPositiveClick(String username, String password);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof ICredentialsDialogListener) {
            listener = (ICredentialsDialogListener) getActivity();
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.activity_lesson05_dialog, null);
        usernameEditText = view.findViewById(R.id.username_edittext);
        passwordEditText = view.findViewById(R.id.password_edittext);

        usernameEditText.setText(getArguments().getString("username"));
        passwordEditText.setText(getArguments().getString("password"));
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("Credentials")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (listener != null) {
                            listener.onDialogPositiveClick(usernameEditText.getText().toString(), passwordEditText.getText().toString());
                        }
                    }
                });
        return builder.create();
    }
}