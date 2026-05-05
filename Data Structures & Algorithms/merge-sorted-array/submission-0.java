class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m-1;
        int l = nums1.length-1;
        int j=n-1;

        while(k >= 0 && j >= 0){
            if(nums1[k] > nums2[j]){
                nums1[l] = nums1[k];
                k--;
            }else{
                nums1[l] = nums2[j];
                j--;
            }
            l--;
        }

        while(j >= 0){
            nums1[l] = nums2[j];
            j--;
            l--;
        }


    }

    
}