package entidades;

import entidades.Cliente;
import entidades.Estado;
import entidades.Filiais;
import entidades.Funcionario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-10-02T18:03:47")
@StaticMetamodel(Cidade.class)
public class Cidade_ { 

    public static volatile ListAttribute<Cidade, Cliente> clienteList;
    public static volatile SingularAttribute<Cidade, Estado> uf;
    public static volatile ListAttribute<Cidade, Funcionario> funcionarioList;
    public static volatile ListAttribute<Cidade, Filiais> filiaisList;
    public static volatile SingularAttribute<Cidade, String> nome;
    public static volatile SingularAttribute<Cidade, Long> id;

}