package entidades;

import entidades.Cidade;
import entidades.Estado;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-10-02T12:36:15")
@StaticMetamodel(Filiais.class)
public class Filiais_ { 

    public static volatile SingularAttribute<Filiais, Cidade> cidade;
    public static volatile SingularAttribute<Filiais, Estado> estado;
    public static volatile SingularAttribute<Filiais, Long> id;
    public static volatile SingularAttribute<Filiais, String> gerente;

}