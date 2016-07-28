package Solutions;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	public static void main(String[] args) {

		String res = getPermutation(8,8590);
		System.out.println(res);
		
	}
	//˼·������nextpermutation������������ֵ���
	//��Ҫ˼·���ڽ�������зֽ⣬�ֽ��Ϊ������
	
    public String getPermutation(int n, int k) {
    	
    	//���
    	StringBuilder sb = new StringBuilder();
    	List<Integer> nums = new ArrayList<Integer>();
    	//���Ƚ���һ������������Ĳ��ұ�,����������
    	int[] factorial = new int[n+1];
    	int sum = 1;
    	factorial[0] =1;
    	for(int i=1; i<=n; i++){
    		sum *= i;
    		factorial[i]=sum;
    	}
    	//�ٽ�һ�����ӵ��б�����������
    	for(int i=1; i<=n; i++){
    		nums.add(i);
    	}
    		
        //���濪ʼ������ֽ�
    	k--;//��Ϊ�����Ǵ�0��ʼ��
    	for(int i=1; i<=n; i++){
    		int index = k/factorial[n-i];
    		sb.append(String.valueOf(nums.get(index)));
    		nums.remove(index);
    		k -= index*factorial[n-i];
    	}
    	return String.valueOf(sb);//������sb.toString
    }



}
