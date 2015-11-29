package solutions.lampert.strangerdanger;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import solutions.lampert.strangerdanger.backend.Connection;

public class OpponentsView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opponents_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Connection c = new Connection(this);

        //Finding elements on page
        final ListView lv_opponents = (ListView) findViewById(R.id.opponents_listView);

        lv_opponents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.d("Temp", "View: " + view.getText());
                Log.d("Temp", lv_opponents.getItemAtPosition(position).toString());
            }
        });

        c.getBTAddresses(lv_opponents);

    }

}

