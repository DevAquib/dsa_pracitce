class Solution {

    // Main function called by the platform (e.g., LeetCode)
    // Sorts the array using Quick Sort and returns it
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

        // Apply Quick Sort on the full array
        quickSort(nums, left, right);
        return nums;
    }

    // Recursive Quick Sort function
    // Sorts the subarray from index left to right
    public void quickSort(int[] nums, int left, int right) {

        // Base condition: at least two elements should be present
        if (left < right) {

            // Partition the array and get the pivot's correct index
            int pivotIndex = partition(nums, left, right);

            // Recursively sort elements on the left of pivot
            quickSort(nums, left, pivotIndex - 1);

            // Recursively sort elements on the right of pivot
            quickSort(nums, pivotIndex + 1, right);
        }
    }

    // Partition function using Lomuto Partition Scheme
    // Chooses the last element as pivot
    // Places pivot at its correct position in sorted array
    public int partition(int[] nums, int left, int right) {

        // Pivot is chosen as the last element
        int pivot = nums[right];

        // i points to the index of the smaller element
        int i = left - 1;

        // Traverse from left to right - 1
        for (int j = left; j < right; j++) {

            // If current element is <= pivot,
            // move it to the left partition
            if (nums[j] <= pivot) {
                i++;
                swap(nums, j, i);
            }
        }

        // Place pivot in its correct sorted position
        swap(nums, i + 1, right);

        // Return the pivot index
        return i + 1;
    }

    // Utility function to swap two elements in the array
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
