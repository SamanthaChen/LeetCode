package Solutions;

public class S278FirstBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int firstBadVersion(int n) {
        //˼�룺���ö��ֲ���
        int left = 1;
        int right = n;
        while(left<right){
            int mid = left+(right-left)/2;
            if(!isBadVersion(mid)) left = mid+1;
            else right = mid;
        }
        return left;
        
    }

}
