package application;

import java.util.Scanner;

import chesslayer.ChessMatch;
import chesslayer.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		ChessMatch chessmatch = new ChessMatch();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			UsuaryInterface.printBoard(chessmatch.getPieces());
			System.out.println();
			System.out.print("Source: ");
			ChessPosition source = UsuaryInterface.readChessPosition(sc);
			
			System.out.print("Target: ");
			ChessPosition target = UsuaryInterface.readChessPosition(sc);
			chessmatch.performChessMove(source, target);
			UsuaryInterface.printBoard(chessmatch.getPieces());
		}
	}

}
