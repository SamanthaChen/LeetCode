package JulyAlgotithm;
/*
 * 求二维数组的最大子数组之和
 * http://www.acmerblog.com/max-sum-rectangle-in-a-matrix-5955.html
 * **/
public class MaxSuminMatrix {

	public static void main(String[] args) {
		int arr[][] = {{1, 2, -1, -4, -20},
	                   {-8, -3, 4, 2, 1},
	                   {3, 8, 10, 1, 3},
	                   {-4, -1, 1, 7, -6}};

		int ans = maxArrSum(arr);
		System.out.println("method 1: " + ans);
		ans = maxArrSum2(arr);
		System.out.println("method 2: " + ans);
	}
	/*
	 * 方法1： 穷举
	 * O(m^2 * n^2)时间
	 * **/
	public static int[][] arrSum(int arr[][]){
		int m = arr.length;
		int n = arr[0].length;
		int p[][] = new int[m+1][n+1];
		p[0][0] = arr[0][0];
		for(int i=0; i<=m; i++) p[i][0] = 0;
		for(int i=0; i<=n; i++) p[0][i] = 0;
		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				p[i][j] = p[i-1][j] + p[i][j-1] + arr[i-1][j-1] - p[i-1][j-1];
			}
		}
		return p;
	}
	//遍历所有二维数组的矩形区域
	public static int  maxArrSum(int arr[][]){
		int m = arr.length;
		int n = arr[0].length;
		int p[][] = arrSum(arr);
		int ans = Integer.MIN_VALUE;
		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				for(int endi=i; endi <=m; endi++){
					for(int endj=j; endj<=n; endj++){
						int sum = p[endi][endj] - p[i-1][endj] - p[endi][j-1] + p[i-1][j-1];
						if(ans < sum) ans = sum;
					}
				}
			}
		}
		return ans;
	}
	
	/**
	 * 方法2： 转化为一维数组计算
	这里并不是把整个二维数组转化为一维的，而是说把部分连续的行合并，看成是一行计算。
	这样枚举所有连续的行，把这些连续的行看成是一个整体，把一列看成是一个数字，问题就转化为上面的一维数组的算法了。
	还可以采用上面的预处理方法，在O（1）的时间内计算出任意一列的和。
	代码如下，colSum函数即为预处理函数，我们还可以根据M，N的大小做些优化。算法的复杂度为 O(N * M * min(M,N) ).
	 * **/
	//跟求一维数组的最大连续和思路是一样的
	//计算的是startline到endline之间所有列的最大子数组和
	static int maxSum(int p[][], int startLine,int endLine,int n){
		int ans = p[endLine][1] - p[startLine-1][1]; //即第一个列(startLine行到endLine行)的和
		int cmax = ans;
		for(int i=2; i<=n; i++){
			int ci = p[endLine][i] - p[startLine-1][i];
			cmax = Math.max(cmax+ci, ci);//局部最大
			ans = Math.max(cmax, ans);//全局最大
		}
		//System.out.println(startLine + " " + endLine + " " +ans);
		return ans;
	}
	
    //计算列的和
	static int[][] colSum(int arr[][]){
		int m = arr.length;
		int n = arr[0].length;
		int  p[][] = new int[m+1][n+1];
		for(int i=1; i<=m; i++)
			for(int j=1; j<=n; j++)
				p[i][j] = p[i-1][j] + arr[i-1][j-1];
		return p;
	}

	static int maxArrSum2(int arr[][]){
		int m = arr.length;
		int n = arr[0].length;
		if(m > n){
			//对数组进行逆置
			arr = reverseArr(arr);
			int tmp = m;
			m = n;
			n = tmp;
		}
		int p[][] = colSum(arr);
		int tempMax = Integer.MIN_VALUE;

		//h表示当前矩阵的高度. 即把多少行合并为一行看
		for(int h=1; h<=m; h++){
			for(int i=1; i+h-1 <= m; i++){
				int endLine = i+h-1;
				//转化为长度为n一维数组，复杂度为O(n)
				tempMax = Math.max(tempMax, maxSum(p, i, endLine, n));
			}
		}
		return tempMax;
	}

	static int[][] reverseArr(int arr[][]){
		int m = arr.length;
		int n = arr[0].length;
		int newArr[][] = new int[n][m];
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				 newArr[j][i] = arr[i][j];
		return newArr;
	}


}
