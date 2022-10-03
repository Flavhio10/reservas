package Modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Reserva.class)
public abstract class Reserva_ {

	public static volatile SingularAttribute<Reserva, Clientes> cliente;
	public static volatile SingularAttribute<Reserva, Quartos> quarto;
	public static volatile SingularAttribute<Reserva, Date> dataEntrada;
	public static volatile SingularAttribute<Reserva, Long> id;
	public static volatile SingularAttribute<Reserva, Date> dataSaida;

}

