package tree;

import apple.laf.JRSUIUtils;
import lombok.Data;
import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yemingming on 2020-01-23.
 */
@Data
public class BinaryTree {





	/*
	 * @author: ymm
	 * @date: 2020-01-23 19:32
	 * @param: [father, val]
	 * @return: tree.TreeNode<T>
	 * @Description:   增加左节点
	 */
	public  <T> TreeNode<T> addLeft(TreeNode<T> father ,T val)  {
		return addNode(father, val, true);
	}

	/*
	 * @author: ymm
	 * @date: 2020-01-23 19:32
	 * @param: [father, val]
	 * @return: tree.TreeNode<T>
	 * @Description:   增加右节点
	 */
	public <T> TreeNode<T> addRight(TreeNode<T> father ,T val) {
		return addNode(father, val, false);
	}

	/*
	 * @author: ymm
	 * @date: 2020-01-23 19:46
	 * @param: [root]
	 * @return: void
	 * @Description: 先序遍历 父 左 右
	 */
	public <T> void  preOrderRecursive(TreeNode<T> root){
		System.out.print(root.getVal() );
		if(root.getLeft() != null){
			System.out.print(" -> ");
			preOrderRecursive(root.getLeft());
		}
		if(root.getRight() != null) {
			System.out.print(" -> ");
			preOrderRecursive(root.getRight());
		}

	}

	/**
	 *  非递归 前序遍历
	 * @param root
	 * @param <T>
	 */
	public <T> void  preOrder(TreeNode<T> root){
		Stack<TreeNode<T>> stack = new Stack<>();
		TreeNode<T> p = root;

		List<TreeNode<T>> list = new ArrayList<>();

		while (p!= null || !stack.empty()){

			while (p != null){
				list.add(p);
				stack.push(p);
				p = p.getLeft();
			}

			if(!stack.empty()){
				p = stack.pop();
				p = p.getRight();
			}

		}

		System.out.print(list.get(0).getVal());
		list.stream()
			.skip(1)
			.forEach(e -> System.out.print( " -> "+e.getVal()) );
	}


	/*
	 * @author: ymm
	 * @date: 2020-01-23 19:52
	 * @param: [root]
	 * @return: void
	 * @Description: 中序遍历 左 中 右
	 */
	public <T> void  inOrderRecursive(TreeNode<T> root){
		if(root.getLeft() != null){
			inOrderRecursive(root.getLeft());
			System.out.print(" -> ");
		}
		System.out.print(root.getVal() );
		if(root.getRight() != null) {
			System.out.print(" -> ");
			inOrderRecursive(root.getRight());
		}

	}


	/**
	 * 非递归中序遍历
	 * @param root
	 * @param <T>
	 */
	public <T> void  inOrder(TreeNode<T> root){
		 ArrayList<TreeNode<T>> list = new ArrayList<>();

		 Stack<TreeNode<T>> stack = new Stack<>();

		 TreeNode<T> p = root;
		 while (p !=null || !stack.empty()){

		 	while (p != null){
		 		stack.push(p);
		 		p = p.getLeft();
			}

		 	if (!stack.empty()){
				TreeNode<T> pop = stack.pop();
				list.add(pop);
				p = pop.getRight();

			}


		 }
		System.out.print(list.get(0).getVal());
		list.stream()
				.skip(1)
				.forEach(e -> System.out.print( " -> "+e.getVal()) );


	}


	/*
	 * @author: ymm
	 * @date: 2020-01-23 19:52
	 * @param: [root]
	 * @return: void
	 * @Description: 后序遍历 左右中
	 */ 
	public <T> void  postOrderRecursive(TreeNode<T> root){
		if(root.getLeft() != null){
			postOrderRecursive(root.getLeft());
			System.out.print(" -> ");
		}
		if(root.getRight() != null) {
			postOrderRecursive(root.getRight());
			System.out.print(" -> ");
		}
		System.out.print(root.getVal() );

	}

	/**
	 * 非递归后序遍历
	 * @param root
	 * @param <T>
	 */
	public <T> void  postOrder(TreeNode<T> root){
		ArrayList<TreeNode<T>> list = new ArrayList<>();

		Stack<TreeNode<T>> stack = new Stack<>();

		TreeNode<T> p = root;

		while (p != null || !stack.empty()){

			while (p!=null){
				stack.push(p);
				p = p.getLeft();
			}

			//暂存前驱节点
			TreeNode<T> preNode = null;
			//是否不存在右节点
			boolean tag = true;
			while(!stack.empty() && tag){
				TreeNode<T> treeNode = stack.peek();
				//
				if(treeNode.getRight() == preNode ){
					TreeNode<T> pop = stack.pop();
					list.add(pop);
					if (stack.empty()){

						System.out.print(list.get(0).getVal());
						list.stream()
								.skip(1)
								.forEach(e -> System.out.print( " -> "+e.getVal()) );

						return;
					}else {
						preNode = pop;
					}


				}else {
					p = treeNode.getRight();
					tag = false;
				}
			}

		}



	}



	private  <T> TreeNode<T> addNode(TreeNode<T> father ,T val , boolean isLeft){
		TreeNode<T> node = new TreeNode<>(val, null, null);
		if(isLeft){
			father.setLeft(node);
		}else {
			father.setRight(node);
		}
		return node;
	}
}
