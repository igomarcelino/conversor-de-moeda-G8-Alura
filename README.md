
---

````markdown
# 💱 Conversor de Moedas com IOF - Challenge Alura G8

Este projeto foi desenvolvido como parte do **Challenge Back-End G8 da Alura**.
A proposta era criar uma aplicação Java que consultasse a cotação de moedas estrangeiras
e realizasse simulações de conversão, considerando taxas como o IOF de acordo com a
forma de pagamento (dinheiro ou cartão).

## 🧠 O que eu aprendi com esse projeto

Durante o desenvolvimento, aprofundei meus conhecimentos em:

- ✅ **Integração com APIs públicas** (consumo de JSON via HTTP);
- ✅ **Tratamento de exceções**, incluindo `InputMismatchException` e controle de entrada do usuário;
- ✅ Estruturação de **menus interativos via console**;
- ✅ Utilização de **`Enum` para representar regras fixas** como formas de pagamento e taxas de IOF;
- ✅ Escrita e leitura de arquivos para **armazenar logs de conversões**;
- ✅ Manipulação de datas e horas com `LocalDateTime` e `DateTimeFormatter`;
- ✅ **Boas práticas de organização de código**, separando responsabilidades em diferentes classes.

## 🛠️ Tecnologias e recursos utilizados

- **Java 17**
- **Java I/O** (FileWriter, FileReader, BufferedReader)
- **Scanner** para leitura via terminal
- **Enums personalizados** para representar IOF
- **Arquitetura simples orientada a objetos**
- API de taxas de câmbio [ExchangeRate-API] (ou similar pública)
- IDE: IntelliJ / Eclipse



## 🚀 Como executar

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/conversor-moedas-iof.git
```

2. Compile e execute com sua IDE favorita ou via terminal:

```bash
javac Menu.java
java Menu
```

3. Navegue pelo menu e simule conversões com base em cotação e forma de pagamento.

## 🧾 Exemplo de Log Gerado

```txt
[12/05/2025 18:18:45] Conversão de Real para Dolar | Quantidade: 100,00 | Resultado: 17,89 | Forma: Dinheiro
```

Todos os logs são salvos no arquivo `conversoes.log` na raiz do projeto.

## 📚 Sobre o Challenge Alura G8

O Challenge Alura G8 é uma iniciativa prática da Alura para incentivar alunos a colocarem em prática os conhecimentos adquiridos em cursos. Ao longo deste desafio, aplicamos conceitos de orientação a objetos, integração com APIs, boas práticas de tratamento de erro e manipulação de arquivos.

---

Desenvolvido por **Igo Marcelino**.



