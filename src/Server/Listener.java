
package Server;


import Functions.IAcceptClientFunction;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Listen connect from client
 */
public class Listener extends Thread{
    private ServerSocket server;
    private boolean stoped;
    private IAcceptClientFunction acceptFunction;

    public Listener(ServerSocket server) {
        this.server = server;
        this.stoped = false;
    }

    public void setAcceptFunction(IAcceptClientFunction func) {
        this.acceptFunction = func;
    }

    public void Stop() {
        this.stoped = true;
    }

    @Override
    public void run() {
        ServerOutput.println("Start listener...");
        while (!this.stoped) {
            try {
                Socket client = this.server.accept();
                ServerOutput.println("Connect success: " +
                        client.getInetAddress().getHostAddress());
                if (this.acceptFunction != null) {
                    this.acceptFunction.Execute(client);
                }
            } catch (IOException ex) {
                ServerOutput.println("Connect fail!");
                Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
