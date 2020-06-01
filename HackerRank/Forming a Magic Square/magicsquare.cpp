#include<bits/stdc++.h>
using namespace std;

const int N = 3;

int arr[]={1,2,3,4,5,6,7,8,9};

typedef vector<int>vi;
typedef vector<vi>vvi;
vvi squares;

bool isMagicSquare();
void magicSquares();
int different(vi , vi);


int main(){
	
	magicSquares();
	/*
	for(unsigned int i = 0; i<squares.size(); i++){
	 for(unsigned int j = 0; j<squares[i].size(); j++) printf("%d ", squares[i][j]);
	 printf("\n");
	}
	*/
	
	vi square(9);
	for(int i =0; i<9; i++) cin>>square[i];
	
	int result = 1e8;
	for(unsigned int i = 0; i<squares.size(); i++){
		result = min(result, different(squares[i], square));
	}
	
	printf("%d\n", result);
 return 0;
}


int different(vi saveSquare, vi square){
	int diff = 0;
	for(unsigned int i = 0 ; i<saveSquare.size(); i++){
		diff += abs(saveSquare[i] - square[i]);
	}
	return diff;
}


bool isMagicSquare(){
	int a[3][3];
	int temp = -1;
	for(int i = 0; i<3; i++){
		int sum = 0;
		for( int j = 0; j<= 2; j++){
			a[i][j]= arr[3*i+j];
			sum += a[i][j];
		}
		temp = temp ==  -1? sum : temp;
		if(temp != sum)return false;
	}
	
	int right_diagonal = 0;
	int left_diagonal = 0;
	
	for(int i = 0; i<= 2; i++){
		int sum = 0;	
		for(int j = 0; j<= 2; j++) sum += a[j][i];
		if(temp != sum) return false;
		right_diagonal +=a[i][i];
		left_diagonal += a[i][2-i];
	}
	
	if (right_diagonal != temp) return false;
	if(left_diagonal != temp)   return false;
	
	return true;
}


void magicSquares(){
	
	do{
		if(isMagicSquare()){
			vi square;
			for(int i = 0; i<9; i++) square.push_back(arr[i]);
			squares.push_back(square);
		}
	}while(next_permutation(arr+0, arr+9));
	
}
