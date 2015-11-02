# LTP-3-Final-work
Morato's final work
Classe Cliente: - pacote: dados
Atributos: código (int), cpf (String), nome (String), telefone (String), email (String), dataInclusao (GregorianCalendar), dataUltAlteracao. Todos com acesso privado. O código do cliente é um nº sequencial gerado pelo sistema.
Método construtor para inicializar os atributos por meio de parâmetros;
Métodos get e set para obter e modificar cada um dos valores dos atributos.
Método toString retornando uma String com os atributos da classe formatados.

Classe Produto: - pacote: dados
Atributos: codigo (int), nome (String), precoUnitario (double), dataInclusao (GregorianCalendar), dataUltAlteracao (GregorianCalendar). Todos com acesso privado, o código do produto é um número sequencial gerado pelo sistema;
Método construtor para inicializar os atributos por meio de parâmetros;
Métodos get e set para obter e modificar cada um dos valores dos atributos.
Método toString retornando uma String com os atributos da classe formatados.

Classe Venda: - pacote: dados
Atributos: numVenda (int), cliente (Cliente), dataVenda (GregorianCalendar), vendaItens (ArrayList<itemVenda>). Todos com acesso privado, o número da venda é um número sequencial gerado pelo sistema;
Método construtor para inicializar os atributos por meio de parâmetros;
Métodos get e set para obter e modificar cada um dos valores dos atributos.
Método toString retornando uma String com os atributos da classe formatados.

Classe ItemVenda: - pacote: dados
Atributos: produto (Produto), precoUnitario (double), quantVenda (int), valorVenda (double). Todos com acesso privado;
Método construtor para inicializar os atributos por meio de parâmetros;
Métodos get e set para obter e modificar cada um dos valores dos atributos.
Método toString retornando uma String com os atributos da classe formatados.
 
Classe SisVendasException : (Herança da Classe Exception) - pacote : erros
Método construtor para passar para o construtor da super classe a mensagen de erro do aplicativo;

Classe Cadastro: - pacote: cadastro
Atributos: clientes (lista de Clientes), produtos (lista de Produtos), e lista de vendas (lista de Vendas). As listas devem ser implementadas usando a classe ArrayList. Todas estáticas e com visibilidade publica;
Lista de Clientes
Método para incluir um novo cliente. Parâmetro o cliente;
Método para excluir um cliente da lista de clientes. Parâmetro o cliente.
Método para buscar o cliente pelo código. Parâmetro o código. Retornar a mensagem “Não existe cliente para o código” para o caso de não achar o cliente, em um objeto SisVendasException.
Método para buscar o cliente pelo cpf. Parâmetro o cpf. Retornar a mensagem “Não existe cliente para o cpf” para o caso de não achar o cliente, em um objeto SisVendasException.
Método para obter lista de clientes em ordem alfabética pelo nome ou por parte do nome do cliente. Retornar a mensagem “Não existe nenhum cliente para o nome” para o caso de não achar nenhum cliente, em um objeto SisVendasException.
Lista de Produtos
Método para incluir um novo produto. Parâmetro o produto;
Método para excluir um produto da lista de produtos. Parâmetro o produto.
Método para buscar o produto pelo código. Parâmetro o código. Retornar a mensagem “Não existe produto para o código” para o caso de não achar o produto, em um objeto SisVendasException.
Método para obter lista de produtos em ordem alfabética pelo nome ou por parte do nome do produto. Retornar a mensagem “Não existe nenhum produto para o nome” para o caso de não achar nenhum produto, em um objeto SisVendasException.
Lista de Vendas
Método para incluir uma nova venda. Parâmetro a venda;
Método para excluir uma venda da lista de vendas. Parâmetro a venda.
Método para buscar a venda pelo código. Parâmetro o código. Retornar a mensagem “Não existe venda para o código” para o caso de não achar a venda, em um objeto SisVendasException.
Método para buscar as vendas para o cliente em ordem descendente do código da venda. Parâmetro o cliente. Retornar a mensagem “Não existe nenhuma venda para o cliente” para o caso de não achar nenhuma venda, em um objeto SisVendasException.
Método para obter lista de vendas em ordem do nome do cliente e data da venda decrescente. Parâmetro: período das vendas;
Método para obter a Estatística de Vendas por cliente em ordem alfabética (Nome do cliente, quantas vezes comprou no período e valor total das compras no período). Parâmetro: período das vendas. Retorno: Lista EstatisticaClientes.
Classe Usuário: - pacote: usuário – (Métodos estáticos e privativos com exceção do main)
Método para apresentar um menu (interface de caracteres). Todos os métodos abaixo, com exceção do main, mais a opção para sair, devem ser chamados no menu. 
Método para ler os dados armazenados em arquivo de objetos da lista de clientes, lista de produtos e lista de vendas);
Método para gravar os dados em arquivo de objetos da lista de clientes, lista de produtos e lista de vendas);
Clientes
Método para incluir um novo cliente. 
Validações:
CPF :
CPF tem que ser válido
Não poderá ser cadastrado cliente com cpf já cadastrado anteriormente.
Nome:
Nome obrigatório com no mínimo duas palavras
Telefone:
Telefone obrigatório
E-mail:
O E-mail tem que ser válido
Método para alterar o cliente via código.
Validações:
Não existe cliente para o código
Exibir os dados do cliente e somente alterar o cliente após a confirmação do usuário.
Validações:
CPF::
CPF tem que ser válido
Não poderá ser alterado o cpf se já existe outro cliente com cpf já cadastrado.
Nome:
Nome obrigatório com no mínimo duas palavras
Telefone:
Telefone obrigatório
E-mail:
O E-mail tem que ser válido
Método para excluir um cliente via código. 
Validações:
Não existe cliente para o código
O cliente não pode ser excluído se tiver alguma venda registrada para ele.
Exibir os dados do cliente e somente excluir o cliente após a confirmação do usuário.
Método para consultar o cliente via cpf;
Método para consultar clientes em ordem alfabética pelo nome ou por parte do nome do cliente.
Produtos
Método para incluir um novo produto;
Validações:
Nome:
Nome é obrigatório.
Preço unitário
O preço é obrigatório e maior que zero
Método para alterar o produto via código.
Validações:
Não existe produto para o código
Exibir os dados do produto e somente alterar o produto após a confirmação do usuário.
Validações:
Nome:
Nome é obrigatório.
Preço unitário
O preço é obrigatório e maior que zero
Método para excluir um produto via código;
 Validações:
