package dispatcher;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextPane;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;

public class DispatcherFrame extends JFrame {

	
	
	
	
	public JPanel queue1_panel = new JPanel();
	public JPanel queue2_panel = new JPanel();
	public JPanel queue3_panel = new JPanel();
	public JPanel queue4_panel = new JPanel();
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public DispatcherFrame(JPanel contentPane, God god) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set size and position of window
		setBounds(20, 20, 1200, 600);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		
		// Set the columns of the grid
		gbl_contentPane.columnWidths = new int[]{20, 70, 70, 70, 70, 70, 111, 150, 30, 20, 0};
		
		// Set the rows of the grid
		gbl_contentPane.rowHeights = new int[]{20, 0, 106, 80, 20, 351, 51, 0};
		
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel_4 = new JLabel("Queue 1");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 1;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Queue 2");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 1;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Queue 3");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 3;
		gbc_lblNewLabel_6.gridy = 1;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Queue 4");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 4;
		gbc_lblNewLabel_7.gridy = 1;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Ready");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 6;
		gbc_lblNewLabel_8.gridy = 1;
		contentPane.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Run");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 8;
		gbc_lblNewLabel_9.gridy = 1;
		contentPane.add(lblNewLabel_9, gbc_lblNewLabel_9);
		queue1_panel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel_10 = new JLabel("Blocked List");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 6;
		gbc_lblNewLabel_10.gridy = 4;
		gbc_lblNewLabel_10.gridwidth = 4;
		contentPane.add(lblNewLabel_10, gbc_lblNewLabel_10);
		queue1_panel.setBackground(Color.LIGHT_GRAY);
		
		
		queue1_panel.setSize(new Dimension(70, 0));
		queue1_panel.setMaximumSize(new Dimension(70, 32767));
		queue1_panel.setBorder(new LineBorder(Color.LIGHT_GRAY));

		
		
		

		
		
		
		

		/*
		JPanel queue3_panel = new JPanel();
		queue3_panel.setBackground(Color.LIGHT_GRAY);
		queue3_panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 3;
		gbc_panel_2.gridy = 2;
		gbc_panel_2.gridheight = 2;
		contentPane.add(queue3_panel, gbc_panel_2);
		
		JPanel queue4_panel = new JPanel();
		queue4_panel.setBackground(Color.LIGHT_GRAY);
		queue4_panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 4;
		gbc_panel_3.gridy = 2;
		gbc_panel_3.gridheight = 2;
		contentPane.add(queue4_panel, gbc_panel_3);
		*/
		JButton addProcessBtn = new JButton("New Process");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 6;
		contentPane.add(addProcessBtn, gbc_btnNewButton);
		
		// Add process on Click
		addProcessBtn.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        //your actions
		    	god.addProcess();
		    }
		});
		
		JButton btnNewButton_2 = new JButton("Context Switch");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 6;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		// Add process on Click
		btnNewButton_2.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        //your actions
		    	god.moveToReady();
		    }
		});
		
		JButton btnNewButton_1 = new JButton("Block");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 8;
		gbc_btnNewButton_1.gridy = 6;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		// Add process on Click
		btnNewButton_1.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        //your actions
		    	god.moveToBlocked();
		    }
		});
		
		
		JButton btnNewButton_3 = new JButton("Terminate");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 7;
		gbc_btnNewButton_3.gridy = 6;
		contentPane.add(btnNewButton_3, gbc_btnNewButton_3);
		
		// Add process on Click
		btnNewButton_3.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        //your actions
		    	god.terminateRun();
		    }
		});
		
		
		
		JButton btnNewButton_4 = new JButton("Timeslice");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_4.gridx = 6;
		gbc_btnNewButton_4.gridy = 6;
		contentPane.add(btnNewButton_4, gbc_btnNewButton_4);
		
		// Add process on Click
		btnNewButton_4.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        //your actions
		    	god.timeslice();
		    }
		});
		
	}
	
}
