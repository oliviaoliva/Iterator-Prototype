import difIterators.IteratorInterface;
import tree.BinarySearchTree;

public class MainIterator {

    public static void main(String[] args) {
        // Cria uma nova instância de uma árvore binária de busca (BinarySearchTree)
        // com a raiz inicializada com o valor 8.
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(8);

        // Preenche a árvore com diversos valores, adicionando-os de forma que mantenha
        // a propriedade de uma árvore binária de busca (menores à esquerda, maiores à direita).
        populateTree(bst);

        // Realiza e Mostra as travessias (percurso) em diferentes ordens:
        // Pré-ordem, Em ordem, Pós-ordem e Ordem por nível (BFS).
        performTraversal("Pre-order traversal:", bst, "Pre");
        performTraversal("In-order traversal:", bst, "In");
        performTraversal("Post-order traversal:", bst, "Post");
        performTraversal("Level-order traversal:", bst, "Level");

        // Clona a árvore binária de busca original
        System.out.println("\nCriando clone..........");
        BinarySearchTree<Integer> clone = bst.clone();
        System.out.println("Clone criado!\n");

        // Realiza o percurso pré-ordem no clone da árvore e Mostra os resultados.
        performTraversal("Clone pré-ordem:", clone, "Pre");

        // Adiciona um novo valor (2000) ao clone da árvore e Mostra a estrutura modificada.
        System.out.println("Adicionando nó 2000 no clone...");
        clone.add(2000);
        System.out.println("Nó adicionado!\n");

        // Mostra a travessia pré-ordem da árvore clonada após a adição do novo valor.
        performTraversal("Clone pré-ordem:", clone, "Pre");

        // Mostra novamente a travessia pré-ordem da árvore original para mostrar que ela não foi modificada pelo clone.
        performTraversal("Original pré-ordem:", bst, "Pre");

        // Realiza as travessias pós-ordem, em ordem e em nível da árvore clonada.
        performTraversal("Clone pós-ordem:", clone, "Post");
        performTraversal("Clone em-ordem:", clone, "In");
        performTraversal("Clone level-ordem:", clone, "Level");
    }

    // Aqui fiz um método auxiliar para popular a árvore com valores predefinidos.
    private static void populateTree(BinarySearchTree<Integer> bst) {
        // Lista de valores a serem inseridos na árvore
        int[] values = {15, 8, 25, 5, 12, 35, 1, 3, 6, 9, 11, 20, 30, 2, 7, 10, 14, 18, 22, 27};
        for (int value : values) {
            // Adiciona cada valor à árvore.
            bst.add(value);
        }
    }

    // Método auxiliar para realizar e exibir diferentes tipos de travessia na árvore.
    private static void performTraversal(String message, BinarySearchTree<Integer> tree, String traversalType) {
        // Mostra uma mensagem de título para a travessia.
        System.out.println(message);
        // Cria um iterador baseado no tipo de travessia solicitado (pré-ordem, em ordem, etc.).
        IteratorInterface<Integer> iterator = tree.createIterator(traversalType);
        // Percorre todos os elementos da árvore na ordem definida pelo iterador e os imprime.
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        // Adiciona uma nova linha ao final da saída da travessia.
        System.out.println();
    }
}
