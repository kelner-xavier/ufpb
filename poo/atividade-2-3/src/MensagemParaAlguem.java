package atividade2;

public class MensagemParaAlguem extends Mensagem {

    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailDestinatario, boolean anonima) {
        super(texto, emailDestinatario, anonima);
    }

    public MensagemParaAlguem(String nome, String emailRemetente, String emailDestinatario, boolean ehAnonima) {
        super(nome, emailRemetente, emailDestinatario, ehAnonima);
    }

    public String getTextoCompletoAExibir() {
        if(super.ehAnonima()){
            return "Mensagem para todos. texto "+ super.getTexto();

        }else{
            return "mensagem de"+ super.getEmailRemetente()+" para todos. Texto "+ super.getTexto();
        }
    }
}