//Author: Blaine Koertje
//Assignment: Project 2

import java.util.ArrayList;

public abstract class ChessPiece
{
    private int row, column;
    private String pieceName, currentMove;
    public String teamColor;
    private char pieceType;
    private static ArrayList<ChessPiece> allMyPieces = new ArrayList<ChessPiece>();

    public static ChessBoard mainBoard = new ChessBoard();

    public ChessPiece(int row, int column, String pieceName, String teamColor)
    {
        this.row = row;
        this.column = column;
        this.pieceName = pieceName;
        this.teamColor = teamColor;

        if(pieceName.equalsIgnoreCase("knight"))
        {
            if(teamColor.equalsIgnoreCase("white"))
            {
                this.pieceType = 'h';
            }
            else
                this.pieceType = 'H';
        }
        else if(teamColor.equalsIgnoreCase("white"))
        {
            this.pieceType = pieceName.toLowerCase().charAt(0);
        }
        else if(teamColor.equalsIgnoreCase("black"))
        {
            this.pieceType = pieceName.toUpperCase().charAt(0);
        }

        mainBoard.setTile("-"+pieceType+"-",this.row, this.column);
        allMyPieces.add(this);

    }

    public static ChessPiece getPieceLocation(int row, int column)
    {
        for(ChessPiece pieces: allMyPieces)
        {
            if(pieces.getRow() == row && pieces.getColumn() == column)
            {
                return pieces;
            }
        }
        return null;

    }

    public int getColumn()
    {
        return column;
    }

    public int getRow()
    {
        return row;
    }

    public char getPieceType()
    {
        return this.pieceType;
    }

    public void setType(char pieceType, int row, int col)
    {
        this.pieceType = pieceType;
    }

    public void setBoardLocation(int row, int column)
    {
        mainBoard.setTile("---", this.row, this.column);
        mainBoard.setTile("-"+pieceType+"-", row, column);
        this.row = row;
        this.column = column;


    }

    public static String getTile(int row, int column)
    {
        return mainBoard.getTile(row, column);
    }



    public String getPieceName()
    {
        return this.pieceName;
    }

    public void setMove(String currentMove)
    {
        this.currentMove = currentMove;
    }

    public String getMove()
    {
        return currentMove;
    }

    public abstract void move(int y, int x);


}
