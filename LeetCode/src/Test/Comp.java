package Test;
/**  
 * 输入两个整数 n 和 m，从数列1，2，3.......n 中 随意取几个数,  
    使其和等于 m ,要求将其中所有的可能组合列出来.  
      
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
            System.out.println("不存在该数！");  
        }else{  
            for(int i=1;i<=m/2;i++){  
                //从1开始计数，打印出两个数的组合，并且两数不相等  
                if(i != m-i)  
                    System.out.println(pre+i+"+"+(m-i));  
                //调用递归，继续求得大于2个数的组合  
                getTheResult(m-i,pre+i,i);  
            }  
        }  
    }  
    //调用递归，继续求得大于2个数的组合,j为组合中已用过的数，所以取大于该数的。  
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