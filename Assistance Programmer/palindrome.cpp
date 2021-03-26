#include<bits/stdc++.h>
using namespace std;






bool isPalindrom(long long num, long long first, long long last){
	 if(first != last) return false;
	 if(num / 10 == 0) return true;
	 
	 last = num % 10;
	 num /= 10;
	 long long counter = 1;
	 long long temp = 0;
	 while(num/10 != 0){
		 temp += counter *(num %10);
		 counter *= 10;
		 num /= 10;
	 }
	 
	 return isPalindrom(temp,num, last);
	
}



int main(){

/**
  const int NN = 1000;
  char num[NN];
  while(scanf("%s", num)){
       int i,j;
       bool isPalindrome=1;
      for(i = 0, j = strlen(num)-1; i<j; i++, j--){
             if(num[i] != num[j]){
                printf("%s not palindrome!\n", num);
                isPalindrome =0;
                break;
             }
      }

      if(isPalindrome){
        printf("%s is palindrome\n", num);

      }

  }
**/

  // finding palindrom by reversing the number
 /**
  int num ;
  while(scanf("%d", &num)){
    // reverse the num
    int rev = 0, temp = num;
    for(; num; num/=10){
        printf("%d ", num);
        rev *= 10;
        rev+= num % 10;
    }

    if(rev == temp){
       printf("\n%d is palindrome\n", temp);
    }else printf("\n%d is not palindrom\n", temp);

  }
  **/
   // checking palindrome without reversing number, array, string
   
   /**
   int num;
   while(scanf("%d", &num)){
      int n  = num;
      bool isPalindrome = 1;
      while(num && num/10 != 0){
        printf("%d\n", num);
        int last = num % 10;
        num /= 10;
        int counter = 1, temp = 0;
        // seeking the first number
        while(num / 10 != 0){
            temp += counter * (num % 10);
            counter *= 10;
            num /= 10;
        }

        if(num != last){
            printf("%d is not palindrom\n", n);
            isPalindrome = 0;
            break;
        }
        num = temp;
      }

      if(isPalindrome){
        printf("%d is palindrome\n", n);
      }

   }
  **/
  
  
  long long num;
  while(cin >> num){
	  cout<< num << (isPalindrom(num, num, num) == true ? " palindromic num" : " not palindromic num") << endl;
  }
  

 return 0;
}
