import java.util.LinkedList;
import java.util.Iterator;

public class EntryList {
	private int hash;
	private LinkedList<RoutingTableEntry> list;
	
	//initial constructor which initializes the list with it's hash code 
	public EntryList(int hash) {
		this.hash = hash;
		list = new LinkedList<RoutingTableEntry>();
	
	}
	
	//adds the entry to the list
	public void add(RoutingTableEntry rte) {
		list.add(rte);
	}
	
	//checks if the list contains packet route already
	public boolean contains(Packet pk) {
		Iterator<RoutingTableEntry> ie = list.iterator();
		for(int i=0; i<list.size(); i++) {
			if(!ie.next().searchForPort(pk.getDestNetwork()).equals(""))
				return true;
		}
		return false;
	}
	
	//returns the data for the class
	public String toString() {
		String retVal = "["+hash+"]"+list.toString();
		return retVal;
	}
	
	
}
