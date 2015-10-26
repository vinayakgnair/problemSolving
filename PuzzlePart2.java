/**
 Author:  Vinayak G Nair
 facebook.com/vinayakgnair
 This is part 2 of the program which has 3 parts
 Result will be a 2 text files or single depending on a condition
 */
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.lang.*;

public class PuzzlePart2
{ 
  HashSet <Long> listPowers;
  ArrayList <Long> listP;
  //ArrayList <Long> Solutions;
  static int processed;
 // long countSoln;
  long tempV;
  PuzzlePart2()  	{ listPowers = new HashSet <Long>(1);
		          listP = new ArrayList <Long> (1);
		         
	             }

  void populate() {  long temp;
                     String lastEntry;
                     try
                        {
   	                       BufferedReader br = new BufferedReader(new FileReader("list.txt"));     
   	                       if ((lastEntry = br.readLine()) == null)
							   { System.out.println("file empty");
                                     
						   }
    	                   else { 
                                 temp = Long.valueOf(lastEntry);
			                     this.listPowers.add(temp); 
			                     this.listP.add(temp); 
     		                     while((lastEntry=br.readLine())!=null)
	         	                  {  temp = Long.valueOf(lastEntry);
					                 this.listPowers.add(temp); 
			                         this.listP.add(temp); 
								  }
						       }
                          br.close();
		                  System.out.println("read and closed list.txt");
	                      System.out.println(this.listPowers.size()+" : "+this.listP.size());
	                  }catch(Exception e){System.out.println(e);}
	                  return;
                   }

void action() { 
                int sizeL =this.listP.size(); 
                String ad;
	            long c,a,b;
	            for(int a1=processed+1;a1>=0 && a1<this.listPowers.size();a1++)
    	          {  a = this.listP.get(a1);
                     for(int b1=0;b1<a1/2;b1++)
		               {
			            b = this.listP.get(b1);
		    	        if(a<b) break;
			            c=a-b;
			            if(c!=b && this.listPowers.contains(c))
			             {	//	System.out.println("a :"+a+" b "+b);		
				           if(this.lcdTest(b,c))
				             {
					           System.out.println("Solved ");
                               try{
						           FileWriter fw2 = new FileWriter("file1.txt",true);
						           fw2.write(a+"\n");
						           fw2.write(b+"\n");
						           fw2.write(c+"\n");
						           fw2.close();
						
				               	}catch(Exception e){System.out.println(e);}
				             }
				             else {
								    try{
						           FileWriter fw2 = new FileWriter("file2.txt",true);
						           fw2.write(a+"\n");
						           fw2.write(b+"\n");
						           fw2.write(c+"\n");
						           fw2.close();
						
				               	      }catch(Exception e){System.out.println(e);} 
				                         System.out.println("LCD check failed @ "+a);
				                  }
								  
			             }	
                            					 
		           }
				    processed =a1;	
                }
	           this.listP.clear();
	           this.listPowers.clear();
			   return;
			   }

boolean lcdTest(long b,long c)
{
	long d,a,a10;
	boolean fla =true;
	
           	d = (b>c)? (b-c):(c-b);
	        a10= (b>c)?c:b;
	       a= (a10>d)?d:a10;
			a++;
	        if(c%2 ==0 && b%2==0)
	        {fla=false;	}
		    else{
				  for(long factor=3;(fla==true) && factor<a;factor=factor+2)
	                      {//System.out.println(factor);
							  if(c%factor==0 && b%factor==0) {
								//  System.out.println("+++"+factor);
								  fla= false;}
						  }
				 }
	    					   
							  
	return fla;
}

void readPreviousState()
{
	 String lastEntry1;
                     try
                        {
   	                       BufferedReader br = new BufferedReader(new FileReader("saved.txt"));     
   	                       if ((lastEntry1 = br.readLine()) == null)
							   { System.out.println("file empty set to 1"); 
						         processed =0;
						       }
    	                   else { 
                                 processed = Integer.valueOf(lastEntry1);
			                    
     		                     while((lastEntry1=br.readLine())!=null)
	         	                  {  processed = Integer.valueOf(lastEntry1);
					                 
								  }
						       }
                          br.close();
		                  System.out.println("read and set previos state"+processed);
	                   
	                  }catch(Exception e){
						  System.out.println(e);
						    System.out.println("Something went wrong in read previous state");
						  }
					  return;
}
	
	public static void main(String args[]) 
    	{  	System.out.println("Program to solve Bael Conjecture part 2 of 3\n This program tries to put the Bael's equation in equality by picking values for\n A^x and B^y from list.txt for each value of C^z from list.txt file");
            System.out.println("\nIt generates 3 files \n Saving present state of execution in saved.txt file \n Saving counter examples in file1.txt file \n Saving values of variables which adhers to Bael's conjecture in file2.txt");
			System.out.println("\nAuthor:Vinayak G Nair @ facebook.com/vinayakgnair");
		    System.out.println("Program Starting...");
		    JVMShutdownHook jvmShutdownHook = new JVMShutdownHook();
            Runtime.getRuntime().addShutdownHook(jvmShutdownHook);
			System.out.println("\n\nPress Ctrl + C combination buttons in keyboard to save the current state if you want to close the program.Expected running time can be upto 10 days...");
		    PuzzlePart2 obj= new PuzzlePart2();
			obj.readPreviousState();
		    obj.populate();
    		obj.action();
	    	//obj.writeSoln();
		    System.out.println("Program completed successfully");
	   }//main program ends
	   
	   //execute when ctrl +c pressed
	   private static class JVMShutdownHook extends Thread {
           public void run() {
              System.out.println("Saving the current value of C^z in saved.yxy file");
			   try{
						           FileWriter fw2 = new FileWriter("saved.txt",true);
						           fw2.write(PuzzlePart2.processed+"\n");
						           
						           fw2.close();
						
				               	}catch(Exception e){System.out.println(e);}
			  
                             }
                                                          }
	   //
}//class ends
