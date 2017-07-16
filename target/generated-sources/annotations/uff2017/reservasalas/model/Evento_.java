package uff2017.reservasalas.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uff2017.reservasalas.model.Espaco;
import uff2017.reservasalas.model.TipoUsuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-16T13:29:40")
@StaticMetamodel(Evento.class)
public class Evento_ { 

    public static volatile SingularAttribute<Evento, String> horaFim;
    public static volatile SingularAttribute<Evento, Boolean> ativo;
    public static volatile SingularAttribute<Evento, Boolean> isAprovado;
    public static volatile ListAttribute<Evento, TipoUsuario> tiposUsuarioPermitidos;
    public static volatile SingularAttribute<Evento, Date> data;
    public static volatile SingularAttribute<Evento, Integer> idEvento;
    public static volatile SingularAttribute<Evento, Espaco> espaco;
    public static volatile SingularAttribute<Evento, String> nome;
    public static volatile SingularAttribute<Evento, String> horaInicio;
    public static volatile SingularAttribute<Evento, Integer> maxParticipantes;
    public static volatile SingularAttribute<Evento, String> descricao;

}