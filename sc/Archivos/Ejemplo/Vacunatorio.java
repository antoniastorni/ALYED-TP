package Archivos.Ejemplo;

import java.io.*;
import java.util.ArrayList;

public class Vacunatorio {
    private ArrayList<Vacuna> vacunas;
    private File f;

    public Vacunatorio() throws IOException, ClassNotFoundException{
        f = new File("datos");
        if (f.exists())
            recuperar();
        else
            vacunas = new ArrayList<Vacuna>();

    }

    public void agregar(Vacuna v){
        vacunas.add(v);
    }

    public Vacuna obtener(int i){
        return vacunas.get(i);

    }
    public int cantVacunas(){
        return vacunas.size();
    }
    public void grabar() throws IOException {

        FileOutputStream salida = new FileOutputStream(f);
        ObjectOutputStream objSeriado = new ObjectOutputStream(salida);
        objSeriado.writeObject(vacunas);
        objSeriado.close();
    }
    public void recuperar() throws IOException, ClassNotFoundException{
        FileInputStream salida = new FileInputStream(f);
        ObjectInputStream objSeriado = new ObjectInputStream(salida);
        ArrayList<Vacuna> t = (ArrayList<Vacuna>) objSeriado.readObject();
        vacunas = t;
        objSeriado.close();

    }
}
