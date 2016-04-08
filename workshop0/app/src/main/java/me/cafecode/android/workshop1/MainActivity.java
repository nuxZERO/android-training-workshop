package me.cafecode.android.workshop1;

import android.content.Intent;
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

    private EditText mNameInput;
    private EditText mPhoneInput;
    private TextView mResultText;
    private Button mSubmitButton;
    private Button mResetButton;
    private CheckBox mJavaCheckBox;
    private CheckBox mJavaScriptCheckBox;
    private CheckBox mPhpCheckBox;
    private RadioButton mStudentRadioButton;
    private RadioButton mDeveloperRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 01 - Connect views from layout to java objects
        mNameInput = (EditText) findViewById(R.id.name_input);
        mPhoneInput = (EditText) findViewById(R.id.phone_input);
        mResultText = (TextView) findViewById(R.id.result_text);
        mSubmitButton = (Button) findViewById(R.id.submit_button);
        mResetButton = (Button) findViewById(R.id.reset_button);
        mJavaCheckBox = (CheckBox) findViewById(R.id.java_checkbox);
        mJavaScriptCheckBox = (CheckBox) findViewById(R.id.javascript_checkbox);
        mPhpCheckBox = (CheckBox) findViewById(R.id.php_checkbox);
        mStudentRadioButton = (RadioButton) findViewById(R.id.student_radio);
        mDeveloperRadioButton = (RadioButton) findViewById(R.id.developer_radio);

        // TODO: 02 - Set on submitForm button click
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do something
                submitForm();
            }
        });

        // TODO: 03 - Set on click for other views (implement OnClickViewListener)
        mJavaCheckBox.setOnClickListener(this);
        mJavaScriptCheckBox.setOnClickListener(this);
        mPhpCheckBox.setOnClickListener(this);
        mStudentRadioButton.setOnClickListener(this);
        mDeveloperRadioButton.setOnClickListener(this);
        mResetButton.setOnClickListener(this);

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
        final String name = mNameInput.getText().toString();
        final String phone = mPhoneInput.getText().toString();

        String skill = "";
        if (mJavaCheckBox.isChecked()) {
            skill += "JAVA, ";
        }
        if (mJavaScriptCheckBox.isChecked()) {
            skill += "JavaScript, ";
        }
        if (mPhpCheckBox.isChecked()) {
            skill += "PHP";
        }

        String occupation = "";
        if (mStudentRadioButton.isChecked()) {
            occupation = "Student";
        } else if (mDeveloperRadioButton.isChecked()) {
            occupation = "Developer";
        }

        mResultText.setText(String.format("Name: %s, Phone: %s, Skill: %s, Occupation: %s", name, phone, skill, occupation));

        // TODO: 07 - Start second activity
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("phone", phone);
        intent.putExtra("age", 25);
        intent.putExtra("isStudent", false);
        startActivity(intent);

    }

    private void resetForm() {
        // TODO: 06 - reset form
        mNameInput.setText("");
        mPhoneInput.setText("");
        mJavaCheckBox.setChecked(false);
        mJavaScriptCheckBox.setChecked(false);
        mPhpCheckBox.setChecked(false);
        mStudentRadioButton.setChecked(false);
        mDeveloperRadioButton.setChecked(false);
    }

}
