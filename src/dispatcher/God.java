package dispatcher;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

public class God {
	
	private List<Queue> queuesList = new ArrayList<Queue>();
	
	private int totalProcessCount = 0;
	
	// This was originally in the dispatcher
	private JPanel contentPane = new JPanel();
	
	// This was originally in the dispatcher
	public DispatcherFrame frame;
	
	// The Ready process
	private JPanel readyPanel = new JPanel();
	private Process readyProcess = null;
	
	// The run process
	private JPanel runPanel = new JPanel();
	private Process runProcess = null;
	
	// The Blocked List
	private JPanel blockedListPanel = new JPanel();
	private List<Process> blockedList;
	
	God()
	{
		frame = new DispatcherFrame(this.contentPane, this);
			
		// Set Blocked List
		blockedList = new ArrayList<Process>();
		
		
		/*
		 * Set Queues
		 */
		// Create 4 queues
		for(int i = 0; i < 4; i++ ) 
		{
			Queue tempQueue = new Queue(i + 1, this.frame, this.contentPane);
			queuesList.add(tempQueue);
		}
		
		// Generate 8 initial processes 
		for( int i = 0; i < 8; i++ )
		{	
			// Add process
			this.addProcess();	
		}
		
		
		/*
		 * Set ready panel
		 */
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.ipady = 20;
		gbc_panel.ipadx = 20;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 6;
		gbc_panel.gridy = 2;
		gbc_panel.gridheight = 1;
		
		contentPane.add(this.readyPanel, gbc_panel);
		GridBagLayout gbl_ready_panel = new GridBagLayout();
		gbl_ready_panel.columnWidths = new int[]{0,70,0};
		gbl_ready_panel.rowHeights = new int[]{0};
		gbl_ready_panel.columnWeights = new double[]{0,0,0};
		gbl_ready_panel.rowWeights = new double[]{Double.MIN_VALUE};
		this.readyPanel.setLayout(gbl_ready_panel);
		this.readyPanel.setBackground(Color.cyan);
		
		
		/*
		 * Set run panel
		 */
		GridBagConstraints gbc_panel1 = new GridBagConstraints();
		gbc_panel1.ipady = 20;
		gbc_panel1.ipadx = 20;
		gbc_panel1.insets = new Insets(0, 0, 5, 5);
		gbc_panel1.fill = GridBagConstraints.BOTH;
		gbc_panel1.gridx = 8;
		gbc_panel1.gridy = 2;
		gbc_panel1.gridheight = 1;
		
		contentPane.add(this.runPanel, gbc_panel1);
		GridBagLayout gbl_run_panel = new GridBagLayout();
		gbl_run_panel.columnWidths = new int[]{0,70,0};
		gbl_run_panel.rowHeights = new int[]{0};
		gbl_run_panel.columnWeights = new double[]{0,0,0};
		gbl_run_panel.rowWeights = new double[]{Double.MIN_VALUE};
		this.runPanel.setLayout(gbl_run_panel);
		this.runPanel.setBackground(Color.magenta);
		
		
		/*
		 * Set up Blocked List panel
		 */
		GridBagConstraints gbc_panel2 = new GridBagConstraints();
		gbc_panel2.ipady = 20;
		gbc_panel2.ipadx = 20;
		gbc_panel2.insets = new Insets(0, 0, 5, 5);
		gbc_panel2.fill = GridBagConstraints.BOTH;
		gbc_panel2.gridx = 6;
		gbc_panel2.gridy = 5;
		gbc_panel2.gridheight = 1;
		gbc_panel2.gridwidth = 3;
		
		contentPane.add(this.blockedListPanel, gbc_panel2);
		GridBagLayout gbl_blocked_panel = new GridBagLayout();
		gbl_blocked_panel.columnWidths = new int[]{0,70,0};
		gbl_blocked_panel.rowHeights = new int[]{0};
		gbl_blocked_panel.columnWeights = new double[]{0,0,0};
		gbl_blocked_panel.rowWeights = new double[]{Double.MIN_VALUE};
		this.blockedListPanel.setLayout(gbl_blocked_panel);
		this.blockedListPanel.setBackground(Color.gray);
		
		
		// Set up ready initially
		moveToReady();
		

				
	}
		
	
	/*
	 * Display for Testing
	 */
	public void display() 
	{
		for(int i = 0; i < 4; i++)
		{
			System.out.println("[" + (i+1) + "]");
			Queue tempQueue = this.queuesList.get(i);
			
			// Get queue's process list
			List<Process> tempList = tempQueue.getProcessList();
			
			
			for(Process process : tempList)
			{
				System.out.println("(" + process.getId() + ") => " + process.getPriority());
			}
			
		}
	}
	
	
	
