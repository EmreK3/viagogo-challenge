package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class World {
	
	Random rand = new Random();
	
	private final double maxP = 100.00;
	private final double minP = 50.00;
	private double boundP = (maxP-minP)+minP;
	
	// Map that links a a set of coordinates to an Event
	private Map<Coordinates, Event> map = new HashMap<Coordinates, Event>();
	
	public World() {
		dataGenerator();
	}
	
	public void scanLocation(Coordinates c) {
		
		
	}
	
	public void dataGenerator() {
		int amountOfEvents = rand.nextInt(100);
		
		for(int i = 0; i < amountOfEvents; i++) {
			Coordinates c = createCoordinates();
			if(!map.containsKey(c)) {
				map.put(c, createEvent());
			}
		}
	}
	
	public Coordinates createCoordinates() {
		return new Coordinates(-10 + rand.nextInt(21), -10 + rand.nextInt(21));
	}
	
	public Event createEvent() {
		Event e = new Event();
		int amountOfTickets = rand.nextInt(50);
		
		for(int i = 0; i < amountOfTickets; i++) {
			Ticket t = new Ticket(e.getEventID(), boundP*rand.nextDouble());
			e.addTicket(t);
		}
		
		return e;
	}
}
