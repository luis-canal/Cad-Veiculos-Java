import java.util.ArrayList;
import java.util.List;

List<String> veiculos = new ArrayList<>();

void main() {
    IO.println("Bem vindo ao SISTEMA CADVEICULOS");
    String menu = """
            MENU
            1- Cadastrar Veículo
            2- Listar Veículos
            3- Remover Veículo
            4- Buscar por nome
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
                buscar_por_nome();
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
    for (int i = 1; i <= veiculos.size(); i++) {
        IO.println(i + " - " + veiculos.get(i - 1));
    }
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
    String busca = IO.readln("Digite o nome do veículo a ser buscado: ");
    busca = busca.trim().toLowerCase();
    boolean encontrado = false;

    for (String v : veiculos) {
        if (v.toLowerCase().contains(busca)) {
            IO.println("Veículo encontrado: " + v);
            encontrado = true;
        }
    }
    if (!encontrado)
        IO.println("Nenhum veículo encontrado");
    IO.println("Total de veículos cadastrados: " + veiculos.size());
}

//TO DO busca por nome(contains)
//TO DO total de veiculos na listagem e na busca
//TO DO mensagem de list vazia no listar e buscar
//TO DO editar veículo, informar o indice, digitar o novo nome e passar pelas mesmas validações do cadastrar
//TO DO ordenação da lista antes de exibir, bubble sort
//TO DO remover por nome 