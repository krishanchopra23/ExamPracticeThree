package edu.osucascades.exampracticethree;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MangleRudely extends AppCompatActivity {

    private Button mResetButton;
    private TextView mMangleRudelyName;
    private Button mRemangleButton;

    private String[] lastNames = new String[] {
            "Ugly",
            "Terrible",
            "Horrible",
            "????",
            "Disgusting"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangle_nicely);

        final String firstName = getIntent().getStringExtra("FirstName");
        String mangleName = firstName + ' ' + lastNames[(int)(Math.random() * lastNames.length)];

        mMangleRudelyName = (TextView) findViewById(R.id.mangle_name);
        mMangleRudelyName.setText(mangleName);

        mRemangleButton = (Button) findViewById(R.id.re_mangle_button_id);
        mRemangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newMangleName = firstName + ' ' + lastNames[(int)(Math.random() * lastNames.length)];
                mMangleRudelyName.setText(newMangleName);
            }
        });

        mResetButton = (Button) findViewById(R.id.reset_button_id);
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resetIntent = new Intent();
                setResult(Activity.RESULT_OK, resetIntent);
                finish();
            }
        });
    }
}
