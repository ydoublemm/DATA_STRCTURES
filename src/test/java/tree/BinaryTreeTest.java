package tree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yemingming on 2020-01-23.
 */
public class BinaryTreeTest {

	/*
		./二叉树.png
	 */
	public static TreeNode<Integer> init(){
		TreeNode<Integer> root = new TreeNode<>();
		root.setVal(1);
		BinaryTree operate = new BinaryTree();

		TreeNode<Integer> leftSon1 = operate.addLeft(root, 2);
		TreeNode<Integer> rightSon1 = operate.addRight(root, 3);

		TreeNode<Integer> leftSon2 = operate.addLeft(leftSon1, 4);
		TreeNode<Integer> rightSon2 = operate.addRight(leftSon1, 5);

		TreeNode<Integer> leftSon3 = operate.addLeft(rightSon2, 8);



		TreeNode<Integer> leftSon4 = operate.addLeft(rightSon1, 6);
		TreeNode<Integer> rightSon4 = operate.addRight(rightSon1, 7);

		TreeNode<Integer> rightSon5 = operate.addRight(leftSon4, 9);
		TreeNode<Integer> leftSon6 = operate.addLeft(rightSon5, 10);
		TreeNode<Integer> rightSon6 = operate.addRight(rightSon5, 11);

		return root;
	}

	@Test
	public void preOrder() {
		BinaryTree operate = new BinaryTree();

		TreeNode<Integer> root = init();

		System.out.println("前序遍历递归");
		operate.preOrderRecursive(root);

		System.out.println("\n--------");
		System.out.println("前序遍历非递归");
		operate.preOrder(root);

		System.out.println("\n--------");
		System.out.println("中序遍历递归");
		operate.inOrderRecursive(root);

		System.out.println("\n--------");
		System.out.println("中序遍历非递归");
		operate.inOrder(root);

		System.out.println("\n--------");
		System.out.println("后序遍历递归");
		operate.postOrderRecursive(root);

		System.out.println("\n--------");
		System.out.println("后序遍历非递归");
		operate.postOrder(root);


	}





}