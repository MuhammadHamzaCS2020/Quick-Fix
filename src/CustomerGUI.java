import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class CustomerGUI extends JPanel implements ActionListener{

	private final int SIZE=4;
	private MyTextField[] NonEditableFields=new MyTextField[SIZE];
	private String[] labelsName= {"NAME OF TECH: ","CONTACT #","EXPACTED COST: ","DURATION: "};
	private String[] getLabelsName= {"TYPE OF JOB: ","ADDRESS: ","DESCRIPTION: ","PREFERRED DATE: ","                "};
	private String[] Titles= {"JOB DETAILS","ASSIGNMENT"};
	private String[] workers= {"PLUMBER","CARPENTER","ELECTRICIAN"};	
	private JTextField[] ActiveField=new JTextField[SIZE/2];

	JButton submit;
	private static int AssignID=0;
	private Broker _broker;
	private boolean flage=true;
	JComboBox[] combobox=new JComboBox[SIZE/2];  
	private Customer customer;

	public CustomerGUI() {
		customer=new Customer();
		customer.setID(AssignID++);
		JPanel panel=new JPanel();       // Main Panel  
		JPanel panel1=new JPanel();      // Internal Panel 1
		JPanel panel2=new JPanel();      // Internal panel 2
		panel.setLayout(new GridLayout(2,1,5,5));
		panel1.setLayout(new GridLayout(5,2)); 
		panel2.setLayout(new GridLayout(4,2));

		Border border = BorderFactory.createTitledBorder(Titles[0]);
		panel1.setBorder(border);
		String[] date= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","13","24","25","26","27","28",
				"29", "30", "31"};                         // TYPES OF WORKERS 

		combobox[0]=new JComboBox(workers);        //combo box for workers
		combobox[0].setPreferredSize(new Dimension(240,25));//combo box size
		combobox[0].setSelectedIndex(0);

		panel1.add(new Label(getLabelsName[0]));
		panel1.add(combobox[0]);

		panel1.add(new Label(getLabelsName[1]));
		ActiveField[0]=new MyTextField(20);
		panel1.add(ActiveField[0]);

		ActiveField[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer.setAddress(ActiveField[0].getText());  //Address=ActiveField[0].getText();
			}
		});

		ActiveField[1]=new MyTextField(20);
		panel1.add(new Label(getLabelsName[2]));
		panel1.add(ActiveField[1]);
		ActiveField[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer.setDescription(ActiveField[1].getText()); //Description=ActiveField[1].getText();
			}
		});

		combobox[1]=new JComboBox(date);                     //combo box for workers
		combobox[1].setPreferredSize(new Dimension(1,5));   //combo box size
		combobox[1].setSelectedIndex(0);

		panel1.add(new Label(getLabelsName[3]));
		panel1.add(combobox[1]);

		submit=new JButton("Submit");
		panel1.add(new Label(getLabelsName[4]));
		submit.addActionListener(this);
		panel1.add(submit);
		panel.add(panel1);

		Border border2 = BorderFactory.createTitledBorder(Titles[1]);
		panel2.setBorder(border2);
		for(int i=0;  i<SIZE; i++) {
			NonEditableFields[i]=new MyTextField(20);
			NonEditableFields[i].setEditable(false);
			panel2.add(new Label(labelsName[i]));
			panel2.add(NonEditableFields[i]);
		}
		panel.add(panel2);
		add(panel,BorderLayout.NORTH);
	}	

	public void actionPerformed(ActionEvent arg0) {
		if(this.flage==true) {
			_broker=Broker.getSingltonObject();
			customer.setJobType((String) combobox[0].getSelectedItem());
			System.err.println(ActiveField[0].getText());
			customer.setAddress(ActiveField[0].getText());
			customer.setDescription(ActiveField[1].getText());
			customer.setDate((String) combobox[1].getSelectedItem());
			if(!(ActiveField[0].getText().isEmpty()) && !(ActiveField[1].getText().isEmpty())){		
				System.out.println("Not Empty");
				_broker.add(this);
				_broker.Submit(customer.getID());
				this.flage=false;
			}
			else{
				JOptionPane.showMessageDialog(null,"Please Fill the Empty Fields They are requaird for Registration");
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"You Already Send Data, If you need our service again then click New");
		}
	}
	public void SetAssigmentInFields() {
		String[] str=customer.getAssignmentRecord();
		for(int i=0; i<SIZE; i++) {
			NonEditableFields[i].setText(str[i]);
		}
	}

	public void setAssignmentRecord(String[] str) {
		customer.setAssignmentRecord(str);
		this.SetAssigmentInFields();
	}

	public String getDescription() {
		return this.customer.getDescription();
	}

	public String getJobType() {
		// TODO Auto-generated method stub
		return this.customer.getJobType();
	}

	public String getAddress() {
		// TODO Auto-generated method stub
		return this.customer.getAddress();
	}

}
