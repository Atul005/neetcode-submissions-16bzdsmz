class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        min_sum = nums[0]
        max_sum = nums[0]
        sum_so_far_max = nums[0]
        sum_so_far_min = nums[0]
        circular_sum = 0
        total_sum = nums[0]

        for i in range(1, len(nums)):

            total_sum += nums[i]

            if sum_so_far_max + nums[i] < nums[i]:
                sum_so_far_max = nums[i]
            else:
                sum_so_far_max += nums[i]

            if sum_so_far_max > max_sum:
                max_sum = sum_so_far_max    

            if sum_so_far_min + nums[i] > nums[i]:
                sum_so_far_min = nums[i]
            else:
                sum_so_far_min += nums[i]

            if sum_so_far_min < min_sum:
                min_sum = sum_so_far_min      


        circular_sum = total_sum - min_sum

        if max_sum > 0:
            return max(circular_sum, max_sum)

        return max_sum    







        