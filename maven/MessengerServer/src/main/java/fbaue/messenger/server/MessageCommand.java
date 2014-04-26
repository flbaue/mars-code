/*
 * Florian Bauer
 * flbaue@posteo.de
 * Copyright (c) 2014.
 */

package fbaue.messenger.server;

/**
 * Created by Florian Bauer on 24.04.14. flbaue@posteo.de
 */
public enum MessageCommand {

    LOGIN,
    LOGOUT,
    SERVER_RESPONSE,
    FILE,
    TEXT;

    public static final long serialVersionUID = 42L;
}
