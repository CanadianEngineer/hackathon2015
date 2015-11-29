package solutions.lampert.strangerdanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import solutions.lampert.strangerdanger.backend.Connection;

public class MainActivity extends AppCompatActivity {

    private TextView myText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Connection c = new Connection();



        TextView deviceList = (TextView)findViewById(R.id.testText);
        deviceList.setText("Text to set");
    }
}