import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Main{
   
     //Scanner read = FileFactory.read();
    //Reader read = new Reader();
     FasterReader read = new FasterReader();
     //Scanner read = new Scanner(System.in);
   
 BitSet tree[],tree2[];
 Integer arr[],arr2[];


 void build(int first ,int last,int node){

 	if(first>last) return;

 	tree[node] = new BitSet();
 	tree2[node] = new BitSet();

 	if(first == last){
 		tree[node].set(arr[first]);
 		tree2[node].set(arr2[first]);
 		return;
 	}
      
    int  mid = (first+last)>>1;

    build(first,mid,node*2);
    build(mid+1,last,node*2+1);

    tree[node].or(tree[node*2]);
    tree[node].or(tree[node*2+1]);

    tree2[node].or(tree2[node*2]);
    tree2[node].or(tree2[node*2+1]);

 }


 BitSet query(int first,int last,int node,int begin,int end,boolean isOne){

 	if(first>last || begin>last || end < first) return new BitSet();

 	//System.out.println(first+" "+begin+" "+last+" "+end);
 	if(begin<=first &&  end >= last ){
 		if(isOne){
 			BitSet bit = new BitSet();
 			bit.or(tree[node]);
 			return bit;
 		}else{
            
            BitSet bit = new BitSet();
            bit.or(tree2[node]);
 			return bit;

 		}
 	}
   

     int mid = (first+last)>>1;

     BitSet bit = query(first,mid,node*2,begin,end,isOne);
     
     BitSet bit2 = query(mid+1,last,node*2+1,begin,end,isOne);
     
     bit.or(bit2);

     return bit;

 }





// main method
    void  main() throws Exception{


    	int size = read.nextInt();

    	arr2 = new Integer[size+1];
    	arr = new Integer[size+1];

    	for(int i=1;i<=size;i=-~i){
    		arr[i] = read.nextInt();
    	}

    	for(int i=1;i<=size;i=-~i){
    		arr2[i] = read.nextInt();
    	}

    	tree = new BitSet[4*size+1];
    	tree2= new BitSet[4*size+1];

    	build(1,size,1);
 


    	int testCase = read.nextInt();

    	for(int cas = 1;cas<=testCase;cas=-~cas){

    	  int[] qry = new int[4];
    	  qry[0] = read.nextInt();
    	  qry[1] = read.nextInt();
    	  qry[2] = read.nextInt();
    	  qry[3] = read.nextInt();

    	
    	  BitSet bit ,bit2;


    	   bit = query(1,size,1,qry[0],qry[1],true);
    	   bit2 = query(1,size,1,qry[2],qry[3],false);
    	 
    	
    	  bit.or(bit2);
    	  int ans =  bit.cardinality();
    	 
    	  System.out.println(ans);


    	}




    }


   // Main method

	public static void main(String[] args) throws Exception{     
        new Main().main();

        int num =4;
        //System.out.println(num);
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


		private static class FasterReader{
			private final int BUFFER_SIZE = 1<<16;
			private DataInputStream dataInputStream;
			private byte[]  buffer;
			private int inputPointer,byteRead;

			public FasterReader(){
				dataInputStream = new DataInputStream(System.in);
				buffer = new byte[BUFFER_SIZE];
				inputPointer = byteRead=0;
			}

			private void fillBuffer() throws Exception {
				byteRead = dataInputStream.read(buffer,inputPointer=0,BUFFER_SIZE);
				if(byteRead ==-1) buffer[0]=-1;
			}

			private byte read() throws Exception{
				if(inputPointer == byteRead) fillBuffer();
				return buffer[inputPointer++];
			}

			public String readLine() throws Exception{
				byte[] bytes = new byte[64];
				int cnt =0,c;

				while((c=read())!=-1){
					if(c=='\n')break;
					bytes[cnt++]=(byte)c;
				}
				return new String(bytes,0,cnt);
			}

			public int nextInt() throws Exception{
				int ret =0;
				byte c = read();

				while(c<=' ')c=read();

				boolean neg = (c=='-');
				if(neg) c=read();

				do{

					ret *=10;
					ret+=c-'0';

				}while((c=read())>='0' && c<='9');
				if(neg) return -ret;
				return ret;

			}


		}

}