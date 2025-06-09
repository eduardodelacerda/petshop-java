package petshop;

import java.util.*;

public class GerenciadorPetshop {
    private static List<Animal> animais = new ArrayList<>();
    private static List<Servico> servicos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n=== Sistema Petshop ===");
            System.out.println("1. Cadastrar Animal");
            System.out.println("2. Listar Animais");
            System.out.println("3. Cadastrar Serviço");
            System.out.println("4. Listar Serviços");
            System.out.println("5. Calcular Preço de Serviço");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarAnimal(scanner);
                case 2 -> listarAnimais();
                case 3 -> cadastrarServico(scanner);
                case 4 -> listarServicos();
                case 5 -> calcularPrecoServico(scanner);
                case 0 -> rodando = false;
                default -> System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }

    private static void cadastrarAnimal(Scanner sc) {
        System.out.print("Tipo (Cachorro/Gato/Outro): ");
        String tipo = sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Raça/Tipo: ");
        String raca = sc.nextLine();
        System.out.print("Idade: ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.print("Proprietário: ");
        String dono = sc.nextLine();

        Animal animal = switch (tipo.toLowerCase()) {
            case "cachorro" -> {
                System.out.print("Porte: ");
                yield new Cachorro(nome, raca, idade, dono, sc.nextLine());
            }
            case "gato" -> {
                System.out.print("Cor dos olhos: ");
                yield new Gato(nome, raca, idade, dono, sc.nextLine());
            }
            case "outro" -> {
                System.out.print("Tipo específico: ");
                yield new OutroAnimal(nome, raca, idade, dono, sc.nextLine());
            }
            default -> null;
        };

        if (animal != null) {
            animais.add(animal);
            System.out.println("Animal cadastrado.");
        }
    }

    private static void listarAnimais() {
        if (animais.isEmpty()) System.out.println("Nenhum animal.");
        else for (int i = 0; i < animais.size(); i++) System.out.println(i + ": " + animais.get(i));
    }

    private static void cadastrarServico(Scanner sc) {
        System.out.print("Tipo (Banho/Tosa/Consulta): ");
        String tipo = sc.nextLine();
        System.out.print("Preço base: ");
        double preco = sc.nextDouble();
        sc.nextLine();

        Servico s = switch (tipo.toLowerCase()) {
            case "banho" -> new Banho(preco);
            case "tosa" -> new Tosa(preco);
            case "consulta" -> new ConsultaVeterinaria(preco);
            default -> null;
        };

        if (s != null) {
            servicos.add(s);
            System.out.println("Serviço cadastrado.");
        }
    }

    private static void listarServicos() {
        if (servicos.isEmpty()) System.out.println("Nenhum serviço.");
        else for (int i = 0; i < servicos.size(); i++) System.out.println(i + ": " + servicos.get(i));
    }

    private static void calcularPrecoServico(Scanner sc) {
        listarAnimais();
        System.out.print("Índice do animal: ");
        int a = sc.nextInt();
        listarServicos();
        System.out.print("Índice do serviço: ");
        int s = sc.nextInt();
        sc.nextLine();

        if (a >= 0 && a < animais.size() && s >= 0 && s < servicos.size()) {
            double preco = servicos.get(s).calcularPreco(animais.get(a));
            System.out.println("Preço: R$" + preco);
        } else {
            System.out.println("Índices inválidos.");
        }
    }
}