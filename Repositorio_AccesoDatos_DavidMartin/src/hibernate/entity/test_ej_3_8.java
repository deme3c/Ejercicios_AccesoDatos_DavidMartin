package hibernate.entity;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import hibernate.util.HibernateUtil;


class test_ej_3_8 {

	@Test
	void abrirConexion() {
		Session con = HibernateUtil.openSession();
		
	}

}
