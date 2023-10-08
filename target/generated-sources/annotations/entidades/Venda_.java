package entidades;

import entidades.Cliente;
import entidades.Filiais;
import entidades.Sistema;
import entidades.StatusServico;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-10-08T12:03:40")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, Double> preco;
    public static volatile ListAttribute<Venda, StatusServico> statusServicoList;
    public static volatile SingularAttribute<Venda, Filiais> filiais;
    public static volatile SingularAttribute<Venda, Cliente> cliente;
    public static volatile SingularAttribute<Venda, String> vendedor;
    public static volatile SingularAttribute<Venda, Date> data;
    public static volatile SingularAttribute<Venda, Sistema> sistema;
    public static volatile SingularAttribute<Venda, Long> id;

}