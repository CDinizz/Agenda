import java.util.ArrayList;
import java.util.List;
public class AgendaTelefonica {

    private List<Contato> contatos;

    public AgendaTelefonica() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        if (!contatoJaExistente(contato)) {
            contatos.add(contato);
            System.err.println("Contato adicionado com sucesso.");
        } else {
            System.err.println("O contato já existe na agenda.");
        }
    }

    public void removerContato(String nome) {
        Contato contato = buscarContato(nome);
        if (contato != null) {
            contatos.remove(contato);
            System.err.println("Contato removido com sucesso.");
        } else {
            System.err.println("Contato não encontrado na agenda.");
        }
    }

    public Contato buscarContato(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }

    public void atualizarContato(String nome, Contato novoContato) {
        Contato contatoExistente = buscarContato(nome);
        if (contatoExistente != null) {
            contatos.remove(contatoExistente);
            contatos.add(novoContato);
            System.err.println("Contato atualizado com sucesso.");
        } else {
            System.err.println("Contato não encontrado na agenda. Não foi possível atualizar.");
        }
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.err.println("A agenda telefônica está vazia.");
        } else {
            System.err.println("Lista de contatos na agenda:");
            for (Contato contato : contatos) {
                System.out.println("Nome: " + contato.getNome() + ", Telefone: " + contato.getTelefone());
            }
        }
    }

    private boolean contatoJaExistente(Contato novoContato) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(novoContato.getNome())) {
                return true;
            }
        }
        return false;
    }
}


