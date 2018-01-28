package DP;
//test
//test1
//test2
/**
 * Created by lsg on 27/10/2017.
 */
/*nums 每个银行有多少钱, 不能挨着相邻的银行抢
* idx: 第n家银行
* */

public class Robber {
	public static int[] result;
	public static int solve(int idx,int[] nums){
		if(idx>=0)
		System.out.print(idx+" ");
		if(idx ==0){
			System.out.println();
		}
		if(idx<0){
			return 0;
		}
		/*if(result[idx] >=0){
			return result[idx];
		}*/
		//System.out.println("nums[idx]+solve(idx-2,nums),solve(idx-1,nums)  "+nums[idx]+"+"+idx);
		result[idx]=Math.max(nums[idx]+solve(idx-2,nums),solve(idx-1,nums));
		return result[idx];
	}

	public static int rob(int[] nums){
		result =new int[nums.length];
		for(int i=0;i<nums.length;++i){
			result[i]=-1;
		}
		return solve(nums.length-1,nums);
	}

	public static void main(String[] args) {
		int[] nums={8,4,1,9,8,2};
   int j = rob(nums);
		System.out.println("the max cash would be "+j);
	}
}
