package chesslayer.pieces;

import boardlayer.Board;
import boardlayer.Position;
import chesslayer.ChessPiece;
import chesslayer.Color;

public class Queen extends ChessPiece{

	public Queen(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {

		boolean[][] temporario = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		p.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		if (getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
		}

		// movimentos abaixo
		p.setValues(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() + 1);
		}
		if (getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
		}

		// movimentos para esquerda
		p.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
		}

		// movimentos para esquerda
		p.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
			p.setColumn(p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
			p.setColumn(p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() + 1);
			p.setColumn(p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() + 1);
			p.setColumn(p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			temporario[p.getRow()][p.getColumn()] = true;
		}
		
		return temporario;
	}
	
	@Override
	public String toString() {
		return "Q";
	}

}
