package chesslayer.pieces;

import boardlayer.Board;
import boardlayer.Position;
import chesslayer.ChessMatch;
import chesslayer.ChessPiece;
import chesslayer.Color;

public class Pawn extends ChessPiece{

	private ChessMatch chessmatch;
	
	public Pawn(Board board, Color color, ChessMatch chessmatch) {
		super(board, color);
		this.chessmatch = chessmatch;
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
			
			if (position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left) && isThereOponnentPiece(left) && chessmatch.getEnPassantVulnerable() == getBoard().piece(left)) {
					temporario[left.getRow() - 1][left.getColumn()] = true;
				}
				
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(right) && isThereOponnentPiece(right) && chessmatch.getEnPassantVulnerable() == getBoard().piece(right)) {
					temporario[right.getRow() - 1][right.getColumn()] = true;
				}
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
			
			if (position.getRow() == 4) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left) && isThereOponnentPiece(left) && chessmatch.getEnPassantVulnerable() == getBoard().piece(left)) {
					temporario[left.getRow() + 1][left.getColumn()] = true;
				}
				
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(right) && isThereOponnentPiece(right) && chessmatch.getEnPassantVulnerable() == getBoard().piece(right)) {
					temporario[right.getRow() + 1][right.getColumn()] = true;
				}
			}
		}
		
		return temporario;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
