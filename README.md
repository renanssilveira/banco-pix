CASE - Desenvolvimento módulo de cadastro de chaves PIX:
INTRODUÇÃO
O Pix é o arranjo de pagamentos e recebimentos instantâneos, disponível todos os dias do ano, com liquidação em tempo real de suas transações. Ou seja, permite a transferência imediata de valores entre diferentes instituições, em todos os horários e dias, entre pessoas físicas, empresas ou entes governamentais.
O Pix é uma forma de pagar e receber valores.
Chave Pix: um apelido para a conta transacional que deve ser atribuído pelo titular da conta ou representante legal/operador permissionado, usado para identificar a conta corrente do cliente recebedor por meio de uma única informação. Essa chave retornará a informação que identificará o recebedor da cobrança.
O formato da chave Pix indica o seu tipo, conforme regras abaixo:
• Número de celular: inicia-se com "+", seguido do código do país, DDD, e número com nove dígitos
• E-mail: contém "@", tamanho máximo de 77 caracteres
• CPF: será utilizado com 11 dígitos, com dígitos verificadores. Deve ser informado sem pontos ou traços
• CNPJ: será utilizado com 14 dígitos, com dígitos verificadores. Deve ser informado sem pontos ou traços
• Chave Aleatória: informação alfanumérica com 36 posições. Deverá ser informado sem pontuação
O cadastro é limitado a até 5 chaves por conta para Pessoa Física e até 20 chaves por conta para Pessoa Jurídica. Ao registrar uma chave Pix, as mesmas devem ser armazenadas e disponibilizadas aos correntistas para consultarem essa chave.
Inclusão
Objetivo: Viabilizar a inclusão de chaves PIX, vinculando a chave a agência e conta do correntista Itaú. Para a implementação dessa funcionalidade, minimamente deve estar contemplado o desenvolvimento de três dos cinco tipos de chaves. Fique livre a escolha por parte do candidato. Exemplo: Inclusão pode contemplar somente para os tipo de chaves celular, e-mail e CPF.
Corporativo | Interno
Dados de entrada da inclusão (tabela 1):
Nome
Tipo Dado
Obrigatório
TIPO CHAVE (celular|email|cpf|cnpj|aleatorio)
Texto (9)
SIM
VALOR CHAVE
Texto (77)
SIM
TIPO CONTA (corrente|poupança)
Texto (10)
SIM
NUMERO AGENCIA
Numérico (4)
SIM
NUMERO CONTA
Numérico (8)
SIM
NOME CORRENTISTA
Texto (30)
SIM
SOBRENOME CORRENTISTA
Texto (45)
NÃO
Critérios de aceite:
1) Deve registrar em banco de dados as informações imputadas
2) Deve gerar um código de registro único (id), independentemente do tipo de chave registrado (celular, e-mail, CPF, CNPJ etc...)
a) A chave (ID) deve ser no formato UUID.
3) Limitar em até 5 chaves por conta para pessoa física e 20 chaves para pessoa jurídica
4) Não deve permitir o registro de chaves duplicadas. O valor informado no campo VALOR CHAVE, não deve existir para outro correntista do banco.
5) Deve ser registrado a data e hora em que a chave foi registrada
6) Deve validar as regras de cadastro seguindo os tipos e regras abaixo:
a) Celular:
i) Deve validar se valor já existe cadastrado
ii) Deve possuir o código pais
(1) Deve ser numérico (não aceitar letras)
(2) Deve ser de até dois dígitos
(3) Deve iniciar com o símbolo “+”
iii) Deve possuir DDD
(1) Deve ser numérico (não aceitar letras)
(2) Deve ser de até três dígitos
iv) Número com nove dígitos
(1) Deve ser numérico (não aceitar letras)
b) E-mail:
i) Deve validar se valor já existe cadastrado
ii) Deve conter o símbolo “@”
iii) Pode conter valores alfanuméricos
iv) Maximo de 77 caracteres
c) CPF:
i) Deve validar se valor já existe cadastrado
ii) Deve conter no máximo 11 dígitos
iii) Deve fazer validação de CPF válido
iv) Deve aceitar somente números
d) CNPJ:
i) Deve validar se valor já existe cadastrado
ii) Deve conter no máximo 14 dígitos
iii) Deve fazer validação de CNPJ válido
iv) Deve aceitar somente números
Corporativo | Interno
e) Chave aleatória:
i) Deve validar se valor já existe cadastrado
ii) Deve aceitar no máximo 36 caracteres alfanuméricos.
f) TIPO CONTA
i) Somente permite os valores (corrente ou poupança)
ii) Deve ser informado obrigatoriamente
iii) Não deve permitir estourar 10 caracteres
g) NÚMERO AGÊNCIA
i) Deve permitir somente valores numéricos
ii) Deve ser informado obrigatoriamente
iii) Não deve permitir estourar 4 digitos
h) NÚMERO CONTA
i) Deve permitir somente valores numéricos
ii) Deve ser informado obrigatoriamente
iii) Não deve permitir estourar 8 digitos
7) Deve respeitar a obrigatoriedade dos campos (tabela 1)
8) Deve exibir mensagem de erro (texto livre), caso regra não seja respeitada
9) Retornar http code 200 caso inclusão seja realizada com sucesso. Retornar no corpo da resposta o id gerado [item 2)] deste critério de aceite.
10) Retornar http code 422 caso inclusão não respeite as regras de validação.
Alteração
Objetivo: Permitir alteração do valor de uma chave registrada. Deve-se permitir alterar um e-mail, telefone, CNPJ / CPF já cadastrado.
Dados de entrada alteração (tabela 2):
Nome
Tipo Dado
Obrigatório
ID
UUID
SIM
TIPO CONTA (corrente|poupança)
Texto (10)
SIM
NUMERO AGENCIA
Numérico (4)
SIM
NUMERO CONTA
Numérico (8)
SIM
NOME CORRENTISTA
Texto (30)
SIM
SOBRENOME CORRENTISTA
Texto (45)
NÃO
Dados de saída (tabela 3):
Nome
Tipo Dado
ID
UUID
TIPO CHAVE (celular|email|cpf|cnpj|aleatorio)
Texto (9)
VALOR CHAVE
Texto (77)
TIPO CONTA (corrente|poupança)
Texto (10)
NUMERO AGENCIA
Numérico (4)
NUMERO CONTA
Numérico (8)
NOME CORRENTISTA
Texto (30)
SOBRENOME CORRENTISTA
Texto (45)
DATA HORA INCLUSAO DA CHAVE
DATETIME
Corporativo | Interno
Critérios de aceite
1) Deve ser feito a validação do valor alterado, conforme tipo de dado e se informação é obrigatória ou não.
2) O ID da chave NÃO pode ser alterada
3) O tipo da chave NÃO pode ser alterada
4) O valor da chave NÃO pode ser alterada
5) Não é permitido alterar chaves inativadas
6) Deve validar os valores alterados seguindo regras abaixo:
a) TIPO CONTA
i) Somente permite os valores (corrente ou poupança)
ii) Deve ser informado obrigatoriamente
iii) Não deve permitir estourar 10 caracteres
b) NÚMERO AGÊNCIA
i) Deve permitir somente valores numéricos
ii) Deve ser informado obrigatoriamente
iii) Não deve permitir estourar 4 digitos
c) NÚMERO CONTA
i) Deve permitir somente valores numéricos
ii) Deve ser informado obrigatoriamente
iii) Não deve permitir estourar 8 digitos
d) NOME CORRENTISTA
i) Deve ser informado obrigatoriamente
ii) Não deve permitir estourar 30 caracteres
e) SOBRENOME CORRENTISTA
i) Se informado, não deve permitir estourar 45 caracteres
7) Deve exibir mensagem de erro (texto livre), caso regra não seja respeitada
8) Retornar http code 200 caso alteração seja realizada com sucesso. Retornar no corpo da resposta o conteúdo da tabela 2.
9) Retornar http code 422 caso alteração não respeite as regras de validação.
10) Retornar http code 404 caso o ID informado não seja encontrado.
Deleção
Objetivo: Inativar uma chave registrada por ID. Impedindo que a mesma seja alterada ou consultada. Somente o ID da chave deve ser informado para efetivar a desativação Funcionalidade opcional, se desejar não é obrigatório implementar
Dados de saída (tabela 4):
Nome
Tipo Dado
ID
UUID
TIPO CHAVE (celular|email|cpf|cnpj|aleatorio)
Texto (9)
VALOR CHAVE
Texto (77)
TIPO CONTA (corrente|poupança)
Texto (10)
Corporativo | Interno
NUMERO AGENCIA
Numérico (4)
NUMERO CONTA
Numérico (8)
NOME CORRENTISTA
Texto (30)
SOBRENOME CORRENTISTA
Texto (45)
DATA HORA INCLUSAO DA CHAVE
DATETIME
DATA HORA INATIVAÇÃO DA CHAVE
DATETIME
Critérios de aceite
1) Se o ID da chave informada já estiver desativada, uma mensagem deve ser retornada informando que a mesma já foi desativada (texto da mensagem livre).
a) Retornar o http code 422
2) Deve ser registrado a data e a hora da solicitação da desativação da chave;
3) Retornar em caso de sucesso
a) http code 200
b) payload conforme tabela 4
Consulta
Objetivo: Disponibilizar funcionalidades de consulta de chaves PIX por:
a) Consulta por ID
b) Consulta por Tipo de chave
c) Agência e Conta
d) Nome do correntista
e) Data de inclusão da chave
f) Data da inativação da chave
Para a implementação dessa funcionalidade, minimamente deve estar contemplado o desenvolvimento de três das seis consultas. A consulta por ID é obrigatória!! Fique livre a escolha por parte do candidato, quais consultas implementar.
Dados de saída (tabela 5):
Nome
Tipo Dado
ID
UUID
TIPO CHAVE (celular|email|cpf|cnpj|aleatorio)
Texto (9)
VALOR CHAVE
Texto (77)
TIPO CONTA (corrente|poupança)
Texto (10)
NUMERO AGENCIA
Numérico (4)
NUMERO CONTA
Numérico (8)
NOME CORRENTISTA
Texto (30)
SOBRENOME CORRENTISTA
Texto (45)
Corporativo | Interno
DATA HORA INCLUSAO DA CHAVE
DATE
(dd/mm/aaaa)
DATA HORA INATIVAÇÃO DA CHAVE
DATE
(dd/mm/aaaa)
Critérios de aceite
1) Disponibilizar consultas combinadas entre os filtros b), c), d), e) ou f)
2) Se informar o ID para consulta, nenhum outro filtro pode ser aceito.
a) Devolver http code 422 com mensagem (texto livre)
3) Não permitir a combinação de filtros Data de inclusão da chave e Data da inativação da chave. Somente um ou outro.
a) Devolver erro 422 com mensagem (texto livre)
4) Caso a consulta não retorne registros
a) Devolver http code 404
5) A lista resultado deve conter os parâmetros da tabela 5, independente do filtro realizado
6) Campos nulos, devem ser apresentados como branco “”.
O seu objetivo é:
1) Escrever um código funcional de um cadastro de Chaves PIX com APIs que atendam as funcionalidades acima descritas;
2) Utilizar preferencialmente a linguagem Java;
3) Seu código deve possuir testes unitários (90% de cobertura);
4) Utilizar banco de dados (livre escolha).
a) mySQL, SQL SERVER, ORACLE, mongoDB, postgres etc..
b) banco em memória (h2),
c) banco em container - mySQL, SQL SERVER, ORACLE, mongoDB, postgres etc..
5) Pode utilizar qualquer framework que esteja familiarizado
a) Springboot
b) Micronaut
c) Quarckus
d) sem framework
6) Utilizar o gerenciador de dependências de sua preferência (maven/gradle)
7) Utilizar um pattern de desenvolvimento que faça sentido, dado o contexto.
a) Referência de patterns: https://refactoring.guru/
8) Versionar seu código em algum controlador de versão (github, CVS etc...)
9) Descrever/demonstrar qual(is) práticas/fatores da metodologia 12 (Twelve) Factor App foram utilizados na sua solução.
a) referência: https://12factor.net/pt_br/ Você irá demonstrar funcionalmente a sua aplicação para a banca; Ter em mãos um client de API’s (POSTMAN por exemplo) para uso e demonstração das API’s construídas.
