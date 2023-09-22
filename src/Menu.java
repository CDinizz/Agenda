import java.util.Scanner;

public class Menu {

    public static void chamarMenu() {
        AgendaTelefonica agenda = new AgendaTelefonica();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== AGENDA DE CONTATOS =====");
            System.out.print("Escolha uma opção (1-6): \n");
            System.out.println("==============================");
            System.out.println("1. Adicionar um novo contato");
            System.out.println("2. Remover um contato existente");
            System.out.println("3. Buscar um contato pelo nome");
            System.out.println("4. Atualizar informações de um contato");
            System.out.println("5. Listar todos os contatos na agenda");
            System.out.println("6. Sair do programa");


            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o número de telefone: ");
                    String numeroTelefone = scanner.nextLine();
                    Contato novoContato = new Contato(nome, numeroTelefone);
                    agenda.adicionarContato(novoContato);
                    break;
                case 2:
                    System.out.print("Digite o nome do contato a ser removido: ");
                    nome = scanner.nextLine();
                    agenda.removerContato(nome);
                    break;
                case 3:
                    System.out.print("Digite o nome do contato a ser buscado: ");
                    nome = scanner.nextLine();
                    Contato contatoEncontrado = agenda.buscarContato(nome);
                    if (contatoEncontrado != null) {
                        System.out.println("Nome: " + contatoEncontrado.getNome() + ", Telefone: " + contatoEncontrado.getTelefone());
                    } else {
                        System.err.println("Contato não encontrado na agenda.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o nome do contato a ser atualizado: ");
                    nome = scanner.nextLine();
                    Contato contatoExistente = agenda.buscarContato(nome);
                    if (contatoExistente != null) {
                        System.out.print("Digite o novo número de telefone: ");
                        numeroTelefone = scanner.nextLine();
                        Contato novoContatoAtualizado = new Contato(nome, numeroTelefone);
                        agenda.atualizarContato(nome, novoContatoAtualizado);
                    } else {
                        System.out.println("Contato não encontrado na agenda. Não foi possível atualizar.");
                    }
                    break;
                case 5:
                    agenda.listarContatos();
                    break;
                case 6:
                    System.out.println("Programa encerrado.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}


// Validação
// Certifique-se de que o programa valide as entradas do usuário, por exemplo,
// evitando a inserção de contatos duplicados com o mesmo nome.