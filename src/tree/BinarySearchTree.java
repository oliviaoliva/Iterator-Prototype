package tree;


import factories.IteratorFactory;
import difIterators.*;

public class BinarySearchTree<T extends Comparable<T>> implements Tree {
    private Node<T> root;

    public BinarySearchTree( T value) {
        this.root = new Node<T>(value);
    }

    public T getRoot(){
        return (T) (root != null? root.value : null);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public IteratorInterface<T> createIterator(String type) {
        IteratorFactory factory = new IteratorFactory();
        return factory.createIterator(type, this.root);
    }

    public BinarySearchTree<T> clone() {
        IteratorInterface<T> originalIterator = this.createIterator("Pre");
        BinarySearchTree<T> clone = new BinarySearchTree<>(originalIterator.next());

        while(originalIterator.hasNext()) {
            clone.add(originalIterator.next());
        }

        return clone;
    }

    public T search(T value)
    {
        if (! isEmpty()) {
            Node<T> node = search(root, value);
            return node != null ? node.value: null;
        } else
            return null;
    }

    private Node<T> search(Node<T> root, T key)
    {

        // if the data being searched for is less than the value of the current root's data,
        // check if the data exists in the current root's left sub-tree
        if ( root == null) {
            return null;
        } else if (key.compareTo(root.value) < 0) {
            return search(root.left, key);
        } else if ( key.compareTo(root.value) > 0){
            return search(root.right, key);
        } else
            return root;

    }

    public boolean contains(T key)
    {
        return contains(root, key);
    }

    private boolean contains(Node<T> root, T key)
    {
        if (root == null)
            return false;

        else if (key.compareTo(root.value) < 0)
            return contains(root.left, key);
        else if (key.compareTo(root.value) > 0)
            return contains(root.right, key);
        else
            return true;
    }

    public void add( T value) {
        this.root = addRecursive(this.root, value);
    }

    private Node<T> addRecursive(Node<T> root, T value) {
        // if tree is empty
        if (root == null) {
            return new Node<T>(value);
        } else if (value.compareTo(root.value) < 0) {
            root.left = addRecursive(root.left, value);
        } else if (value.compareTo(root.value) > 0 ) {     //insert in the left subtree
            root.right = addRecursive(root.right, value);
        } else {
            return root;
        }
        return root;
    }

    public T delete(T key)
    {

        T node =  search( key);
        if (node != null) {
            this.root = delete(root, key);
            return node;
        } else
            return null;
    }

    private Node<T> delete(Node<T> root, T data)
    {
        // if the root node is null, then either there's nothing to delete or no more traversal is necessary
        if (root == null)
            return null;

            // if the value of the data being searched for is less than the value of the current root node, then
            // traverse to the left node of the current root, setting the current left node to whatever gets returned
            // from the delete method
        else if (data.compareTo(root.value) < 0 )
        {
            root.left = delete(root.left, data);
        }
        // if the value of the data being searched for is greater than the value of the current root node, then
        // traverse to the right node of the current root, setting the current right node to whatever gets returned
        // from the delete method
        else if (data.compareTo(root.value) > 0)
        {
            root.right = delete(root.right, data);
        }
        // this else statement means that the data being searched for is equal to the current root, meaning that
        // we've found the node we wish to delete
        else
        {
            // if the node has no children, then return a value of null
            if (root.left == null && root.right == null)
            {
                return null;
            }
            // if the node has a left child, but no right child, then return the left child
            else if (root.right == null)
            {
                return root.left;
            }
            // if the node has a right child, but no left child, then return the right child
            else if (root.left == null)
            {
                return root.right;
            }
            // if the node has two children, then set the node's data to be the largest element
            // in the left sub-tree of the node, and then set the left child's data to be equal to
            // whatever data is returned when deleting the new root data from the left sub-tree
            // (i.e., the data that is currently set in the left child)
            else
            {
                root.value = findMax(root.left);
                root.left = delete(root.left, root.value);
            }
        }

        return root;
    }

    // This method assumes root is non-null, since this is only called by
    // delete() on the left subtree, and only when that subtree is non-empty.
    private T findMax(Node<T> root)
    {
        // simply continue traversing to the right until you can't go no mo', and then you've found
        // the largest element
        while (root.right != null)
        {
            root = root.right;
        }

        return root.value;
    }

    public void preorder()
    {
        System.out.print("Pre-order Traversal:");
        preorder(root);
        System.out.println();
    }

    private void preorder(Node<T> root)
    {
        if (root == null)
            return;

        System.out.print(" " + root.value);
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder()
    {
        System.out.print("In-order Traversal:");
        inorder(root);
        System.out.println();
    }

    private void inorder(Node<T> root)
    {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(" " + root.value);
        inorder(root.right);
    }

    public void postorder()
    {
        System.out.print("Post-order Traversal:");
        postorder(root);
        System.out.println();
    }
    private void postorder(Node<T> root)
    {
        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(" " + root.value);
    }

    public int size() {
        return size(root);
    }
    public int size(Node<T> root) {
        if (root == null)
            return 0;
        else
            return 1 + size(root.left) + size(root.right);

    }


}