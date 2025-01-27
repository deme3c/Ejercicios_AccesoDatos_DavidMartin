package hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "bolsa")
public class Bolsa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bol_id")
	private int id_bolsa;
	@Column(name = "bol_nombre")
	private String nombre;
	@Column(name = "bol_ubicacion")
	private String ubicacion;
	
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "bolsa_activo", 
        joinColumns = @JoinColumn(name = "bol_id", foreignKey = @ForeignKey(name = "fk_bolsa_id")),
        inverseJoinColumns = @JoinColumn(name = "act_id", foreignKey = @ForeignKey(name = "fk_activo_id")) 
    )
    private List<Activo> activos = new ArrayList<>();
	
}
