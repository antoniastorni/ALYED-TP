package ArbolesBinariosDeBusqueda;

import TpComparacion.AVLTree;
import TpComparacion.ElementBelongsToTreeException;
import TpComparacion.ElementdontexistException;
import TpComparacion.TreeIsEmptyException;

import java.util.ArrayList;

public class MainOrganism {
    public static void main(String[] args) {
        ArrayList<Organism> array = new ArrayList<>();
        array.add(new Organism("ASDEW", "Bacteria", "fkjflwe", 23));
        array.add(new Organism("SDASW", "Bacteria", "fkjflwe", 23));
        array.add(new Organism("SDDEW", "Bacteria", "fkjflwe", 23));
        array.add(new Organism("ZEDEW", "Bacteria", "fkjflwe", 23));
        array.add(new Organism("OMGFD", "Bacteria", "fkjflwe", 23));

        try {
            OrganismABM abm = new OrganismABM();
            AVLTree<Organism> tree = abm.fromListToTree(array);
            Organism organism = new Organism("HADEW", "Bacteria", "fkjflwe", 23);
            abm.sortedInform(tree);
            System.out.println("\n");
            abm.insertNewOrganism(organism, tree);
            abm.sortedInform(tree);
            System.out.println("\n");
            abm.deleteOrganism(organism, tree);
            abm.sortedInform(tree);
            System.out.println("\n");
        } catch (ElementBelongsToTreeException | TreeIsEmptyException | ElementdontexistException e) {
            System.out.println(e.getMessage());
        }
    }
}
