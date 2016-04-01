
package Server;

import Functions.IDisconnectFunction;
import Functions.IReceiveDataFunction;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Player {
    private final Object lockObject = new Object();
    private int id;
    private Socket socket;
    private ReceiveData receiveData;
    private PrintWriter out;

    public Player(Socket socket) {
        this.socket = socket;
        receiveData = new ReceiveData(this.socket);
    }

    public void setReceiveFunction(IReceiveDataFunction func) {
        receiveData.setRecieveDataFunction(func);
    }

    public void setDisconnectFunction(IDisconnectFunction func) {
        receiveData.setDisconnectFunction(func);
    }

    public void Start() {
        this.receiveData.start();
    }

    public void Stop() {
        this.receiveData.stopReceive();
    }

    public void sendData(String data) {
        synchronized (this.lockObject) {
            try {
                if (this.out == null) {
                    this.out = new PrintWriter(this.socket.getOutputStream(), true);
                }
                this.out.println(data);
                ServerOutput.println("[" + this.id + "] " + "Send: " + data);
            } catch (IOException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
