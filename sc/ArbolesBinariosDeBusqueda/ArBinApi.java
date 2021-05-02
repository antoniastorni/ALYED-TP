package ArbolesBinariosDeBusqueda;

public class ArBinApi <T> {
    public void inorden (BinarySearchTree <T> a)throws TreeIsEmptyException{
        if (!a.isEmpty()){
            inorden(a.getLeft());
            System.out.println(((Estudiante) a.getRoot()).getMatricula() +
                    " " +((Estudiante) a.getRoot()).getApellido());
            inorden(a.getRight());
        }
    }

    public void inordenOrganism (BinarySearchTree <T> a)throws TreeIsEmptyException{
        if (!a.isEmpty()){
            inordenOrganism(a.getLeft());
            System.out.println("Code: " + ((Organism) a.getRoot()).getCode() +
                    "\nType: " + ((Organism) a.getRoot()).getType() +
                    "\nDescription: " + ((Organism) a.getRoot()).getDescription() +
                    "\nSize: " + ((Organism) a.getRoot()).getSize() + "\n");
            inordenOrganism(a.getRight());
        }
    }
}
