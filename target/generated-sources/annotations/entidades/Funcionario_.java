package entidades;

import entidades.Cidade;
import entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-21T10:32:02")
@StaticMetamodel(Funcionario.class)
public class Funcionario_ { 

    public static volatile SingularAttribute<Funcionario, String> funcao;
    public static volatile SingularAttribute<Funcionario, String> primeiroNome;
    public static volatile SingularAttribute<Funcionario, Cidade> cidade;
    public static volatile ListAttribute<Funcionario, Usuario> usuarioList;
    public static volatile SingularAttribute<Funcionario, String> segundoNome;
    public static volatile SingularAttribute<Funcionario, Integer> id;

}