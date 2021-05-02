package ArbolesBinariosDeBusqueda;

public class Organism implements Comparable<Organism>{
    private final String code;
    private String type;
    private String description;
    private int size;


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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
