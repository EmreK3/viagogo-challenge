package data;

import java.util.Random;

import model.Coordinates;
import model.Event;
import model.Ticket;
import model.World;

public class DataGenerator {
	private World world;
	private Random rand = new Random();
	
	private final double max = 150.00;
	private final double min = 20.00;
	private final double diff = max-min;
	
	public DataGenerator(World world) {
		this.world = world;
		generate();
	}
	
	public void generate() {
		int amountOfEvents = rand.nextInt(100);
		
		for(int i = 0; i < amountOfEvents; i++) {
			Coordinates c = createCoordinates();
			if(!world.getMap().containsKey(c)) {
				world.getMap().put(c, createEvent());
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
