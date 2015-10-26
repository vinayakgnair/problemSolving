/**
 Author:  Vinayak G Nair
 facebook.com/vinayakgnair
 This is part 1 of the program which has 3 parts
 Result will be a text file
 Program to find perfect powers for collection
 

 */

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Iterator;
import java.io.*;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.lang.*;
public class PuzzlePart1
{ 
  HashSet <Long> listPowers;
  ArrayList <Long> listP;
  long tempV;
	PuzzlePart1()
	{
		listPowers = new HashSet <Long>(1);
		listP = new ArrayList <Long> (1);
	}
public long power(long a, long s)
{
	long df =a;
	for(long ll=1;ll<s;ll++)
	{
		df=df*a;
		
	}
	return df;
}
void populate()
{  
	long rr =Long.valueOf(2097152);
	tempV =1;
	long powered;
	listPowers.add(this.tempV);
	//System.out.println(listPowers.size());
	System.out.println("Starting the program..... ");
	for(long numBase =2;numBase<rr;numBase++)
	{
		for(long power=3;power<63;power++)
		{   powered = this.power(numBase,power);
			if(powered<1) break;
			// if the number move out of bounds it becomes negative or zero
			if(powered%numBase==0)
				{listPowers.add(powered);}
			else break;
				
		}
	}
	System.out.println("Added "+listPowers.size()+" items to list\n Now will add to text file");
	return;
}
void write()
{
	for(long unsortedL:this.listPowers)
	{
		listP.add(unsortedL);
	}
	try{
	FileWriter fw = new FileWriter("list.txt",false); //the true will append the new data
    System.out.println("File list.txt opened....... ");
	Collections.sort(this.listP);
	//System.out.println("list sorted....... ");
    for(long item:this.listP)
      { 
       // System.out.println(item);
       fw.write(item+"\n");
	   }//appends the string to the file 
	fw.close();	
	System.out.println("The collection of all values of C^z have been written to file list.txt having "+this.listP.size()+" values for C^z");
	}catch(Exception e){System.out.println("write method encountered error"+e);}
	return;
	
}

	
	public static void main(String args[]) 
    	{  
		PuzzlePart1 obj= new PuzzlePart1();
		System.out.println("Program to solve Bael Conjecture part 1 of 3\n This program generates a collection of all values of C^z for the Bael's Conjecture equation.");
        System.out.println("Author:Vinayak G Nair @ facebook.com/vinayakgnair");
		obj.populate();
		//
		obj.write();
		
	   }//main program ends
}//class ends
