import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.io.*;

class ThreadRunner extends Exception implements Runnable{
  private Thread t;
  private String server;

  public ThreadRunner(String s){
    server = s;
    System.out.println("Creating "+server);
  }

  public void run(){
    BufferedWriter bw = null;
    try{
      bw = new BufferedWriter(new FileWriter("out"+server+".txt"));
    }catch(Exception e){
      System.out.println(e);
    }
    int time = 0;
    int ser = 0;
    long now = 1486330000;
    System.out.println(EpochToString(now));
    System.out.println(EpochToString(now+60));
    String serStr = "192.168."+server+".";
    while(time < 1440){
      ser = 0;
      while(ser < 125){
        try{
          bw.write(String.valueOf(now+time*60)+", "+serStr+String.valueOf(ser)+", 0, "+ String.valueOf(new Random().nextInt(100) + 1)+"\n");
          bw.write(String.valueOf(now+time*60)+", "+serStr+String.valueOf(ser)+", 1, "+ String.valueOf(new Random().nextInt(100) + 1)+"\n");
          ser++;
          bw.flush();
        }catch(Exception e){
          System.out.println(e);
        }

      }
      time++;
    }
   
    System.out.println("Done "+server);
  }

  public void start(){
    System.out.println("Starting " +  server );
      if (t == null) {
         t = new Thread (this, server);
         t.start();
      }
  }
  
  public  String EpochToString(long epoc){
	  epoc *= 1000;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(new Date(epoc));
		
		
	}
}

public class Generate{
  public static void main(String[] args){
    for(int i=0;i<4;i++)
      new ThreadRunner(String.valueOf(i)).start();
  }
  

}

