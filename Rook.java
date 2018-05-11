//Author: Blaine Koertje
//Assignment: Project 2

import java.nio.file.Path;

public class Rook extends ChessPiece
{
    //Rook constructor uses the ChessPiece constructor through super, and adds the piece name
    public Rook(int row, int column, String teamColor)
    {
        super(row, column, "rook", teamColor);

    }

    public String getTeamColor()
    {
        return this.teamColor;
    }

    //Rook's version of move with The appropriate
    public void move(int row, int col) throws ArrayIndexOutOfBoundsException
    {
        this.setMove(this.getPieceName()+": ("+(this.getRow())+","+(this.getColumn())+") (" + row+","+col+")");

        try
        {
            if(this.teamColor.equalsIgnoreCase("white"))
            {
                for(int i = this.getColumn(); i < (col - 1); i++)
                {
                    if(!mainBoard.getTile(row, i + 1).equals("---") && Character.isLowerCase(mainBoard.getTile(row, i + 1).charAt(1)))
                    {
                        throw new PathWayException("You Have A Piece In The Way!!");
                    }
                }
            }
            else if(this.teamColor.equalsIgnoreCase("black"))
            {
                for(int k = this.getColumn(); k > (col + 1);k--)
                {
                    if(!mainBoard.getTile(row, k - 1).equals("---") && Character.isUpperCase(mainBoard.getTile(row, k - 1).charAt(1)))
                    {
                        throw new PathWayException("You Have A Piece There");
                    }
                }
            }


            //this if statement and the following else if statement prevent the rook
            //from jumping over pieces
//
            //keeps the piece from moving out of bounds
            if(row >= 8 || row < 0 || col >= 8 || col < 0)
            {
                throw new OutOfBoardException("Invalid Move Off The Board!");
            }

            //same thing as above instead it checks if a piece is at
            //the location another piece is moving to
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
                else if(Character.isUpperCase(ChessPiece.getTile(row, col).charAt(1)) && Character.isLowerCase(this.getPieceType()))
                {

                    if((col - this.getColumn() > 0) && this.getRow() == row && this.getTeamColor().equalsIgnoreCase("white"))
                    {
                        System.out.println("Attack Move!");
                        this.setBoardLocation(row, col);
                        System.out.println(this.getMove() + "Valid Move!");

                    }
                    else if(this.getColumn() == col && (this.getRow() >= 0 || this.getRow() <= 7) && this.getTeamColor().equalsIgnoreCase("white"))
                    {
                        System.out.println("Attack Move!");
                        this.setBoardLocation(row, col);
                        System.out.println(this.getMove() + "Valid Move!");
                    }

                }
                else if(Character.isLowerCase(ChessPiece.getTile(row, col).charAt(1)) && Character.isUpperCase(this.getPieceType()))
                {
                    if((col - this.getColumn() < 0) && this.getRow() == row && this.getTeamColor().equalsIgnoreCase("black"))
                    {
                        System.out.println("Attack Move!");
                        this.setBoardLocation(row, col);
                        System.out.println(this.getMove() + "Valid Move!");
                    }
                    else if(this.getColumn() == col && (this.getRow() >= 0 || this.getRow() <= 7) && this.getTeamColor().equalsIgnoreCase("black"))
                    {
                        System.out.println("Attack Move!");
                        this.setBoardLocation(row, col);
                        System.out.println(this.getMove() + "Valid Move!");
                    }
                }
                else
                    throw new IllegalMoveException("Cant Move Rook There");
            }
            if(ChessPiece.getTile(row, col).equals("---"))
            {
                if(this.getRow() == row || this.getColumn() == col)
                {
                    this.setBoardLocation(row,col);
                    System.out.println(this.getMove() + "Valid Move!");
                }
                else
                    throw new IllegalMoveException("Can't Move Rook There!");
            }

            //for this specific piece, rook,  it can move vertically and horizontally
            //for the next two else if statements I check if either the column or the row is the same
            //as the original row or column the move is valid if and only if another exception
            //isn't thrown
//            else if(this.getColumn() == col)
//            {
//                this.setBoardLocation(row, col);
//                System.out.println(this.getMove() + "Valid Move!");
//            }
//            else if(this.getRow() == row)
//            {
//                this.setBoardLocation(row,col);
//                System.out.println(this.getMove() + "Valid Move!");
//            }
            //Any moves not covered from above than the pending move is invalid
            // and will return an IllegalMoveException
//            else
//            {
//               throw new IllegalMoveException("Invalid Move For A Rook!");
//            }

        }

        catch(OutOfBoardException oobe){
            System.out.println(this.getMove()+" "+oobe.getMessage());
        }
        catch(PathWayException pwe){
            System.out.println(this.getMove()+" "+pwe.getMessage());
        }
        catch(IllegalMoveException ime){
            System.out.println(this.getMove()+" "+ime.getMessage());
        }


    }
}
