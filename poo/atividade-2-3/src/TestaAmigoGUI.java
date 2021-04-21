package atividade2;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class TestaAmigoGUI {

    public static void main (String [] args){
        int maxMensagens = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de mensagens: "));
        SistemaAmigo sistema = new SistemaAmigo(maxMensagens);
        int quantAmigos = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de amigos: "));

        for(int i = 0; i < quantAmigos; i++){
            String nomeAmigo = JOptionPane.showInputDialog("Nome da pessoa: ");
            String emailAmigo = JOptionPane.showInputDialog("Email da pessoa: ");
            try{
                sistema.cadastraAmigo(nomeAmigo,emailAmigo);
            } catch (AmigoJaExistenteException e) {
                JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar");
                e.printStackTrace();
            }
        }
        List <Amigo> todosOsParticipantes = sistema.pesquisaTodosOsParticipantes();
        for(Amigo i: todosOsParticipantes){
            String emailSorteado = JOptionPane.showInputDialog("Quem é o amigo de" + i.getEmail() + " ? ");
            try {
                sistema.configuraAmigoSecretoDe(i.getEmail(), emailSorteado);
            } catch (AmigoInexistenteException e) {
                JOptionPane.showMessageDialog(null,"Problema no sorteio");
                e.printStackTrace();
            }

        }
        String texto = JOptionPane.showInputDialog("Digite o texto da mensagem ");
        String emailRemetente = JOptionPane.showInputDialog("Digite o seu email cadastrado ");
        String mensagemEhAnonima = JOptionPane.showInputDialog("A mensagem é anonima? /n (S) sim ou (N) Não ");
        boolean ehAnonima = false;
        if (mensagemEhAnonima.equals("S")){
            ehAnonima = true;
        }
        sistema.enviarMensagemParaTodos(texto, emailRemetente, ehAnonima);


    }
}
