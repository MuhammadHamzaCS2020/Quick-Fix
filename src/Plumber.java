
public class Plumber implements Technician{
	
	private String[] workers= {"Ahmer Khan","Mubashar Dilmor","Saad Wata","Islam Khan","Sultan Ahmad"};	
	
	public String getContactNo() {
		return "03053467695";
	}

	public String getName() {
		return "Zeshan Ahmad";
	}

	public String[] getWorkers() {
		return workers;
	}

	public void setWorkers(String[] workers) {
		this.workers = workers;
	}
}
