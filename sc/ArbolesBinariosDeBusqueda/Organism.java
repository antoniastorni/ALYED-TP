package ArbolesBinariosDeBusqueda;

public class Organism implements Comparable<Organism>{
    private final String code;
    private final String type;
    private final String description;
    private final int size;


    public Organism(String code, String type, String description, int size) {
        this.code = code;
        this.type = type;
        this.description = description;
        this.size = size;
    }

    @Override
    public int compareTo(Organism o) {
        return this.code.compareTo(o.code);
    }

    public String getCode() {
        return code;
    }
}
