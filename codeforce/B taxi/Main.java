import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Main{
   
     //Scanner read = FileFactory.read();
    Reader read = new Reader();
     //Scanner read = new Scanner(System.in);
   

     final int MAX_SIZE=5;
     int passangers[],groupSize;

    


    void  solve() throws Exception{

      //while(read.hasNext()){

      groupSize = read.nextInt();
       passangers = new int[MAX_SIZE];
      for(int i=0;i<groupSize;++i){
      	++passangers[read.nextInt()];
      }

      int requireCar=passangers[4];

       passangers[1] = passangers[1]>=passangers[3]? passangers[1]-passangers[3]:0; 

      requireCar+=passangers[3];
      

       //System.out.println(requireCar);
      
      //System.out.println(passangers[1]+" "+passangers[2]);

      requireCar+=passangers[2]/2;

      passangers[2] =passangers[2]%2;

      passangers[1] = passangers[1]>=2*passangers[2] ? passangers[1]-2*passangers[2] : 0;

       requireCar+=passangers[2];      

      //System.out.println(passangers[1]);


     

      requireCar+=passangers[1]/4;
      
      //System.out.println(passangers[1]);

      passangers[1] =passangers[1]%4;
      
      requireCar+= passangers[1]>0 ? 1:0;
       
       ///System.out.println(passangers[2]);

      System.out.println(requireCar);
    //}

    }


   // Main method

	public static void main(String[] args) throws Exception{     
        new Main().solve();
	}

	 // faster input reader

		private class Reader{
			private BufferedReader buffered;
			private StringTokenizer tokenizcer;

			public Reader(){
			  this.tokenizcer = null;
			  buffered = new BufferedReader(new InputStreamReader(System.in),31768);
			}

			public String nextLine(){
				try{
					return buffered.readLine();
				}catch(Exception ex){
					throw new RuntimeException(ex);
				}
			}

			public String next(){
				while(tokenizcer == null || !tokenizcer.hasMoreTokens()){
					tokenizcer = new StringTokenizer(nextLine());
				}
				return tokenizcer.nextToken();
			}

			public int nextInt(){
				try{
					return Integer.parseInt(next());
				}catch(Exception ex){
					return -1;
				}
			}

			public long nextLong(){
				try{
					return Long.parseLong(next());
				}catch(Exception ex){
				return -1;	
				}
			}

			public double nextDouble(){
				try{
					return Double.parseDouble(next());
				}catch(Exception ex){
					return -1.0;
				}
			}


		}

}