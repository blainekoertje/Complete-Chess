import java.nio.file.Path;

public class King extends ChessPiece
{
    public King(int row, int column, String teamColor)
    {
        super(row,column,"King", teamColor);

    }

    public String getTeamColor()
    {
        return this.teamColor;
    }

    public void move(int row, int column)
    {
        int currentX = this.getRow() - row ;
        int currentY = this.getColumn() - column;

        this.setMove(this.getPieceName()+": ("+(this.getRow())+","+(this.getColumn())+") (" + row+","+ column+")");

        try {

            if(Character.isUpperCase(ChessPiece.getTile(row, column).charAt(1)) && Character.isLowerCase(this.getPieceType()))
            {
                for(int i = this.getColumn(); i < (column - 1); i++ )
                {
                    if(!mainBoard.getTile(row,i + 1).equals("---") && Character.isLowerCase(ChessPiece.getTile(row, column).charAt(1)))
                    {
                        throw new PathWayException("Theres a piece already there!");
                    }
                }

            }
            else if(Character.isLowerCase(ChessPiece.getTile(row, column).charAt(1)) && Character.isUpperCase(this.getPieceType()))
            {
                for(int j = getColumn(); j > (column - 1); j--)
                {
                    if(!mainBoard.getTile(row, j - 1).equals("---") && Character.isUpperCase(ChessPiece.getTile(row, column).charAt(1)))
                    {
                        throw new PathWayException("There's a piece already there");
                    }
                }
            }

            if (row >= 8 || row < 0 || column >= 8 || column < 0)
                throw new OutOfBoardException("Invalid Move Off The Board!");
            else if (!ChessPiece.getTile(row, column).equals("---")) {
                if (Character.isLowerCase(ChessPiece.getTile(row, column).charAt(1)) && Character.isLowerCase(this.getPieceType())) {
                    throw new PathWayException("You Already Have A White Piece There!");
                } else if (Character.isUpperCase(ChessPiece.getTile(row, column).charAt(1)) && Character.isUpperCase(this.getPieceType())) {
                    throw new PathWayException("You Already Have A Black Piece There!");
                } else if (Character.isUpperCase(ChessPiece.getTile(row, column).charAt(1)) && Character.isLowerCase(this.getPieceType())) {
                    if ((currentX == 1 || currentX == -1 || currentX == 0) && (currentY == 1 || currentY == -1 || currentY == 0)) {
                        System.out.println("Attack Move!");
                        this.setBoardLocation(row, column);
                        System.out.println(this.getMove() + "Valid Move!");
                    } else
                        throw new IllegalMoveException("Invalid Move For White Kings!");
                } else if (Character.isLowerCase(ChessPiece.getTile(row, column).charAt(1)) && Character.isUpperCase(this.getPieceType())) {
                    if ((currentX == 1 || currentX == -1 || currentX == 0) && (currentY == 1 || currentY == -1 || currentY == 0)) {
                        System.out.println("Attack Move!");
                        this.setBoardLocation(row, column);
                        System.out.println(this.getMove() + "Valid Move!");
                    } else
                        throw new IllegalMoveException("Invalid Move For Black Kings!");
                }
            } else if (ChessPiece.getTile(row, column).equals("---")) {
                if (this.teamColor.equals("white") && ((currentX == 1 || currentX == -1 || currentX == 0) && (currentY == 1 || currentY == -1 || currentY == 0))) {
                    this.setBoardLocation(row, column);
                    System.out.println(this.getMove() + "Valid Move!");
                } else if (this.teamColor.equalsIgnoreCase("black") && ((currentX == 1 || currentX == -1 || currentX == 0) && currentY == 1 || currentY == -1 || currentY == 0)) {
                    this.setBoardLocation(row, column);
                    System.out.println(this.getMove() + "Valid Move!");
                } else
                    throw new IllegalMoveException("Invalid Move For Kings");


            }
        }
            catch(OutOfBoardException oobe)
            {
                System.out.println(this.getMove()+" "+oobe.getMessage());
            }
            catch(PathWayException pwe)
            {
                System.out.println(this.getMove()+" "+pwe.getMessage());
            }
            catch(IllegalMoveException ime)
            {
                System.out.println(this.getMove()+" "+ime.getMessage());
            }




    }
}
