package difIterators;

import tree.Node;
import java.util.Stack;

// Iterador para percorrer uma árvore binária em pós-ordem(post-order)
public class PostOrderIterator<T extends Comparable<T>> implements IteratorInterface<T> {

    private Stack<Node<T>> stack = new Stack<>(); //  Uso de pilha
    private Node<T> lastVisitedNode; // Mantém o controle do último nó que foi visitado

    // O construtor inicializa o iterador empurrando todos os nós mais à esquerda da árvore na pilha
    public PostOrderIterator(Node<T> root) {
        pushLeftMostNodes(root);
    }

    // Verifica se ainda há nós para visitar
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Retorna o próximo valor na travessia
    @Override
    public T next() {

        // Continua enquanto houver nós para visitar
        while (hasNext()) {
            Node<T> currentNode = stack.peek(); // Dá uma olhada no nó no topo da pilha sem removê-lo

            // Se o nó atual tiver um filho à direita e esse filho ainda não foi visitado,
            // empurra os nós mais à esquerda do filho à direita na pilha
            if (currentNode.getRight() != null && lastVisitedNode != currentNode.getRight()) {
                pushLeftMostNodes(currentNode.getRight());
            } else {
                // Se não houver mais filhos à direita, ou já os visitamos, pop da pilha e registra como último visitado
                lastVisitedNode = stack.pop();
                return lastVisitedNode.getValue(); // Retorna o valor do nó
            }
        }
        return null; // Se não houver mais nós, retorna null (pode-se lançar uma exceção aqui se preferir)
    }

    // Função auxiliar que empurra todos os nós mais à esquerda do nó dado na pilha
    private void pushLeftMostNodes(Node<T> node) {
        while (node != null) {
            stack.push(node); // Empurra o nó atual na pilha
            node = node.getLeft(); // Vai para o filho à esquerda
        }
    }
}
