package hibernate.entity;

import javax.persistence.*;
import hibernate.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sistema")
public class Sistema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sys_id")
	private int id_sys;

	@Column(name = "sys_name")
	private String nombre;
	
	@Column(name = "sys_ords_max")
	private int ords_max;
	
	@Column(name = "sys_ords_min")
	private int ords_min;
	
	@OneToMany(mappedBy = "sistema", cascade = CascadeType.ALL)
	private List<Orden> ordenes = new ArrayList<>();

}