	/*
	 * Add Processes to a queue
	 */
	public void addProcess()
	{
		
		// Create new process 
		Process process = new Process(this.totalProcessCount);
					
		// Put the process in the correct queue based on its priority
		int tempPriority = process.getPriority();
		
		
		// Add Process
		queuesList.get(tempPriority - 1).addProcess(process);
		
		// Keep track of how many processes
		this.totalProcessCount++;
		
	}
	
	
	/*
	 * Remove first Process from a queue
	 */
	public void removeProcess(int priority)
	{
		
		// Add Process
		this.queuesList.get(priority - 1).removeProcess();
		
		// Keep track of how many processes
		this.totalProcessCount--;
		
	}
	
	
	/*
	 * Move next highest priority to run
	 */
	public void moveToReady() {
		
		// reset panel every time
		this.readyPanel.removeAll();
				
		Queue highestPriorityQueue = null;
		
		// If there is already something in ready, move it to run
		if(this.readyProcess != null)
			this.moveToRun();
		
		for(Queue q : this.queuesList)
		{
			// If the queue isn't empty it must be highest priorty
			if(!q.processList.isEmpty())
				highestPriorityQueue = q;
		}
		
		// If there is nothing in any queue just return
		if(highestPriorityQueue == null)
			return;
			
		
		// Get first process from list
		Process processToMove = highestPriorityQueue.processList.get(0);
		
		// Set the process in ready
		this.readyProcess = processToMove;
		
		// Put process in run
		JButton button = new JButton("ID: " + processToMove.getId() + " Priority: " + processToMove.getPriority());
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton_2.gridy = 0;
		gbc_btnNewButton_2.gridx = 1;
		
		this.readyPanel.add(button, gbc_btnNewButton_2);
		
		// Remove process from queue
		highestPriorityQueue.removeProcess();
		
		// Repaint
		this.readyPanel.revalidate();
		this.frame.repaint();
		
		
		System.out.println("Highest => " + highestPriorityQueue.priority_id);
	}
	
	
	/*
	 * Move from ready to run
	 */
	public void moveToRun() {		
		
		// Get first process from list
		Process processToMove = this.readyProcess;
		
		// Set current run process
		this.runProcess = processToMove;
		
		// Put process in run
		// reset panel every time
		this.runPanel.removeAll();
				
		JButton button = new JButton("ID: " + processToMove.getId() + " Priority: " + processToMove.getPriority());
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton_2.gridy = 0;
		gbc_btnNewButton_2.gridx = 1;
		
		this.runPanel.add(button, gbc_btnNewButton_2);
		
		// Repaint
		this.runPanel.revalidate();
		this.frame.repaint();
		
	}
	
	
	/*
	 * Move from run to blocked list
	 */
	public void moveToBlocked() {		
		
		// If there are no processes running, Move on
		if(this.runProcess == null )
			return;
		
		// Get first process from list
		Process processToMove = this.runProcess;
		
		// Set current run process
		this.blockedList.add(processToMove);
	
		
		// Paint blocked
		this.paintBlocked();
		
		// Move the from queue to ready and from ready to run
		this.moveToReady();
				
		
		
	}
	
	
	/*
	 * Repaint the blocked list
	 */
	public void paintBlocked() {
		// reset panel every time
		this.blockedListPanel.removeAll();
		
		int tempGridY = 0; 
		int count = 0;
		// Print each process in list
		for( Process process : this.blockedList )
		{
			JButton button = new JButton("ID: " + process.getId() + " Priority: " + process.getPriority());
			GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
			gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
			gbc_btnNewButton_2.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnNewButton_2.gridy = tempGridY;
			
			
			count++;
			
			// If there are more than 4 in this row, move to next
			if(count > 3)
			{
				tempGridY++;
				count = 0;
			}
				
			this.blockedListPanel.add(button, gbc_btnNewButton_2);
			
			// Add feature to allow a blocked process to go back to queue when clicked
			int tempPriority = process.getPriority();
			Queue queueToModify = this.queuesList.get(tempPriority - 1);
			
			// Define the current blocklist so we can modify it in the action listener
			List<Process> blockList = this.blockedList;
			God god = this;
			button.addActionListener(new ActionListener() {

			    @Override
			    public void actionPerformed(ActionEvent e) {
			        Process tempProcess = new Process(process.getId());
			        tempProcess.setPriority(process.getPriority());
			        
			        // Put process back in queue
			        queueToModify.addProcess(tempProcess);
			        
			        // Remove process from blocked list
			        blockList.remove(process);
			        
			        god.paintBlocked();
			        
			    }
			});
		}
		
		// Repaint
		this.blockedListPanel.revalidate();
		this.frame.repaint();
	}
	
	
	/*
	 * Terminate Process in run
	 */
	public void terminateRun() {		
		
		this.runProcess = null;
		
		this.runPanel.removeAll();
		this.runPanel.revalidate();
		this.frame.repaint();
		
		this.moveToReady();
		
	}
	
	
	/*
	 * Send process from run to ready for timeslice
	 */
	public void timeslice() {		
		
		if(this.runProcess == null)
			return;
		
		// Get process to move
		Process processToMove = this.runProcess;
		
		// Reset run panel
		this.runProcess = null;
		
		this.runPanel.removeAll();
		
		this.runPanel.revalidate();
		this.frame.repaint();
		
		// Put ready process back in queue
		int tempPriority = processToMove.getPriority();
		this.queuesList.get(tempPriority - 1).addProcess(processToMove);
		
		// Context Switch
		this.moveToReady();
		
		
	}
	
	
}
