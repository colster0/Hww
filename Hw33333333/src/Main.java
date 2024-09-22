import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Main {
//names of jframe buttons, fields, and labels. declare
	private JFrame frame;
	private JTextField itemName;
	private JTextField priceAmount;
	private JTextField ItemQuant;
	private JTextArea textArea;
	private SalesSlip salesSlip;
	private JTextField totalDisplay;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	// GUI
	private void initialize() {

		salesSlip = new SalesSlip();

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Add Item Button
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.setBounds(201, 140, 117, 29);
		frame.getContentPane().add(btnAddItem);
//Item Name
		JLabel lblItemName = new JLabel("Item Name:");
		lblItemName.setBounds(22, 31, 84, 16);
		frame.getContentPane().add(lblItemName);
//Where ItemName will be typed
		itemName = new JTextField();
		itemName.setBounds(145, 26, 242, 26);
		frame.getContentPane().add(itemName);
		itemName.setColumns(10);

		// Label for the price
		JLabel lblItemPrice = new JLabel("Item Price:");
		lblItemPrice.setBounds(22, 69, 84, 16);
		frame.getContentPane().add(lblItemPrice);

		// Where price is typed
		priceAmount = new JTextField();
		priceAmount.setBounds(145, 64, 242, 26);
		frame.getContentPane().add(priceAmount);
		priceAmount.setColumns(10);

		// Quantity
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(22, 114, 61, 16);
		frame.getContentPane().add(lblQuantity);
//Type Quantity
		ItemQuant = new JTextField();
		ItemQuant.setBounds(145, 109, 242, 26);
		frame.getContentPane().add(ItemQuant);
		ItemQuant.setColumns(10);
//Where items will be displayed
		textArea = new JTextArea();
		textArea.setBounds(22, 168, 405, 71);
		frame.getContentPane().add(textArea);
		totalDisplay = new JTextField();
		totalDisplay.setBounds(208, 240, 179, 26);
		frame.getContentPane().add(totalDisplay);
		totalDisplay.setColumns(10);

		// total
		lblNewLabel = new JLabel("Total:");
		lblNewLabel.setBounds(32, 245, 74, 16);
		frame.getContentPane().add(lblNewLabel);

		// Add action listener
		btnAddItem.addActionListener(new ActionListener() {
			// handle errors
			public void actionPerformed(ActionEvent e) {
				try {
					String name = itemName.getText();
					double price = Double.parseDouble(priceAmount.getText());
					int quantity = Integer.parseInt(ItemQuant.getText());

					SalesItem newItem = new SalesItem(name, price, quantity);
					salesSlip.addItem(newItem);

					textArea.setText(salesSlip.slipWritten());
//Will add the money sign to the total at the bottom
					totalDisplay.setText(String.format("$%.2f", salesSlip.computeTotal()));
//resets it so that another item can be added
					itemName.setText("");
					priceAmount.setText("");
					ItemQuant.setText("");
					// Will catch the errors if a letter is entered in the price or quantity

				} catch (NumberFormatException ex) {
					textArea.setText("ERROR, enter a number");
				}
			}
		});
	}
}
