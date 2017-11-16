package driver;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;

import data.DataGenerator;
import data.PlotWorld;
import model.Coordinates;
import model.World;

public class Driver {
	
	public static void main(String[] args) {
		Pattern p = Pattern.compile("-?([0-9]|10),-?([0-9]|10)");
		
		System.out.println("Enter your location:");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
	
		Matcher m = p.matcher(s);
		
		int x = 0;
		int y = 0;
		
		if(m.matches()) {
			String[] coords = s.split(",");
			x = Integer.parseInt(coords[0]);
			y = Integer.parseInt(coords[1]);
		} else {
			System.out.println("Error, invalid coordinates entered.");
			input.close();
			return;
		}
	    
		Coordinates loc = new Coordinates(x, y);
		World world = new World(loc);
		DataGenerator data = new DataGenerator(world);
		
		System.out.println("Number of events in this world: " + world.getMap().size());
		System.out.println("Closest Events to (" + x + "," + y + ") that have available tickets:");
		world.scanLocation(loc);
		
		PlotWorld plot = new PlotWorld(world, world.getClosest(), loc);
		plot.setSize(800, 400);
		plot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    plot.setVisible(true);
	    
		input.close();
	}
	
}
