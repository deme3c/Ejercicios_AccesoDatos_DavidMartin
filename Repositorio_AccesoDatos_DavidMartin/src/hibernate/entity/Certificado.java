package hibernate.entity;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "certificado")
public class Certificado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cer_id")
	private int id_certificado;
	@Column(name = "cer_nom_holder")
	private String nombre_holder;
	@Column(name = "cer_fecha_expedicion")
	private Date fecha_expedicion;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cer_acc_id", referencedColumnName = "acc_id", foreignKey = @ForeignKey(name = "fk_acc_id"))
	private Accion accion;
}
