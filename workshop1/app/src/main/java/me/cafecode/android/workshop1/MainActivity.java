package me.cafecode.android.workshop1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameInput;
    private TextView resultText;
    private Button submitButton;
    private Button resetButton;
    private CheckBox javaCheckBox;
    private CheckBox javaScriptCheckBox;
    private CheckBox phpCheckBox;
    private RadioButton studentRadioButton;
    private RadioButton developerRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 01 - Connect views from layout to java objects
        nameInput = (EditText) findViewById(R.id.name_input);
        resultText = (TextView) findViewById(R.id.result_text);
        submitButton = (Button) findViewById(R.id.submit_button);
        resetButton = (Button) findViewById(R.id.reset_button);
        javaCheckBox = (CheckBox) findViewById(R.id.java_checkbox);
        javaScriptCheckBox = (CheckBox) findViewById(R.id.javascript_checkbox);
        phpCheckBox = (CheckBox) findViewById(R.id.php_checkbox);
        studentRadioButton = (RadioButton) findViewById(R.id.student_radio);
        developerRadioButton = (RadioButton) findViewById(R.id.developer_radio);

        // TODO: 02 - Set on submitForm button click
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });

        // TODO: 03 - Set on click for other views (implement OnClickViewListener)
        javaCheckBox.setOnClickListener(this);
        javaScriptCheckBox.setOnClickListener(this);
        phpCheckBox.setOnClickListener(this);
        studentRadioButton.setOnClickListener(this);
        developerRadioButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);

    }

    // TODO: 04 - Implement OnClickListener
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reset_button:
                resetForm();
                break;
            case R.id.java_checkbox:
                CheckBox javaCheckBox = (CheckBox) v;
                if (javaCheckBox.isChecked()) {
                    Toast.makeText(this, "Java checked!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Java unchecked!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.javascript_checkbox:
                CheckBox javaScriptCheckBox = (CheckBox) v;
                if (javaScriptCheckBox.isChecked()) {
                    Toast.makeText(this, "JavaScript checked!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "JavaScript unchecked!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.php_checkbox:
                CheckBox phpCheckBox = (CheckBox) v;
                if (phpCheckBox.isChecked()) {
                    Toast.makeText(this, "PHP checked!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "PHP unchecked!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.student_radio:
                RadioButton studentRadioButton = (RadioButton) v;
                if (studentRadioButton.isChecked()) {
                    Toast.makeText(this, "Student checked!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Student unchecked!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.developer_radio:
                RadioButton developerRadioButton = (RadioButton) v;
                if (developerRadioButton.isChecked()) {
                    Toast.makeText(this, "Developer checked!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Developer unchecked!", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    private void submitForm() {
        // TODO: 05 - Submit form
        String name = nameInput.getText().toString();

        String skill = "";
        if (javaCheckBox.isChecked()) {
            skill += "JAVA, ";
        }
        if (javaScriptCheckBox.isChecked()) {
            skill += "JavaScript, ";
        }
        if (phpCheckBox.isChecked()) {
            skill += "PHP";
        }

        String occupation = "";
        if (studentRadioButton.isChecked()) {
            occupation = "Student";
        } else if (developerRadioButton.isChecked()) {
            occupation = "Developer";
        }

        resultText.setText(String.format("Name: %s, Skill: %s, Occupation: %s", name, skill, occupation));
    }

    private void resetForm() {
        // TODO: 06 - reset form
        nameInput.setText("");
        javaCheckBox.setChecked(false);
        javaScriptCheckBox.setChecked(false);
        phpCheckBox.setChecked(false);
        studentRadioButton.setChecked(false);
        developerRadioButton.setChecked(false);
    }

}
