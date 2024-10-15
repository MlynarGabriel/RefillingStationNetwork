package org.example;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    int id;
    List<ChargeSession> chargeSessions;

    public Invoice(int id) {
        this.id = id;
        this.chargeSessions = new ArrayList<>();
    }

    public void addChargeSession(ChargeSession session) {
        chargeSessions.add(session);
    }

    public List<ChargeSession> getChargeSessions() {
        return chargeSessions;
    }

    public int getId() {
        return id;
    }
}