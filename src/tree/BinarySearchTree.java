package tree;

import factories.IteratorFactory;
import difIterators.*;

public class BinarySearchTree<T extends Comparable<T>> implements Prototype<BinarySearchTree<T>> {
    private Node<T> root;

    public BinarySearchTree(T value) {
        this.root = new Node<>(value);
    }

    public BinarySearchTree() {
        this.root = null;
    }

    public T getRoot() {
        return root != null ? root.value : null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public IteratorInterface<T> createIterator(String type) {
        IteratorFactory factory = new IteratorFactory();
        return factory.createIterator(type, this.root);
    }

    @Override
    public BinarySearchTree<T> getClone() {
        BinarySearchTree<T> clone = new BinarySearchTree<>();
        cloneTree(this.root, clone);
        return clone;
    }

    private void cloneTree(Node<T> node, BinarySearchTree<T> clone) {
        if (node != null) {
            clone.add(node.value); // Adiciona o valor do nó atual na árvore clone
            cloneTree(node.left, clone);
            cloneTree(node.right, clone);
        }
    }

    public T search(T value) {
        if (!isEmpty()) {
            Node<T> node = search(root, value);
            return node != null ? node.value : null;
        } else
            return null;
    }

    private Node<T> search(Node<T> root, T key) {
        if (root == null) {
            return null;
        } else if (key.compareTo(root.value) < 0) {
            return search(root.left, key);
        } else if (key.compareTo(root.value) > 0) {
            return search(root.right, key);
        } else
            return root;
    }

    public boolean contains(T key) {
        return contains(root, key);
    }

    private boolean contains(Node<T> root, T key) {
        if (root == null)
            return false;

        else if (key.compareTo(root.value) < 0)
            return contains(root.left, key);
        else if (key.compareTo(root.value) > 0)
            return contains(root.right, key);
        else
            return true;
    }

    public void add(T value) {
        this.root = addRecursive(this.root, value);
    }

    private Node<T> addRecursive(Node<T> root, T value) {
        if (root == null) {
            return new Node<>(value);
        } else if (value.compareTo(root.value) < 0) {
            root.left = addRecursive(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = addRecursive(root.right, value);
        }
        return root;
    }

    public T delete(T key) {
        T node = search(key);
        if (node != null) {
            this.root = delete(root, key);
            return node;
        } else
            return null;
    }

    private Node<T> delete(Node<T> root, T data) {
        if (root == null)
            return null;

        else if (data.compareTo(root.value) < 0) {
            root.left = delete(root.left, data);
        } else if (data.compareTo(root.value) > 0) {
            root.right = delete(root.right, data);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                root.value = findMax(root.left);
                root.left = delete(root.left, root.value);
            }
        }

        return root;
    }

    private T findMax(Node<T> root) {
        while (root.right != null) {
            root = root.right;
        }

        return root.value;
    }

    public void preorder() {
        System.out.print("Pre-order Traversal:");
        preorder(root);
        System.out.println();
    }

    private void preorder(Node<T> root) {
        if (root == null)
            return;

        System.out.print(" " + root.value);
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder() {
        System.out.print("In-order Traversal:");
        inorder(root);
        System.out.println();
    }

    private void inorder(Node<T> root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(" " + root.value);
        inorder(root.right);
    }

    public void postorder() {
        System.out.print("Post-order Traversal:");
        postorder(root);
        System.out.println();
    }

    private void postorder(Node<T> root) {
        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(" " + root.value);
    }

    public int size() {
        return size(root);
    }

    private int size(Node<T> root) {
        if (root == null)
            return 0;
        else
            return 1 + size(root.left) + size(root.right);
    }
}
