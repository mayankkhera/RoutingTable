import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

//this class contains the main method and the scanner for the program
public class MainClass {
	
	//main method scanning the given file by user and reading packets and processing them according to their types
	public static void main(String[] args) throws IOException{
		Router rt = new Router();
		Scanner input = new Scanner(System.in);
		System.out.print("Input file name: ");
		String fname = input.next();
		input.close();
		System.out.println();
		try{
			input = new Scanner(Paths.get(fname));
		}catch(IOException e) {
			System.err.println("Error opening file. Terminating");
			return;
		}
		char packetType;
		while(input.hasNext()) {
			packetType = input.next().charAt(0);
			Packet pk;
			if(packetType=='p')
				pk = new RoutingPacket();
			else if(packetType=='d')
				pk = new DataPacket();
			else {
				System.err.println("Invalid packet type. Terminating");
				input.close();
				return;
			}
			if(!pk.readPacket(input)) {
				System.out.println("Invalid IP Address scanned. Terminating");
				return;
			}
			rt.processPacket(pk);
		}
		rt.displayTable();
		input.close();

	}
	
}
