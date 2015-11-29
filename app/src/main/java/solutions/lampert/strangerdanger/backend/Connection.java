package solutions.lampert.strangerdanger.backend;

import android.bluetooth.*;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

/**
 * Created by andrew on 11/28/15.
 */
public class Connection{
    private ArrayList<String> m_devices;

    private final static Intent REQUEST_ENABLE_BT = new Intent();
    private AppCompatActivity m_activity;

    public Connection(AppCompatActivity activity){
        m_activity = activity;
    }

    void updateDeviceList(){
        // Send query to server to get a list of devices
    }

    public String getDeviceList(final TextView deviceList){
        deviceList.setText("Looking for devices");
        String deviceText = "";

        // Getting bluetooth adapter
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            // Device does not support Bluetooth
        }

        // Making sure BT is enabled

        //TODO: Check to see if BT is enabled

        if (!mBluetoothAdapter.isEnabled()) {
            deviceList.setText("BT not enabled");
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//            startActivityForResult(m_activity, REQUEST_ENABLE_BT);
        }

        // Find devices in area

        // Create a BroadcastReceiver for ACTION_FOUND
        BroadcastReceiver mReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                // When discovery finds a device
                deviceList.setText("Device Found: ");
                if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                    // Get the BluetoothDevice object from the Intent
                    BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                    // Add the name and address to an array adapter to show in a ListView
//                    CharSequence oldText = deviceList.getText();
                    deviceList.setText(deviceList.getText().toString() + device.getName() + "\n" + device.getAddress());
                }
            }
        };
        // Register the BroadcastReceiver
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
//        mBluetoothAdapter.
        if(m_activity != null){
            m_activity.registerReceiver(mReceiver, filter); // Don't forget to unregister during onDestroy
        }

        mBluetoothAdapter.startDiscovery();



        return deviceText;
    }
}
