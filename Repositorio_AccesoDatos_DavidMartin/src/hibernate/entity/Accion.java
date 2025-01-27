package hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "accion")
public class Accion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "acc_id")
	private int acc_id;
	@Column(name = "acc_empresa")
	private String empresa;
	@Column(name = "acc_estado")
	private boolean estado;
	
	@OneToOne(mappedBy = "accion")
	private Certificado certificado;
	
}
