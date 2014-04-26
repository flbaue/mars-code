/*
 * Florian Bauer
 * flbaue@posteo.de
 * Copyright (c) 2014.
 */

package fbaue.messenger.server;

import java.io.Serializable;

/**
 * Created by Florian Bauer on 24.04.14. flbaue@posteo.de
 */
public class Message implements Serializable {

    public static final long serialVersionUID = 42L;

    private MessageCommand command;
    private String text;
    private byte[] binary;
    private Client sender;
    private Client receiver;

    public Message() {
        this.command = null;
        this.text = null;
        this.binary = null;
        this.sender = null;
        this.receiver = null;
    }

    public Message(MessageCommand command, Client sender) {
        this.command = command;
        this.text = "";
        this.binary = null;
        this.sender = sender;
        this.receiver = null;
    }

    public Message(MessageCommand command, String text, Client sender) {
        this.command = command;
        this.text = text;
        this.binary = null;
        this.sender = sender;
        this.receiver = null;
    }

    public Message(MessageCommand command, byte[] binary, Client sender) {
        this.command = command;
        this.text = null;
        this.binary = binary;
        this.sender = sender;
        this.receiver = null;
    }

    public Message(MessageCommand command, String text, byte[] binary, Client sender) {
        this.command = command;
        this.text = text;
        this.binary = binary;
        this.sender = sender;
        this.receiver = null;
    }

    public MessageCommand getCommand() {
        return command;
    }

    public void setCommand(MessageCommand command) {
        this.command = command;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public byte[] getBinary() {
        return binary;
    }

    public void setBinary(byte[] binary) {
        this.binary = binary;
    }

    public Client getSender() {
        return sender;
    }

    public void setSender(Client sender) {
        this.sender = sender;
    }

    public Client getReceiver() {
        return receiver;
    }

    public void setReceiver(Client receiver) {
        this.receiver = receiver;
    }
}
