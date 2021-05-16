package ArbolesBinariosDeBusqueda;

import TpComparacion.AVLTree;
import TpComparacion.ElementBelongsToTreeException;
import TpComparacion.ElementdontexistException;
import TpComparacion.TreeIsEmptyException;

import java.util.ArrayList;

public class OrganismABM {

    public void insertNewOrganism(Comparable<Organism> organism, AVLTree<Organism> a) throws ElementBelongsToTreeException {
        a.insert(organism);
    }

    public void deleteOrganism(Comparable<Organism> organism, AVLTree<Organism> a) throws ElementdontexistException {
        a.delete(organism);
    }

    public AVLTree<Organism> fromListToTree(ArrayList<Organism> list) throws ElementBelongsToTreeException {
        AVLTree<Organism> tree = new AVLTree<>();
        for (int i = 0; i < list.size(); i++) {
            tree.insert(list.get(i));
        }
        return tree;
    }

    public void sortedInform(AVLTree<Organism> a) throws TreeIsEmptyException {
        ArBinApi<Organism> b = new ArBinApi<>();
        b.inordenOrganism(a);
    }

    public void modifyDescriptionOfOrganism(Comparable<Organism> organism, AVLTree<Organism> a, String newDescription) throws ElementBelongsToTreeException {
        if (a.exists(organism)) {
            a.search(organism).setDescription(newDescription);
        }
    }

    public void modifySizeOfOrganism(Comparable<Organism> organism, AVLTree<Organism> a, int newSize) throws ElementBelongsToTreeException {
        if (a.exists(organism)) {
            a.search(organism).setSize(newSize);
        }
    }
    public void modifyTypeOfOrganism(Comparable<Organism> organism, AVLTree<Organism> a, String newType) throws ElementBelongsToTreeException {
        if (a.exists(organism)) {
            a.search(organism).setType(newType);
        }
    }
}
