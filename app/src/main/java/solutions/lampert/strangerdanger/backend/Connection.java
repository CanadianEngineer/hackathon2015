package solutions.lampert.strangerdanger.backend;

import android.bluetooth.*;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

/**
 * Created by andrew on 11/28/15.
 */
public class Connection{
    private AppCompatActivity m_activity;
    private final static Intent REQUEST_ENABLE_BT = new Intent();
    private ArrayList<String> m_devices;

    private BluetoothAdapter m_btAdapter;

    public Connection(AppCompatActivity activity){
        m_activity = activity;
        setupBTAdapter();
    }

    void updateDeviceList(){
        // Send query to server to get a list of devices
    }

    public void setupBTAdapter(){
        // Getting bluetooth adapter
        m_btAdapter = BluetoothAdapter.getDefaultAdapter();
        if (m_btAdapter == null) {
            // Device does not support Bluetooth
        }

        //TODO: Check to see if BT is enabled

        if (!m_btAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//            startActivityForResult(m_activity, REQUEST_ENABLE_BT);
        }
    }

    public void getBTAddresses(ListView lv_opponents){

        final ArrayList<String> addresses = new ArrayList<String>();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(m_activity, android.R.layout.simple_list_item_1, addresses);

        lv_opponents.setAdapter(arrayAdapter);

        BroadcastReceiver mReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                    BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                    arrayAdapter.add(device.getAddress());

                    Log.d("conn", "Found new device: " + device.getAddress());

                    arrayAdapter.notifyDataSetChanged();
                }
            }
        };
        // Register the BroadcastReceiver
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        if(m_activity != null){
            m_activity.registerReceiver(mReceiver, filter); // Don't forget to unregister during onDestroy
        }

        m_btAdapter.startDiscovery();

    }
}
