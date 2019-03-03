import java.util.Arrays;

public class PeakFinding {

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
    private static int peakOneD(int i, int[] nums) {
        if (i > 0 && nums[i] < nums[i - 1])
            return -1;
        if (i < nums.length - 1 && nums[i] < nums[i + 1])
            return 1;
        return 0;
    }

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
    private static int peakX(int x, int y, int[][] nums) {
        if (x > 0 && nums[y][x] < nums[y][x - 1])
            return -1;
        if (x < nums[0].length - 1 && nums[y][x] < nums[y][x + 1])
            return 1;
        return 0;
    }

    // Return -1 if up is higher, 1 if down is higher, 0 if peak
    private static int peakY(int x, int y, int[][] nums) {
        if (y > 0 && nums[y][x] < nums[y - 1][x])
            return -1;
        if (y < nums.length - 1 && nums[y][x] < nums[y + 1][x])
            return 1;
        return 0;
    }

    // These two functions return the index of the highest value along the X or Y axis, with the given
    // value for the other axis. Searches between hi (exclusive) and lo (inclusive)
    private static int maxXIndex(int y, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int x = lo; x < hi; x++) {
            if (maxIndex == -1 || nums[y][x] > nums[y][maxIndex])
                maxIndex = x;
        }
        return maxIndex;
    }

    private static int maxYIndex(int x, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int y = lo; y < hi; y++) {
            if (maxIndex == -1 || nums[y][x] > nums[maxIndex][x])
                maxIndex = y;
        }
        return maxIndex;
    }


    public static int findOneDPeak(int[] nums) {
        int mid = nums.length/2;
        if(peakOneD(0,nums)==0){
            return 0;
        }
        if(peakOneD(nums.length-1,nums)==0){
            return nums.length-1;
        }
        if(peakOneD(mid,nums)==-1){
            findOneDPeak(nums);
        }
        if(peakOneD(mid,nums)==1){
            findOneDPeak(nums);
        }
        if(peakOneD(mid,nums)==0){
            return mid;
        }
        return 0;
    }

    public static int[] findTwoDPeak(int[][] nums) {
        // TODO
        int midX = nums.length/2;
        int midY = nums[0].length/2;
        int[] indices=new int[2];
        if(peakX(midX,midY,nums)==0 && peakY(midX,midY,nums)==0){
            indices[0] = midX;
            indices[1] = midY;
            return indices;
        }
        if(peakX(0,0,nums)==0 && peakY(0,0,nums)==0){
            indices[0] = 0;
            indices[1] = 0;
            return indices;
        }

        if(peakX(nums.length-1,0,nums)==0 && peakY(nums.length-1,0,nums)==0){
            indices[0] = 0;
            indices[1] = nums.length-1;
            return indices;
        }
        if(peakX(nums[0].length-1,nums.length-1,nums)==0 && peakY(nums[0].length-1,nums.length-1,nums)==0){
            indices[0] = nums[0].length-1;
            indices[1] = nums.length-1;
            return indices;
        }
        if(midX==0 || midX==nums.length-1){
            indices[0]=midX;
            indices[1]=maxYIndex(midX,0,nums.length-1,nums);
            return indices;
        }
        else{
            indices[0]=midX;
            indices[1]=findOneDPeak(nums[midX]);
            return indices;
        }
    }

}
