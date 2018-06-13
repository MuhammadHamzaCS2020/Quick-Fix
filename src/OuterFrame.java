import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JInternalFrame;

public class OuterFrame extends JFrame{
	private JDesktopPane outerPane;

	public OuterFrame(){
		super( "Customer External Frame" );
		JMenuBar bar = new JMenuBar(); // create menu bar
		JMenu addMenu = new JMenu( "New" ); // create Add menu
		JMenuItem newFrame = new JMenuItem( "Customer" );

		addMenu.add(newFrame); // add menu item to Add menu
		bar.add( addMenu ); // add Add menu to menu bar
		setJMenuBar( bar ); // set menu bar of outer frame

		outerPane = new JDesktopPane(); // create pane for outer frame
		add(outerPane); // add this pane to the outer frame

		newFrame.addActionListener(new ActionListener()	{  
			public void actionPerformed( ActionEvent event ){
				// create internal frame
				JInternalFrame frame = new JInternalFrame( 
						"CLIENT INTERFACE", true, true, true, true );

				CustomerGUI customer = new CustomerGUI();  // Creation of New Customer with GUI
				frame.add(customer);
				frame.pack();         // set internal frame to size of contents
				frame.setSize(500,350); //set frame size
				outerPane.add( frame ); // add internal frame to outer frame
				frame.setVisible( true ); // show internal frame
			} 
		}); 
	}
} 


