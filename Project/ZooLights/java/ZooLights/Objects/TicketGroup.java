package ZooLights.Objects;

import ZooLights.Helpers.modeOfTransport;

import java.util.ArrayList;

public class TicketGroup {

    private Party party;
    public ArrayList<Ticket> tickets = new ArrayList<>();
    public String associatedParty;

    public TicketGroup(Party party) {
        this.party = party;
        this.associatedParty = party.getPartyName();
    }

    public void compileTickets() {
        for (Guest guest : party.guestList) {
            tickets.add(new Ticket(guest,party));
        }
    }

    public void displayTicketsInGroup() {
        for (Ticket ticket : tickets) {
            System.out.println("Ticket of " + ticket.guest.getName() + " has ID = " + ticket.id);
        }
    }


}
