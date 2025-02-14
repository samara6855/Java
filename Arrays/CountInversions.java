// https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1

class Solution {

    // Brute Force - T.C: Near to O(n^2), S.C: O(1)
    static int inversionCount(int arr[]) {
        int n = arr.length;
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[i]) count++;
            }
        }
        return count;
    }

    // Optimal - Using Merge Sort, Counting the pairs while adding the pairs in each stage in Merge Sort
    // T.C: O(n*logn), S.C: O(n) - for Array List
    static int inversionCount(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // Temporary array
        int left = low;      // Starting index of left half
        int right = mid + 1; // Starting index of right half
        int cnt = 0;         // Count variable to track inversions

        // Merging the two halves in sorted order
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += (mid - left + 1); // Count inversions
                right++;
            }
        }

        // Copy remaining elements of left half
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // Copy remaining elements of right half
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Transfer sorted elements back to original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return cnt;
    }

    static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;

        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);  // Left half
        cnt += mergeSort(arr, mid + 1, high); // Right half
        cnt += merge(arr, low, mid, high);  // Merging sorted halves

        return cnt;
    }
}
