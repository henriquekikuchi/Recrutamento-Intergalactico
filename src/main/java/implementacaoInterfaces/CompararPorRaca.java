package implementacaoInterfaces;

import domain.Rebelde;
import interfaces.Comparacao;

public class CompararPorRaca implements Comparacao {

    @Override
    public boolean ehMenorQue(Rebelde a, Rebelde b) {
        return a.getRaca().getDescricao().compareToIgnoreCase(b.getRaca().getDescricao()) < 0;
    }
}
