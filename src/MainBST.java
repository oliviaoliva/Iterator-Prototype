import tree.BinarySearchTree;

public class MainBST {
    public static void main(String args[]) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(50);
        System.out.println("Root:" + bst.getRoot());
        System.out.println("Size:" + bst.size());

        System.out.println("Delete 50:" + bst.delete(50));
        System.out.println("Root:" + bst.getRoot());


        bst.add(30);
        bst.add(80);
        bst.add(20);
        bst.add(95);
        bst.add(90);
        bst.preorder();
        bst.inorder();
        bst.postorder();

        System.out.println("Search 90: " + bst.search(90));
        System.out.println("Contains 80: " + bst.contains(80));

        System.out.println("Delete 50:" + bst.delete(50));
        System.out.println("Root:" + bst.getRoot());

        System.out.println("Size:" + bst.size());

    }
}
