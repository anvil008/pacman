
package Server;


import Functions.IDisconnectFunction;
import Functions.IReceiveDataFunction;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * A thread use to receive data from client
 */
public class ReceiveData extends Thread {

    private Socket socket;
    private IReceiveDataFunction funcReceiveData;
    private IDisconnectFunction funcDisconnect;
    private boolean stoped;

    public ReceiveData(Socket socket) {
        this.socket = socket;
        stoped = false;
    }

    public void setRecieveDataFunction(IReceiveDataFunction func) {
        this.funcReceiveData = func;
    }

    public void setDisconnectFunction(IDisconnectFunction func) {
        this.funcDisconnect = func;
    }

    public void stopReceive() {
        this.stoped = true;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(this.socket.getInputStream()));
            while (!this.stoped) {
                try {
                	//Wait data and read
                    String data = reader.readLine();

                    //if data is null, disconnect
                    if (data == null) {
                        this.stoped = true;
                        if (funcDisconnect != null) {
                            funcDisconnect.Execute(this.socket);
                        }
                    } else if (funcReceiveData != null) {
                        funcReceiveData.Execute(data);
                    }
                } catch (Exception ex) {
                	//if has exception to disconnect
                    if (funcDisconnect != null) {
                        funcDisconnect.Execute(this.socket);
                    }
                    this.stoped = true;
                    if (reader != null) {
                        reader.close();
                    }
                    Logger.getLogger(ReceiveData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (reader != null) {
                reader.close();
            }
        } catch (IOException ex) {
            if (funcDisconnect != null) {
                funcDisconnect.Execute(this.socket);
            }
            this.stoped = true;
            Logger.getLogger(ReceiveData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
