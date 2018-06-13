
public class Electrician implements Technician {
	
	private String[] workers= {"M Rashid","Tanveer Ahmed","Nabeel Ahmed","Sohail Khan","Shahzad Malla"};
	
	public String getContactNo() {
		return "03074748822";
	}
	public String getName() {
		return "Muhammad Faisal";
	}
	public String[] getWorkers() {
		return workers;
	}
	public void setWorkers(String[] workers) {
		this.workers = workers;
	}
}
