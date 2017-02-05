import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.Instant;
import java.util.Calendar;
import java.util.Random;


public class ServL {

	static int b1 = 198;
    static int b2 = 162;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 try{
			 
			    
			    // Create file System.currentTimeMillis() + 
			    FileWriter fstream = new FileWriter("out1.txt");
			    BufferedWriter out = new BufferedWriter(fstream);
			    String message="";
			    
			    
			    
			    
			    long now = Instant.now().toEpochMilli();
			    System.out.println(now/1000);
			    int numT=0;
			    long start = now;
			   
			    
			    String ip1 = Integer.toString(b1);
			    String ip2 = Integer.toString(b2);
			   
			    int count=0;
			    int ts=0;
			    int cpu_id=0;
			    int num=0;
			    while(numT<10){
				    ++numT;	
			   /// System.out.println("*****************************"+numT);
			    while(ts<4){
			       String ip3 = Integer.toString(ts);
			       
			       //System.out.println("Count of"+count);
			       while(count<255){
			    	   int b4 = count;
			           count++;
			       String ip4 = Integer.toString(b4);
			       cpu_id=0;
			       while(cpu_id<2){
			              
			              Random rn=new Random();
			              int cpu_usage = rn.nextInt(100) + 1;
			              StringBuilder sb=null;
						    //Now the IP is b1.b2.b3.b4 
						    sb = new StringBuilder();
						    sb.append(ip1).append(".").append(ip2).append(".").append(ip3).append(".").append(ip4);
						    // System.out.println(sb);
						    String temp=(++num)+", "+now/1000+" ,"+sb+", "+cpu_id+" ,"+cpu_usage; 
						  // if(count==1)
							//   System.out.println(temp);
						    message += temp;
			              //System.out.println("**");
			              cpu_id++;
			              
			       }
			       
			    }
			       count=0;
			       ts++;
			      
			    }   
			    now+=60000;//300000;
			    ts=0;
			   
			    
			    }  
			   // String message="Hi Hello";
			    System.out.println("Done"+(Instant.now().toEpochMilli()-start));
			    out.write(message);
			    System.out.println("File"+(Instant.now().toEpochMilli()-start));
			    out.close();
			    //Close the output stream
			    
		 
			    }catch (Exception e){//Catch exception if any
			      System.err.println("Error: " + e.getMessage());
			    }
			  }
			}