Uma empresa possui varios funcionarios.
A empresa deseja calcular o valor recebido por todos os funcionarios.

SalarioLiq = Salario Base - 13% inss + 10% se for gerente
-3% se usar vale transporte +50 por filho, ate 3 filhos
se for vendedor recebe 2% das vendas realizadas.

Ao final mostre o funcionario com o maior salario da empresa.

--- PASSOS:
1º passo - Identificar as classes:
Empresa
Funcionario
Main

2º Passo - Atributos:
Empresa    : nome, listaFuncionarios
Funcionario: salario, nome, funcao, filhos, turno, valeTrans, totalVendas

3º Responsabilidade das Classes:
Funcionario: salario liquido
Empresa    : funcionarioMaiorSalario, somaSalarios
---