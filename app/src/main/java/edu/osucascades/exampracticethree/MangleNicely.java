package edu.osucascades.exampracticethree;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MangleNicely extends AppCompatActivity {

    private Button mResetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangle_nicely);

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
