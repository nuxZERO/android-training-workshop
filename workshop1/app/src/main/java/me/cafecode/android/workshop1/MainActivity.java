package me.cafecode.android.workshop1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView photoImage = (ImageView) findViewById(R.id.photo_image);
        final TextView titleText = (TextView) findViewById(R.id.title_text);
        final TextView subtitleText = (TextView) findViewById(R.id.subtitle_text);
        final EditText messageInput = (EditText) findViewById(R.id.message_input);
        final Button sendMessageButton = (Button) findViewById(R.id.send_message_button);

        photoImage.setImageResource(R.drawable.place2);
        titleText.setText("Hello Nux!");
        subtitleText.setText("Do you want a coffee?");
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageInput.getText().toString();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                Log.i(TAG, message);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                if (!message.equals("")) {
                    intent.putExtra("message", message);
                }
                startActivity(intent);
            }
        });

    }
}
