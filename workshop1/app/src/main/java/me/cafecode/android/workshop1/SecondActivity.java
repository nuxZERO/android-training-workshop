package me.cafecode.android.workshop1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String message = null;

        if (getIntent().hasExtra("message")) {
            message = getIntent().getStringExtra("message");
            Log.i(TAG, "Receive message :" + message);
        } else {
            Log.e(TAG, "Not found message");
        }

        Toast.makeText(SecondActivity.this, message, Toast.LENGTH_SHORT).show();

        TextView messageText = (TextView) findViewById(R.id.message_text);
        messageText.setText(message);

    }
}
