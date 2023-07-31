package com.example.gbv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

class animateText extends Thread
{
    private  TextView tx;
    private String[] msg;
    animateText(TextView tx, String[] msg)
    {
        this.tx = tx;
        this.msg = msg;
    }
    @Override
    public void run()
    {
        int s = msg.length;
        while( true )
        {
            for( int i = 0; i < s; i++)
            {
                SystemClock.sleep(1000);

                tx.setText( msg[i]);
            }

        }
    }
}


//modal class
class anime
{
    public String message;
    public String img;
}

public class MainActivity extends AppCompatActivity {
    private TextView tx;
    private String []msg = new String[5];
   private animateText t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx = (TextView) findViewById(R.id.animeText);
        addMessage();

        Spinner dropDown = findViewById(R.id.menu);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        dropDown.setAdapter(adapter);

        t = new animateText(tx, msg);
        t.start();

    }

    public void backToLogin(View view)
    {
        setContentView(R.layout.login);
    }
    public void logIn(View view)
    {
        setContentView(R.layout.activity_main);
    }

    public void signUp(View view)
    {
        setContentView(R.layout.signup);
    }


    public void backToMain(View view)
    {
        setContentView(R.layout.activity_main);
    }


    public void userProfile(View v)
    {
        setContentView(R.layout.profile);
    }

    private void addMessage()
    {
        msg[0] = "What is Gender Based Violence?";
        msg[1] =  "What are the causes of \nGender Based Violence?";
        msg[2] =  "What are the effects of \nGender Based Violence?";
        msg[3] =  "Are males also victims of \nGender Based Violence?";
        msg[4] = "How can we curb \nGender Based Violence?";
    }

    void handleMenuClick(View v)
    {
        tx.setText("What is Gender Based Violence?");
    }
}