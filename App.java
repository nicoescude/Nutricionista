public class App {
    public static void main(String[] args) throws Exception {

        Administrador admin = Administrador.getInstance();
        Profesional pro = new Profesional("Luiz", "Perez", "Medico Clinico");
        Paciente pac = new Paciente("Eduardo", "Perez", 44,15632145, "M", "A", 80f, 80f);

        //Habilita Usuarios
        admin.allowUser(pac); admin.allowUser(pro);
        //Agrega colaciones y bebidas permitidas
        admin.allowColacion(new Consumible("Barrita Felfort"));
        admin.allowBebida(new Consumible("Coca"));
        admin.allowBebida(new Consumible("Agua Mineral"));
        
        //El plan1 es asignado al profesional y al paciente
        Plan plan1 = pro.asignarPlan(pac, Plan.DURACION.SEMANAL.value());

        //Creamos una rutina para reutilizarla
        RutinaDiaria r1 = new RutinaDiaria(new Consumible("Hamburguesa"), 
        new Consumible("Ensalada"), new ComidaBalanceada("c1",0.1f,0.6f,0.3f), new ComidaBalanceada("c2",0.1f,0.5f,0.4f));

        //Se agregan las 7 rutinas (Semanal)
        pac.addRutina(r1);
        pac.addRutina(r1);
        pac.addRutina(r1);
        pac.addRutina(r1);
        pac.addRutina(r1);
        pac.addRutina(r1);
        pac.addRutina(r1);

        //Se agregan colaciones/bebidas
        plan1.addBebida("Coca");                // Bebida permitida
        plan1.addBebida("Agua Mineral");        // Bebida permitida
        plan1.addBebida("Sprite");              // Bebida no permitida
        plan1.addColacion("Barrita Felfort");   // colacion permitida
        plan1.addColacion("Facturas");          // colacion no permitida
 
        if (plan1 != null){
            //Agregamos los objetivos
            pro.addObjetivo(plan1,"Comer desayunos saludables");
            pro.addObjetivo(plan1,"Agregar objetivo 2");

            //Queremos cerrar el plan
            //Vemos los objetivos marcados
            plan1.showObjetivos();
            //Vemos las comidas cargadas
            plan1.showRutinas();
            //Procedemos a cerrar el plan
            //Podemos enviar el plan o el dni del paciente ya que cada plan tiene 1 solo paciente
            pro.cerrarPlan(15632145, Plan.CALIFICACION.BUENA.value(),"Todo correcto");
            //Se cerró el plan con calificacion 'BUENA'
            //El admin genera el reporte del plan
            admin.generarReporte(plan1);
        }
    }
}
