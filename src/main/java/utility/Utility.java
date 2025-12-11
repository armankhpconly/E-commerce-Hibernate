package utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Utility {

	public static EntityManagerFactory entityManagerFactory =   Persistence.createEntityManagerFactory("Arman");
	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
