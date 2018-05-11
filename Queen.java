public class Queen extends ChessPiece
{
    public Queen(int row, int column, String teamColor)
    {
        super(row,column,"Queen", teamColor);

    }

    public String getTeamColor()
    {
        return this.teamColor;
    }

    public void move(int row, int column)
    {
        this.setMove(this.getPieceName()+": ("+(this.getRow())+","+(this.getColumn())+") (" + row+","+ column+")");

        try {
            if(this.teamColor.equalsIgnoreCase("white"))
            {
                for(int i = getColumn();i < (column - 1);i++)
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
                for(int g = getColumn();g > (column + 1);g--)
                {
                    for(int h = getRow(); h > (row + 1); h++) {
                        if (!mainBoard.getTile(row - 1, g - 1).equals("---")) {
                            throw new PathWayException("Piece in the way");
                        }
                    }
                }
            }


            if (row >= 8 || row < 0 || column >= 8 || column < 0)
                throw new OutOfBoardException("Invalid Move Off The Board!");
            else if (!ChessPiece.getTile(row, column).equals("---")) {
                int diffX = Math.abs(this.getRow() - row);
                int diffY = Math.abs(this.getColumn() - column);
                //white piece tries to move to a tile that is already filled with a white piece
                if (Character.isLowerCase(ChessPiece.getTile(row, column).charAt(1)) && Character.isLowerCase(this.getPieceType())) {
                    throw new PathWayException("You Already Have A White Piece There!");
                }
                //black piece tries to move to a tile that is filled with a black piece already
                else if (Character.isUpperCase(ChessPiece.getTile(row, column).charAt(1)) && Character.isUpperCase(this.getPieceType())) {
                    throw new PathWayException("You Already Have A Black Piece There!");
                }
                //white piece attacking black piece
                else if (Character.isUpperCase(ChessPiece.getTile(row, column).charAt(1)) && Character.isLowerCase(this.getPieceType())) {
                    if (this.teamColor.equalsIgnoreCase("white") && this.getRow() == row && ((Math.abs(column - this.getColumn()) >= 0) || Math.abs(column - this.getColumn()) <= 7)) {
                        System.out.println("Attack Move!");
                        this.setBoardLocation(row, column);
                        System.out.println(this.getMove() + "Valid Move!");
                    } else if (this.teamColor.equalsIgnoreCase("white") && this.getColumn() == column && ((Math.abs(row - this.getRow()) >= 0) || Math.abs(row - getRow()) <= 7)) {
                        System.out.println("Attack Move!");
                        this.setBoardLocation(row, column);
                        System.out.println(this.getMove() + "Valid Move!");
                    } else if (diffX - diffY == 0) {
                        if (this.getColumn() - column > 0)//up
                        {
                            if (this.getRow() - row > 0)//right
                            {
                                System.out.println("Attack Move!");
                                this.setBoardLocation(row, column);
                                System.out.println(this.getMove() + "Valid Move!");
                            } else if (this.getRow() - row < 0)//left
                            {
                                System.out.println("Attack Move!");
                                this.setBoardLocation(row, column);
                                System.out.println(this.getMove() + "Valid Move!");
                            } else
                                throw new IllegalMoveException("Invalid Queen Move!1");
                        } else if (this.getColumn() - column < 0)//down
                        {
                            if (this.getRow() - row > 0) {
                                System.out.println("Attack Move!");
                                this.setBoardLocation(row, column);
                                System.out.println(this.getMove() + "Valid Move!");
                            } else if (this.getRow() - row < 0) {
                                System.out.println("Attack Move!");
                                this.setBoardLocation(row, column);
                                System.out.println(this.getMove() + "Valid Move!");
                            } else
                                throw new IllegalMoveException("Invalid Queen Move!2");
                        }
                    } else
                        throw new IllegalMoveException("Illegal Move For Queens(white)!");
                }
                //black piece attakcing white piece
                else if (Character.isLowerCase(ChessPiece.getTile(row, column).charAt(1)) && Character.isUpperCase(getPieceType())) {
                    if (this.teamColor.equalsIgnoreCase("black") && this.getRow() == row && ((Math.abs(column - this.getColumn()) >= 0) || Math.abs(column - this.getColumn()) <= 7)) {
                        System.out.println("Attack Move!");
                        this.setBoardLocation(row, column);
                        System.out.println(this.getMove() + "Valid Move!");
                    } else if (this.teamColor.equalsIgnoreCase("black") && this.getColumn() == column && ((Math.abs(row - this.getRow()) >= 0) || Math.abs(row - getRow()) <= 7)) {
                        System.out.println("Attack Move!");
                        this.setBoardLocation(row, column);
                        System.out.println(this.getMove() + "Valid Move!");
                    } else if (diffX - diffY == 0) {
                        if (this.getColumn() - column > 0)//up
                        {
                            if (this.getRow() - row > 0)//right
                            {
                                System.out.println("Attack Move!");
                                this.setBoardLocation(row, column);
                                System.out.println(this.getMove() + "Valid Move!");
                            } else if (this.getRow() - row < 0)//left
                            {
                                System.out.println("Attack Move!");
                                this.setBoardLocation(row, column);
                                System.out.println(this.getMove() + "Valid Move!");
                            } else
                                throw new IllegalMoveException("Invalid Queen Move!1");
                        } else if (this.getColumn() - column < 0)//down
                        {
                            if (this.getRow() - row > 0) {
                                System.out.println("Attack Move!");
                                this.setBoardLocation(row, column);
                                System.out.println(this.getMove() + "Valid Move!");
                            } else if (this.getRow() - row < 0) {
                                System.out.println("Attack Move!");
                                this.setBoardLocation(row, column);
                                System.out.println(this.getMove() + "Valid Move!");
                            } else
                                throw new IllegalMoveException("Invalid Queen Move!2");
                        } else
                            throw new IllegalMoveException("Illegal Move For Queens(black)!");
                    }
                }
            }
                else if (ChessPiece.getTile(row, column).equals("---")) {
                    if ((this.teamColor.equalsIgnoreCase("white") && this.getRow() == row && ((Math.abs(column - this.getColumn()) >= 0) || Math.abs(column - this.getColumn()) <= 7))) {
                        this.setBoardLocation(row, column);
                        System.out.println(this.getMove() + "Valid Move!");

                    } else if (this.teamColor.equalsIgnoreCase("white") && this.getColumn() == column && ((Math.abs(row - this.getRow()) >= 0) || Math.abs(row - getRow()) <= 7)) {
                        this.setBoardLocation(row, column);
                        System.out.println(this.getMove() + "Valid Move!");
                    } else if (this.teamColor.equalsIgnoreCase("white") && (Math.abs(this.getColumn() - column) / Math.abs(this.getRow() - row)) == 1) {
                        this.setBoardLocation(row, column);
                        System.out.println(this.getMove() + "Valid Move!");
                    } else if (this.teamColor.equalsIgnoreCase("black") && this.getRow() == row && ((Math.abs(column - this.getColumn()) >= 0) || Math.abs(column - this.getColumn()) <= 7)) {
                        this.setBoardLocation(row, column);
                        System.out.println(this.getMove() + "Valid Move!");
                    } else if (this.teamColor.equalsIgnoreCase("black") && this.getColumn() == column && ((Math.abs(row - this.getRow()) >= 0 || Math.abs(row - this.getRow()) <= 7))) {
                        this.setBoardLocation(row, column);
                        System.out.println(this.getMove() + "Valid Move!");
                    } else if (this.teamColor.equalsIgnoreCase("black") && (Math.abs(this.getColumn() - column) / Math.abs(this.getRow() - row)) == 1) {
                        this.setBoardLocation(row, column);
                        System.out.println(this.getMove() + "Valid Move!");
                    } else {
                        throw new IllegalMoveException("Invalid Move For Queens");
                    }
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
