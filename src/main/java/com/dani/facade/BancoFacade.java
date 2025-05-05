package main.java.com.dani.facade;

import main.java.com.dani.model.Cliente;
import main.java.com.dani.model.Conta;
import main.java.com.dani.repository.ClienteRepository;
import main.java.com.dani.repository.ContaRepository;
import main.java.com.dani.service.TransacaoService;
import main.java.com.dani.util.enums.TipoConta;

/**
 * Fachada para operações bancárias, simplificando a interação com o sistema
 * complexo.
 * Centraliza operações comuns do banco, abstraindo a complexidade interna.
 */
public class BancoFacade {
    
    private final ClienteRepository clienteRepository;
    private final ContaRepository contaRepository;
    // private final TransacaoService transacaoService;

    public BancoFacade(ClienteRepository clienteRepo,
            ContaRepository contaRepo,
            TransacaoService transacaoService) {

        this.clienteRepository = clienteRepo;
        this.contaRepository = contaRepo;
        //this.transacaoService = transacaoService;
    }

    // TODO: senha banco : 987654321Dm**
    // https://supabase.com/dashboard/project/iglpohnwbyasehzesiku/settings/general

    /**
     * Abre uma nova conta para o cliente
     * 
     * @param cliente Dados do cliente
     * @param tipo    Tipo de conta a ser criada
     * @return Conta criada
     */
    public Conta abrirConta(Cliente cliente, TipoConta tipo) {
        // Validação inicial
        if (cliente == null || tipo == null) {
            throw new IllegalArgumentException("Cliente e tipo são obrigatórios");
        }

        // Persiste o cliente se for novo
        if (cliente.getId() == null) {
            cliente = clienteRepository.salvar(cliente);
        }

        // Cria a conta
        Conta novaConta = new Conta(cliente, tipo);
        novaConta = contaRepository.salvar(novaConta);

        // Atualiza relação no cliente
        cliente.adicionarConta(novaConta);
        clienteRepository.atualizar(cliente);

        return novaConta;
    }

    // /**
    //  * Realiza transferência entre contas
    //  * 
    //  * @param origem  Número da conta de origem
    //  * @param destino Número da conta de destino
    //  * @param valor   Valor a transferir
    //  * @return Comprovante da transação
    //  */
    // public Transacao transferir(Long origem, Long destino, BigDecimal valor) {
    //     Conta contaOrigem = contaRepository.buscarPorId(origem)
    //             .orElseThrow(() -> new ContaNaoEncontradaException(origem));

    //     Conta contaDestino = contaRepository.buscarPorId(destino)
    //             .orElseThrow(() -> new ContaNaoEncontradaException(destino));

    //     // Validações adicionais...
    //     if (valor.compareTo(BigDecimal.ZERO) <= 0) {
    //         throw new ValorInvalidoException("Valor deve ser positivo");
    //     }

    //     // Executa a transferência
    //     contaOrigem.transferir(contaDestino, valor);

    //     // Atualiza contas
    //     contaRepository.atualizar(contaOrigem);
    //     contaRepository.atualizar(contaDestino);

    //     // Registra transação
    //     return transacaoService.registrarTransferencia(contaOrigem, contaDestino, valor);
    // }

    // // Outros métodos consolidados...
    // public Extrato gerarExtrato(Long numeroConta, LocalDate inicio, LocalDate fim) {
    //     // Implementação simplificada para o cliente
    // }

    // public ResumoCliente consultarResumoCliente(String clienteId) {
    //     // Agrega informações de várias fontes
    // }
}
