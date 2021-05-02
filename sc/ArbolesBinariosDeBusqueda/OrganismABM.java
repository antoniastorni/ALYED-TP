package ArbolesBinariosDeBusqueda;

import java.util.ArrayList;

public class OrganismABM {

    public void insertNewOrganism(Comparable<Organism> organism, BinarySearchTree<Organism> a) throws ElementBelongsToTreeException {
        a.insert(organism);
    }

    public void deleteOrganism(Comparable<Organism> organism, BinarySearchTree<Organism> a) throws ElementdontexistException {
        a.delete(organism);
    }

    public BinarySearchTree<Organism> fromListToTree(ArrayList<Organism> list) throws ElementBelongsToTreeException {
        BinarySearchTree<Organism> tree = new BinarySearchTree<>();
        for (int i = 0; i < list.size(); i++) {
            tree.insert(list.get(i));
        }
        return tree;
    }

    public void sortedInform(BinarySearchTree<Organism> a) throws TreeIsEmptyException {
        ArBinApi<Organism> b = new ArBinApi<>();
        b.inordenOrganism(a);
    }
}
