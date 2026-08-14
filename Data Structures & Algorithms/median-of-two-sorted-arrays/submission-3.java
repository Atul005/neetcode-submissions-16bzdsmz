class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        return solve(nums1, nums2); 
    }

    public double solve(int[] nums1, int[] nums2){
        if(nums1.length > nums2.length){
            return solve(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int l = 0;
        int h = m;
        int key = (m+n+1)/2;

        int l1 = -1;
        int l2 = -1;
        int r1 = -1;
        int r2 = -1;

        while(l <= h){
            int mid1 = l + (h-l)/2;
            int mid2 = key - mid1;

            l1 = mid1 <= 0 ? Integer.MIN_VALUE : nums1[mid1-1];
            l2 = mid2 <= 0 ? Integer.MIN_VALUE : nums2[mid2-1];

            r1 = mid1 >= m ? Integer.MAX_VALUE : nums1[mid1];
            r2 = mid2 >= n ? Integer.MAX_VALUE : nums2[mid2];

            if(l1 <= r2 && l2 <= r1){
                if((m+n) % 2 == 1){
                    return Math.max(l1, l2);
                }
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }

            if(l1 > r2){
                h = mid1 - 1;
            }else if(l2 > r1){
                l = mid1 + 1;
            }
        }

        return Integer.MIN_VALUE;
    }
}
