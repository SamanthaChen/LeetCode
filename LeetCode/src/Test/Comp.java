package Test;
/**  
 * ������������ n �� m��������1��2��3.......n �� ����ȡ������,  
    ʹ��͵��� m ,Ҫ���������еĿ�������г���.  
      
    e.g   
    n=6,m=6   1,2,3    2,4    1,5  
    n=  
 * @author wangxm  
 */  
public class Comp {  
    static void getAllComp(int n,int m){  
        String pre = m+"=";  
        int theMax = (1+n)*n/2;  
        if(theMax<m){  
            System.out.println("�����ڸ�����");  
        }else{  
            for(int i=1;i<=m/2;i++){  
                //��1��ʼ��������ӡ������������ϣ��������������  
                if(i != m-i)  
                    System.out.println(pre+i+"+"+(m-i));  
                //���õݹ飬������ô���2���������  
                getTheResult(m-i,pre+i,i);  
            }  
        }  
    }  
    //���õݹ飬������ô���2���������,jΪ��������ù�����������ȡ���ڸ����ġ�  
    static void getTheResult(int m,String pre,int j){  
        for(int i=j+1;i<=m/2;i++){  
            if(i != m-i)  
                System.out.println(pre+"+"+i+"+"+(m-i));  
            getTheResult(m-i,pre+"+"+i,i);  
        }  
    }  
      
    public static void main(String[] args) {  
        getAllComp(20,10);  
    }  
}  