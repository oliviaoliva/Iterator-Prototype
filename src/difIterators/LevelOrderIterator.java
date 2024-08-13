package difIterators;

import tree.Node;
import java.util.LinkedList;
import java.util.Queue;

// Iterador para percorrer uma árvore binária de busca em ordem de nível (level-order)
public class LevelOrderIterator<T extends Comparable<T>> implements IteratorInterface<T> {

    private Queue<Node<T>> queue = new LinkedList<>();  // Fila para armazenar os nós durante o percurso

    public LevelOrderIterator(Node<T> root) {
        if (root != null) {
            queue.offer(root);  // Adiciona a raiz à fila se ela não for nula
        }
    }

    // Método para verificar se ainda há nós para serem percorridos
    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    // Método para retornar o próximo valor no percurso em ordem de nível (level-order)
    @Override
    public T next() {
        // Verifica se há elementos para percorrer, caso não haja retorna null
        if (!hasNext()) {
            return null;
        }

        // Remove o nó da frente da fila (First in first out)
        Node<T> currentNode = queue.poll();

        // Armazena o valor do nó atual para ser retornado
        T result = currentNode.getValue();

        // Adiciona o filho esquerdo do nó atual à fila se não for null
        if (currentNode.getLeft() != null) {
            queue.offer(currentNode.getLeft());
        }

        // Adiciona o filho direito do nó atual à fila se não for null
        if (currentNode.getRight() != null) {
            queue.offer(currentNode.getRight());
        }

        // Retorna o valor do nó atual
        return result;
    }
}
