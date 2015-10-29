package cuco.com.hairdresserclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by eagle on 29/10/15.
 */
public class SignIn extends Activity{

    public Button signInBtn;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set View to register.xml
        setContentView(R.layout.signit);
        signInBtn = (Button) findViewById(R.id.signInFinalButton);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),NorwayMap.class);
                startActivity(i);
                finish();
            }
        });

    }
}
