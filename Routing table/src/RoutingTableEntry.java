//each object of this class manages entries into the routing table
public class RoutingTableEntry{

	//private instances
	private IPAddress destination;
	private String portCode;
	
	//default constructor initializing the objects of the class
	public RoutingTableEntry(){
		destination = new IPAddress();
		portCode = "";
	}

	//adds an entry into the class abject using the parameters passed
	public void addEntry(IPAddress add, String portCode){
		destination.initialize(add);
		this.portCode = portCode;
	}

	//displays the entry in the object
	public String toString(){
		return "destination: "+destination +"\tportcode: "+ portCode;
	}

	//looks for the parameter passed into the class object, if matched returns the portCode, if not thena an empty string
	public String searchForPort(IPAddress add){
		if(destination.isEqual(add))
			return portCode;
		return "";
	}
	
	public boolean ipcpr(IPAddress add) {
		if(add.isGreaterThan(destination))
			return false;
		return true;
	}
	
	
	/*public int calcHash() {
		return destination.calcHash();
	}*/

}