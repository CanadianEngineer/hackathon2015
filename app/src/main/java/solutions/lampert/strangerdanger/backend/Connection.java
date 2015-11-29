package solutions.lampert.strangerdanger.backend;

import android.bluetooth.*;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

/**
 * Created by andrew on 11/28/15.
 */
public class Connection {
    private ArrayList<String> m_devices;

    void updateDeviceList(){
        // Send query to server to get a list of devices
    }

    String getDeviceList(){
        String deviceText = "";

        // Getting bluetooth adapter
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            // Device does not support Bluetooth
        }

        // Making sure BT is enabled

        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }



        return deviceText;
    }
}
