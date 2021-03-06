package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import chesslayer.ChessMatch;
import chesslayer.ChessPiece;
import chesslayer.ChessPosition;
import chesslayer.Color;

public class UsuaryInterface {

	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static ChessPosition readChessPosition(Scanner sc) {
		try {
			String s = sc.next();
			char column = s.charAt(0);
			int row = Integer.parseInt(s.substring(1));
			return new ChessPosition(column, row);
		} catch (RuntimeException e) {
			throw new InputMismatchException("Erro na leitura, valores incorretos para uma partida de xadrez");
		}
	}
	
	public static void printMatch(ChessMatch chessMatch, List<ChessPiece> capturedPiece) {
		printBoard(chessMatch.getPieces());
		System.out.println();
		printCapturedPieces(capturedPiece);
		System.out.println();
		System.out.print("Turn: " + chessMatch.getTurn() + '\n');
		if (!chessMatch.getCheckMate()) {
			System.out.println("Waiting for player: " + (chessMatch.getColor()));
			if (chessMatch.getCheck()) {
				System.out.println(ANSI_RED + "CHECK!" + ANSI_RESET);
			}
		} else {
			System.out.println("CHECKMATE!");
			System.out.print("Winner: " + chessMatch.getColor());
		}
	}

	public static void printBoard(ChessPiece[][] piece) {
		for (int i = 0; i < piece.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < piece.length; j++) {
				printPiece(piece[i][j], false);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	public static void printBoard(ChessPiece[][] piece, boolean[][] possibleMoves) {
		for (int i = 0; i < piece.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < piece.length; j++) {
				printPiece(piece[i][j], possibleMoves[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}

	public static void printPiece(ChessPiece piece, boolean possibleMove) {
		if (possibleMove) {
			System.out.print(ANSI_PURPLE_BACKGROUND);
		}
		if (piece == null) {
			System.out.print("-" + ANSI_RESET);
		} else {
			if (piece.getColor() == Color.WHITE) {
				System.out.print(ANSI_WHITE + piece + ANSI_RESET);
			} else {
				System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
			}
		}
		System.out.print(" ");
	}
	
	private static void printCapturedPieces(List<ChessPiece> capturedPieces) {
		List<ChessPiece> white = capturedPieces.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
		List<ChessPiece> black = capturedPieces.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
		System.out.println("Captured pieces: ");
		System.out.println();
		System.out.print("White: ");
		System.out.print(ANSI_WHITE);
		System.out.println(Arrays.toString(white.toArray()));
		System.out.print(ANSI_RESET);
		System.out.print("Black: ");
		System.out.print(ANSI_YELLOW);
		System.out.println(Arrays.toString(black.toArray()));
		System.out.print(ANSI_RESET);
	}
}
