class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target == nums[left]) {
                return left;
            } else if (target == nums[right]) {
                return right;
            }else if (nums[left] < nums[mid]) { // 왼쪽이 오름차순일 때
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            } else { // 오른쪽이 오름차순일 때
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            }
        }

        return -1;
    }
}