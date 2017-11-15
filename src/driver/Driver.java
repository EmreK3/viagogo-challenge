package driver;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Coordinates;
import model.World;

public class Driver {
	
	public static void main(String[] args) {
		Pattern p = Pattern.compile("-?([0-9]|10),-?([0-9]|10)");
		World world = new World();
		
		System.out.println("Enter your location:");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
	
		Matcher m = p.matcher(s);
		
		if(m.matches()) {
			String[] coords = s.split(",");
			int x = Integer.parseInt(coords[0]);
			int y = Integer.parseInt(coords[1]);
			System.out.println("Closest Events to (" + x + "," + y + "):");
			world.scanLocation(new Coordinates(x, y));
		} else {
			System.out.println("Error, invalid coordinates entered.");
		}
		
		input.close();
	}
	
}
