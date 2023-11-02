package entidades;

import entidades.Fornecedor;
import entidades.Venda;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-10-25T14:25:26")
@StaticMetamodel(Sistema.class)
public class Sistema_ { 

    public static volatile SingularAttribute<Sistema, Double> preco;
    public static volatile SingularAttribute<Sistema, String> inversor;
    public static volatile SingularAttribute<Sistema, Integer> inversor1;
    public static volatile SingularAttribute<Sistema, Integer> modulo1;
    public static volatile SingularAttribute<Sistema, String> codigo;
    public static volatile ListAttribute<Sistema, Venda> vendaList;
    public static volatile SingularAttribute<Sistema, Long> id;
    public static volatile SingularAttribute<Sistema, Fornecedor> fornecedor;
    public static volatile SingularAttribute<Sistema, String> modulo;

}