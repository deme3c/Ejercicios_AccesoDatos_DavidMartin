package hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "activo")
public class Activo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "act_id")
	private int id_activo;
	@Column(name = "act_nombre")
	private String nombre;
	@Column(name = "act_descripcion")
	private String tipo;
	
    @ManyToMany(mappedBy = "activos", cascade = CascadeType.ALL)
    private List<Bolsa> bolsas = new ArrayList<>();
}
