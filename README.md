# Projeto - Banco

Dicas de desenvolvimento. Ao criar o Objeto, instancie ele como um array, ficará mais fácil para o desenvolvimento final e também será uma boa prática de escalabilidade do seu código, supondo que podemos adicionar mais contasBancos futuramente.
 
Todos os inputs de usuários deverão ser com Scanner.
 
1) Crie uma classe ContaBanco. Deverá os atributos:
- Nome;
- Saldo em conta.
- Senha (Utilize regex para validar uma senha forte)
 
2) Adicione os métodos de Saque e Depósito:
- O método saque deverá ter uma taxa de 1% do valor ao sacar.
- O método saque precisa solicitar e validar a senha cadastrada anteriormente.
 
Imprima o valor sacado e o valor atual em conta.
 
3) Adicione um método para alterar a senha do usuário.
- Cuide com a validação da senha novamente.
 
4) Crie dois Objetos ContaBanco (cb1 - cb2...).
- Adicione o atributo de CPF (Utilize regex para validar a entrada do CPF: 000.000.000-00)
- Adicione o método de transferência bancária.
- O valor de uma conta deverá ir para a outra.
 
Encontraremos a outra conta através do CPF (Exemplo: como uma chave PIX).
 
5) Limite os valores de transferência por hora do dia / fim de semana.
- Fins de semana: R$ 1.000 das 6h até às
20h.
Entre 20h01 até 5h59 - R$ 500.
- Dia de semana: R$ 2.000 das 6h até às 20h.
Entre 20h01 até 5h59 - R$ 850.
- Bloqueie a transferência/saque caso esteja fora desses limites.
 
Classes implícitas no Java para auxílio da questão 5: LocalDate - Throw exception.
