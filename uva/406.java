import java.util.*;
 class Main{
 private static final int N= 1003;
 private static int[] mark = new int[N];
 private static Vector<Integer> primeList = new Vector<Integer>(); 
  private static void sieve()
  {
     Arrays.fill(mark,1);
     mark[0]=0;
     primeList.add(1);
     primeList.add(2);
     for(int i=4;i<N;i+=2)mark[i]=0;
        int limit = (int) Math.sqrt(N);
    for(int i=3;i<N;i+=2)
    {
       if(mark[i]==1)
       { 
        primeList.add(i);
        for(int j=i*i;j<N;j+=i*2)mark[j]=0;
       }
    }


  }

  private static int binarySearch(int firstIndex,int lastIndex,int num)
  {

    int mid =(int)((firstIndex+lastIndex)/2);
     if(firstIndex>primeList.size()-1) return primeList.size()-1;
     if(lastIndex<0) return 0;       
      if(primeList.get(mid)==num) return mid;
     else if( mid-1>0 && num>primeList.get(mid-1) && num<primeList.get(mid)) return mid-1;
     else if(num<primeList.get(mid)) return binarySearch(firstIndex,mid-1,num);
     else return binarySearch(mid+1,lastIndex,num);  

  }

   public static void main(String[] args)
   {

    sieve();
    //for(int i=0;i<primeList.size();i++)
        //System.out.print(primeList.get(i)+" ");
    Scanner read = new Scanner(System.in);
    while(read.hasNext())
    {
        int n = read.nextInt();
        int c = read.nextInt();
        int index=binarySearch(0,primeList.size()-1,n);
        System.out.print(n+" "+c+":");
        int size=index+1;
        int center =(int)(size/2);
        //System.out.println(center);
        c*=2;
        if(size%2==1)c--;
        int firstC =(int) c/2;
        int start = center-firstC;
        if(start<0) 
         for(int i=0;i<=index && i<=c;i++)
            System.out.print(" "+primeList.get(i));
         else{
        for(int i=start;i<=center;i++)
            System.out.print(" "+primeList.get(i));
        if(c%2==0) firstC--;
        for(int i=center+1;i<=center+firstC;i++)
            System.out.print(" "+primeList.get(i));
            }
          System.out.printf("\n\n");        

    }
    read.close();


   }

}