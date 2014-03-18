/*
 * Florian Bauer
 * flbaue@posteo.de
 * Copyright (c) 2014.
 */

package flbaue.products;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian Bauer on 15.03.14. flbaue@posteo.de
 */
public class Lotto6Aus49Ticket implements Ticket {
    private List<TicketComponent> components;

    public Lotto6Aus49Ticket(List<TicketComponent> components) {
        this.components = new ArrayList<>(components);
    }


}
