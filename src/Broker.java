import java.util.*;

public class Broker {
	private static Broker BrokerReference=null;
	private static HeadManager _manager;
	private ArrayList<CustomerGUI> _customers = new ArrayList<>();
	private Broker() {
		_manager=new HeadManager();
	}
	public static Broker getSingltonObject() {
		if(BrokerReference==null) {
			BrokerReference=new Broker();
		}
		return BrokerReference;
	}
	public void Notify(int id,String[] str) {
		this._customers.get(id).setAssignmentRecord(str);
	}
	public void add(CustomerGUI customer) {
		this._customers.add(customer);
	}	
	public boolean customerConfirm(CustomerGUI	 temp) {
		for(int i=0; i<_customers.size(); i++) {
			if(_customers.get(i)==temp) {
				return false;
			}
		}
		return true;
	}

	public String GetDetails(int id) {
		return _customers.get(id).getDescription();
	}
	public void Submit(int id) {
		String[] str= {_customers.get(id).getJobType(),_customers.get(id).getAddress()};
		//System.out.println(str[0]+""+str[1]+"  ID "+id);
		_manager.newCustomer(str,id);
	}
}
