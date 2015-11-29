package solutions.lampert.strangerdanger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import solutions.lampert.strangerdanger.backend.Connection;

public class MainActivity extends AppCompatActivity {

    private TextView myText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Connection c = new Connection(this);



        TextView deviceList = (TextView)findViewById(R.id.testText);
//        deviceList.setText("Text to set");
        c.getDeviceList(deviceList);

        // Setting button action listeners

        final Button btn_toOpponentsView = (Button) findViewById(R.id.btn_viewOpponents);


        // Listeners
        View.OnClickListener handler_toOpponentsView = new View.OnClickListener(){
            public void onClick(View v){
                if (v == btn_toOpponentsView){
                    Intent intentMain = new Intent(MainActivity.this, OpponentsView.class);
                    MainActivity.this.startActivity(intentMain);
                    Log.i("Content ", " Main layout ");
                }
            }
        };

        btn_toOpponentsView.setOnClickListener(handler_toOpponentsView);
    }
}