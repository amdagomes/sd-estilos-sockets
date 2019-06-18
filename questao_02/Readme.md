## Atividades - Assuntos: Estilos Arquiteturais, Comunicação, Concorrência

### Questão 2 (estilo arquitetural baseado em objetos)

Considere o cenário onde uma aplicação cliente possui conhecimento de onde encontram-se outros três nós, sendo que dois deles são iguais (réplicas) e que ao necessitar  realizar uma requisição para qualquer um dos nós, caso não consiga, tentará em um outro diferente (não réplica). Implemente este cenário o esquema ao lado. 

Notas:
  - siga a topologia ao lado;
  - adote socket;

Observações
  - Node2 é réplica de Node1;
  - Node1 e Node2 sabe resolver apenas op1;
  - Node3 sabe resolver apenas op2;
  - Node1 deve delegar para Node3 a operação de op2;
  - Node3 deve delegar para Node1 a operação de op1 e

Considere a formulação para 

<p align="center">
  op1(x,y) = 2yx 
</p>
<p align="center">
  op2(x,y) = 2x/y 
</p>

<p align="center">
  <img width="400" height="300" src="https://user-images.githubusercontent.com/30418538/59645107-895fb580-9146-11e9-910c-67adb94ef6aa.png">
</p>
