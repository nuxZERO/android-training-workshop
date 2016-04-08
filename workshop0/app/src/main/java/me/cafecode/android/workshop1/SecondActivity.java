package me.cafecode.android.workshop1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final TextView nameText = (TextView) findViewById(R.id.name_text);
        final TextView phoneText = (TextView) findViewById(R.id.phone_text);
        final TextView ageText = (TextView) findViewById(R.id.age_text);
        final TextView studentText = (TextView) findViewById(R.id.student_text);
        final Button directionButton = (Button) findViewById(R.id.direction_intent_button);
        final Button urlIntentButton = (Button) findViewById(R.id.url_intent_button);

        // TODO: Receive intent data
        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");
        int age = getIntent().getIntExtra("age", 0);
        boolean isStudent = getIntent().getBooleanExtra("isStudent", false);

        nameText.setText(name);
        phoneText.setText(phone);
        ageText.setText(String.format("%s", age));
        studentText.setText(String.format("%s", isStudent ? "I'm student" : "I'm not student"));

        directionButton.setOnClickListener(this);
        urlIntentButton.setOnClickListener(this);
    }

    private void startDirection() {
        // TODO: Start Google map direction
        Uri gmmIntentUri = Uri.parse("google.navigation:q=16.8405744,100.2313737&mode=d");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    private void startUrlAction() {
        // TODO: Start dial action
        Uri urlIntentUri = Uri.parse("http://cafecode.me");
        Intent urlIntent = new Intent(Intent.ACTION_VIEW, urlIntentUri);
        startActivity(urlIntent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.direction_intent_button:
                startDirection();
                break;
            case R.id.url_intent_button:
                startUrlAction();
                break;
        }
    }
}
