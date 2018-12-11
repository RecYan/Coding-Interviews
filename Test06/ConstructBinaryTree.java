package Test06;

/**
 * Created by Yan_Jiang on 2018/12/11.
 *
 * 题目：
 * 输入某二叉树的前序遍历和中序遍历的结果，请重新构造出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中不包含重复的数字。
 * 例如输入的前序遍历序列为｛1，2，4，7，3，5，6，8｝和中序遍历为{4,7,2,1,5,3,6,8},则重建出二叉树并输出它的头结点。
 *
 * 思路：
 * 前序确定根节点的值 中序确定根节点左右子树的序列值
 * 然后使用递归 重建二叉树
 */
public class ConstructBinaryTree {

    //二叉树节点定义
    public static class BinaryTreeNode {
        int value; //节点值
        BinaryTreeNode leftNode; //左子树
        BinaryTreeNode rightNode; //右子树

        public BinaryTreeNode(int value){
            this.value = value;
        }
    }

    /**
     *
     * @param preOrder 前序遍历数组
     * @param inOrder 中序遍历数组
     * @param length 数组长度
     * @return 根(头)节点
     */
    public static BinaryTreeNode construct(int[] preOrder, int[] inOrder, int length) {
        // 输入参数合法性判断
        if (preOrder == null || inOrder == null || length < 0) {
            return null;
        }

        //重建二叉树核心代码
        try {
            return ConstructCore(preOrder, 0, preOrder.length - 1, inOrder, 0,inOrder.length - 1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 重建二叉树
     * @param preOrder 前序遍历数组
     * @param startPreIndex 前序初始位置
     * @param endPreIndex 前序结束位置
     * @param inOrder 中序遍历数组
     * @param startInIndex 中序初始位置
     * @param endInIndex 中序结束位置
     * @return 根(头)节点
     */
    public static BinaryTreeNode ConstructCore(int[] preOrder,int startPreIndex, int endPreIndex,
                                               int[] inOrder,int startInIndex, int endInIndex) throws Exception {

        int rootValue = preOrder[startPreIndex]; //前序遍历的第一个位置为根节点的值
        BinaryTreeNode root = new BinaryTreeNode(rootValue);

        // 序列中只有一个元素 前序-->中序
        if (startPreIndex == endPreIndex) {
            if (startInIndex == endInIndex
                    && preOrder[startPreIndex] == inOrder[startInIndex]) {
                return root;
            } else {
                throw new Exception("输入参数不合法");
            }
        }

        //在中序序列中寻找根节点
        int rootInIndex = startInIndex;
        while (rootInIndex <= endInIndex && inOrder[rootInIndex] != rootValue) {
            rootInIndex ++;
        }
        //中序数组中没有找到
        if (rootInIndex == endInIndex && inOrder[rootInIndex] != rootValue) {
            throw new Exception("中序序列中没有根节点");
        }
        //中序序列中找到了根节点
        int leftLength = rootInIndex - startInIndex; //中序 左子树的元素个数
        int leftPreOrderEndIndex = startPreIndex + leftLength; //左子树元素 对应前序序列 结束位置
        if (leftLength > 0) {
            // 构建左子树
            root.leftNode = ConstructCore(preOrder, startPreIndex + 1,
                    leftPreOrderEndIndex, inOrder, startInIndex,
                    rootInIndex - 1);
        }

        if (leftLength < endPreIndex - startPreIndex) { //
            // 构建右子树
            root.rightNode = ConstructCore(preOrder, leftPreOrderEndIndex + 1,
                    endPreIndex, inOrder, rootInIndex + 1, endInIndex);
        }
        return root;

    }

    //前序二叉树遍历打印
    public static void printPreOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.value + " ");
        }
        if (root.leftNode != null) {
            printPreOrder(root.leftNode);
        }
        if (root.rightNode != null) {
            printPreOrder(root.rightNode);
        }
    }




    public static void main(String[] args) {

        int[] preOrder={1,2,4,7,3,5,6,8};
        int[] inOrder={4,7,2,1,5,3,8,6};
        printPreOrder(construct(preOrder, inOrder, preOrder.length));

    }




}
