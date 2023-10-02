package entidades;

import entidades.Cidade;
import entidades.Estado;
import entidades.Venda;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-10-01T21:15:00")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> primeiroNome;
    public static volatile SingularAttribute<Cliente, Cidade> cidade;
    public static volatile SingularAttribute<Cliente, Estado> estado;
    public static volatile ListAttribute<Cliente, Venda> vendaList;
    public static volatile SingularAttribute<Cliente, String> segundoNome;
    public static volatile SingularAttribute<Cliente, Long> id;

}