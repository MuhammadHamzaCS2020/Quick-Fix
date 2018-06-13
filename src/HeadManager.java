import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class HeadManager {
	private static JFrame frame=null;
	private static JPanel outer=null;
	private JPanel jpanel,PrimaryJpanel;
	private String[] labelname= {"                   Customer                  ","Type of Job                                      ","Technician                ","Expected Cost         ","Duration                                                      "};
	Border border = BorderFactory.createTitledBorder("Customer Record");
	
	public void newCustomer(String[] str, int id) {
		if(frame==null) {
			frame =new JFrame("MANAGER INTERFACE");
			frame.setSize(900,500);
			outer=new JPanel();
			PrimaryJpanel=new JPanel();
			jpanel=new JPanel();
			PrimaryJpanel.add(new Label(labelname[0]));
			PrimaryJpanel.add(new Label(labelname[1]));
			PrimaryJpanel.add(new Label(labelname[2]));
			PrimaryJpanel.add(new Label(labelname[3]));
			PrimaryJpanel.add(new Label(labelname[4]));
			PrimaryJpanel.setLayout(new FlowLayout());
			jpanel.add(PrimaryJpanel,BorderLayout.CENTER);
			outer.add(jpanel,BorderLayout.NORTH);
			outer.setLayout(new FlowLayout());
			frame.add(outer);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(0);	
		}
		//System.out.println(str[0]+""+str[1]+"  ID "+id);
		manager newmng=new manager(str,id);
		
		outer.add(newmng,BorderLayout.CENTER);	
		frame.add(outer);
		frame.setVisible(true);

	}

}
