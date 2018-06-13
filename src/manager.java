import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class manager extends JPanel implements ActionListener{
	private Technician technician; 
	private FactoryClass factory;
	private Broker _broker;
	//private String[] workers= {"Select","Plumber","Carpenter","Electrician","ETC"};	
	private JTextField[] textfields=new JTextField[5];
	private JButton assign;
	private JButton detail;
	private JComboBox combobox;


	public manager(String[] str, int id){

		textfields[0]=new JTextField();
		textfields[0].setPreferredSize(new Dimension(30, 25));
		textfields[0].setEditable(false);
		textfields[0].setText(""+(id));
		textfields[0].setBorder(null);
		add(textfields[0]);

		textfields[1]=new JTextField();
		textfields[1].setPreferredSize(new Dimension(120, 25));
		textfields[1].setEditable(false);
		textfields[1].setText(str[0]);
		add(textfields[1]);

		textfields[2]=new JTextField();
		textfields[2].setPreferredSize(new Dimension(120, 25));
		textfields[2].setEditable(false);
		textfields[2].setText(str[1]);
		add(textfields[2]);

		detail =new JButton("Detail");
		detail.addActionListener(this);
		detail.setFocusable(false);
		detail.setBackground(Color.GREEN);
		add(detail);

		factory=FactoryClass.getSingltonObject();
		technician=factory.getObjectUsingFactoryPattern(str[0]);
		String[] string=technician.getWorkers();

		combobox=new JComboBox(string);                     //combio box for workers
		combobox.setPreferredSize(new Dimension(120,25));   //combo box size
		combobox.setSelectedIndex(0);
		add(combobox);

		textfields[3]=new JTextField();
		textfields[3].setPreferredSize(new Dimension(120, 25));
		add(textfields[3]);

		textfields[4]=new JTextField();
		textfields[4].setPreferredSize(new Dimension(120, 25));
		add(textfields[4]);

		assign=new JButton("Assign");
		assign.addActionListener(this);
		assign.setFocusable(false);
		assign.setBackground(Color.GREEN);
		add(assign);
		setLayout(new FlowLayout());
		setVisible(true);

	}

	public void actionPerformed(ActionEvent event) {
		_broker=Broker.getSingltonObject();
		if(event.getSource()==assign) {
			if(!(this.textfields[3].getText().isEmpty()) && !(this.textfields[4].getText().isEmpty()) ){
				factory=FactoryClass.getSingltonObject();
				technician=factory.getObjectUsingFactoryPattern((String) combobox.getSelectedItem());
				
				String[] assigndata= {(String) combobox.getSelectedItem(),technician.getContactNo(),
						this.textfields[3].getText(),this.textfields[4].getText()};
				
				_broker.Notify(ConvertStringToInt(textfields[0].getText()),assigndata);	
			}
			else {
				JOptionPane.showMessageDialog(null,"Please Fill the Empty Fields They are requaird for Registration");
			}
		}
		else if(event.getSource()==detail) {
			JOptionPane.showMessageDialog(null,_broker.GetDetails(ConvertStringToInt(textfields[0].getText())));
			//System.out.println(_broker.GetDetails(ConvertStringToInt(textfields[0].getText())));
		}
	}


	public int ConvertStringToInt(String str) {
		int sum=0,i=0,temp;
		while(i<str.length()) {
			temp=str.charAt(i)-48;
			sum=sum*10;
			sum+=temp;
			i++;
		}
		//System.out.println(sum);
		return sum;
	}
}
