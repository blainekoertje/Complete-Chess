//Author: Blaine Koertje
//Assignment: Project 2

public class Pawn extends ChessPiece
{
    //created a counter to keep track if the move is the first move or not
    private int firstMove;

    //constructor that uses the constructor from the ChessPiece class and adds the piecename
    public Pawn(int row, int col, String teamColor)
    {
        super(row, col, "pawn", teamColor);
        firstMove = 0;

    }

    public int getFirstMove()
    {
        return this.firstMove;
    }

    public String getTeamColor()
    {
        return this.teamColor;
    }

    public void move(int row, int col)
    {
        this.setMove(this.getPieceName() + ": ("+(this.getRow())+","+(this.getColumn())+") (" + row + "," + col +")");

        try
        {
            //the pawn cannot switch rows during the move so if the current row is not the
            //same as the row that the pawn is trying to move to than the move will be invalid

            if(this.teamColor.equalsIgnoreCase("white"))
            {
                for(int i = getColumn();i < (col - 1);i++)
                {
                    if (!mainBoard.getTile(row, i + 1).equals("---"))
                    {
                        throw new PathWayException("You Have A Teammate there!");
                    }
                }
            }
            else if(this.teamColor.equalsIgnoreCase("black"))
            {
                for(int g = getColumn();g > (col + 1);g--)
                {
                    if (!mainBoard.getTile(row, g - 1).equals("---"))
                    {
                        throw new PathWayException("Piece in the way");
                    }
                }
            }
            if(!ChessPiece.getTile(row, col).equals("---"))
            {
                if(Character.isUpperCase((ChessPiece.getTile(row, col).charAt(1))) && Character.isUpperCase(this.getPieceType()))
                {
                    throw new PathWayException("There is a piece there!");
                }
                else if(Character.isLowerCase((ChessPiece.getTile(row, col).charAt(1))) && Character.isLowerCase(this.getPieceType()))
                {
                    throw new PathWayException("There is a piece there!");
                }
                else
                {
                    System.out.println("Attack Move!");
                    if(teamColor.equalsIgnoreCase("white") && (this.getColumn() + 1 == col) && (this.getRow() + 1 == row))
                    {
                        this.setBoardLocation(row, col);
                        System.out.println(this.getMove() + "Valid Move!");
                        this.firstMove++;
                    }
                    else if(teamColor.equalsIgnoreCase("white") && (this.getColumn() + 1 == col) && (this.getRow() - 1 == row))
                    {
                        this.setBoardLocation(row, col);
                        System.out.println(this.getMove() + "Valid Move!");
                        this.firstMove++;
                    }
                    else if(teamColor.equalsIgnoreCase("black") && (this.getColumn() -1 == col) && this.getRow() - 1 == row)
                    {
                        this.setBoardLocation(row,col);
                        System.out.println(this.getMove() + "Valid Move!");
                        this.firstMove++;
                    }
                    else if(teamColor.equalsIgnoreCase("black") && (this.getColumn() - 1 == col) && (this.getRow() + 1 == row))
                    {
                        this.setBoardLocation(row,col);
                        System.out.println(this.getMove() + "Valid Move!");
                        this.firstMove++;
                    }
                }
            }
            if(ChessPiece.getTile(row, col).equals("---"))
            {
                if(firstMove == 0 && teamColor.equalsIgnoreCase("white") && this.getRow() == row && (this.getColumn() + 2) == col)
                {
                    this.setBoardLocation(row,col);
                    System.out.println(this.getMove() + "Valid Move!");
                    this.firstMove++;
                }
                else if(firstMove >= 0 && teamColor.equalsIgnoreCase("white") && this.getRow() == row && (this.getColumn() + 1) == col)
                {
                    this.setBoardLocation(row, col);
                    System.out.println(this.getMove() + "Valid Move!");
                    this.firstMove++;
                }
                else if(firstMove == 0 && teamColor.equalsIgnoreCase("black") && this.getRow() == row && (this.getColumn() - 2) == col)
                {
                    this.setBoardLocation(row,col);
                    System.out.println(this.getMove() + "Valid Move!");
                    this.firstMove++;
                }
                else if(firstMove >= 0 && teamColor.equalsIgnoreCase("black") && this.getRow() == row && (this.getColumn() - 1) == col)
                {
                    this.setBoardLocation(row, col);
                    System.out.println(this.getMove() + "Valid Move!");
                    this.firstMove++;
                }
                else
                    throw new IllegalMoveException("Invalid Move for pawns!");
            }

            //if the coordinates are outside the board than an exception will be caught and thrown
            else if(col >= 8 || col < 0 || row >= 8 || row < 0)
            {
                throw new OutOfBoardException("Move Is Off The Board!");
            }
        }
        catch(OutOfBoardException obe)
        {
            System.out.println(this.getMove() + " "+ obe.getMessage());
        }
        catch(IllegalMoveException ime)
        {
            System.out.println(this.getMove() + " " + ime.getMessage());
        }
        catch(PathWayException pwe)
        {
            System.out.println(this.getMove() + " " + pwe.getMessage());
        }

    }
}