package me.cafecode.android.workshop2;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button debugLogButton = (Button) findViewById(R.id.button_log);
        debugLogButton.setOnClickListener(this);
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
            case R.id.button_log:
                logConsole();
                break;
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

    public void logConsole() {
        // TODO: 01 - Log console here
        Log.i(TAG, "Send an INFO log message.");
        Log.v(TAG, "Send a VERBOSE log message.");
        Log.w(TAG, "Send a WARN log message.");
        Log.wtf(TAG, "What a Terrible Failure: Report a condition that should never happen.");
        Log.e(TAG, "Send an ERROR log message.");
        Log.d(TAG, "Send a DEBUG log message.");
    }


    public void simpleToastAlert() {
        // TODO: 02 - Simple Toast here
        Toast.makeText(this, "Simple Toast", Toast.LENGTH_SHORT).show();
    }

    public void alignToastAlert() {
        // TODO: 03 - Align Toast here
        Toast toast = Toast.makeText(this, "Position Toast", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.START, 0, 0);
        toast.show();

    }

    public void customToastAlert() {
        // TODO: 04 - Custom Toast here
        View customToast = LayoutInflater.from(this).inflate(R.layout.custom_toast, null);
        Toast toast = Toast.makeText(this, "Position Toast", Toast.LENGTH_SHORT);
        toast.setView(customToast);
        toast.show();
    }

    public void simpleAlertDialog() {
        // TODO: 05 - Simple AlertDialog here
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Simple AlertDialog");
        dialog.setMessage("Hello world");
        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
//        dialog.setNeutralButton("No thanks", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
        dialog.show();
    }

    public void progressDialog() {
        // TODO: 06 - Progress Dialog here
        final ProgressDialog progressDialog = ProgressDialog.show(this, "Title", "Loading...", true, true);
        progressDialog.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        }, 5000);
    }

    public void listDialog() {
        // TODO: 07 - List dialog
        final String[] colors = {"Red", "Green", "Yellow"};

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("List dialog");
        dialog.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, colors[which], Toast.LENGTH_SHORT).show();
            }
        });
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
        dialog.setSingleChoiceItems(choices, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, choices[which], Toast.LENGTH_SHORT).show();
            }
        });
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

        dialog.setMultiChoiceItems(choices, checked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(MainActivity.this, choices[which], Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    public void customDialog() {
        // TODO: 10 - Custom Dialog here
        View customView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null);
        final EditText nameInput = (EditText) customView.findViewById(R.id.input_message);

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Custom Dialog");
        dialog.setView(customView);
        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String message = nameInput.getText().toString();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

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
        Calendar calender = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Toast.makeText(MainActivity.this, dayOfMonth+"/"+monthOfYear+"/"+year, Toast.LENGTH_SHORT).show();

            }
        }, calender.get(Calendar.YEAR), calender.get(Calendar.MONTH), calender.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.setTitle("Date Picker");

        datePickerDialog.show();
    }

}
