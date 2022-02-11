package implementacaoInterfaces;

import domain.Rebelde;
import interfaces.Comparacao;

public class OrdenarPorIdade implements Comparacao {
    @Override
    public boolean ehMenorQue(Rebelde a, Rebelde b) {
        return a.getIdade().compareTo(b.getIdade()) < 0;
    }
}
