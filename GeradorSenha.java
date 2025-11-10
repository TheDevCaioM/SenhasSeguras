import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GeradorSenha {

    // Conjuntos de caracteres para a senha
    private static final String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    private static final String MAIUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMEROS = "0123456789";
    private static final String SIMBOLOS = "!@#$%&*()_+-=[]|,./?><";

    // Configurações
    private static final int TAMANHO_MINIMO = 8;
    private static final SecureRandom random = new SecureRandom();
    private static final Scanner scanner = new Scanner(System.in);

    // Cores para terminal (opcional - para ficar mais bonito)
    private static final String RESET = "\u001B[0m";
    private static final String VERDE = "\u001B[32m";
    private static final String AZUL = "\u001B[34m";
    private static final String AMARELO = "\u001B[33m";
    private static final String ROXO = "\u001B[35m";
    private static final String CIANO = "\u001B[36m";

    public static void main(String[] args) {
        exibirCabecalho();

        boolean continuar = true;

        while (continuar) {
            // Configurações do usuário
            ConfiguracaoSenha config = obterConfiguracoesUsuario();

            // Gerar e exibir senha
            exibirSenhaGerada(config);

            // Verificar se deseja continuar
            continuar = perguntarSeDesejaContinuar();
        }

        exibirRodapeCompleto();
        scanner.close();
    }

    private static void exibirCabecalho() {
        System.out.println(ROXO + "╔════════════════════════════════════════╗");
        System.out.println("║         GERADOR DE SENHAS SEGURAS      ║");
        System.out.println("║              by Caio Melo              ║");
        System.out.println("╚════════════════════════════════════════╝" + RESET);
        System.out.println();
    }

    private static void exibirRodapeCompleto() {
        System.out.println();

        // Logo do GitHub
        System.out.println(VERDE + "═".repeat(50));
        System.out.println(AZUL + "                                                                                ");
        System.out.println("      ██████╗ ██╗████████╗██╗  ██╗██╗   ██╗██████╗           ");
        System.out.println("     ██╔════╝ ██║╚══██╔══╝██║  ██║██║   ██║██╔══██╗          ");
        System.out.println("     ██║  ███╗██║   ██║   ███████║██║   ██║██████╔╝          ");
        System.out.println("     ██║   ██║██║   ██║   ██╔══██║██║   ██║██╔══██╗          ");
        System.out.println("     ╚██████╔╝██║   ██║   ██║  ██║╚██████╔╝██████╔╝          ");
        System.out.println("      ╚═════╝ ╚═╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝ ╚═════╝           ");
        System.out.println("                                                                                " + RESET);

        // Informações do rodapé
        System.out.println(VERDE + "═".repeat(50));
        System.out.println("Obrigado por usar o gerador de senhas!");
        System.out.println("Desenvolvido por Caio Melo");
        System.out.println("GitHub: https://github.com/TheDevCaioM");
        System.out.println("Contato: caiomelomorais.c.js@gmail.com");
        System.out.println("═".repeat(50) + RESET);
    }

    private static ConfiguracaoSenha obterConfiguracoesUsuario() {
        ConfiguracaoSenha config = new ConfiguracaoSenha();

        System.out.println(AZUL + "CONFIGURAÇÃO DA SENHA" + RESET);
        System.out.println();

        // Tamanho da senha
        config.tamanho = obterTamanhoSenha();

        // Tipos de caracteres
        System.out.println();
        System.out.println(AMARELO + "SELECIONE OS TIPOS DE CARACTERES:" + RESET);

        config.incluirMaiusculas = obterResposta("Letras maiúsculas (A-Z)");
        config.incluirMinusculas = obterResposta("Letras minúsculas (a-z)");
        config.incluirNumeros = obterResposta("Números (0-9)");
        config.incluirSimbolos = obterResposta("Símbolos especiais (!@#$...)");

        validarConfiguracoes(config);

        return config;
    }

    private static int obterTamanhoSenha() {
        while (true) {
            System.out.print("Digite o tamanho da senha (mínimo " + TAMANHO_MINIMO + "): ");
            try {
                int tamanho = Integer.parseInt(scanner.nextLine());
                if (tamanho >= TAMANHO_MINIMO) {
                    return tamanho;
                } else {
                    System.out.println(AMARELO + "O tamanho mínimo é " + TAMANHO_MINIMO + " caracteres." + RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(AMARELO + "Erro: Digite um número válido." + RESET);
            }
        }
    }

    private static boolean obterResposta(String pergunta) {
        while (true) {
            System.out.print("   " + pergunta + "? (s/n): ");
            String resposta = scanner.nextLine().trim().toLowerCase();

            if (resposta.equals("s") || resposta.equals("sim")) {
                return true;
            } else if (resposta.equals("n") || resposta.equals("nao") || resposta.equals("não")) {
                return false;
            } else {
                System.out.println(AMARELO + "   Digite 's' para sim ou 'n' para não." + RESET);
            }
        }
    }

    private static void validarConfiguracoes(ConfiguracaoSenha config) {
        if (!config.incluirMaiusculas && !config.incluirMinusculas &&
                !config.incluirNumeros && !config.incluirSimbolos) {
            System.out.println();
            System.out.println(AMARELO + "Nenhum tipo de caractere selecionado.");
            System.out.println("   Usando configuração padrão (todos os tipos)." + RESET);

            config.incluirMaiusculas = true;
            config.incluirMinusculas = true;
            config.incluirNumeros = true;
            config.incluirSimbolos = true;
        }
    }

    private static void exibirSenhaGerada(ConfiguracaoSenha config) {
        String senha = gerarSenha(config);
        String forca = avaliarForcaSenha(senha);
        String corForca = obterCorForca(forca);

        System.out.println();
        System.out.println(VERDE + "╔════════════════════════════════════════╗");
        System.out.println("║              SENHA GERADA              ║");
        System.out.println("╚════════════════════════════════════════╝" + RESET);
        System.out.println();
        System.out.println("   Senha: " + CIANO + senha + RESET);
        System.out.println("   Tamanho: " + senha.length() + " caracteres");
        System.out.println("   Força: " + corForca + forca + RESET);
        System.out.println();
    }

    private static String obterCorForca(String forca) {
        switch (forca) {
            case "Muito Forte": return VERDE;
            case "Forte": return AZUL;
            case "Moderada": return AMARELO;
            case "Fraca": return ROXO;
            default: return RESET;
        }
    }

    private static boolean perguntarSeDesejaContinuar() {
        System.out.print(AMARELO + "Deseja gerar outra senha? (s/n): " + RESET);
        String resposta = scanner.nextLine().trim().toLowerCase();
        System.out.println();
        return resposta.equals("s") || resposta.equals("sim");
    }

    public static String gerarSenha(ConfiguracaoSenha config) {
        StringBuilder conjuntoCaracteres = new StringBuilder();
        List<Character> caracteresSenha = new ArrayList<>();

        // Adicionar pelo menos um caractere de cada tipo selecionado
        if (config.incluirMinusculas) {
            conjuntoCaracteres.append(MINUSCULAS);
            caracteresSenha.add(gerarCaractereAleatorio(MINUSCULAS));
        }

        if (config.incluirMaiusculas) {
            conjuntoCaracteres.append(MAIUSCULAS);
            caracteresSenha.add(gerarCaractereAleatorio(MAIUSCULAS));
        }

        if (config.incluirNumeros) {
            conjuntoCaracteres.append(NUMEROS);
            caracteresSenha.add(gerarCaractereAleatorio(NUMEROS));
        }

        if (config.incluirSimbolos) {
            conjuntoCaracteres.append(SIMBOLOS);
            caracteresSenha.add(gerarCaractereAleatorio(SIMBOLOS));
        }

        // Verificar se há caracteres disponíveis
        if (conjuntoCaracteres.length() == 0) {
            throw new IllegalArgumentException("Nenhum conjunto de caracteres selecionado");
        }

        // Preencher o restante da senha
        int caracteresRestantes = config.tamanho - caracteresSenha.size();
        for (int i = 0; i < caracteresRestantes; i++) {
            caracteresSenha.add(gerarCaractereAleatorio(conjuntoCaracteres.toString()));
        }

        // Embaralhar os caracteres
        Collections.shuffle(caracteresSenha, random);

        // Construir senha final
        StringBuilder senha = new StringBuilder();
        for (char c : caracteresSenha) {
            senha.append(c);
        }

        return senha.toString();
    }

    private static char gerarCaractereAleatorio(String conjunto) {
        int indice = random.nextInt(conjunto.length());
        return conjunto.charAt(indice);
    }

    private static String avaliarForcaSenha(String senha) {
        int score = 0;

        // Critérios de avaliação
        boolean temMaiuscula = false;
        boolean temMinuscula = false;
        boolean temNumero = false;
        boolean temSimbolo = false;

        for (char c : senha.toCharArray()) {
            if (Character.isUpperCase(c)) temMaiuscula = true;
            else if (Character.isLowerCase(c)) temMinuscula = true;
            else if (Character.isDigit(c)) temNumero = true;
            else temSimbolo = true;
        }

        // Pontuação baseada no comprimento
        if (senha.length() >= 16) score += 3;
        else if (senha.length() >= 12) score += 2;
        else if (senha.length() >= 8) score += 1;

        // Pontuação baseada na variedade
        if (temMaiuscula) score++;
        if (temMinuscula) score++;
        if (temNumero) score++;
        if (temSimbolo) score += 2; // Símbolos dão mais força

        // Classificação final
        if (score >= 7) return "Muito Forte";
        else if (score >= 5) return "Forte";
        else if (score >= 3) return "Moderada";
        else return "Fraca";
    }

    // Método utilitário para uso externo
    public static String gerarSenhaPadrao(int tamanho) {
        ConfiguracaoSenha config = new ConfiguracaoSenha();
        config.tamanho = Math.max(tamanho, TAMANHO_MINIMO);
        return gerarSenha(config);
    }

    // Classe para armazenar configurações
    static class ConfiguracaoSenha {
        int tamanho = 12;
        boolean incluirMaiusculas = true;
        boolean incluirMinusculas = true;
        boolean incluirNumeros = true;
        boolean incluirSimbolos = true;
    }
}