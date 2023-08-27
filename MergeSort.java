package mypackage;

import java.util.Random;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] randomarray = new int[10];
		
		Random rand = new Random();
		
		for(int i =0 ; i< randomarray.length ; i++)
		{
			randomarray[i] = rand.nextInt(1000);
		}
		System.out.println("Before :");
		for(int rannum : randomarray)
		{
			System.out.println(rannum);
		}
			
		 int[] resarray =  mergesort(randomarray);
		 
		 System.out.println("After :");
		 
		 for(int num : resarray)
		 {
			 System.out.println(num);
		 }
		 
	}
	
	private static int[] mergesort( int[] randarray)
	{
		
		int mainArrayLength = randarray.length;
		
		
		if(randarray.length <  2)
		{
			return randarray ;
		}
		
		int middleNum = mainArrayLength /2 ;
		int[] leftarray = new int[middleNum];
		int[] rightarray = new int[ mainArrayLength - middleNum];
		
		for(int i =0 ; i<middleNum ; i++)
		{
			leftarray[i] = randarray[i];
		}
		for(int i =middleNum ; i<randarray.length ; i++)
		{
			rightarray[ i-middleNum ] = randarray[i];
		}
		
		mergesort(leftarray);
		mergesort(rightarray);
		
		
		return merge(randarray, leftarray, rightarray);
	}
	
	private static int[] merge( int[] randarray , int[] leftHalf , int[] rightHalf )
	{
		int left =0 , right =0 , main =0 ;
		
		while( left  < leftHalf.length && right < rightHalf.length  )
		{
			
			if( leftHalf[left] <= rightHalf[right] )
			{
				
				randarray[main] = leftHalf[left];
				left += 1;
				main += 1;
				
			}
			else {
				
				randarray[main] = rightHalf[right];
				right += 1;
				main += 1;
				
			}
			
		}
		
		while (left < leftHalf.length) {
            randarray[main] = leftHalf[left];
            left += 1;
            main += 1;
        }

        while (right < rightHalf.length) {
            randarray[main] = rightHalf[right];
            right += 1;
            main += 1;
        }
		
		return randarray;
		
	}

}
