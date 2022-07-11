package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chesslayer.ChessException;
import chesslayer.ChessMatch;
import chesslayer.ChessPiece;
import chesslayer.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		ChessMatch chessmatch = new ChessMatch();
		Scanner sc = new Scanner(System.in);
		List<ChessPiece> capturedpiece = new ArrayList<>();
		
		while (true) {
			try {
				UsuaryInterface.clearScreen();
				UsuaryInterface.printMatch(chessmatch, capturedpiece);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UsuaryInterface.readChessPosition(sc);
				
				boolean[][] possibleMoves = chessmatch.possibleMoves(source);
				UsuaryInterface.clearScreen();
				UsuaryInterface.printBoard(chessmatch.getPieces(), possibleMoves);
				System.out.println();
				
				System.out.print("Target: ");
				ChessPosition target = UsuaryInterface.readChessPosition(sc);
				ChessPiece capturedPiece = chessmatch.performChessMove(source, target);
				
				if (capturedPiece != null) {
					capturedpiece.add(capturedPiece);
				}
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
