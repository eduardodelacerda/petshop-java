package petshop;

import java.util.Objects;

public class Cachorro extends Animal {
    private String porte;

    public Cachorro(String nome, String racaTipo, int idade, String proprietario, String porte) {
        super(nome, racaTipo, idade, proprietario);
        this.porte = porte;
    }

    public String getPorte() {
        return porte;
    }

    @Override
    public String toString() {
        return "Cachorro - " + super.toString() + ", porte: " + porte;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) && o instanceof Cachorro c && Objects.equals(porte, c.porte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), porte);
    }
}