

public class RutinaDiaria {
    private Consumible desayuno;
    private Consumible merienda;
    private ComidaBalanceada almuerzo;
    private ComidaBalanceada cena;

    public RutinaDiaria(Consumible desayuno, Consumible merienda, ComidaBalanceada almuerzo, ComidaBalanceada cena){
        this.desayuno = desayuno;
        this.merienda = merienda;
        this.almuerzo = almuerzo;
        this.cena = cena;
    }

    public String getAlmuerzo() {
        return almuerzo.getDescripcion() + "-Pro:" + almuerzo.getPro() + "-Car:" + almuerzo.getCar() + "-Veg:" + almuerzo.getVeg();
    }

    public String getCena() {
        return cena.getDescripcion() + "-Pro:" + cena.getPro() + "-Car:" + cena.getCar() + "-Veg:" + cena.getVeg();
    }

    public String getDesayuno() {
        return desayuno.getDescripcion();
    }

    public String getMerienda() {
        return merienda.getDescripcion();
    }
}
