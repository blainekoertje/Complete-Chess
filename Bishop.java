//Author: Blaine Koertje
//Assignment: Project 2

public class Bishop extends ChessPiece
{
    //used the constructor from ChessPiece and added the specific piecename to this piece
    public Bishop(int row, int column, String teamColor)
    {
        super(row, column, "Bishop", teamColor);
    }

    public String getTeamColor()
    {
        return this.teamColor;
    }

    public void move(int row, int col)
    {
        this.setMove(this.getPieceName()+": ("+(this.getRow())+","+(this.getColumn())+") (" + row+","+col+")");

        try {
            if(this.teamColor.equalsIgnoreCase("white"))
            {
                for(int i = getColumn();i < (col - 1);i++)
                {
                    for(int r = getRow(); r < (row - 1); r++) {
                        if (!mainBoard.getTile( r + 1, i + 1).equals("---")) {
                            throw new PathWayException("You Have A Teammate there!");
                        }
                    }
                }
            }
            if(this.teamColor.equalsIgnoreCase("black"))
            {
                for(int g = getColumn();g > (col + 1);g--)
                {
                    for(int h = getRow(); h > (row + 1); h++) {
                        if (!mainBoard.getTile(row - 1, g - 1).equals("---")) {
                            throw new PathWayException("Piece in the way");
                        }
                    }
                }
            }

            //if the pending move will leave the piece off the board than an exception
            //is caught and thrown
            if (row >= 8 || row < 0 || col >= 8 || col < 0) {
                throw new OutOfBoardException("Invalid Move Off The Board!");
            }

            if (!ChessPiece.getTile(row, col).equals("---")) {
                if (Character.isUpperCase(ChessPiece.getTile(row, col).charAt(1)) && Character.isUpperCase(this.getPieceType())) {
                    throw new PathWayException("There is already a black piece there!");
                } else if (Character.isLowerCase(ChessPiece.getTile(row, col).charAt(1)) && Character.isLowerCase(this.getPieceType())) {
                    throw new PathWayException("There is already a white piece there!");
                }
                //white piece attacking black piece
                else if (Character.isUpperCase(ChessPiece.getTile(row, col).charAt(1)) && Character.isLowerCase(this.getPieceType())) {
                    int diffX = Math.abs(this.getRow() - row);
                    int diffY = Math.abs(this.getColumn() - col);

                    if (diffX - diffY != 0) {
                        throw new IllegalMoveException("Invalid Move For Bishops!4");
                    } else {
                        if (col - this.getColumn() > 0)//up
                        {
                            if (row - this.getRow() > 0)//right
                            {
                                this.setBoardLocation(row, col);
                                System.out.println("Attack Move!");
                                System.out.println(this.getMove() + "Valid Move!");
                            } else if (row - this.getRow() < 0)//left
                            {
                                this.setBoardLocation(row, col);
                                System.out.println("Attack Move!");
                                System.out.println(this.getMove() + "Valid Move!");
                            } else
                                throw new PathWayException("Invalid Move For Bishops!5");
                        } else if (col - this.getColumn() < 0) {
                            if (row - this.getRow() > 0)//right
                            {
                                this.setBoardLocation(row, col);
                                System.out.println("Attack Move!");
                                System.out.println(this.getMove() + "Valid Move!");
                            } else if (row - this.getRow() < 0)//left
                            {
                                this.setBoardLocation(row, col);
                                System.out.println("Attack Move!");
                                System.out.println(this.getMove() + "Valid Move!");
                            } else
                                throw new IllegalMoveException("Invalid Move For Bishops!7");
                        } else
                            throw new PathWayException("Invalid Move For Bishops!8");
                    }
                }
                //black piece attacking white piece
                else if (Character.isLowerCase(ChessPiece.getTile(row, col).charAt(1)) && Character.isUpperCase(this.getPieceType())) {
                    int diffX = Math.abs(this.getRow() - row);
                    int diffY = Math.abs(this.getColumn() - col);

                    if (diffX - diffY != 0) {
                        throw new IllegalMoveException("Invalid Move For Bishops!4");
                    } else {
                        if (col - this.getColumn() > 0)//up
                        {
                            if (row - this.getRow() > 0)//right
                            {
                                System.out.println("Attack Move!");
                                this.setBoardLocation(row, col);
                                System.out.println(this.getMove() + "Valid Move!");
                            } else if (row - this.getRow() < 0)//left
                            {
                                System.out.println("Attack Move!");
                                this.setBoardLocation(row, col);
                                System.out.println(this.getMove() + "Valid Move!");
                            } else
                                throw new IllegalMoveException("Invalid Move For Bishops!5");
                        } else if (col - this.getColumn() < 0)//down
                        {
                            if (row - this.getRow() > 0)//right
                            {
                                System.out.println("Attack Move!");
                                this.setBoardLocation(row, col);
                                System.out.println(this.getMove() + "Valid Move!");
                            } else if (row - this.getRow() < 0)//left
                            {
                                System.out.println("Attack Move!");
                                this.setBoardLocation(row, col);
                                System.out.println(this.getMove() + "Valid Move!");
                            } else
                                throw new IllegalMoveException("Invalid Move For Bishops!7");
                        } else
                            throw new IllegalMoveException("Invalid Move For Bishops!8");
                    }
                }
            }
                if (ChessPiece.getTile(row, col).equals("---"))
                {
                    int diffX = Math.abs(this.getRow() - row);
                    int diffY = Math.abs(this.getColumn() - col);

                    if (diffX - diffY != 0) {
                        throw new IllegalMoveException("Invalid Move For Bishops!2");
                    }
                    else if(diffX - diffY == 0)
                    {
                        if (col - this.getColumn() > 0) // up
                        {
                            if (row - this.getRow() > 0) // right
                            {
                                this.setBoardLocation(row, col);
                                System.out.println(this.getMove() + "Valid Move!");
                            } else if (row - this.getRow() < 0)//left
                            {
                                this.setBoardLocation(row, col);
                                System.out.println(this.getMove() + "Valid Move!");
                            } else {
                                throw new IllegalMoveException("Invalid Move For Bishops1!");
                            }
                        }
                        else if (col - this.getColumn() < 0)//down
                        {
                            if (row - this.getRow() > 0)//right
                            {
                                this.setBoardLocation(row, col);
                                System.out.println(this.getMove() + "Valid Move!");
                            }
                            else if (row - this.getRow() < 0) // left
                            {
                                this.setBoardLocation(row, col);
                                System.out.println(this.getMove() + "Valid Move!");
                            } else
                                throw new IllegalMoveException("Invalid Move For Bishops2!");
                        }
                    }
                }
        }
        catch(OutOfBoardException oobe)
        {
            System.out.println(this.getMove()+" "+oobe.getMessage());
        }
        catch(IllegalMoveException ime)
        {
            System.out.println(this.getMove()+" "+ime.getMessage());
        }
        catch(PathWayException pwe)
        {
            System.out.println(this.getMove()+" "+pwe.getMessage());
        }
    }
}
