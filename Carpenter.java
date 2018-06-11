
public class Carpenter implements Technician{
	
	private String[] workers= {"M Hamza","Muhammad Adnan","Musharaf Malik","Hussnain Malik","Arslan Asghar"};
	
	public String getContactNo() {
		return "03014379118";
	}
	public String[] getWorkers() {
		return workers;
	}
	public void setWorkers(String[] workers) {
		this.workers = workers;
	}
	public String getName() {
		return "Muhammad Hamza";
	}
}
