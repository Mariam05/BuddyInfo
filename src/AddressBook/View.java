package AddressBook;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class View extends JFrame {
	
	JList list;
	AddressBook addressBook;
	JMenuBar menuBar;
	JMenu menu, submenu;
	JMenuItem menuItem;
	
	public View() {
		addressBook = new AddressBook();
		list = new JList<>(addressBook);
		
		//Set up the menu
		menuBar = new JMenuBar();
		menu = new JMenu("AddressBook");
		menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);
		menuItem = new JMenuItem("Create Address Book", KeyEvent.VK_B);
		menu.add(menuItem);
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "A new address book will be created. All buddies will be removed.");
				addressBook.clear();
			}
			
		});
		
		menuItem = new JMenuItem("Add Buddy", KeyEvent.VK_C);
		menu.add(menuItem);
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JPanel optionPanel = new JPanel();
				
				JTextField name = new JTextField(10);
				JTextField address = new JTextField(10);
				JTextField number = new JTextField(10);
				
				optionPanel.add(new JLabel("Name: "));
				optionPanel.add(name);
				optionPanel.add(new JLabel("Address: "));
				optionPanel.add(address);
				optionPanel.add(new JLabel("PhoneNumber: "));
				optionPanel.add(number);		
					
				int result = JOptionPane.showConfirmDialog(null, optionPanel, "New Buddy", JOptionPane.OK_CANCEL_OPTION); 
				
				if (result == JOptionPane.OK_OPTION) {
					BuddyInfo newBuddy = new BuddyInfo(name.getText(), address.getText(), number.getText());
					addressBook.addBuddy(newBuddy);
					
				}
			}
			
		});
		
		
		menuItem = new JMenuItem("Remove Buddy");
		menu.add(menuItem);
		//This can also be implemented by adding an action listener on the list that will remove the one that is selected
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String response = JOptionPane.showInputDialog("Which buddy would you like to remove? ", JOptionPane.OK_CANCEL_OPTION);
				int index = Integer.parseInt(response);
				addressBook.remove(index);
			}
			
		});
			
		setLayout(new BorderLayout());
		setTitle("AddressBook");
		setSize(300, 400);
		
		
		add(menuBar, BorderLayout.NORTH);
		add(list);
		setVisible(true);
	}
	

	
	public void updateView() {
		
	}
	
	
	public static void main(String[] args) {
		View addressBookView = new View();
	}
}
