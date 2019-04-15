/*
Author: Kevin Hinson

Description: Game of Blobs is a scenario where several blobs exist in flat land, the blobs will try to eat eachother. Prey items for the blobs are blobs
that are smaller than them but will prefer the biggest prey item.
*/

import java.util.Random;

class gob{
	
	public static void main(String args[]){
		
		Random randy = new Random();
		int numBlob = randy.nextInt(1) + 200;
		boolean cycle = true;//for the while loop
		
		blob blobArray[] = new blob[numBlob];//creating obj array
		blob blobManager = new blob();//blob object that will perform actions 
		
		for(int i = 0; i < numBlob; i++)//setting up blobs
		{
			blobArray[i] = new blob();
			blobArray[i].init(i);
			//blobArray[i].print();
		}
		
		while(cycle)//while there are valid mvoes
		{
			blobManager.movement(numBlob,blobArray);
			blobManager.merge(numBlob,blobArray);
			
			cycle = blobManager.moveCheck(numBlob,blobArray);
		}
		
		System.out.println("==============Here are the winners!==========");
		for(int j = 0; j < numBlob; j++)
		{
			if(blobArray[j].size != 0)
				blobArray[j].print();
		}
		
	}
}

//blob class defines a blobs variables and class methods
/*class blob{
	
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
}*/
