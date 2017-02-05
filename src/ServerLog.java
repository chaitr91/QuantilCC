

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;
class ServerLog 
{
   public static void main(String args[])
  {
      try{
    // Create file System.currentTimeMillis() + 
    FileWriter fstream = new FileWriter("out.txt");
    BufferedWriter out = new BufferedWriter(fstream);
    
    
    long offset = Timestamp.valueOf("2012-01-01 00:00:00").getTime();
    long end = Timestamp.valueOf("2013-01-01 00:00:00").getTime();
    long diff = end - offset + 1; 
    Timestamp rand = new Timestamp(offset+(long)(Math.random() * diff));
    System.out.println(rand);
    SimpleDateFormat df=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    Date date = (Date) df.parse(String.valueOf(offset/1000));
    long epoch = date.getTime();
    
    System.out.println(epoch); // 1055545912454
    
    boolean ipCheck=false;
    
    int i=0;
    
    int b1 = 198;
    int b2 = 162;
    String ip1 = Integer.toString(b1);
    String ip2 = Integer.toString(b2);
    while(i<100){
    
    i++; 
    if(i%2==0)
		ipCheck=true;
	
    
    if(ipCheck)
    {
    StringBuilder sb = null;
    Random rn = new Random();
    int answer = rn.nextInt(255) + 1;

    Random rn1 = new Random();
    int percent = rn1.nextInt(10) + 1;
    String percent4 = Integer.toString(percent);
     
    
    int b3 = (answer >>  8) & 0xff;
    int b4 = answer;
    String ip3 = Integer.toString(b3);
    String ip4 = Integer.toString(b4);
    
    
   
    

    //Now the IP is b1.b2.b3.b4
    sb = new StringBuilder();
    sb.append(ip1).append(".").append(ip2).append(".").append(ip3).append(".").append(ip4);
    // System.out.println(sb);

    String x=rand.toString()+','+sb+","+percent4;
    }
    String x="hleee";
    out.write(x);
    //Close the output stream
    }
    }catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
  }
}
