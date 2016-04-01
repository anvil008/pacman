
package Server;


import Functions.IAcceptClientFunction;
import Functions.IDisconnectFunction;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Server class use to listen connect from client, receive data and send data
 * The program has only one server object
 */
public class ServerGame {
	private static ServerGame instance;

	public static ServerGame getInstance() {
		if (instance == null)
			instance = new ServerGame();
		return instance;
	}

	private Player player;
    private ServerSocket server;
    private Listener listener;
    private ServerGame() {

    }
    public void Start() {
        this.server = this.OpenServer();
        this.listener = new Listener(this.server);
        this.listener.setAcceptFunction(this.getAcceptFunction());
        this.listener.start();
    }

    public ServerSocket OpenServer() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
            ServerOutput.println("Open server success");
        } catch (IOException ex) {
            Logger.getLogger(ServerGame.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return serverSocket;
    }

    public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void CloseServer() {
        this.listener.Stop();
        try {
            this.server.close();
            ServerOutput.println("Closed server!");
        } catch (IOException ex) {
            ServerOutput.println("Can not close server!");
            Logger.getLogger(ServerGame.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    private IAcceptClientFunction getAcceptFunction() {
        return new IAcceptClientFunction() {
            @Override
            public void Execute(Socket client) {
            	if (ServerGame.this.player != null)
            	{
            		ServerGame.this.player.sendData("<disconnect>");
            		ServerGame.this.player.Stop();
            	}
        		ServerGame.this.player = new Player(client);
            	ServerGame.this.player.sendData("<ready>");
            	ServerGame.this.player.Start();
        		ServerGame.this.player.setDisconnectFunction(new IDisconnectFunction() {
					@Override
					public void Execute(Socket socket) {
						ServerGame.this.player = null;
					}
				});
            }
        };
    }
}
