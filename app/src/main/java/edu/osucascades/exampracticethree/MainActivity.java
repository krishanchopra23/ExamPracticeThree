package edu.osucascades.exampracticethree;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mMangleNicelyButton;
    private Button mMangleRudelyButton;
    private EditText mFirstNameText;

    private static final int REQUEST_CODE = 0;
    private static final String KEY_INDEX = "index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstNameText = (EditText) findViewById(R.id.first_name_input);

        mMangleNicelyButton = (Button) findViewById(R.id.mangle_nicely_button_id);
        mMangleNicelyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFirstNameText.length() <= 0) {
                    Toast.makeText(MainActivity.this, R.string.warning_toast, Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, MangleNicely.class);
                    intent.putExtra("FirstName", mFirstNameText.getText().toString());
                    startActivityForResult(intent, REQUEST_CODE);
                }
            }
        });

        mMangleRudelyButton = (Button) findViewById(R.id.mangle_rudely_button_id);
        mMangleRudelyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFirstNameText.length() <= 0) {
                    Toast.makeText(MainActivity.this, R.string.warning_toast, Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, MangleRudely.class);
                    intent.putExtra("FirstName", mFirstNameText.getText().toString());
                    startActivityForResult(intent, REQUEST_CODE);
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        } else {
            if (requestCode == REQUEST_CODE) {
                if (data == null) {
                    return;
                }
            }
        }
        mFirstNameText.setText("");
    }

}
