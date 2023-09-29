package entidades;

import entidades.Cidade;
import entidades.Cliente;
import entidades.Filiais;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-29T18:31:58")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile ListAttribute<Estado, Cliente> clienteList;
    public static volatile ListAttribute<Estado, Cidade> cidadeList;
    public static volatile SingularAttribute<Estado, String> uf;
    public static volatile ListAttribute<Estado, Filiais> filiaisList;
    public static volatile SingularAttribute<Estado, String> nome;
    public static volatile SingularAttribute<Estado, Long> id;

}