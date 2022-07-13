package chesslayer.pieces;

import boardlayer.Board;
import boardlayer.Position;
import chesslayer.ChessPiece;
import chesslayer.Color;

public class Pawn extends ChessPiece{

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] temporario = new boolean[getBoard().getRows()][getBoard().getColumns()];

		if (getColor() == Color.WHITE) {
			
			Position p = new Position(0, 0);
			p.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
				temporario[position.getRow() - 1][position.getColumn()] = true;
			}
			
			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().ThereIsAPiece(p2) && getMoveCount() == 0) {
				temporario[position.getRow() - 2][position.getColumn()] = true;
			}
			
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOponnentPiece(p)) {
				temporario[position.getRow() - 1][position.getColumn() - 1] = true;
			}
			
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOponnentPiece(p)) {
				temporario[position.getRow() - 1][position.getColumn() + 1] = true;
			}
		} else {
			
			Position p = new Position(0, 0);
			p.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
				temporario[position.getRow() + 1][position.getColumn()] = true;
			}
			
			p.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().ThereIsAPiece(p2) && getMoveCount() == 0) {
				temporario[position.getRow() + 2][position.getColumn()] = true;
			}
			
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOponnentPiece(p)) {
				temporario[position.getRow() + 1][position.getColumn() - 1] = true;
			}
			
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOponnentPiece(p)) {
				temporario[position.getRow() + 1][position.getColumn() + 1] = true;
			}
			
		}
		
		return temporario;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
