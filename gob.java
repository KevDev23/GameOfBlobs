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
		
		
		for(int i = 0; i < numBlob; i++)//setting up blobs
		{
			blobArray[i] = new blob();
			blobArray[i].init(i);
			//blobArray[i].print();
		}
		
		while(cycle)//while there are valid mvoes
		{
			for(int i = 0; i < numBlob; i++)//finds food, and decides on which axis to move on
				blobArray[i].movement(numBlob,blobArray);
			
			for(int j = 0; j < numBlob; j++)//applies this movement
				blobArray[j].applymovement();
			
			for(int k = 0; k < numBlob; k++)//merges
				blobArray[k].merge(numBlob,blobArray);
					
		}
		
		System.out.println("==============Here are the winners!==========");
		for(int j = 0; j < numBlob; j++)
		{
			if(blobArray[j].eaten == false)
				blobArray[j].print();
		}
		
	}
}
