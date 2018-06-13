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

public class Customer {

	private final int SIZE=4;
	private String[] AssignmentRecord=new String[SIZE];
	private String JobType=null;
	private String Address=null;
	private String Description=null;
	private String Date=null;
	private int ID;

	public String getJobType() {
		return JobType;
	}

	public void setJobType(String jobType) {
		JobType = jobType;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String[] getAssignmentRecord() {
		return AssignmentRecord;
	}
	public void setAssignmentRecord(String[] assignmentRecord) {
		AssignmentRecord = assignmentRecord;
	}
	public int getSIZE() {
		return SIZE;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

}



