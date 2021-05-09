class Solution
{
    public:
    //Function to sort an array using quick sort algorithm.
    void quickSort(int arr[], int low, int high)
    {
        if(low < high){
            int p = partition(arr, low, high);
          //  for(int i = low; i<= high; i++) cout << arr[i] << " ";
        //    cout << endl;
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }
    
    public:
    int partition (int arr[], int low, int high)
    {
       int pivot = arr[high];
       int i = low, j = high -1;
       while(i < j){
           while(arr[i] <= pivot && i <= j) i++;
           while(arr[j] > pivot && j > i) j--;
           if(i < j){
               swap(arr[i], arr[j]);
           }
       }
       if(pivot < arr[i]){
           swap(arr[i], arr[high]);
       }
       return i;
    }
};
