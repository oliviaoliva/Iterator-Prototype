package difIterators;

import tree.Node;
import java.util.Stack;

// Iterador para percorrer uma árvore binária de busca em ordem (in-order)
public class InOrderIterator<T extends Comparable<T>> implements IteratorInterface<T> {

    private Stack<Node<T>> stack = new Stack<>();  // Pilha para armazenar os nós durante o percurso
    private Node<T> currentNode;  // Nó atual sendo processado

    // Construtor que inicializa o iterador com a raiz da árvore
    public InOrderIterator(Node<T> root) {
        currentNode = root;
    }

    // Método para verificar se ainda há nós para serem percorridos
    @Override
    public boolean hasNext() {
        return !stack.isEmpty() || currentNode != null;
    }

    // Método para retornar o próximo valor no percurso em ordem (in-order)
    @Override
    public T next() {
        // Continua empilhando os nós da subárvore esquerda
        while (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.getLeft();
        }

        // Desempilha o nó mais à esquerda (nó mínimo da subárvore atual)
        Node<T> node = stack.pop();

        // O próximo nó a ser processado será o filho direito do nó atual
        currentNode = node.getRight();

        // Retorna o valor do nó desempilhado (nó atual do percurso)
        return node.getValue();
    }
}
