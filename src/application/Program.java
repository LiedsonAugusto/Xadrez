package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chesslayer.ChessException;
import chesslayer.ChessMatch;
import chesslayer.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		ChessMatch chessmatch = new ChessMatch();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			try {
				UsuaryInterface.clearScreen();
				UsuaryInterface.printBoard(chessmatch.getPieces());
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UsuaryInterface.readChessPosition(sc);
				
				boolean[][] possibleMoves = chessmatch.possibleMoves(source);
				UsuaryInterface.clearScreen();
				UsuaryInterface.printBoard(chessmatch.getPieces(), possibleMoves);
				
				System.out.print("Target: ");
				ChessPosition target = UsuaryInterface.readChessPosition(sc);
				chessmatch.performChessMove(source, target);
			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
				sc.nextLine();
			}
		}
	}

}
