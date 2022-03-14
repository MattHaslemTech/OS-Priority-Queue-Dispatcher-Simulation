package dispatcher;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Queue {
	
	public int priority_id; 
	
	public List<Process> processList;
	
	// The actual panel section in the grid on the GUI
	private JPanel panel = new JPanel();
	
	// The whole contentpane
	private JPanel contentPane;
	
	// The frame (The whole window class)
	private DispatcherFrame frame;
	
	
	// Default Constructor
	Queue()
	{
		
	}
	
	// Constructor
	Queue( int priority, DispatcherFrame frame, JPanel contentPane)
	{
		
		priority_id = priority; 
		
		processList = new ArrayList<Process>();
		
		// Get the frame
		this.frame = frame;
		
		// Get the whole contentpane
		this.contentPane = contentPane;
		
		this.newPanel();
	}
	
	public void displayProcesses() 
	{
		int count = 0;
		
		// reset panel every time
		this.panel.removeAll();
		
		for( Process process : this.processList )
		{
			// Get the current number of processes in queue so we know what grid row to put the new item in
			int nextGridRow = count + 2;
			
			JButton button = new JButton("ID: " + process.getId() + " Priority: " + process.getPriority());
			GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
			gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
			gbc_btnNewButton_2.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnNewButton_2.gridx = 1;
			gbc_btnNewButton_2.gridy = nextGridRow;
			this.panel.add(button, gbc_btnNewButton_2);
			
			count++;
		}
		
		this.panel.revalidate();
		this.frame.repaint();
		
		
	}
	
	
	// Getters
	public List<Process> getProcessList(){return this.processList;}
	public JPanel getPanel() {return this.panel;}
	
	
	// Setters
	
	public void addProcess(Process process) {
		this.processList.add(process);
		
		// Sort process list by id		
		//Collections.sort(this.processList, new SortById());
		
		// Display Queue every time a process is added
		this.displayProcesses();
	}
	
	
	
	public void removeProcess() {
		if(this.processList.size() > 0)
			this.processList.remove(0);
		
		// Display Queue every time a process is added
		this.displayProcesses();
		
	}
	
	
	
	
	
	public void newPanel()
	{
		// Set Panel constraints
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.ipady = 20;
		gbc_panel.ipadx = 20;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = this.priority_id;
		gbc_panel.gridy = 2;
		gbc_panel.gridheight = 4;
		
		contentPane.add(this.panel, gbc_panel);
		GridBagLayout gbl_queue1_panel = new GridBagLayout();
		gbl_queue1_panel.columnWidths = new int[]{0,70,0};
		gbl_queue1_panel.rowHeights = new int[]{0};
		gbl_queue1_panel.columnWeights = new double[]{0,0,0};
		gbl_queue1_panel.rowWeights = new double[]{Double.MIN_VALUE};
		this.panel.setLayout(gbl_queue1_panel);
		this.panel.setBackground(Color.blue);
		
		//this.panel.revalidate();
	}

	
	
}



//Used by addProcess to sort by id
class SortById implements Comparator<Process> {
    // Used for sorting in ascending order of
    // roll number
    public int compare(Process a, Process b)
    {
        return a.getId() - b.getId();
    }
}
