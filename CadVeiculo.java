import java.util.ArrayList;
import java.util.List;

List<String> veiculos = new ArrayList<>();

void main() {
    IO.println("Bem vindo ao SISTEMA CADVEICULOS");
    String menu = """
            MENU
            1- Cadastrar Veículo
            2- Listar Veículos
            3- Remover Veículo pelo índice
            4- Remover veículo pelo nome
            5- Buscar por nome
            6- Editar veículo
            0- Sair
            """;
    int opcao;

    do {
        IO.println(menu);
        opcao = Input.scanInt("Digite a opção selecionada: ");
        switch (opcao) {
            case 1 -> {
                cadastrar();
                IO.readln("Pressione enter para continuar");
            }
            case 2 -> {
                listar();
                IO.readln("Pressione enter para continuar");
            }
            case 3 -> {
                remover();
                IO.readln("Pressione enter para continuar");                
            }
            case 4 -> {
                remover_por_nome();
                IO.readln("Pressione enter para continuar");                
            }
            case 5 -> {
                buscar_por_nome();
                IO.readln("Pressione enter para continuar");                
            }
            case 6 -> {
                editar_veiculo();
                IO.readln("Pressione enter para continuar");                
            }
            case 0 -> {
                IO.println("Volte sempre!!");
            }
        
            default -> {
                IO.println("Opção inválida");
                IO.readln("Pressione enter para continuar");
            }               
        }
    } while (opcao != 0);
}

void cadastrar() {
    String veiculo = IO.readln("Digite o nome do veículo: ");
    veiculo = veiculo.trim();
    if (veiculo.isEmpty()) {
        IO.println("Nome do veículo inválido");
        return;
    }
    for (String v : veiculos){
        if (v.equalsIgnoreCase(veiculo)) {
            IO.println("Veículo já cadastrado!");
            return;
        }
    }
    veiculos.add(veiculo); 
    IO.println("Veículo cadastrado com sucesso!");
}

void listar() {
    if (veiculos.isEmpty()) {
        IO.println("A lista de veículos está vazia");
        return;
    }
    bubble_sort();
    for (int i = 1; i <= veiculos.size(); i++) {
        IO.println(i + " - " + veiculos.get(i - 1));
    }
    IO.println("Total de veículos cadastrados: " + veiculos.size());
}

void remover() {
    listar();
    int indice = Input.scanInt("Digite o índice do carro a ser removido: ");
    if (indice > veiculos.size() || indice <= 0)
        IO.println("Veículo não encontrado");
    else {
        veiculos.remove(indice - 1);
        IO.println("Veículo removido com sucesso");
    }    
}

void buscar_por_nome() {
    if (veiculos.isEmpty()) {
        IO.println("A lista de veículos está vazia");
        return;
    }
    String busca = IO.readln("Digite o nome do veículo a ser buscado: ");
    busca = busca.trim().toLowerCase();
    boolean encontrado = false;
    int tamanho = 0;

    for (String v : veiculos) {
        if (v.toLowerCase().contains(busca)) {
            IO.println("Veículo encontrado: " + v);
            tamanho++;
            encontrado = true;
        }
    }
    if (!encontrado)
        IO.println("Nenhum veículo encontrado");
    IO.println("Total de veículos encontrados: " + tamanho);
}

void editar_veiculo() {
    if (veiculos.isEmpty()) {
        IO.println("A lista de veículos está vazia");
        return;
    }
    listar();
    int indice = Input.scanInt("Digite o índice do carro a ser editado: ");
    if (indice > veiculos.size() || indice <= 0) {
        IO.println("Veículo não encontrado");
        return;
    }
    String novo_nome = IO.readln("Digite o novo nome do veículo: ");
    novo_nome = novo_nome.trim();
    if (novo_nome.isEmpty()) {
        IO.println("Nome do veículo inválido");
        return;
    }
    for (String v : veiculos){
        if (v.equalsIgnoreCase(novo_nome)) {
            IO.println("Nome de Veículo já cadastrado!");
            return;
        }
    }

    veiculos.set(indice - 1, novo_nome);
    IO.println("Veículo editado com sucesso");
}

void remover_por_nome() {
    if (veiculos.isEmpty()) {
        IO.println("A lista de veículos está vazia");
        return;
    }
    listar();
    String removido = IO.readln("Digite o nome do veículo a ser removido: ");
    if (removido.isEmpty()) {
        IO.println("Nome do veículo inválido");
        return;
    }
    removido = removido.trim();
    for (int i = 0; i < veiculos.size(); i++) {
        if (veiculos.get(i).equalsIgnoreCase(removido)) {
            String nomeRemovido = veiculos.remove(i);
            IO.println("Veículo " + nomeRemovido + " removido com sucesso!");
            return;
        }
    }
    IO.println("Veículo não encontrado.");
}

void bubble_sort() {
    for (int i = 0; i < veiculos.size() - 1; i++) {
        for (int j = 0; j < veiculos.size() - 1 - i; j++) {

            String atual = veiculos.get(j);
            String proximo = veiculos.get(j + 1);

            if (atual.compareToIgnoreCase(proximo) > 0) {
                veiculos.set(j, proximo);
                veiculos.set(j + 1, atual);
            }
        }
    }
}
//TO DO ordenação da lista antes de exibir, bubble sort