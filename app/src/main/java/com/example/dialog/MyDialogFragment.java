package com.example.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.Locale;

public class MyDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final  String[] catNamesArray = {"Весемир", "Рубероид", "Мемензис"};
        final boolean[] checkedItemsArray = {false, true, false};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Выберите кота")
                .setMultiChoiceItems(catNamesArray, checkedItemsArray,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which, boolean isChecked) {
                                checkedItemsArray[which] = isChecked;
                            }
                        })
                .setPositiveButton("Готово",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                StringBuilder state = new StringBuilder();
                                for (int i = 0; i < catNamesArray.length; i++) {
                                    state.append(catNamesArray[i]);
                                    if (checkedItemsArray[i])
                                        state.append(" выбран\n");
                                    else
                                        state.append(" не выбран\n ");
                                }
                        Toast.makeText(getActivity(),
                                state.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
        return  builder.create();
    }

}
