package ThreeSum;

import java.util.Arrays;
//ͨ�������������򣬶�����Ԫ����ͣ����ö��ֲ��ҷ��������Ƿ���ڸú͵��෴����������ڣ�
//��˵��������Ԫ��ĺ�Ϊ 0��
//Ӧ��ע����ǣ�ֻ�����鲻������ͬԪ�ز���ʹ�����ֽⷨ��������ֲ��ҵĽ�������
//�÷������Խ� ThreeSum �㷨��������������Ϊ O(N2logN)��
public class ThreeSumBinarySearch implements ThreeSum{
	@Override
	public int count(int[] nums) {
		Arrays.sort(nums);
		int N = nums.length;
		int cnt = 0;
		for(int i = 0;i < N;i++) {
			for(int j = i+1;j < N;j++) {
				int target = -nums[i] - nums[j];
				int index = BinarySearch.search(nums,target);
				//����Ӧ��ע���±�������i��������ظ�ͳ��
				if(index > i) {
					cnt++;
				}
			}
		}
		return cnt;
	}

}
