package Modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Ocupacao.class)
public abstract class Ocupacao_ {

	public static volatile SingularAttribute<Ocupacao, Clientes> cliente;
	public static volatile SingularAttribute<Ocupacao, Quartos> quarto;
	public static volatile SingularAttribute<Ocupacao, Date> dataEntrada;
	public static volatile SingularAttribute<Ocupacao, Long> id;
	public static volatile SingularAttribute<Ocupacao, Date> dataSaida;

}

