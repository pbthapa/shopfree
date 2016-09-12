import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class DataSourceConnectionTest {

	@PersistenceContext(unitName = "retailPersistenceUnit")
	private static EntityManager em;
	
	public static void main(String[] args) {
		Query query = em.createNativeQuery("select * from customer");
		List result = query.getResultList();
		System.out.println(result.get(0));
	}
}
