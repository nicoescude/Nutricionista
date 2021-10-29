import java.util.ArrayList;
import java.util.HashMap;

public class Profesional extends Usuario{
    private String especialidad;
    private String matricula;
    private HashMap<Integer, Plan> planes;
    private ArrayList<Plan> planesCerrados;

    public Profesional(String nombre, String apellido, String espec, String mat) {
        super(nombre, apellido);
        this.especialidad = espec;
        this.matricula = mat; 
        init();
    }
    /** Constructor minimo */
    public Profesional(String nombre, String apellido, String espec) {
        super(nombre, apellido);
        this.especialidad = espec;
        init();
    }

    public void addObjetivo(Plan p, String objetivo){
        if (getPlanes().containsKey(p.getPaciente().getDni()))
            p.addObjetivo(objetivo);
        else
            System.out.println("Error, este plan no está a cargo de este profesional");
    }

    public Plan asignarPlan(Paciente pac,int duracion, ArrayList<String> objetivos){
        if (isHabilitado()){
            Plan plan = new Plan(pac,duracion);
            pac.asignarPlan(plan);
            if (objetivos != null) plan.setObjetivos(objetivos);
            this.getPlanes().put(pac.getDni(), plan);
            return plan;
        }
        else{
            System.out.println("Usuario no habilitado");
            return null;
        }        
    }

    public Plan asignarPlan(Paciente pac,int duracion){
        return asignarPlan(pac, duracion, null);
    }

    public void cerrarPlan(Plan p,String calificacion, String observaciones){
        if (p.cerrar(calificacion, observaciones))
        {
            p.getPaciente().cerrarPlan();
            this.getPlanesCerrados().add(p);
            this.getPlanes().remove(p.getPaciente().getDni());
        }
    }

    public void cerrarPlan(int dniPaciente,String calificacion, String observaciones){
        Plan p = getPlanes().get(dniPaciente);
        this.cerrarPlan(p, calificacion, observaciones);
    }

    private void init(){
        this.planes = new HashMap<>();
        this.planesCerrados = new ArrayList<>();
    }

    private HashMap<Integer, Plan> getPlanes() {
        return planes;
    }

    private ArrayList<Plan> getPlanesCerrados() {
        return planesCerrados;
    }
}
