package boardlayer;

public class Board {

	private int rows;
	private int columns; 
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if ((rows < 1) || (columns < 1)) {
			throw new BoardException("Erro, a matriz precisa conter pelo menos tamanho de linha e coluna 1");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Erro, não existe posição no tabuleiro com as informações passadas.");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Erro, não existe posição no tabuleiro com as informações passadas.");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (ThereIsAPiece(position)) {
			throw new BoardException("Erro, ja existe uma peça na posição passada.");
		}
		this.pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Erro, não existe posição no tabuleiro com as informações passadas.");
		}
		if (!ThereIsAPiece(position)) {
			return null;
		}
		Piece auxiliar = piece(position);
		auxiliar.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return auxiliar;
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < this.rows && column >= 0 && column < this.columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean ThereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Erro, não existe posição no tabuleiro com as informações passadas.");
		}
		
		return piece(position) != null;
	}
}
