package petshop;

import java.util.Objects;

public abstract class Servico {
    protected String nome;
    protected double precoBase;

    public Servico(String nome, double precoBase) {
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public abstract double calcularPreco(Animal animal);

    @Override
    public String toString() {
        return nome + " (base: R$" + precoBase + ")";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Servico s && Objects.equals(nome, s.nome) && precoBase == s.precoBase;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, precoBase);
    }
}

