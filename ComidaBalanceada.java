public class ComidaBalanceada extends Consumible{

    private float proteinas, carbohidratos, vegetales;
    
    public ComidaBalanceada(String desc,float proteinas, float carbohidratos, float vegetales) throws Exception {
        super(desc);
        if (proteinas+carbohidratos+vegetales!=1.0f)
            throw new Exception("Error, distribucion de comidas incorrecta: "+desc);
        this.proteinas = proteinas;
        this.carbohidratos = carbohidratos;
        this.vegetales = vegetales;
    }

    public float getCar() {
        return carbohidratos;
    }

    public float getPro() {
        return proteinas;
    }

    public float getVeg() {
        return vegetales;
    }
}
