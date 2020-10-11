package com.example.settingspage;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class LogOutAlert extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog .Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Log Out")
                .setMessage("Are you sure you want to log out?")
                .setPositiveButton("Sure", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(200);
                    }
                });
        return builder.create();
    }
}
