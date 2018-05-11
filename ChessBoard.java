//Author: Blaine Koertje
//Assignment: Project 2

public class ChessBoard {

    //created two private global constants that equal the dimensions of the chessBoard(9x9).
    private static final int ROWBASE = 9;
    private static final int COLBASE = 9;

    //create a 2-D String Array to be used to build the chess board
    private static String[][] chessBoard;

    public ChessBoard()
    {
        chessBoard = new String[ROWBASE][COLBASE];

        //double for-loop that fills the array with either an "---" or the column/row markers
        for (int row = 0; row < ROWBASE; row++) {
            for (int col = 0; col < COLBASE; col++) {
                if (row < (ROWBASE-1) && col > 0)
                {
                    chessBoard[row][col] = "---";
                }
                else if((row < (ROWBASE -1)) && col == 0)
                {
                    chessBoard[row][col] = "=" + Integer.toString(7-row) + "=";
                }
                else if(row == 8 && col == 0)
                {
                    chessBoard[row][col] = "===";
                }
                else
                    chessBoard[row][col] = "=" + Integer.toString(col - 1) + "=";
            }
        }


    }

    //setTile hard codes a specific tile with a specific String
    public void setTile(String s, int x, int y)
    {
        chessBoard[7 - y][x + 1] = s;
    }


    //returns the tile of a specific x,y coordinate from the chessBoard
    public String getTile(int x, int y)
    {
        return chessBoard[7-y][x+1];
    }

    public void setNewBoard()
    {
        ChessBoard newBoard = new ChessBoard();

        ChessPiece rightRookWhite = new Rook(0,0, "white");
        ChessPiece leftRookWhite = new Rook(7,0,"white");
        ChessPiece rightKnightWhite = new Knight(1,0,"white");
        ChessPiece leftKnightWhite = new Knight(6,0,"white");
        ChessPiece leftBishopWhite = new Bishop(2,0,"white");
        ChessPiece rightBishopWhite = new Bishop(5,0,"white");
        ChessPiece kingWhite = new King(3,0,"white");
        ChessPiece queenWhite = new Queen(4,0,"white");
        ChessPiece pawnWhite1 = new Pawn(0,1,"white");
        ChessPiece pawnWhite2 = new Pawn(1,1,"white");
        ChessPiece pawnWhite3 = new Pawn(2,1,"white");
        ChessPiece pawnWhite4 = new Pawn(3,1,"white");
        ChessPiece pawnWhite5 = new Pawn(4,1,"white");
        ChessPiece pawnWhite6 = new Pawn(5,1,"white");
        ChessPiece pawnWhite7 = new Pawn(6,1,"white");
        ChessPiece pawnWhite8 = new Pawn(7,1,"white");

        ChessPiece rightRookBlack = new Rook(7,7, "black");
        ChessPiece leftRookBlack = new Rook(0,7,"black");
        ChessPiece rightKnightBlack = new Knight(6,7,"black");
        ChessPiece leftKnightBlack = new Knight(1,7,"black");
        ChessPiece leftBishopBlack = new Bishop(2,7,"black");
        ChessPiece rightBishopBlack = new Bishop(5,7,"black");
        ChessPiece kingBlack = new King(3,7,"black");
        ChessPiece queenBlack = new Queen(4,7,"black");
        ChessPiece pawnBlack0 = new Pawn(0,6,"black");
        ChessPiece pawnBlack1 = new Pawn(1,6,"black");
        ChessPiece pawnBlack2 = new Pawn(2,6,"black");
        ChessPiece pawnBlack3 = new Pawn(3,6,"black");
        ChessPiece pawnBlack4 = new Pawn(4,6,"black");
        ChessPiece pawnBlack5 = new Pawn(5,6,"black");
        ChessPiece pawnBlack6 = new Pawn(6,6,"black");
        ChessPiece pawnBlack7 = new Pawn(7,6,"black");

        System.out.println(newBoard.toString());
    }

    //toString method that allows me to print the chess board
    public String toString()
    {
        String board = "";
        for (int row = 0; row < chessBoard.length; row++)
        {
            board += "\n";
            for(int col = 0; col < chessBoard.length; col++)
            {
                board += chessBoard[row][col] + " ";
            }
        }
        return board;
    }

}
