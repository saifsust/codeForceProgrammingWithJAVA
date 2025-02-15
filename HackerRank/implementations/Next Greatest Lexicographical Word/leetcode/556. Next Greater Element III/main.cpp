#include<bits/stdc++.h>
using namespace std;

int nextGreaterElement(int n) {
        vector<long long>nums;
        while(n){
            nums.push_back(n % 10);
            n /= 10;
        }


        reverse(nums.begin(), nums.end());

        int pivot = nums.size() - 2;

        while(pivot >= 0 && nums[pivot] >= nums[pivot + 1]){
            --pivot;
        }


       // cout << pivot << endl;
        if(pivot < 0) return -1;

        int right = nums.size() - 1;

        while(nums[right] <= nums[pivot]){
            --right;
        }

        swap(nums[pivot], nums[right]);

        reverse(nums.begin() + pivot + 1, nums.end());

        //cout << right << endl;
        long long ans = 0;

        for(int i = 0; i<nums.size(); i++){
            ans *= 10;
            ans += nums[i];
        }

        return ans > INT_MAX ? -1 : ans;
    }

int main(){
     ios::sync_with_stdio(false);
     cin.tie(0);
     int n;
     cin >> n;
     cout << nextGreaterElement(n) << endl;
    return 0;
}
