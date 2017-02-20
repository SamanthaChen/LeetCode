package Solutions;

import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        
        //�ҵĵ�һ�ֽⷨ����������ָ��ѭ���Ƚϴ�С��ӣ���������4%��
        // HashMap<Character,Integer> map =  new HashMap<Character,Integer>();
        // map.put('M',1000);
        // map.put('D',500);
        // map.put('C',100);
        // map.put('L',50);
        // map.put('X',10);
        // map.put('V',5);
        // map.put('I',1);
        // if(s == null) return 0;
        // if(s.length() == 1) return map.get(s.charAt(0));
        // //���ַ����ȴ���1
        // int res = 0;
        // for(int i = 0; i<s.length();i++ ){//��2��Ϊ�˱�֤j��������
        //     int j = i + 1;
        //     char left = s.charAt(i);
        //     //��i�Ѿ��ߵ����һ������ʱ��j�ߵ��˿�
        //     if(j == s.length()){
        //       res += map.get(left); 
        //       break;
        //     } 
        //     //��j��û�ߵ��յ�ʱ��
        //     char right = s.charAt(j);
        //     if(map.get(left) < map.get(right)) //��������ұ�С�Ǽ���
        //         res = res - map.get(left);
        //     else //�����Ǽӷ�
        //         res += map.get(left);
        // }
        // return res;
        
        //�ڶ��ֽⷨ��������ĸ�����ֵĻ���ת�������ٴ�mapȡֵ�Ƚϵ�ʱ�䣨����56%��
        int[] a = new int[26];
        a['I'-'A'] = 1;
        a['V'-'A'] = 5;
        a['X'-'A'] = 10;
        a['L'-'A'] = 50;
        a['C'-'A'] = 100;
        a['D'-'A'] = 500;
        a['M'-'A'] = 1000;
        int len = s.length();//�ַ�������
        if(s == null || len == 0) return 0;
        int res = a[s.charAt(len-1)-'A'];//��¼���һ����
        if(len == 1) return res;
        int pivot = res;//�Ƚϴ�С����
        //�Ӻ��濪ʼ�Ƚϣ���Ϊ���һ�����϶��Ǽӵ�
        for(int i = len-2; i >= 0; i-- ){
            int left = a[s.charAt(i)-'A'];
            
            if(left < pivot) 
                res  -= left;
            else //��ʹ����ȣ���Ҳ�Ǽ�
                res += left; 
            
            pivot = left;
        }
        return res;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}