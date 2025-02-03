import java.util.Random;

public class GeradorSenhas {
    public static void main(String[] args) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        Random random = new Random();
        int tamanhoSenha = 12; // Tamanho da senha gerada
        StringBuilder senha = new StringBuilder();

        // Gerar senha aleatoria
        for (int i = 0; i < tamanhoSenha; i++) {
            int index = random.nextInt(caracteres.length());
            senha.append(caracteres.charAt(index));
        }

        System.out.println("Sua senha segura e: " + senha.toString());
    }
}
