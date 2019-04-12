//blob class defines a blobs variables and class methods
import java.util.Random;

public class blob{
	
	private int xcoord;
	private int ycoord;
	private int size;
	private int blobid;//identifies blob
	private int xnext; //next x coordinate
    private int ynext; // next y coordinate
		
		public void print(){//prints blob data
			System.out.println("blobID:" + this.blobid + " Size:" + this.size + " blobXcoord:" + this.xcoord + " blobycoord:" + this.ycoord);
		}
		
		public void init(int id){//initializes x,y coordinates and it's size
			Random rand = new Random();
			int rando = rand.nextInt(999) + 1;
				
			this.xcoord = rando;
				
			rando = rand.nextInt(999) + 1;
				
			this.ycoord = rando;
				
			rando = rand.nextInt(999) + 1;
				
			this.size = rando; 
			
			this.blobid = id;
		}				
}
