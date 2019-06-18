## Atividades - Assuntos: Estilos Arquiteturais, Comunicação, Concorrência

### Questão 4 (estilo arquitetural baseado em camadas)
Implemente um replicador de dados simples que garanta a consistência dos dados. Adote a topologia do sistema distribuído ao lado para isto e teste conforme instruções abaixo. (Utilize socket para comunicação entre os nós).

<p align="center">
  <img width="400" height="300" src="https://user-images.githubusercontent.com/30418538/59645316-9cbf5080-9147-11e9-9ce0-efd3ddef2e37.png"/>
</p>

| Carga | Procedimento | Resultado |
| ------ | ------ | ------ |
| 100 usuários | Envie 100 requisições de inserção de dados de usuários e informe o tempo total (em segundos) | 39 segundos |
| 1000 usuários | Envie 1000 requisições de inserção de dados de usuários e informe o tempo total (em segundos) | 3345 segundos |
| 1000 usuários | [pAdotando threads, implemente uma solução que reduza o tempo de inserção a partir de 1000 requisições e informe o tempo total (em segundos) | 2308 segundos |
