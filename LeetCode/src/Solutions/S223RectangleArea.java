package Solutions;

public class S223RectangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //注意看题目啊，是求覆盖的面积，不是交叉的面积
        //应该包含三种情况：1.交叉 2.包含 3.不相交
        int area1 = (A-C)*(B-D);
        int area2 = (E-G)*(F-H);
        
        //求交叉的面积 (方法1)
        // int width;
        // int height;
        // int overlaparea ;
        // //不相交时
        // if( C<=E || G<=A || D<=F  || H<=B) overlaparea = 0;
        // else{
        //     //相交或者包含都是取中间两个的坐标
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
        
        //方法2
         int left = Math.max(A,E);
         int right = Math.min(C,G);
         int top = Math.min(D,H);
         int bottom = Math.max(B,F);
         
         int overlap = 0;
         //假设存在重叠
         if(left<right && bottom<top) overlap = (right-left)*(top-bottom);
         return area1+area2-overlap;
        
         
    }

}
