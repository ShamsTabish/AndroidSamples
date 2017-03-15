package com.acadgild.session8;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

public class YesNoDialog extends DialogFragment{
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(getActivity());
        dialogBuilder.setTitle("Are you going to movie this week-end..?");
        
        dialogBuilder.setPositiveButton("I Love Movies..", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(), "We are going for a MOVIE.....", Toast.LENGTH_SHORT).show();
            }
        });
        
        dialogBuilder.setNegativeButton("I'm Busy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(), "Cant go for movie..", Toast.LENGTH_SHORT).show();
            }
        });
        return dialogBuilder.create();
    }
}
