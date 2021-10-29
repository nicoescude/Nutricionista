import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Plan {
    /** Duracion */
    public enum DURACION {
        SEMANAL (7), QUINCENAL(15), MENSUAL(30);
        private int dias;
        private DURACION(int dias){ this.dias = dias;}
        public int value(){ return this.dias; }
    }
    
    public enum CALIFICACION {
        EXCELENTE("EXCELENTE"), BUENA("BUENA"), REGULAR("REGULAR");
        private String calificacion;
        private CALIFICACION(String s){ this.calificacion = s;}
        public String value(){ return this.calificacion; }
    }

    private static final AtomicInteger idCount = new AtomicInteger();
    private int edad, duracion, idPlan;
    private float peso,medida;
    private String calificacion, observaciones;
    private Paciente paciente;
    private ArrayList<String> objetivos;
    private ArrayList<Consumible> colaciones;
    private ArrayList<Consumible> bebidas;
    private ArrayList<RutinaDiaria> rutinas;

    public Plan(Paciente p,int duracion){
        this.edad = p.getEdad();
        this.peso = p.getPeso();
        this.medida = p.getMedida();
        this.paciente = p;
        this.idPlan = idCount.getAndIncrement();
        this.duracion = duracion;
        init();
    }

    public int getIdPlan() {
        return idPlan;
    }

    public void init(){
        this.rutinas = new ArrayList<>();
        this.objetivos = new ArrayList<>();
        this.bebidas = new ArrayList<>();
        this.colaciones = new ArrayList<>();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setObjetivos(ArrayList<String> objetivos) {
        this.objetivos.addAll(objetivos);
    }

    public void addObjetivo(String objetivo) {
        this.objetivos.add(objetivo);
    }

    public void addColacion(String colacion) {
        if (Administrador.getInstance().isColacionPermited(colacion))
            this.getColaciones().add(new Consumible(colacion));
        else
            System.out.println("Error, esta colación no esta permitida en el sistema.");
    }

    public void addBebida(String bebida) {
        if (Administrador.getInstance().isBebidaPermited(bebida))
            this.getBebidas().add(new Consumible(bebida));
        else
            System.out.println("Error, esta bebida no esta permitida en el sistema.");
    }

    public void addRutina(RutinaDiaria rutina) {
        if (rutinas.size() < duracion)
            this.rutinas.add(rutina);
        else
            System.out.println("Error, se ha alcanzado el limite de rutinas para este plan");
        
    }

    public void showRutinas(){
        for(RutinaDiaria rutina: this.rutinas){
            System.out.println(rutina.getDesayuno()+"-"+
            rutina.getMerienda()+"-"+
            rutina.getAlmuerzo()+"-"+
            rutina.getCena());
        }
    }

    public void showObjetivos(){
        for(String s : this.objetivos){
            System.out.println(s+"-");
        }
    }

    public boolean cerrar(String calificacion, String observaciones){
        if (this.getRutinas().size() == getDuracion()){
            this.calificacion = calificacion;
            this.observaciones = observaciones;
            return true;
        }
        else
        {
            System.out.println("Error, no se puede cerrar plan incompleto.");
            return false;
        }        
    }

    private int getDuracion() {
        return duracion;
    }

    private ArrayList<RutinaDiaria> getRutinas() {
        return rutinas;
    }

    private ArrayList<Consumible> getBebidas() {
        return bebidas;
    }

    private ArrayList<Consumible> getColaciones() {
        return colaciones;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public String getObservaciones() {
        return observaciones;
    }
}
