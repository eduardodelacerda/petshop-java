package petshop;

public class Banho extends Servico {
    public Banho(double precoBase) {
        super("Banho", precoBase);
    }

    @Override
    public double calcularPreco(Animal animal) {
        if (animal instanceof Cachorro c) {
            return switch (c.getPorte().toLowerCase()) {
                case "pequeno" -> precoBase;
                case "medio" -> precoBase * 1.2;
                case "grande" -> precoBase * 1.5;
                default -> precoBase;
            };
        }
        return precoBase;
    }
}