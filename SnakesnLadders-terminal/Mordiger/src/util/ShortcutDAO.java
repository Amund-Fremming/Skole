package util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.database.Shortcut;
import interfaces.ShortcutDAOInterface;

public class ShortcutDAO {
	
	private EntityManagerFactory emf;
	
	public ShortcutDAO() {
		emf = Persistence.createEntityManagerFactory("shortcut");
	}

	public Shortcut shortcutAt(Integer boardPlacement) {
		
		EntityManager em = emf.createEntityManager();
		Shortcut shortcut = null; 
		
		try {
			
			shortcut = em.find(Shortcut.class, boardPlacement);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return shortcut;
		
	}
	
	/*
	 * EntityManager em = emf.createEntityManager();
		List<Shortcut> shortcuts = null;
		
		try {
			
			TypedQuery<Shortcut> query = em.createQuery("SELECT p FROM shortcut;", Shortcut.class);
			query.setParameter("boardplacement", boardPlacement);
			shortcuts = query.getResultList();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return shortcuts.get(0);
	 */

}
