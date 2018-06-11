
public class FactoryClass {
	private Technician technician=null;
	private static FactoryClass FactoryReference=null;
	private FactoryClass() {

	}
	public static FactoryClass getSingltonObject() {
		if(FactoryReference==null) {
			FactoryReference=new FactoryClass();
		}
		return FactoryReference;
	}
	public Technician getObjectUsingFactoryPattern(String arg) {

		if(arg.equals("Plumber") || arg.equals("PLUMBER")) {
			technician=new Plumber();
		}
		else if(arg.equals("Electrician") || arg.equals("ELECTRICIAN")) {
			technician=new Electrician();
		}
		else if(arg.equals("Carpenter") || arg.equals("CARPENTER")) {
			technician=new Carpenter();
		}
		else {
			technician=new Electrician();
		}
		return technician;
	}

}
