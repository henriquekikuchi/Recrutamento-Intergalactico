package implementacaoInterfaces;

import domain.Rebelde;
import interfaces.Comparacao;

public class OrdenarPorNome implements Comparacao {

    @Override
    public boolean ehMenorQue(Rebelde a, Rebelde b) {
        return a.getNome().compareToIgnoreCase(b.getNome()) < 0;
    }
}
