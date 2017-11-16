package data;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import model.Coordinates;
import model.Event;
import model.World;

@SuppressWarnings("serial")
public class PlotWorld extends JFrame {

	private World world;
	private Coordinates loc;
	private ArrayList<Coordinates> closest;

	public PlotWorld(World world, ArrayList<Coordinates> closest, Coordinates loc) {
		this.world = world;
		this.loc = loc;
		this.closest = closest;

		XYDataset dataset = createDataset();

		// Create chart
		JFreeChart chart = ChartFactory.createScatterPlot(
				"Event Locations", 
				"X-Axis", "Y-Axis", dataset);


		//Changes background colour
		XYPlot plot = (XYPlot)chart.getPlot();
		plot.setBackgroundPaint(new Color(255,228,196));


		// Create Panel
		ChartPanel panel = new ChartPanel(chart);
		setContentPane(panel);
	}

	private XYDataset createDataset() {
		XYSeriesCollection dataset = new XYSeriesCollection();


		XYSeries currentLoc = new XYSeries("Current Location");
		currentLoc.add(loc.getX(), loc.getY());

		ArrayList<Coordinates> al = new ArrayList<Coordinates>();

		for(Map.Entry<Coordinates, Event> e : world.getMap().entrySet()) {
			al.add(e.getKey());
		}

		//	    System.out.println(al);
		//	    System.out.println(closest);


		XYSeries events = new XYSeries("Events");
		for(int i = 0; i < al.size(); i++) {
			events.add(al.get(i).getX(), al.get(i).getY());
		}

		XYSeries topFive = new XYSeries("Closest");
		if(closest.size() > 5) {
			for(int i = 0; i < 5; i++) {
				topFive.add(closest.get(i).getX(), closest.get(i).getY());
			}
		} else {
			for(int i = 0; i < closest.size(); i++) {
				topFive.add(closest.get(i).getX(), closest.get(i).getY());
			}
		}


		dataset.addSeries(currentLoc);
		dataset.addSeries(topFive);
		dataset.addSeries(events);


		return dataset;
	}

}