import java.util.ArrayList;

public class Paciente extends Usuario{

    private int edad,dni;
    private String sexo, disciplina;
    private float peso, medida;
    private Plan planActivo;

    private ArrayList<Plan> historialPlanes;

    public Paciente(String nombre, String apellido, int edad, int dni, String sexo, String disciplina, float peso, float medida) {
        super(nombre, apellido);
        this.dni = dni;
        this.edad = edad;
        this.sexo = sexo;
        this.disciplina = disciplina;
        this.peso = peso;
        this.medida = medida;
        this.historialPlanes = new ArrayList<>();
    }
    
    public void addRutina(RutinaDiaria rutina){
        if (this.planActivo != null){
            this.planActivo.addRutina(rutina);
        }
        else
            System.out.println("Error, no hay rutina activa");
    }

    public void cerrarPlan(){
        if (planActivo != null){
            this.historialPlanes.add(planActivo);
            this.planActivo = null;
        }
        else{
            System.out.println("Error, este paciente no tiene plan activo para cerrar.");
        }
    }

    public void asignarPlan(Plan p){
        this.planActivo = p;
    }

    public void cargarColacion(String colacion){
        this.planActivo.addColacion(colacion);
    }

    public void cargarBebida(String bebida){
        this.planActivo.addBebida(bebida);
    }

    public int getEdad() {
        return edad;
    }
    public String getSexo() {
        return sexo;
    }
    public String getDisciplina() {
        return disciplina;
    }

    public float getPeso() {
        return peso;
    }

    public int getDni() {
        return dni;
    }

    public float getMedida() {
        return medida;
    }
}
