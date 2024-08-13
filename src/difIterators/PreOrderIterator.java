package difIterators;

import tree.Node;
import java.util.Stack;

// Iterador para percorrer uma árvore binária em pré-ordem (pre-order)
public class PreOrderIterator<T extends Comparable<T>> implements IteratorInterface<T> {

    private Stack<Node<T>> stack = new Stack<>(); // Uso de pilha para controlar nós

    // O construtor inicializa o iterador com a raiz da árvore, se a raiz não for nula
    public PreOrderIterator(Node<T> root) {
        if (root != null) {
            stack.push(root); // Adiciona a raiz à pilha
        }
    }

    // Verifica se ainda há nós a serem percorridos
    @Override
    public boolean hasNext() {
        return !stack.isEmpty(); // Retorna verdadeiro se a pilha não estiver vazia
    }

    // Retorna o próximo valor no percurso em pré-ordem
    @Override
    public T next() {
        // Se não houver mais nós, retorna null (alternativamente, pode-se lançar uma exceção)
        if (!hasNext()) {
            return null;
        }

        // Remove o nó do topo da pilha (último nó inserido)
        Node<T> currentNode = stack.pop();

        // Guarda o valor do nó atual para ser retornado
        T result = currentNode.getValue();

        // Adiciona o filho direito do nó atual à pilha, se existir
        if (currentNode.getRight() != null) {
            stack.push(currentNode.getRight());
        }

        // Adiciona o filho esquerdo do nó atual à pilha, se existir
        if (currentNode.getLeft() != null) {
            stack.push(currentNode.getLeft());
        }

        // Retorna o valor do nó que foi visitado
        return result;
    }
}
