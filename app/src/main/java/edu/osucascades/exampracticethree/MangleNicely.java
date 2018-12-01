package edu.osucascades.exampracticethree;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MangleNicely extends AppCompatActivity {

    private Button mResetButton;
    private TextView mMangleNicelyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangle_nicely);

        final String firstName = getIntent().getStringExtra("FirstName");
        String mangleName = firstName;

        mMangleNicelyName = (TextView) findViewById(R.id.mangle_name);
        mMangleNicelyName.setText(mangleName);

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
