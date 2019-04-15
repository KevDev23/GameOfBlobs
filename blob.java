//blob class defines a blobs variables and class methods
import java.util.Random;

public class blob{
	
	int xcoord;
    int ycoord;
    int size;
    int blobid;//identifies blob
    int xnext; //next x coordinate
    int ynext; // next y coordinate
    boolean validmove;
	boolean eaten;
		
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
			this.eaten = false
			this.xnext = 0;
			this.ynext = 0;
			this.blobid = id;
		}

		//find the closest blob to eat. numblob, searchingBlob is the id of the blob looking for food.
		//If there are no possible prey items there are no valid moves for this blob, will return -1.
		private int closestBlob(int numblob, int searchingBlob,blob[] blobArray){
			
			int closest = -1;//will take the id of blobs that the searchingBlob can eat
			
			for(int i = 0; i < numblob; i++)
			{
				if((blobArray[searchingBlob].size > blobArray[i].size) && (blobArray[i].eaten == false))//Select prey and if prey has not been eaten
				{
					if(closest == -1)//if we haven't selected a possible canidate for a blob to consume set the first possible blob as the selected meal
					{	
						closest = i;
					}
					else{
							if(blobArray[closest].size < blobArray[i].size)//Selects new prey canidate if blobArray[i].size is larger than the current selected blob
							{
								closest = i;
							}
						}
				}
				
					
			}
			
			return closest;
				
			
		}
		
		public void movement(int numblob,blob[] blobArray){//decides what xnext and what ynext is
			
			int meal = 0;//will be the blob to be consume
			int xDistance = 0;
			int yDistance = 0;
			
					meal = closestBlob(numblob,blobArray[i].blobid,blobArray);
					
					if(meal != -1)//if meal is -1 then the blob closestBlob returned cannot move so we skip it, else we work on finding out it's new movement
					{	
						xDistance = Math.max(this.xcoord,blobArray[meal].xcoord) - Math.min(this.xcoord,blobArray[meal].xcoord);
						yDistance = Math.max(this.ycoord,blobArray[meal].ycoord) - Math.min(this.ycoord,blobArray[meal].ycoord);
						
						if(xDistance < yDistance)//if blob is closer on the x-axis
						{
							if(this.xcoord > blobArray[meal].xcoord)//if the blob looking for a meal is farther on the x-axis we need to decrement it
							{
								this.xnext = this.xcoord--;
							}
							else{
								  this.xnext = this.xcoord++;
								}
						this.ynext = this.ycoord;//the y-coordinates will not change
						}
						else{
								if(this.ycoord > blobArray[meal].ycoord)//if blob looking for meal is farther on the y-axis...
								{
									this.ynext = this.ycoord--;//decrease the y-axis coordinate
								}
								else{
									  this.ynext = this.ycoord++;//increase the y-axis coordinate
									}
							this.xnext = this.xcoord;//the x-coordinates will not change 
							}
					}
					else{
						 this.validmove = false;//set valid moves to false since meal == -1 indicating the blob can no longer move
						}
		}
		
		//will merge blobs with the same coordinates
		public void merge(int numblob,blob[] blobArray){
			
			for(int i = 0; i < numblob; i++)
			{
					if((blobArray[i].xcoord == this.xcoord) && (blobArray[i].ycoord == this.ycoord))//are 2 blobs on the same coordinates?
					{
						if(this.size > blobArray[i].size)
						{
							this.size += blobArray[i].size;
						}
						
						if(this.size < blobArray[i].size)//if this blob will be eaten
						{
						  this.eaten = true;//to signify it is eaten
						}
						//if this blob is larger than it's fellow it will eat it
					}						
			
			}
			
		}
		
		public void applymovement(){//applying movement
				this.xcoord = this.xnext;
				this.ycoord = this.ynext;
		}
		//checks to see if blobs still have a valid movement, game ends when no blobs have a valid move
		public boolean checkMove(int numblob,blob[] blobArray){
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
