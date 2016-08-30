package JulyAlgotithm;
/*
 * ���ά��������������֮��
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
	 * ����1�� ���
	 * O(m^2 * n^2)ʱ��
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
	//�������ж�ά����ľ�������
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
	 * ����2�� ת��Ϊһά�������
	���ﲢ���ǰ�������ά����ת��Ϊһά�ģ�����˵�Ѳ����������кϲ���������һ�м��㡣
	����ö�������������У�����Щ�������п�����һ�����壬��һ�п�����һ�����֣������ת��Ϊ�����һά������㷨�ˡ�
	�����Բ��������Ԥ����������O��1����ʱ���ڼ��������һ�еĺ͡�
	�������£�colSum������ΪԤ�����������ǻ����Ը���M��N�Ĵ�С��Щ�Ż����㷨�ĸ��Ӷ�Ϊ O(N * M * min(M,N) ).
	 * **/
	//����һά��������������˼·��һ����
	//�������startline��endline֮�������е�����������
	static int maxSum(int p[][], int startLine,int endLine,int n){
		int ans = p[endLine][1] - p[startLine-1][1]; //����һ����(startLine�е�endLine��)�ĺ�
		int cmax = ans;
		for(int i=2; i<=n; i++){
			int ci = p[endLine][i] - p[startLine-1][i];
			cmax = Math.max(cmax+ci, ci);//�ֲ����
			ans = Math.max(cmax, ans);//ȫ�����
		}
		//System.out.println(startLine + " " + endLine + " " +ans);
		return ans;
	}
	
    //�����еĺ�
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
			//�������������
			arr = reverseArr(arr);
			int tmp = m;
			m = n;
			n = tmp;
		}
		int p[][] = colSum(arr);
		int tempMax = Integer.MIN_VALUE;

		//h��ʾ��ǰ����ĸ߶�. ���Ѷ����кϲ�Ϊһ�п�
		for(int h=1; h<=m; h++){
			for(int i=1; i+h-1 <= m; i++){
				int endLine = i+h-1;
				//ת��Ϊ����Ϊnһά���飬���Ӷ�ΪO(n)
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
