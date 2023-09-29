package entidades;

import entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-28T20:30:25")
@StaticMetamodel(Permissao.class)
public class Permissao_ { 

    public static volatile SingularAttribute<Permissao, Boolean> filiais;
    public static volatile SingularAttribute<Permissao, Boolean> status_servico;
    public static volatile SingularAttribute<Permissao, Boolean> cidade;
    public static volatile SingularAttribute<Permissao, Boolean> estado;
    public static volatile ListAttribute<Permissao, Usuario> usuarioList;
    public static volatile SingularAttribute<Permissao, Boolean> sistema;
    public static volatile SingularAttribute<Permissao, Boolean> permissao;
    public static volatile SingularAttribute<Permissao, Boolean> cliente;
    public static volatile SingularAttribute<Permissao, Boolean> venda;
    public static volatile SingularAttribute<Permissao, Boolean> usuario;
    public static volatile SingularAttribute<Permissao, Long> id;
    public static volatile SingularAttribute<Permissao, Boolean> fornecedor;
    public static volatile SingularAttribute<Permissao, Boolean> funcionario;

}