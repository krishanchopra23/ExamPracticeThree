package edu.osucascades.exampracticethree;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MangleNicely extends AppCompatActivity {

    private static final String LAST_NAME = "last_name";

    private Button mResetButton;
    private TextView mMangleNicelyName;
    private Button mRemangleButton;
    private Button mSendMangleButton;
    private String mLastName;

    private String[] lastNames = new String[] {
            "Beautiful",
            "Handsome",
            "Adorable",
            "Tall",
            "Magnificent"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangle_nicely);

        final String firstName = getIntent().getStringExtra("FirstName");
        //String mangleName = firstName + ' ' + lastNames[(int)(Math.random() * lastNames.length)];

        mMangleNicelyName = (TextView) findViewById(R.id.mangle_name);
        //mMangleNicelyName.setText(mangleName);

        if (savedInstanceState != null) {
            mLastName = savedInstanceState.getString(LAST_NAME);
            mMangleNicelyName.setText(getMangledName(firstName, mLastName));
        } else {
            mLastName = firstName + ' ' + lastNames[(int)(Math.random() * lastNames.length)];
            mMangleNicelyName.setText(getMangledName(firstName, mLastName));
        }

        mRemangleButton = (Button) findViewById(R.id.re_mangle_button_id);
        mRemangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newMangleName = firstName + ' ' + lastNames[(int)(Math.random() * lastNames.length)];
                mMangleNicelyName.setText(newMangleName);
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

        mSendMangleButton = (Button) findViewById(R.id.send_mangle_button_id);
        mSendMangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                startActivity(i);
            }
        });
    }

    private String getMangledName(String firstName, String lastName) {
        MangleName mangledName = new MangleName(firstName, lastName);
        return mangledName.getMangledName();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(LAST_NAME, mLastName);
    }

}
