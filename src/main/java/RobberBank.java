/**
 * Created by lsg on 1/11/2017.
 */
public class RobberBank {

	 public static int solve(int idx,int[] nums){
       if(idx<0){
       	return 0;
	   }
        return Math.max(nums[idx]+solve(idx-2,nums),solve(idx-1,nums));
	 }

	public static void main(String[] args) {
	 	int[] nums={1,4,3,6,9};
		System.out.println(solve(nums.length-1,nums));
	}
}
