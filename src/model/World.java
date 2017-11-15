package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class World {
	
	Random rand = new Random();
	
	private final double max = 150.00;
	private final double min = 20.00;
	private final double diff = max-min;
	
	// Map that links a a set of coordinates to an Event
	private Map<Coordinates, Event> map = new TreeMap<Coordinates, Event>();
	
	public World() {
		dataGenerator();
		System.out.println("Number of events in current world: " + map.size());
	}
	
	public void scanLocation(Coordinates c) {
		Map<Integer, Coordinates> distances = new TreeMap<Integer, Coordinates>();
		for(Map.Entry<Coordinates, Event> e : map.entrySet()) {
			int d = c.distanceTo(e.getKey());
			distances.put(d, e.getKey());
		}
		
		ArrayList<String> al = new ArrayList<String>();
		
		for(Map.Entry<Integer, Coordinates> dist : distances.entrySet()) {
			int d = dist.getKey();
			Coordinates coords = dist.getValue();
			Event event = map.get(coords);
			
			if(event.findCheapestTicket() == null) {
				System.out.println("You've run into a test where something wrong happens LMAO");
			} else {
				Ticket t = event.findCheapestTicket();
				al.add(t + " Distance " + d);
			}	
		}
		
		if(al.size() < 4) {
			for(int i = 0; i < al.size(); i++) {
				System.out.println(al.get(i));
			}
		} else {
			for(int i = 0; i < 5; i++) {
				System.out.println(al.get(i));
			}
		}
		
		
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
 
		double randomValue = min + Math.random( ) * diff;
		double tempRes = Math.floor(randomValue * 10);
		double finalRes = tempRes/10;
		
		for(int i = 0; i < amountOfTickets; i++) {
			Ticket t = new Ticket(e.getEventID(), finalRes);
			e.addTicket(t);
		}
		
		return e;
	}
}
