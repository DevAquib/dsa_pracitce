class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Lengths of both arrays
        int n = nums1.length;
        int m = nums2.length;

        // CASE 1: Total length is EVEN
        if ((n + m) % 2 == 0) {

            // Pointers for nums1, nums2, and merged index
            int i = 0, j = 0, k = 0;

            // Indices of the two middle elements
            int ind1 = ((n + m) / 2) - 1;
            int ind2 = (n + m) / 2;

            // To store the two middle elements
            int ele1 = 0, ele2 = 0;

            // Merge both arrays until one is exhausted
            while (i < n && j < m) {

                // Pick smaller element from nums1
                if (nums1[i] <= nums2[j]) {

                    // If current merged index matches first median index
                    if (k == ind1) ele1 = nums1[i];

                    // If current merged index matches second median index
                    else if (k == ind2) {
                        ele2 = nums1[i];
                        return (ele1 + ele2) / 2.0;
                    }

                    i++;
                    k++;
                }
                // Pick smaller element from nums2
                else {

                    if (k == ind1) ele1 = nums2[j];
                    else if (k == ind2) {
                        ele2 = nums2[j];
                        return (ele1 + ele2) / 2.0;
                    }

                    j++;
                    k++;
                }
            }

            // Process remaining elements of nums1
            while (i < n) {
                if (k == ind1) ele1 = nums1[i];
                else if (k == ind2) {
                    ele2 = nums1[i];
                    return (ele1 + ele2) / 2.0;
                }
                i++;
                k++;
            }

            // Process remaining elements of nums2
            while (j < m) {
                if (k == ind1) ele1 = nums2[j];
                else if (k == ind2) {
                    ele2 = nums2[j];
                    return (ele1 + ele2) / 2.0;
                }
                j++;
                k++;
            }
        }

        // CASE 2: Total length is ODD
        else {

            // Index of the median element
            int ind = (n + m) / 2;

            int i = 0, j = 0, k = 0;

            // Merge until median index is reached
            while (i < n && j < m) {

                if (nums1[i] <= nums2[j]) {
                    if (k == ind) return nums1[i] / 1.0;
                    i++;
                } else {
                    if (k == ind) return nums2[j] / 1.0;
                    j++;
                }
                k++;
            }

            // Remaining elements in nums1
            while (i < n) {
                if (k == ind) return nums1[i] / 1.0;
                i++;
                k++;
            }

            // Remaining elements in nums2
            while (j < m) {
                if (k == ind) return nums2[j] / 1.0;
                j++;
                k++;
            }
        }

        // Fallback return (won’t be reached in valid input)
        return 1.0;
    }
}
