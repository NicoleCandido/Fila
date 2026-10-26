<h1 align="center">Fila Circular em Java</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java-8a2be2?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Estrutura%20de%20Dados-ff69b4?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Status-Concluído-8a2be2?style=for-the-badge" />
</p>

<p align="center">
  Implementação de uma <b>fila circular</b> de números inteiros usando vetor,<br>
  com as operações básicas da estrutura de dados.
</p>

---

## O que é uma fila?

Uma fila segue a regra **FIFO** (*First In, First Out*): o primeiro elemento que entra é o primeiro que sai, como uma fila de banco.

```
 entra →  [ 10 | 20 | 30 ]  → sai
            ▲          ▲
          frente      trás
```

## Por que circular?

Numa fila comum feita com vetor, as posições do início ficam vazias depois das remoções e não são reaproveitadas. Na fila circular, quando `tras` chega ao fim do vetor, ele **volta para o início**:

```java
tras = (tras + 1) % capacidade;
```

Assim, todo o espaço do vetor é reaproveitado.

## Operações

| Método            | O que faz                                         |
| :---------------- | :------------------------------------------------ |
| `enqueue(valor)`  | Adiciona um elemento no final da fila             |
| `dequeue()`       | Remove e retorna o elemento da frente             |
| `peek()`          | Mostra o elemento da frente sem removê-lo         |
| `isEmpty()`       | Indica se a fila está vazia                       |
| `isFull()`        | Indica se a fila está cheia                       |
| `exibir()`        | Mostra os elementos, da frente para o final       |

## Saída do programa

```
=== Adicionando elementos ===
Fila: [ 10 20 30 ]

=== Consultando a frente ===
Elemento da frente (peek): 10

=== Removendo um elemento ===
Removido da fila: 10
Fila: [ 20 30 ]

=== Enchendo a fila (comportamento circular) ===
Fila: [ 20 30 40 50 60 ]
Fila cheia! Não foi possível adicionar 70.

=== Esvaziando a fila ===
Removido: 20
...
Fila: [ ]
A fila está vazia!
```
