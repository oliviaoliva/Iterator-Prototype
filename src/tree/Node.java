package tree;


/**
 * Classe Node com o parâmetro genérico T que estende Comparable<T>. Isso significa que
 * o tipo T deve ser comparável a si mesmo, permitindo que os nós sejam organizados de acordo
 * com seus valores.
 * @param <T>
 */
public class Node<T extends Comparable<T>> implements Prototype<Node<T>> {
    T value;
    Node<T> left;
    Node<T> right;

    // Construtor padrão
    Node(T value) {
        this.value = value;
        right = null;
        left = null;
    }

    // Construtor de cópia (privado)
    private Node(Node<T> otherNode) {
        this.value = otherNode.value;
        if (otherNode.left != null) {
            this.left = new Node<>(otherNode.left);
        }
        if (otherNode.right != null) {
            this.right = new Node<>(otherNode.right);
        }
    }

    // Implementação do método getClone da interface Prototype
    @Override
    public Node<T> getClone() {
        return new Node<>(this);
    }

    // Getter para o valor
    public T getValue() {
        return value;
    }

    // Getter para o nó esquerdo
    public Node<T> getLeft() {
        return left;
    }

    // Getter para o nó direito
    public Node<T> getRight() {
        return right;
    }

    // Método toString
    public String toString() {
        return value.toString();
    }

    // Método compareTo
    public int compareTo(Node<T> otherNode) {
        return this.value.compareTo(otherNode.value);
    }
}
