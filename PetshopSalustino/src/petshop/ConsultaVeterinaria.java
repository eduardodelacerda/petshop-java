package petshop;

public class ConsultaVeterinaria extends Servico {
    public ConsultaVeterinaria(double precoBase) {
        super("Consulta Veterinária", precoBase);
    }

    @Override
    public double calcularPreco(Animal animal) {
        return precoBase + (10 * animal.idade);
    }
}