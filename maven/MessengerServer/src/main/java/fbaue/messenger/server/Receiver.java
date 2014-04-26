/*
 * Florian Bauer
 * flbaue@posteo.de
 * Copyright (c) 2014.
 */

package fbaue.messenger.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingDeque;

/**
 * Created by Florian Bauer on 24.04.14. flbaue@posteo.de
 */
public class Receiver implements Runnable {

    private int port;
    private BlockingDeque<Message> messageQueue;

    public Receiver(BlockingDeque<Message> messageQueue, int port) {
        this.messageQueue = messageQueue;
        this.port = port;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (!Thread.currentThread().isInterrupted()) {
                Socket clientSocket = serverSocket.accept();
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                Message message = (Message) in.readObject();
                messageQueue.addLast(message);
                in.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            MessengerUtil.closeServerSocketSafely(serverSocket);
        }
    }
}
