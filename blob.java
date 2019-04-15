//blob class defines a blobs variables and class methods
import java.util.Random;

public class blob{
	
	private int xcoord;
	private int ycoord;
	private int size;
	private int blobid;//identifies blob
	private int xnext; //next x coordinate
    private int ynext; // next y coordinate
	private bool validmove;
		
		public void print(){//prints blob data
			System.out.println("blobID:" + this.blobid + " Size:" + this.size + " blobXcoord:" + this.xcoord + " blobycoord:" + this.ycoord);
		}
		
		//initializes x,y coordinates and it's size
		public void init(int id){
			Random rand = new Random();
			int rando = rand.nextInt(999) + 1;
				
			this.xcoord = rando;
				
			rando = rand.nextInt(999) + 1;
				
			this.ycoord = rando;
				
			rando = rand.nextInt(999) + 1;
				
			this.size = rando; 
			
			this.validmove = true;
			this.xnext = 0;
			this.ynext = 0;
			this.blobid = id;
		}

		//find the closest blob to eat. numblob, searchingBlob is the id of the blob looking for food.
		//If there are no possible prey items there are no valid moves for this blob, will return -1.
		private int closestblob(int numblob, int searchingBlob){
			
			int closest = -1;//will take the id of blobs that the searchingBlob can eat
			
			for(int i = 0; i < numblob; i++)
			{
				if((blobArray[searchingBlob].size > blobArray[i].size) && (blobArray[i].size != 0))//if possible prey blob is smaller than searchingBlob and hasn't been eaten(denoted by size = 0)
				{
					if(closest == -1)//if we haven't selected a possible canidate for a blob to consume set the first possible blob as the selected meal
					{	
						closest = i;
					}
					else{
							if(blobArray[temp].size < blobArray[i].size)//Selects new prey canidate if blobArray[i].size is larger than the current selected blob
							{
								closest = i;
							}
						}
				}
				
					
			}
			
			return closest;
				
			
		}
		
		public void movement(int numblob){//decides what xnext and what ynext is and aplies it
			
			int meal = 0;//will be the blob to be consume
			int xDistance = 0;
			int yDistance = 0;
			
			
				for(int i = 0; i < numblob; i++)
				{
					meal = closestblob(numblob,blobArray[i].blobid);
					
					if(meal != -1)
					{	
						xDistance = max(blobArray[i].xcoord,blobArray[meal].xcoord) - min(blobArray[i].xcoord,blobArray[meal].xcoord);
						yDistance = max(blobArray[i].ycoord,blobArray[meal].ycoord) - min(blobArray[i].ycoord,blobArray[meal].ycoord);
						
						if(xDistance < yDistance)//if blob is closer on the x-axis
						{
							if(blobArray[i].xcoord > blobArray[meal].xcoord)//if the blob looking for a meal is farther on the x-axis we need to decrement it
							{
								blobArray[i].xnext = blobArray[i].xcoord--;
							}
							else{
								  blobArray[i].xnext = blobArray[i].xcoord++;
								}
						blobArray[i]ynext = blobArray[i].ycoord;//the y-coordinates will not change
						}
						else{
								if(blobArray[i].ycoord > blobArray[meal.ycoord)//if blob looking for meal is farther on the y-axis...
								{
									blobArray[i].ynext = blobArray[i].ycoord--;//decrease the y-axis coordinate
								}
								else{
									  blobArray[i].ynext = blobArray[i].ycoord++;//increase the y-axis coordinate
									}
							blobArray[i].xnext = blobArray[i].xcoord;//the x-coordinates will not change 
							}
					}
					else{
						 blobArray[i].validmove = false;//set valid moves to false since meal == -1 indicating the blob can no longer move
						}
					
				}
				
				//applying movement
				for(int j = 0; j < numblob; j++)
				{
					blobArray[j].xcoord = blobArray[j].xnext;
					blobArray[j].ycoord = blobArray[j].ynext;
				}
		}
		
		//will merge blobs with the same coordinates
		public void merge(int numblob){
			
			for(int i = 0; i < numblob; i++)
			{
				for(int j = 0; j < numblob; j++)
				{
					if((blobArray[i].xcoord == blobArray[j].xcoord) && (blobArray[i].ycoord == blobArray[j].ycoord))//are 2 blobs on the same coordinates?
					{
						if(blobArray[i].size > blobArray[j].size)
						{
							blobArray[i].size += blobArray[j].size;
							blobArray[j].size = 0;//this blob was eaten so it's size is registered as 0
							blobArray[j].validmove = false;//cannot move since it was eaten
						}
						
						if(blobArray[i].size < blobArray[j].size)
						{
							blobArray[j].size += blobArray[i].size;
							blobArray[i].size = 0;//this blob was eaten so it's size is set to 0
							blobArray[i].validmove = false;
						}
						//if the blobs are equal in size then neither gets eaten
					}						
				}
			}
			
		}
		
		//checks to see if blobs still have a valid movement, game ends when no blobs have a valid move
		public boolean checkMove(int numblob){
			int count = 0;
			
			for(int i = 0; i < numblob; i++)
			{
				if(!blobArray[i].validmove)//if valid move is false
					count++;
			}
			
			if(count == numblob)
			{
		      return false;
			}
			else{
				  return true;
				}
		}
}
