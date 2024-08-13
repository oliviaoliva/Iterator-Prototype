package factories;

import difIterators.IteratorInterface;
import difIterators.*;
import tree.Node;

// Fábrica responsável por criar iteradores para percorrer uma árvore binária com base no tipo de percurso desejado
// Sendo eles: (pre order),(in order),(post order) e (level order)
public class IteratorFactory<T extends Comparable<T>> {

    // Método que cria o iterador apropriado
    public IteratorInterface<T> createIterator(String tipo, Node<T> root) {
        return switch (tipo) {
            case "Pre" -> new PreOrderIterator<>(root);     // Cria um iterador em pré ordem
            case "In" -> new InOrderIterator<>(root);       // Cria um iterador em ordem
            case "Post" -> new PostOrderIterator<>(root);   // Cria um iterador em pós ordem
            case "Level" -> new LevelOrderIterator<>(root); // Cria um iterador em ordem de nivel
            default -> {
                throw new IllegalArgumentException("Tipo de iterador inválido: " + tipo); // Exceção para tipos inválidos
            }
        };
    }
}
