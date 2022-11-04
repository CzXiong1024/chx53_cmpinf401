import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author bearking
 * Date Nov,3 2022
 */
public class RecordList {
	
	/**
	 * The node class represents a single list element with a data item and
	 * reference to the next node in the list
	 */
	private class Node {
		// data held by this node
		Record data;
		// reference to the next node in the list, or null if there is no such node
		// (i.e. this is the last node in the list)
		Node next;
		
		/**
		 * Creates a node with the given data
		 * @param dataValue data to hold in this node
		 */
		public Node(Record dataValue) {
			next = null;
			data = dataValue;
		}
		
	}
	
	private Node head;
	
	/**
	 * Initializes a linked list with a single "dummy" node (contains no real data)
	 * to simplify code for the case of an empty list
	 */
	public RecordList() {
		head = new Node(null);
	}
	
	/**
	 * Finds the index of the record with the given name in the list
	 * @param name name to search for
	 * @return index of name in list if found, -1 otherwise
	 */
	public int indexOf(String name) {
		if(this.head.data==null) {return -1;}
		if(this.head.data.getName().equals(name)) {
			return 0;
		}
		Node currentNode = head;
		int index = 0;
		// traverse through the list looking for our target node
		while (currentNode.next != null && !currentNode.next.data.getName().equals(name)) {
			currentNode = currentNode.next;
			index++;
		}
		
		// we got to the end of the list without finding our target
		if (currentNode.next == null) return -1;
		else return index+1;
	}
	
	/**
	 * Adds the given item to the list, sorted by time (lowest to highest)
	 * @param data data to add
	 * @return the index the data was inserted at
	 */
	public int add(Record data) {
		// Replace this with your own code. You can use the indexOf() method as a guide.
		if(this.head.data==null) {
			this.head.data = data;
			return 0;
		}
		
		// traverse to place to insert node (i.e. get currentNode to be the one
		// immediately before where we want to insert -- the last node with a strictly
		// lower time)
		Node plug = new Node(data);
		if(this.head.data.getTime()>=data.getTime()) {
			plug.next = this.head;
			this.head = plug;
			return 0;
		}
		int index = 0;
		Node currentNode = head;
		while (currentNode.next != null && currentNode.next.data.getTime()<data.getTime()) {
			currentNode = currentNode.next;
			index++;
		}
		// add new node in the spot we've found
		plug.next = currentNode.next;
		currentNode.next = plug;
		return index+1;
	}
	
	/**
	 * Prints out each record in the list, one per line
	 */
	public void print() {
		// note that we start from our first *real* node in this case (head.next, not
		// our dummy head)
		if(this.head.data==null) {System.out.println("You have not added any data!");}
		Node currentNode = this.head;
		while (currentNode != null) {
			System.out.println(indexOf(currentNode.data.getName())+":"+currentNode.data.getName() + ", " + currentNode.data.getTime());
			currentNode = currentNode.next;
		}
		System.out.println();
	}
	
	/**
	 * Write out the contents of the linked list to the given file, one entry per line
	 * @param filename name of the file to write the list to
	 */
	public void writeToFile(String filename) {
		// Add your own code here to write out the list contents to a file. You can use
		// our file writing examples and the print() method above as a guide.
		File file = new File(filename);
		file.delete();
		Node currentNode = this.head;
		try {
			FileWriter fw = new FileWriter(filename,true);
			BufferedWriter bw = new BufferedWriter(fw);
			while(currentNode!=null) {
				bw.write(currentNode.data.getName()+","+currentNode.data.getTime()+"\n");
				currentNode = currentNode.next;
			}
			bw.close();
			fw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}




