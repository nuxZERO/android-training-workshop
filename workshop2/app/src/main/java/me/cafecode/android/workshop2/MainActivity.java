package me.cafecode.android.workshop2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button simpleToastButton = (Button) findViewById(R.id.button_simple_toast);
        simpleToastButton.setOnClickListener(this);
        final Button alignToastButton = (Button) findViewById(R.id.button_position_toast);
        alignToastButton.setOnClickListener(this);
        final Button customToastButton = (Button) findViewById(R.id.button_custom_toast);
        customToastButton.setOnClickListener(this);
        final Button simpleDialogButton = (Button) findViewById(R.id.button_simple_dialog);
        simpleDialogButton.setOnClickListener(this);
        final Button progressDialogButton = (Button) findViewById(R.id.button_progress_dialog);
        progressDialogButton.setOnClickListener(this);
        final Button listDialogButton = (Button) findViewById(R.id.button_list_dialog);
        listDialogButton.setOnClickListener(this);
        final Button singleChoiceListIDialogButton = (Button) findViewById(R.id.button_single_choice_list_dialog);
        singleChoiceListIDialogButton.setOnClickListener(this);
        final Button multipleChoiceListDialogButton = (Button) findViewById(R.id.button_multiple_choice_list_dialog);
        multipleChoiceListDialogButton.setOnClickListener(this);
        final Button customDialogButton = (Button) findViewById(R.id.button_custom_layout_dialog);
        customDialogButton.setOnClickListener(this);
        final Button datePickerDialogButton = (Button) findViewById(R.id.button_date_picker_dialog);
        datePickerDialogButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_simple_toast:
                simpleToastAlert();
                break;
            case R.id.button_position_toast:
                alignToastAlert();
                break;
            case R.id.button_custom_toast:
                customToastAlert();
                break;
            case R.id.button_simple_dialog:
                simpleAlertDialog();
                break;
            case R.id.button_progress_dialog:
                progressDialog();
                break;
            case R.id.button_list_dialog:
                listDialog();
                break;
            case R.id.button_single_choice_list_dialog:
                singleChoiceListDialog();
                break;
            case R.id.button_multiple_choice_list_dialog:
                multipleChoiceListDialog();
                break;
            case R.id.button_custom_layout_dialog:
                customDialog();
                break;
            case R.id.button_date_picker_dialog:
                datePickerDialog();
                break;
            default:
                break;
        }
    }

    public void simpleToastAlert() {
        // TODO: 02 - Simple Toast here

    }

    public void alignToastAlert() {
        // TODO: 03 - Align Toast here

    }

    public void customToastAlert() {
        // TODO: 04 - Custom Toast here

    }

    public void simpleAlertDialog() {
        // TODO: 05 - Simple AlertDialog here

    }

    public void progressDialog() {
        // TODO: 06 - Progress Dialog here


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Dismiss dialog

            }
        }, 5000);
    }

    public void listDialog() {
        // TODO: 07 - List dialog

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("List dialog");

        // Do here

        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    public void singleChoiceListDialog() {
        // TODO: 08 - Single choice list dialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Single Choice");

        final String[] choices = {"Choice 1", "Choice 2", "Choice 3"};
        // Do here

        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    public void multipleChoiceListDialog() {
        // TODO: 09 - Multiple choice list dialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Multiple choice Choice");

        final String[] choices = { "Choice 1", "Choice 2", "Choice 3" };
        final boolean[] checked = { false, false, false };

        // Do here

        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    public void customDialog() {
        // TODO: 10 - Custom Dialog here
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Custom Dialog");

        // Do here

        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Get input here

            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    public void datePickerDialog() {
        // TODO: 11 - Date Picker Dialog here

    }

}
