package boardlayer;

public abstract class Piece {
	
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.position = null;
		this.board = board;
	}

	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] temporario = possibleMoves();
		for (int i = 0; i < temporario.length; i++) {
			for (int j = 0; j < temporario.length; j++) {
				if (temporario[i][j] == true) {
					return true;
				}
			}
		}
		return false;
	}
}
