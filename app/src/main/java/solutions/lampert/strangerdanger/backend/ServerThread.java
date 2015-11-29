package solutions.lampert.strangerdanger.backend;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.UUID;

/**
 * Created by andrew on 11/29/15.
 */
public class ServerThread extends Thread {
    private final BluetoothServerSocket mmServerSocket;
    private BluetoothAdapter mBluetoothAdapter;

    public ServerThread() {
        // Use a temporary object that is later assigned to mmServerSocket,
        // because mmServerSocket is final
        BluetoothServerSocket tmp = null;
        try {
            // MY_UUID is the app's UUID string, also used by the client code
            UUID u = new UUID(128, 0);
            tmp = mBluetoothAdapter.listenUsingRfcommWithServiceRecord("connection_tmp", u.randomUUID());
        } catch (IOException e) { }
        mmServerSocket = tmp;
    }

    public void run() {
        BluetoothSocket socket = null;
        // Keep listening until exception occurs or a socket is returned
        while (true) {
            // If a connection was accepted
            try {
                socket = mmServerSocket.accept();

                if (socket != null) {
                    // Do work to manage the connection (in a separate thread)
    //                manageConnectedSocket(socket);
                    mmServerSocket.close();
                    break;
                }

            } catch (IOException e) {
                break;
            }
        }
    }

    /** Will cancel the listening socket, and cause the thread to finish */
    public void cancel() {
        try {
            mmServerSocket.close();
        } catch (IOException e) { }
    }
}
