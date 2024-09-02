## README - Simulador de Autômato (automato.java)

Este programa Java implementa um simulador de autômato finito determinístico (AFD) que reconhece uma linguagem específica sobre o alfabeto {a, b}. O autômato aceita palavras que terminam no estado inicial.

### Como usar

1. **Compile o código:**
   ```bash
   javac automato.java
   ```

2. **Execute o programa:**
   ```bash
   java automato
   ```

3. **Insira a palavra:**
   O programa solicitará que você digite uma palavra composta apenas por 'a' e 'b'.

4. **Veja o resultado:**
   O programa informará se a palavra é aceita ou rejeitada pelo autômato e exibirá o caminho percorrido pelos estados durante o processamento.

### Funcionalidades

- **Simulação de AFD:** Simula o comportamento de um autômato finito determinístico específico.
- **Reconhecimento de Linguagem:** Determina se uma palavra pertence à linguagem aceita pelo autômato.
- **Rastreamento de Estados:** Mostra a sequência de estados percorridos durante o processamento da palavra.
- **Tratamento de Erros:** Lida com entradas inválidas e possíveis exceções durante a execução.

### Estrutura do Código

- `Estado`: Enumeração que representa os estados do autômato (`INICIAL`, `S`, `T`, `U`).
- `proximoEstado`: Função que, dado um conjunto de estados atuais e um símbolo de entrada, retorna o conjunto de possíveis próximos estados.
- `obterCaminho`: Função que, dada uma palavra, retorna uma string representando o caminho percorrido pelos estados.
- `aceitaPalavra`: Função que verifica se uma palavra é aceita pelo autômato.
- `main`: Função principal que interage com o usuário, recebe a entrada, processa a palavra e exibe o resultado.

### Exemplo

```
Digite uma palavra composta por 'a' e 'b': abba
Palavra: abba -> Aceita | Caminho: w => [INICIAL] -> [U] -> [T] -> [S] -> [INICIAL]
```
