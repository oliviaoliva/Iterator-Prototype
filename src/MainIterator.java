import difIterators.IteratorInterface;
import tree.BinarySearchTree;

public class MainIterator {

    public static void main(String[] args) {
        // Cria uma nova instância de uma árvore binária de busca (BinarySearchTree)
        // com a raiz inicializada com o valor 8.
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(8);

        populateTree(bst);

        // Realiza e Mostra os percursos em diferentes ordens:
        // Pré-ordem, Em ordem, Pós-ordem e Ordem por nível.
        performTraversal("Pre-order: ", bst, "Pre");
        performTraversal("In-order: ", bst, "In");
        performTraversal("Post-order: ", bst, "Post");
        performTraversal("Level-order: ", bst, "Level");

        // Clona a árvore binária de busca original
        System.out.println("\nCriando clone..........");
        BinarySearchTree<Integer> clone = bst.clone();
        System.out.println("Clone criado!\n");

        // Realiza o percurso pré-ordem no clone da árvore e Mostra os resultados.
        performTraversal("Clone pré-ordem:", clone, "Pre");

        // Adiciona um novo valor (777) ao clone da árvore e Mostra a estrutura modificada.
        System.out.println("Adicionando nó 2000 no clone...");
        clone.add(777);
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

            bst.add(value); //Adiciona à árvore.
        }
    }

    // Método auxiliar para realizar e exibir diferentes tipos de travessia na árvore.
    private static void performTraversal(String message, BinarySearchTree<Integer> tree, String traversalType) {
        System.out.println(message);
        // Cria um iterador baeasdo no tipo.
        IteratorInterface<Integer> iterator = tree.createIterator(traversalType);
        // Percorre todos os elementos da árvore na ordem definida pelo iterador e os imprime.
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        // Adiciona uma nova linha ao final da saída da travessia.
        System.out.println();
    }
}
