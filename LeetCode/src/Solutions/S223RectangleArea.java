package Solutions;

public class S223RectangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //ע�⿴��Ŀ�������󸲸ǵ���������ǽ�������
        //Ӧ�ð������������1.���� 2.���� 3.���ཻ
        int area1 = (A-C)*(B-D);
        int area2 = (E-G)*(F-H);
        
        //�󽻲����� (����1)
        // int width;
        // int height;
        // int overlaparea ;
        // //���ཻʱ
        // if( C<=E || G<=A || D<=F  || H<=B) overlaparea = 0;
        // else{
        //     //�ཻ���߰�������ȡ�м�����������
        //     ArrayList<Integer> x = new ArrayList<Integer>();
        //     x.add(A);
        //     x.add(C);
        //     x.add(E);
        //     x.add(G);
        //     ArrayList<Integer> y = new ArrayList<Integer>();
        //     y.add(B);
        //     y.add(D);
        //     y.add(F);
        //     y.add(H);
        //     Collections.sort(x);
        //     Collections.sort(y);
        //     width = x.get(2)-x.get(1);
        //     height = y.get(2)-y.get(1);
        //     overlaparea = width*height;
        // }
 
        // return area1+area2-overlaparea;
        
        //����2
         int left = Math.max(A,E);
         int right = Math.min(C,G);
         int top = Math.min(D,H);
         int bottom = Math.max(B,F);
         
         int overlap = 0;
         //��������ص�
         if(left<right && bottom<top) overlap = (right-left)*(top-bottom);
         return area1+area2-overlap;
        
         
    }

}
