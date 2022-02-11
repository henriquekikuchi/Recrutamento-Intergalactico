import controllers.InteligenciaCentral;
import domain.Rebelde;
import enums.FieldsEnum;
import enums.RacasEnum;
import implementacaoInterfaces.SelectionSort;
import views.CadastroRebeldesView;
import views.OrdenacaoRebeldesView;
import views.RebeldeView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProcessoSeletivoIntergalacticoApplication {
    public static void main(String[] args) {

        InteligenciaCentral ic = new InteligenciaCentral();
        CadastroRebeldesView.iniciarCadastroRebeldes(ic);
        FieldsEnum fieldsEnum = OrdenacaoRebeldesView.iniciarOrdenacaoRebeldes(ic);
        ic.ordenarRebeldesAprovados(new SelectionSort(), fieldsEnum);
        ic.imprimirAprovados();

    }
}
