package edu.osucascades.exampracticethree;

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
                    startActivity(intent);
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
                    startActivity(intent);
                }
            }
        });
    }

}
