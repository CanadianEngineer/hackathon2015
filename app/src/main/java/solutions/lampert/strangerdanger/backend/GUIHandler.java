package solutions.lampert.strangerdanger.backend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import solutions.lampert.strangerdanger.OpponentsView;

/**
 * Created by andrew on 11/29/15.
 */
public class GUIHandler {

    public View.OnClickListener changeViewHandler(final Button btn, final AppCompatActivity act1, final AppCompatActivity act2){
        View.OnClickListener handler = new View.OnClickListener(){
            public void onClick(View v){
                if (v == btn){
//                    Intent intentMain = new Intent(MainActivity.this, OpponentsView.class);
//                    MainActivity.this.startActivity(intentMain);
//                    Log.i("Content ", " Main layout ");
                }
            }
        };

        return handler;
    }
}
