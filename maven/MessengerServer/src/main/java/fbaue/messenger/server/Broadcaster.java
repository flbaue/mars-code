/*
 * Florian Bauer
 * flbaue@posteo.de
 * Copyright (c) 2014.
 */

package fbaue.messenger.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.BlockingDeque;

/**
 * Created by Florian Bauer on 24.04.14. flbaue@posteo.de
 */
public class Broadcaster implements Runnable {

    private BlockingDeque<Message> messageQueue;
    private Set<Client> clients;

    public Broadcaster(BlockingDeque<Message> messageQueue, Set<Client> clients) {
        this.messageQueue = messageQueue;
        this.clients = clients;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Message message;
            try {
                message = messageQueue.takeFirst();

                for (Client client : clients) {
                    Socket clientSocket = null;
                    try {
                        clientSocket = new Socket(client.getHost(), client.getPort());
                        ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                        out.writeObject(message);
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        MessengerUtil.closeSocketSafely(clientSocket);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
