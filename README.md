# 🔐 Gerador de Senhas Seguras com Java
gerador de senhas seguras com java

Um gerador de senhas seguras e totalmente personalizável desenvolvido em Java, com interface interativa no terminal e avaliação de força das senhas geradas.

## Características

    Personalização Completa: Controle total sobre os tipos de caracteres

    Segurança Robusta: Uso de SecureRandom para geração criptograficamente segura

    Avaliação de Força: Sistema inteligente que classifica a segurança da senha

    Interface Colorida: Terminal com cores e emojis para melhor experiência

    Geração Múltipla: Possibilidade de gerar várias senhas em sequência

    Configurações Flexíveis: Tamanho personalizável com mínimo de 8 caracteres

## Como Usar
Pré-requisitos

    Java JDK 17 ou superior

    Terminal que suporte cores ANSI (a maioria dos terminais modernos)

Execução
```bash

# Clone o repositório
git clone https://github.com/TheDevCaioM/gerador-senhas-java.git
```
```
# Navegue até o diretório
cd gerador-senhas-java
```
```
# Compile o programa
javac GeradorSenha.java
```
```
# Execute
java GeradorSenha
```
```
// Geração rápida com configurações padrão
String senha = GeradorSenha.gerarSenhaPadrao(16);

// Configuração personalizada
GeradorSenha.ConfiguracaoSenha config = new GeradorSenha.ConfiguracaoSenha();
config.tamanho = 20;
config.incluirSimbolos = false;
String senhaCustom = GeradorSenha.gerarSenha(config);
```

## Funcionalidades
  Configurações Disponíveis

    Tamanho da Senha: Mínimo 8 caracteres

    Letras Maiúsculas (A-Z)

    Letras Minúsculas (a-z)

    Números (0-9)

    Símbolos Especiais (!@#$%&* etc.)

## Sistema de Avaliação

O programa classifica as senhas em:

    Fraca: Menos de 3 critérios atendidos

    Moderada: 3-4 critérios atendidos

    Forte: 5-6 critérios atendidos

    Muito Forte: 7+ critérios atendidos

## Critérios de Avaliação

    Comprimento da senha

    Presença de letras maiúsculas

    Presença de letras minúsculas

    Presença de números

    Presença de símbolos especiais

## Tecnologias Utilizadas

    Java 17+: Linguagem de programação

    SecureRandom: Geração criptográfica segura

    ANSI Colors: Cores no terminal para melhor UX

    Unicode Emojis: Ícones visuais intuitivos

## Requisitos de Segurança

    Comprimento Mínimo: 8 caracteres

    Variedade de Caracteres: Múltiplos conjuntos

    Embaralhamento: Ordem aleatória dos caracteres

    Distribuição: Garante pelo menos um de cada tipo selecionado

    Geração Segura: Uso de SecureRandom em vez de Random

## Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para:

    Fazer um fork do projeto

    Criar uma branch para sua feature (git checkout -b feature/AmazingFeature)

    Commit suas mudanças (git commit -m 'Add some AmazingFeature')

    Push para a branch (git push origin feature/AmazingFeature)

    Abrir um Pull Request

## Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para detalhes.

---

### 💬 Contato

📧 **E-mail:** [caiomelomorais.c.js@gmail.com](mailto:caiomelomorais.c.js@gmail.com)  
💼 **LinkedIn:** [linkedin.com/in/caio-melo-930433362](https://www.linkedin.com/in/caio-melo-930433362/)  
🌐 **GitHub:** [github.com/TheDevCaioM](https://github.com/TheDevCaioM)

<div align="center">
⭐️ Não esqueça de dar uma estrela se este projeto te ajudou! ⭐️
</div>
