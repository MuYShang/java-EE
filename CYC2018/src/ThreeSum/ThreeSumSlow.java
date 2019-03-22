package ThreeSum;

//��һ�������к�Ϊ0����Ԫ������
public class ThreeSumSlow implements ThreeSum {
@Override
public int count(int[] nums) {
	
	int N = nums.length;
	int cnt = 0;
	for(int i = 0;i < N ;i++) {
		for(int j = i;j < N;j++) {
			for(int k = j+1;k < N;k++){
				if(nums[i] + nums[j] + nums[k] == 0) {
					cnt++;
				}
			}
		}
	}
	return cnt;
}
}
