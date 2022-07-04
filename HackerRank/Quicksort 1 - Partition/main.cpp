vector<int> quickSort(vector<int> arr) {
    if(arr.size() <= 1) return arr;
    int p = arr[0];
    int start = 1, end = arr.size()-1;
    
    while(start < end){
        while(p > arr[start] && start < end)start++;
        while(p < arr[end] && start <= end) end--;
        
        if(start < end){
            swap(arr[start], arr[end]);
        }
    }
    
    swap(arr[0], arr[end]);
    
    return arr;
}
