package entidades;

import entidades.Sistema;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-28T20:30:25")
@StaticMetamodel(Fornecedor.class)
public class Fornecedor_ { 

    public static volatile ListAttribute<Fornecedor, Sistema> sistemaList;
    public static volatile SingularAttribute<Fornecedor, String> nome;
    public static volatile SingularAttribute<Fornecedor, Long> id;
    public static volatile SingularAttribute<Fornecedor, String> contato;

}