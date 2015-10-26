/**
 Author:  Vinayak G Nair
 facebook.com/vinayakgnair
 This is part 3 of the program which has 3 parts
 Result will be a text file
 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.lang.*;

public class PuzzlePart3
{ 
  HashSet <Long> listPowers;
  ArrayList <Long> listP;
  HashMap<String, String> cache;
  int limit;
  //ArrayList <Long> Solutions;
  static int processed;
 // long countSoln;
  long tempV;
  PuzzlePart3()  	{ listPowers = new HashSet <Long>(1);
		          listP = new ArrayList <Long> (1);
		          cache = new HashMap<String, String>();
				  limit =0;
	             }
				 //
 public long power(long a, long s)
  {
	long df =a;
	for(long ll=1;ll<s;ll++)
	 {	df=df*a;}
	return df;
}
void p()
{  
	long rr =Long.valueOf(2097152);
	tempV =1;
	long powered;
	String s1,s2;  
	
	s1="1 ^ 5";
			s2=String.valueOf(tempV+3);
			cache.put(s2,s1);
	//listPowers.add(this.tempV);
	//System.out.println(listPowers.size());
	System.out.println("Starting the program..... ");
	for(long numBase =2;numBase<rr;numBase++)
	{
		for(long power=3;power<63;power++)
		{   powered = this.power(numBase,power);
			if(powered<1) break;
			// if the number move out of bounds it becomes negative or zero
			if(powered%numBase==0)
				{//listPowers.add(powered);
			s1=numBase+" ^ "+power;
			s2=String.valueOf(powered);
			cache.put(s2,s1);
			}
			else break;
				
		}
	}
	System.out.println("Added "+cache.size()+" items to list\n Now will add to text file");
	return;
}
				 //

  void p1() {  long temp;
                     String lastEntry;
                     try
                        {
   	                       BufferedReader br = new BufferedReader(new FileReader("file2.txt"));     
   	                       if ((lastEntry = br.readLine()) == null)
							   { System.out.println("file empty");
                                     
						   }
    	                   else { 
                                 temp = Long.valueOf(lastEntry);
			                    // this.listPowers.add(temp); 
			                     this.listP.add(temp); 
								 this.limit++;
     		                     while((lastEntry=br.readLine())!=null)
	         	                  {  temp = Long.valueOf(lastEntry);
					                 //this.listPowers.add(temp); 
			                         this.listP.add(temp); 
									 this.limit++;
								  }
						       }
                          br.close();
		                  System.out.println("read and closed file1.txt");
	                      System.out.println("read from file : "+this.listP.size());
	                  }catch(Exception e){System.out.println(e);}
	                  return;
                   }

void action() { 
String ss,ss1;
long a1,a2,kk;
String longString;
try{
	FileWriter fw = new FileWriter("result.txt",false);
for(int index =0;index<this.limit;)
{
	ss=String.valueOf(this.listP.get(index));
	ss1 =this.cache.get(ss);
	kk=Long.valueOf(ss);
	longString = ss1+"("+ss+")";
	//System.out.println(longString);
	index++;
	//2
	ss=String.valueOf(this.listP.get(index));
	a1=this.listP.get(index);
	ss1 =this.cache.get(ss);
	longString = longString+" = "+ss1+"("+ss+")";
	index++;
	//3
	ss=String.valueOf(this.listP.get(index));
	a2=this.listP.get(index);
	ss1 =this.cache.get(ss);
	longString = longString+" + "+ss1+"("+ss+")";
	index++;
	longString = longString+" has "+lcdTest(a1,a2)+" as common factor";
	if(this.listPowers.contains(kk))
	     {
		 System.out.println("Duplicate avoided");
	      }
	  else{
	   System.out.println(longString);
	   fw.write(longString+"\n\n");
	   this.listPowers.add(kk);
	   }
	
}
fw.close();	
	System.out.println("Written and closed....... ");
	}catch(Exception e){System.out.println("write method encountered error"+e);}
	
                	  
			           
			   return;
			   }


long lcdTest(long b,long c)
{
	long d,a,a10;
	boolean fla =true;
	long dfd =0;
           	d = (b>c)? (b-c):(c-b);
	        a10= (b>c)?c:b;
	       a= (a10>d)?d:a10;
			a++;
	        if(c%2 ==0 && b%2==0)
	        {fla=false;	
		    dfd=2;
		}
		    else{
				  for(long factor=3;(fla==true) && factor<a;factor=factor+2)
	                      {//System.out.println(factor);
							  if(c%factor==0 && b%factor==0) {
								//  System.out.println("+++"+factor);
								dfd =factor;
								  fla= false;}
						  }
				 }
	    					   
							  
	return dfd;
}

	
	public static void main(String args[]) 
    	{  	System.out.println("Program Starting...");
		    JVMShutdownHook jvmShutdownHook = new JVMShutdownHook();
            Runtime.getRuntime().addShutdownHook(jvmShutdownHook);
			System.out.println("set shutdown hook...");
		    PuzzlePart3 obj= new PuzzlePart3();
			
		    obj.p();
			 obj.p1();
    		obj.action();
	    	//obj.writeSoln();
		    System.out.println("Program completed successfully");
	   }//main program ends
	   
	   //execute when ctrl +c pressed
	   private static class JVMShutdownHook extends Thread {
           public void run() {
              System.out.println("JVM Shutdown Hook: Thread initiated.");
			 /*  try{
						           FileWriter fw2 = new FileWriter("saved.txt",true);
						           fw2.write(pHdFinalS.processed+"\n");
						           
						           fw2.close();
						
				               	}catch(Exception e){System.out.println(e);}*/
			  
                             }
                                                          }
	   //
}//class ends
