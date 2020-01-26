package tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by yemingming on 2020-01-23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode<T> {
	T val;

	TreeNode<T> left;

	TreeNode<T> right;




}
