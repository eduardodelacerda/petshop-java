package petshop;

import java.util.Objects;

public class OutroAnimal extends Animal {
    private String tipoEspecifico;

    public OutroAnimal(String nome, String racaTipo, int idade, String proprietario, String tipoEspecifico) {
        super(nome, racaTipo, idade, proprietario);
        this.tipoEspecifico = tipoEspecifico;
    }

    @Override
    public String toString() {
        return "Outro - " + super.toString() + ", tipo: " + tipoEspecifico;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) && o instanceof OutroAnimal a && Objects.equals(tipoEspecifico, a.tipoEspecifico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tipoEspecifico);
    }
}