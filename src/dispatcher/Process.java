package dispatcher;
import java.util.Random;
import java.util.*;

public class Process {
	
	private int priority;
	
	private int id; 
	
	Process(int id)
	{
		// Set the id that God gave us
		this.id = id;
		
		// Init the random object
		Random r_obj = new Random();
		
		// Generate a random priority from 1-4
		priority = r_obj.nextInt(4) + 1;
	}
	
	
	// Getters
	public int getPriority() {return this.priority;}
	public int getId() {return this.id;}
	
	// Setters
	public void setId(int id) {this.id = id;}
	public void setPriority(int priority) {this.priority = priority;}
	
	
	
}
