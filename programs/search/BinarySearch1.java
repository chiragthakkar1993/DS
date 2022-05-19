package search;

class BinarySearch1 {
  
    public int search(int[] nums, int target) {
      
        int start = 0;
        int end = nums.length -1;
        int mid = 0;
        while(start <= end){
             mid = (start + end) / 2;
            if(nums[mid] < target)
                start = mid+1;
            else
                end = mid-1;
        }
        if(nums[start] == target)
            return start;
        return -1;
        
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch1().search(new int[]{1, 3, 5, 9, 12, 16, 45},9));
    }
}
