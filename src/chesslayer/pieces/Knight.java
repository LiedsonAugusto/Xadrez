package chesslayer.pieces;

import boardlayer.Board;
import boardlayer.Position;
import chesslayer.ChessPiece;
import chesslayer.Color;

public class Knight extends ChessPiece{

	public Knight(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] temporario = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		p.setValues(position.getRow() - 1, position.getColumn() - 2);
		if (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p) || getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() - 2, position.getColumn() - 1);
		if (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p) || getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() - 2, position.getColumn() + 1);
		if (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p) || getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() - 1, position.getColumn() + 2);
		if (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p) || getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() + 1, position.getColumn() - 2);
		if (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p) || getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() + 2, position.getColumn() - 1);
		if (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p) || getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() + 2, position.getColumn() + 1);
		if (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p) || getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() + 1, position.getColumn() + 2);
		if (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p) || getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
		}
		
		return temporario;
	}
	
	@Override
	public String toString() {
		return "N";
	}

}
