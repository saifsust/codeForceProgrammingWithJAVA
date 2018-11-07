import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Main{
   
     //Scanner read = FileFactory.read();
    Reader read = new Reader();
     //Scanner read = new Scanner(System.in);
   
     int requireMoney[],n,k,w;
 
    


    void  solve() throws Exception{

         k=read.nextInt();
         n=read.nextInt();
         w=read.nextInt();
         requireMoney = new int[w+1];

         for(int i=1;i<=w;++i){
 			requireMoney[i]+=requireMoney[i-1]+i*k;
         }

         System.out.println(requireMoney[w]>=n ? requireMoney[w]-n:0);


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