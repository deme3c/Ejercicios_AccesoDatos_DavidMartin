package hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name="orden")
public class Orden {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ord_id")
	private int ord_id;
	@Column(name="ord_name")
	private String nombre;
	@Column(name="ord_symbol")
	private String symbol;
	@Column(name="ord_tp")
	private double tp;
	@Column(name="ord_sl")
	private double sl;
	@Column(name="ord_px")
	private double precio;
	@Column(name="ord_lot")
	private int lote;
	
	@ManyToOne
	@JoinColumn(name = "sys_id", referencedColumnName = "sys_id", foreignKey = @ForeignKey (name = "fk_sys_id"))
	private Sistema sistema;
}
