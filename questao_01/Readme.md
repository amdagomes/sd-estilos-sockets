## Atividades - Assuntos: Estilos Arquiteturais, Comunicação, Concorrência

### Questão 1 (estilo arquitetural baseado em camadas)
 
Observando a topologia apresentada na figura abaixo, construa as aplicações que possam resolver os seguintes requisitos:
  - A aplicação do "node1" deve gerar dois números inteiros entre 0 e 100 e enviar para a aplicação do "node3" através do "node2";
  - O "node2" deve resolver receber a mensagem enviada pelo "node1" e enviar para o "node3" somente quando os dois números forem diferentes;
  - No caso dos dois números enviados pelo "node1" serem iguais, o "node2" deve responder ao "node1" com o valor "0";
O "node3" deve usar a equação abaixo para responder as requisições que lhe são feitas:

<p align="center">
  f(x,y) = y^y + x^x
</p>

<p align="center">
  <img width="300" height="200" src="https://user-images.githubusercontent.com/30418538/59644837-19046480-9145-11e9-9c30-082a21710cc6.png">
</p>
