import java.util.ArrayList;

public class Administrador {

    private ArrayList<Consumible> colacionesGlobales;
    private ArrayList<Consumible> bebidasGlobales;

    private static Administrador instance = null;

    public static Administrador getInstance(){
        if (instance == null)
            instance = new Administrador();
        return instance;
    }

    private Administrador(){
        this.bebidasGlobales = new ArrayList<>();
        this.colacionesGlobales = new ArrayList<>();
    }

    public void allowColacion(Consumible colaciones){
        this.colacionesGlobales.add(colaciones);
    }   

    public void allowBebida(Consumible bebidas){
        this.bebidasGlobales.add(bebidas);
    }


    public boolean isColacionPermited(String comida){
        boolean flag = false;
        for (Consumible c : colacionesGlobales){
            if (c.getDescripcion().equals(comida)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean isBebidaPermited(String bebida){
        boolean flag = false;
        for (Consumible c : bebidasGlobales){
            if (c.getDescripcion().equals(bebida)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void generarReporte(Plan p){
        System.out.println("El plan ha finalizado con calificacion: "+p.getCalificacion());
        System.out.println("Sus observaciones: "+p.getObservaciones());
    }

    public void allowUser(Usuario u){
        u.setHabilitado(true);
    }
}
