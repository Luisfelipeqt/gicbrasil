# Resolvedor de Expressões Matemáticas

Um programa Java interativo que resolve expressões matemáticas mostrando cada passo da resolução.

## Descrição

Este projeto implementa um resolvedor de expressões matemáticas que avalia operações respeitando a precedência de operadores e parênteses. O diferencial é que ele exibe cada etapa da resolução, permitindo visualizar o processo de cálculo.

## Funcionalidades

- Suporte para operações básicas: adição (+), subtração (-), multiplicação (*), divisão (/)
- Suporte para potenciação (^)
- Reconhecimento de parênteses para alterar a ordem de precedência
- Exibição passo a passo da resolução
- Interface interativa via linha de comando
- Tratamento de erros e validação de entrada

## Tecnologias

- **Linguagem:** Java
- **Versão mínima requerida:** Java 14+ (uso de switch expressions)
- **Algoritmo:** Avaliação de expressões usando pilhas (similar ao algoritmo Shunting Yard)

## Estrutura do Projeto

```
gicbrasil/
├── Main.java              # Classe principal com interface do usuário
├── ExpressionSolver.java  # Lógica de resolução de expressões
└── README.md             # Este arquivo
```

### Arquivos

- **Main.java**: Contém o ponto de entrada do programa e gerencia a interação com o usuário
- **ExpressionSolver.java**: Implementa o algoritmo de resolução usando pilhas para números e operadores

## Como Funciona

O programa utiliza duas pilhas:
1. **Pilha de números**: Armazena os valores numéricos
2. **Pilha de operadores**: Armazena os operadores (+, -, *, /, ^, parênteses)

### Precedência de Operadores

1. **Nível 3 (maior):** ^ (potenciação)
2. **Nível 2:** * e / (multiplicação e divisão)
3. **Nível 1 (menor):** + e - (adição e subtração)

Parênteses têm a maior prioridade e alteram a ordem natural de avaliação.

## Como Executar

### Pré-requisitos

- Java JDK 14 ou superior instalado
- Variável de ambiente JAVA_HOME configurada

### Compilação

Abra o terminal na pasta do projeto e execute:

```bash
javac Main.java ExpressionSolver.java
```

### Execução

Após compilar, execute:

```bash
java Main
```

### Alternativa - Usando IDE

1. Abra o projeto em sua IDE Java preferida (IntelliJ IDEA, Eclipse, VS Code)
2. Execute a classe `Main.java`

## Exemplos de Uso

### Exemplo 1 - Expressão Simples
```
Expressão: 2+3*4
────────────────────────────────────────
2+3*4
2+12
14
```

### Exemplo 2 - Com Parênteses
```
Expressão: (2+3)*4
────────────────────────────────────────
(2+3)*4
5*4
20
```

### Exemplo 3 - Potenciação
```
Expressão: 2^3+1
────────────────────────────────────────
2^3+1
8+1
9
```

### Exemplo 4 - Expressão Complexa
```
Expressão: (10+5)*2/3
────────────────────────────────────────
(10+5)*2/3
15*2/3
30/3
10
```

## Como Usar

1. Execute o programa
2. Digite uma expressão matemática quando solicitado
3. Observe os passos da resolução
4. Digite outra expressão ou "sair" para encerrar

### Regras para Expressões

- Use apenas números e os operadores: `+`, `-`, `*`, `/`, `^`
- Use parênteses `()` para agrupar operações
- Não use espaços (ou use, pois eles são removidos automaticamente)
- Números decimais devem usar ponto (`.`) como separador
