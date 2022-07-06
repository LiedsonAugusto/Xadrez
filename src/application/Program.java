package application;

import chesslayer.ChessMatch;

public class Program {

	public static void main(String[] args) {
		
		ChessMatch chessmatch = new ChessMatch();
		UsuaryInterface.printBoard(chessmatch.getPieces());
	}

}
