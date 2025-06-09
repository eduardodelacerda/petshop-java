package petshop;

public class Tosa extends Servico {
    public Tosa(double precoBase) {
        super("Tosa", precoBase);
    }

    @Override
    public double calcularPreco(Animal animal) {
        return animal.racaTipo.equalsIgnoreCase("poodle") ? precoBase * 1.3 : precoBase;
    }
}