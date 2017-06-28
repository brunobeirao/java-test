# Projeto java-test

### Sobre o projeto
Pequeno projeto com um programa que lê todas as linhas do arquivo CSV utilizando esse arquivo como base para consultas. A primeira linha contém o nome das propriedades e as linhas subsequentes os valores. Após ler o arquivo, o programa espera os comandos. Abaixo seguem os comandos:

    count * - escreve no console a contagem total de registros.
    count distinct [coluna] - escreve no console o total de valores distintos da coluna.
    filter [coluna] [valor] - escreve no console a linha de cabeçalho e todas as linhas em que a coluna enviada possua o valor enviado.

### Execução do programa
Para execução do programa, executar no console o comando mvn clean install para gerar o jar, em seguida executar o jar criado (java -jar java-1.0.jar) que está na raiz do projeto.

### Execução testes unitários
Para execução dos testes via IDE executar o JUnit Test. Os testes estão no arquivo LeitorArquivoTest.
Os testes também são executados quando é feito mvn install, na pasta do projeto via linha de comando, ou na IDE.