Não existe produto para o código.
O produto não pode ser excluído se tiver alguma venda registrada para ele.
Exibir os dados do produto e somente excluir o produto após a confirmação do usuário.
Método para consultar produtos em ordem alfabética pelo nome ou por parte do nome do produto.
Vendas
Método para incluir uma venda para um cliente;
Validações da venda:
Cliente:
Não existe cliente para o CPF.
Data da venda
Data tem que ser válida
Data da venda não pode ser maior que a data corrente
Validações dos itens da venda:
A venda tem que ter pelo menos um item
Produto
Não existe produto para o código
Já existe o produto em outro item desta venda
Quantidade	
A quantidade tem que ser maior que zero
Valor
Valor = quantidade x preço unitário do produto
Método para excluir uma venda de um cliente via código da venda;
Validações:
Não existe venda para o código.
Exibir os dados da venda e somente excluir a venda após a confirmação do usuário.
Método para consultar as vendas pelo período em ordem de cliente e data da venda decrescente. 
Validações:
Período de venda inválido.
Data inicial inválida, Data final inválida, Data inicial superior a Data final
Método para consultar a Estatística de Vendas por cliente em ordem alfabética em um período de vendas (Nome, quantas vezes o cliente comprou no período e valor total das compras do cliente no período). 
Validações:
Período de venda inválido.
Data inicial inválida, Data final inválida, Data inicial superior a Data final




Observações:

Leitura de dados do usuário e impressão na tela devem ser feitos somente na classe Usuário;
Todas as exceções lançadas pelo sistema deverão ser tratadas. 
Usar as interfaces Serializable, Comparable e Comparator.
Os métodos da biblioteca LtpUtil poderão ser utilizados no projeto.
Usar o método sort da classe java.util.Collections para fazer as classificações das listas de objetos do aplicativo, usando as interfaces Comparable ou Comparator.
Faça comentários no formato JavaDoc para todas as classes e todos os métodos. Gere uma documentação usando este utilitário. Documentação mínima para classe: Descrição, autor, versão e data de criação. Documentação mínima para método: Descrição, parâmetros, valor retornado, exceções;




Belo Horizonte, 05 de outubro de 2015
