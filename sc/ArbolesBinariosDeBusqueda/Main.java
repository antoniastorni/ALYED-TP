package ArbolesBinariosDeBusqueda;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree <Estudiante> a = new BinarySearchTree
                <Estudiante>();
        try{
            Estudiante e =new Estudiante("I004", "Gonzalez");
            a.insert(e);
            a.insert(new Estudiante("D022", "Lettera"));
            a.insert(new Estudiante("I014", "Alvarez"));
            a.insert(new Estudiante("E023", "Schmit"));
            a.insert(new Estudiante("O105", "Oberman"));

            if (a.exists(new Estudiante("A023")))
                System.out.println("existe");
            else
                System.out.println("no existe");
            (new ArBinApi<Estudiante>()).inorden(a);
        }catch(TreeIsEmptyException e){
            e.getMessage();
        }catch(ElementBelongsToTreeException e){
            e.getMessage();
        }


    }

}
