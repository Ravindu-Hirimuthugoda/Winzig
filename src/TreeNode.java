public class TreeNode{

    private String node_label;
    private TreeNode left;
    private TreeNode right;
    private int childCount;

    TreeNode(String node_label){
        this.node_label = node_label;
    }

    public void setLeftChild(TreeNode node) {
        left = node;
    }

    public void setRightChild(TreeNode node) {
        right = node;
    }

    public void setChildCount(int c) {
        childCount = c;
    }

    public void PreOrderTraverse(int indentSize){
        for(int i = 0 ; i < indentSize; i++ ) System.out.print(". ");
        System.out.print(this.node_label);
        System.out.println("("+ childCount +")");

        if(this.left != null){
            left.PreOrderTraverse(indentSize + 1);
        }

        if(this.right != null){
            right.PreOrderTraverse(indentSize);
        }
    }
}
