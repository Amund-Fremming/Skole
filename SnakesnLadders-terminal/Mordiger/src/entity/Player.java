package entity;

import interfaces.PlayerInterface;

public class Player implements PlayerInterface {
	
	private Integer ID, boardPlacement;
	
	public Player(Integer ID) {
		this.ID = ID;
		this.boardPlacement = 1;
	}

	@Override
	public Integer getID() {
		return ID;
	}

	@Override
	public void setID(Integer ID) {
		this.ID = ID;
		
	}

	@Override
	public Integer getBoardPlacement() {
		return boardPlacement;
	}

	@Override
	public void setBoardPlacement(Integer boardPlacement) {
		this.boardPlacement = boardPlacement;
	}
	
}
