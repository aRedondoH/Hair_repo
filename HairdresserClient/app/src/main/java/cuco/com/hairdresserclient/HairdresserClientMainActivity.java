package cuco.com.hairdresserclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HairdresserClientMainActivity extends AppCompatActivity {

    public Button signItBtn;
    public Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hairdresser_client_main);
        // Assign button to the respective variables
        signItBtn = (Button)findViewById(R.id.signInButton);
        registerBtn = (Button)findViewById(R.id.registerButton);

        signItBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(),SignIn.class);
                startActivity(i1);
                finish();
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),Register.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hairdresser_client_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
