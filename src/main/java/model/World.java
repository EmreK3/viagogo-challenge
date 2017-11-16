package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class World {

	// Map that links a a set of coordinates to an Event
	private Map<Coordinates, Event> map = new TreeMap<Coordinates, Event>();
	private ArrayList<Coordinates> closest;

	public World(Coordinates c) {
		scanLocation(c);
	}

	public void scanLocation(Coordinates c) {
		Map<Integer, List<Coordinates>> distances = new TreeMap<Integer, List<Coordinates>>();
		for(Map.Entry<Coordinates, Event> e : map.entrySet()) {
			int d = c.distanceTo(e.getKey());

			List<Coordinates> list = distances.get(d);
			if(list == null)
			{
				ArrayList<Coordinates> newList = new ArrayList<Coordinates>();
				newList.add(e.getKey());
				distances.put(d, newList);
			}else
			{
				list.add(e.getKey());
				distances.put(d, list);

			}

		}

		closest = new ArrayList<Coordinates>();
		ArrayList<String> al = new ArrayList<String>();

		for(Map.Entry<Integer, List<Coordinates>> dist : distances.entrySet()) {
			int d = dist.getKey();

			if(dist.getValue().size() > 1) {
				for(int i = 0; i < dist.getValue().size(); i++) {
					Coordinates coords = dist.getValue().get(i);
					closest.add(coords);
					Event event = map.get(coords);
					if(!(event.findCheapestTicket() == null)) {
						Ticket t = event.findCheapestTicket();
						al.add(t + " Distance " + d);
					}
				} 
			} else {
				Coordinates coords = dist.getValue().get(0);
				closest.add(coords);
				Event event = map.get(coords);

				if(!(event.findCheapestTicket() == null)) {
					Ticket t = event.findCheapestTicket();
					al.add(t + " Distance " + d);
				}	
			}
		}

		if(al.size() <= 4) {
			for(int i = 0; i < al.size(); i++) {
				System.out.println(al.get(i));
			}
		} else {
			for(int i = 0; i < 5; i++) {
				System.out.println(al.get(i));
			}
		}

	}

	public Map<Coordinates, Event> getMap() {
		return map;
	}

	public ArrayList<Coordinates> getClosest() {
		return closest;
	}
}
