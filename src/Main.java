import com.rentcar.model.*;
import com.rentcar.service.Locadora;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locadora locadora = new Locadora();

        int escolhaMenu = -1;

        while (escolhaMenu != 0) {
            System.out.println("---------- MENU ----------");
            System.out.println("1. Cadastrar veículo.");
            System.out.println("2. Cadastrar cliente.");
            System.out.println("3. Registrar locação.");
            System.out.println("4. Finalizar locação.");
            System.out.println("5. Listar veículos.");
            System.out.println("6. Ver histórico de locações de um cliente.");
            System.out.println("7. Ver total gasto por um cliente.");
            System.out.println("0. Sair.");
            escolhaMenu = scanner.nextInt();
            scanner.nextLine();

            switch (escolhaMenu) {
                case 1:
                    System.out.println("---------- CADASTRO DE VEÍCULOS ----------");
                    System.out.println("Escolha categoria do carro que irá cadastrar: ");
                    System.out.println("1 - Hatch");
                    System.out.println("2 - Sedan");
                    System.out.println("3 - SUV");
                    System.out.println("4 - Utiliário");
                    System.out.println("5 - Voltar ao menu principal");
                    int escolhaSubMenu = scanner.nextInt();
                    scanner.nextLine();

                    if (escolhaSubMenu == 5) {
                        break;
                    }

                    System.out.println("Digite a marca: ");
                    String marca = scanner.nextLine();

                    System.out.println("Digite o modelo: ");
                    String modelo = scanner.nextLine();

                    System.out.println("Digite a placa: ");
                    String placa = scanner.nextLine();

                    System.out.println("Digite o valor da diária: ");
                    double valorDiaria = scanner.nextDouble();

                    System.out.println("Digite o ano de fabricação: ");
                    int anoFabricacao = scanner.nextInt();
                    scanner.nextLine();

                    switch (escolhaSubMenu) {
                        case 1:
                            Veiculo veiculoHatchCriado = new Hatch(marca, modelo, placa, valorDiaria, anoFabricacao);
                            locadora.cadastrarVeiculo(veiculoHatchCriado);
                            break;
                        case 2:
                            Veiculo veiculoSedanCriado = new Sedan(marca, modelo, placa, valorDiaria, anoFabricacao);
                            locadora.cadastrarVeiculo(veiculoSedanCriado);
                            break;
                        case 3:
                            System.out.println("Digite o valor da taxa porte: ");
                            double taxaPorte = scanner.nextDouble();
                            scanner.nextLine();

                            Veiculo veiculoSuvCriado = new Suv(marca, modelo, placa, valorDiaria, anoFabricacao, taxaPorte);
                            locadora.cadastrarVeiculo(veiculoSuvCriado);
                            break;
                        case 4:
                            System.out.println("Digite a capacidade de carga do veículo (em kg): ");
                            double capacidadeCargaKg = scanner.nextDouble();
                            scanner.nextLine();

                            System.out.println("Digite o valor cobrado por kg de capacidade (R$): ");
                            double valorPorKg = scanner.nextDouble();
                            scanner.nextLine();

                            Veiculo veiculoUtilitarioCriado = new Utilitario(marca, modelo, placa, valorDiaria, anoFabricacao, valorPorKg, capacidadeCargaKg);
                            locadora.cadastrarVeiculo(veiculoUtilitarioCriado);
                            break;
                        default:
                            System.out.println("OPÇÃO INVÁLIDA!");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("---------- CADASTRO DE CLIENTES ---------");

                    System.out.println("Digite o nome: ");
                    String nome = scanner.nextLine();

                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    System.out.println("Digite a data de nascimento (dd/MM/yyyy): ");
                    String textoData = scanner.nextLine();
                    LocalDate dataNascimento = LocalDate.parse(textoData, formato);

                    System.out.println("Digite o CPF: ");
                    long cpf = scanner.nextLong();

                    System.out.println("Digite o número da CNH: ");
                    long numeroCnh = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("Digite a categoria da CNH: ");
                    String categoriaCnh = scanner.nextLine();

                    System.out.println("Digite a data de validade da CNH (dd/MM/yyyy): ");
                    String textoDataValidadeCnh = scanner.nextLine();
                    LocalDate dataValidadeCnh = LocalDate.parse(textoDataValidadeCnh, formato);

                    System.out.println("Digite a data de emissão da CNH (dd/MM/yyyy): ");
                    String textoDataEmissaoCnh = scanner.nextLine();
                    LocalDate dataEmissaoCnh = LocalDate.parse(textoDataEmissaoCnh, formato);

                    System.out.println("Digite o telefone para contato: ");
                    long telefone = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("Digite o email: ");
                    String email = scanner.nextLine();

                    System.out.println("Digite o endereço: ");
                    String endereco = scanner.nextLine();

                    Cliente novoCliente = new Cliente(nome, dataNascimento, cpf, numeroCnh, categoriaCnh, dataValidadeCnh, dataEmissaoCnh, telefone, email, endereco);
                    locadora.cadastrarCliente(novoCliente);
                    break;
                case 3:
                    System.out.println("---------- REGISTRAR LOCAÇÃO ---------");

                    System.out.println("Digite o CPF do cliente: ");
                    long cpfParaLocacao = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("Digite a placa do veículo ");
                    String placaParaLocar = scanner.nextLine();

                    DateTimeFormatter formatoDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    System.out.println("Digite a data de início da locação (dd/MM/yyyy): ");
                    String textoDataInicioLocacao = scanner.nextLine();
                    LocalDate dataInicioLocacao = LocalDate.parse(textoDataInicioLocacao, formatoDate);

                    System.out.println("Digite a quantidade de dias que deseja locar: ");
                    int quantidadeDias = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        Cliente clienteEncontrado = locadora.buscarClientePorCpf(cpfParaLocacao);
                        Veiculo veiculoEncontrado = locadora.buscarVeiculoPorPlaca(placaParaLocar);
                        locadora.registrarLocacao(clienteEncontrado, veiculoEncontrado, dataInicioLocacao, quantidadeDias);
                        System.out.println("Locação registrada com sucesso!");
                    } catch (IllegalStateException e) {
                        System.out.println("Erro ao registrar locação: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("---------- FINALIZAR LOCAÇÃO ----------");

                    System.out.println("Digite o ID da locação que deseja finalizar: ");
                    int idFinalizar = scanner.nextInt();

                    try {
                        locadora.finalizarLocacao(idFinalizar);
                        System.out.println("Locação finalizada com sucesso!");
                    } catch (IllegalStateException e) {
                        System.out.println("Erro ao finalizar locação: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("---------- LISTAR VEICULOS ----------");

                    List<Veiculo> todosOsVeiculos = locadora.listarVeiculos();

                    for (Veiculo veiculo : todosOsVeiculos) {
                        System.out.println("Informações sobre os veículos");
                        System.out.println("Marca: " + veiculo.getMarca());
                        System.out.println("Modelo: " + veiculo.getModelo());
                        System.out.println("Placa: " + veiculo.getPlaca());
                        System.out.println("Valor da diária: " + veiculo.getValorDiaria());
                        System.out.println("Ano fabricação: " + veiculo.getAnoFabricacao());
                        System.out.println("Disponibilidade: " + veiculo.isDisponivel());

                        if (veiculo instanceof Suv) {
                            Suv suvConvertido = (Suv) veiculo;
                            System.out.println("Taxa de porte: " + suvConvertido.getTaxaPorte());
                        }

                        if (veiculo instanceof  Utilitario) {
                            Utilitario utilitarioConvertido = (Utilitario) veiculo;
                            System.out.println("Capacidade de carga do veículo (em kg): " + utilitarioConvertido.getCapacidadeCargaKg());
                            System.out.println("Taxa de valor por KG: " + utilitarioConvertido.getValorPorKg());
                        }
                    }
                    break;
                case 6:
                    System.out.println("HISTÓRICO DE LOCAÇÕES DE UM CLIENTE");

                    System.out.println("Digite o CPF do cliente: ");
                    long cpfCliente = scanner.nextLong();

                    try {
                        Cliente cliente = locadora.buscarClientePorCpf(cpfCliente);
                        List<Locacao> historico = locadora.historicoClientes(cliente);

                        for (Locacao locacao : historico) {
                            System.out.println("ID do cliente: " + locacao.getId());
                            System.out.println("Nome do cliente: " + locacao.getCliente().getNome());
                            System.out.println("Marca do veículo: " + locacao.getVeiculo().getMarca());
                            System.out.println("Modelo do veículo: " + locacao.getVeiculo().getModelo());
                            System.out.println("Data de início da locação: " + locacao.getDataInicio());
                            System.out.println("Quantidade de dias locado: " + locacao.getQuantidadeDias());
                            System.out.println("Estado da locação: " + locacao.isLocFinalizada());
                            System.out.println("Valor total do serviço: " + locacao.getValorTotal());
                        }
                    } catch (IllegalStateException e) {
                        System.out.println("Erro ao listar histórico de locações: " + e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("---------- TOTAL GASTO POR CLENTE ----------");
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
            }
        }
        scanner.close();
    }
}