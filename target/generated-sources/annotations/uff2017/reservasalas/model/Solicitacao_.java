package uff2017.reservasalas.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uff2017.reservasalas.model.Evento;
import uff2017.reservasalas.model.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-16T13:29:40")
@StaticMetamodel(Solicitacao.class)
public class Solicitacao_ { 

    public static volatile SingularAttribute<Solicitacao, Evento> evento;
    public static volatile SingularAttribute<Solicitacao, Date> data;
    public static volatile SingularAttribute<Solicitacao, Usuario> idUsuario;
    public static volatile SingularAttribute<Solicitacao, Integer> idSolicitacao;

}