package Solutions;

import java.util.List;

import DataStructual.TreeNode;

public class ContructBinaryTreefromPreorder {

	public static void main(String[] args) {

		int[] pre = { 1, 2, 4, 5, 10, 11, 3, 6, 13, 7 };
		int[] in = { 4, 2, 10, 5, 11, 1, 6, 13, 3, 7 };

		// int[] pre = { 3, 2, 8, 7, 9, 5, 6, 4, 0, 1 };
		// int[] in = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		TreeNode root = buildTree(pre, in);

		List<Integer> prelist = BinaryTreePreorderTravelsal.preorderTraversal(root);
		System.out.println("���������");
		prelist.forEach(e -> {
			System.out.print(e + " ");
		});
		System.out.println("");

		List<Integer> inlist = BinaryTreeInorderTravelsal.inorderTraversal(root);
		System.out.println("���������");
		inlist.forEach(e -> {
			System.out.print(e + " ");
		});
		System.out.println("");

	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {

		return helper(0, 0, inorder.length - 1, preorder, inorder);

	}

	// ��Ҫ�������֣�prestart ȷ������inorder�е�λ�ã�Ȼ��inorder �ʿ�
	// �������������Ȼ���ٶ����������ݹ齨��������˻���Ҫ�������������ֱ�ķ�Χ
	// instart��inend
	public static TreeNode helper(int prestart, int instart, int inend, int[] preorder, int[] inorder) {
		// �ݹ��������
		if (prestart > preorder.length - 1 || instart > inend)
			return null;
		TreeNode root = new TreeNode(preorder[prestart]);
		// �ҵ����ڵ���inorder�ж�Ӧ��λ��
		int i = 0;
		for (; i < inorder.length; i++) {
			if (inorder[i] == preorder[prestart])
				break;
		}
		root.left = helper(prestart + 1, instart, i - 1, preorder, inorder);
		// ��������ʼλ��Ӧ��=��������ʼλ��+����������
		root.right = helper(prestart + 1 + i - instart, i + 1, inend, preorder, inorder);
		return root;
	}

}