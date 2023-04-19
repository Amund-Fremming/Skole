package entity.database;

import javax.persistence.Entity;
import javax.persistence.Id;

import interfaces.ShortcutInterface;

@Entity
public class Shortcut implements ShortcutInterface {
	
	@Id
	private Integer from1;
	private Integer to1;
	private boolean type1;
	
	public Shortcut() {}
	
	public Shortcut(Integer from1, Integer to1, boolean type1) {
		this.from1 = from1;
		this.to1 = to1;
		this.type1 = type1;
	}

	@Override
	public Integer getFrom() {
		return this.from1;
	}

	@Override
	public Integer getTo() {
		return this.to1;
	}

	@Override
	public boolean isLadder() {
		return type1; 
	}

}
