/*
Author: Kevin Hinson

Description: Game of Blobs is a scenario where several blobs exist in flat land, the blobs will try to eat eachother. Prey items for the blobs are blobs
that are smaller than them but will prefer the biggest prey item.

The grid is assumed to be a Left Hand Coordinate System where the origin would be the top left hand corner of the screen. The larger the X-coordinate the farther
along to the right of the origin.  The larger the Y-coordinate the farther down from the origin.
*/

import java.util.Random;

class gob{
	
	public static void main(String args[]){
		
		Random randy = new Random();
		int numBlob = randy.nextInt(4) + 1;
		int count = 0;//for while loop
		boolean cycle = true;//for the while loop
		
		blob blobArray[] = new blob[numBlob];//creating obj array
		
		
		for(int i = 0; i < numBlob; i++)//setting up blobs
		{
			blobArray[i] = new blob();
			blobArray[i].init(i);
			//blobArray[i].print();
		}
		
		while(cycle)//while there are valid mvoes
		{
			//finds food, and decides on which axis to move on
			for(int i = 0; i < numBlob; i++)
				blobArray[i].movement(numBlob,blobArray);
			
			//applies this movement
			for(int j = 0; j < numBlob; j++)
				blobArray[j].applymovement();
			
			//merges blobs
			for(int k = 0; k < numBlob; k++)
				blobArray[k].merge(numBlob,blobArray);
			
			//counting valid moves
			for(int x = 0; x < numBlob; x++)
			{
				if(blobArray[x].validmove == false)
				{
				   count++;
				}
			}
			
			//if valid moves == numBlob the game is over
			if(count == numBlob)
			{
				cycle = false;
			}
			else{
				count = 0;//resetting count
				}
				
			for(int y = 0; y < numBlob; y++)
			{
				blobArray[y].print();
			}
		}
	
		System.out.println("==============Here are the winners!==========");
		for(int j = 0; j < numBlob; j++)
		{
			if(blobArray[j].eaten == false)
				blobArray[j].print();
		}
		
	}
}
