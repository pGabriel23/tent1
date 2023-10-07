package entidades;

import entidades.Venda;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-10-07T15:58:43")
@StaticMetamodel(StatusServico.class)
public class StatusServico_ { 

    public static volatile SingularAttribute<StatusServico, Venda> venda;
    public static volatile SingularAttribute<StatusServico, Date> entrada;
    public static volatile SingularAttribute<StatusServico, Date> segundaParcela;
    public static volatile SingularAttribute<StatusServico, Long> id;
    public static volatile SingularAttribute<StatusServico, Date> instalacaoConcluida;
    public static volatile SingularAttribute<StatusServico, Date> instalacaoIniciada;

}