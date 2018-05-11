public class Knight extends ChessPiece
{
    //using super from the ChessPiece constructor and adding the pieceNem
    public Knight(int row, int column, String teamColor)
    {
        super(row,column,"Knight", teamColor);

    }

    public String getTeamColor()
    {
        return this.teamColor;
    }

    public void move(int row, int col)
    {
        this.setMove(this.getPieceName()+": ("+(this.getRow())+","+(this.getColumn())+") (" + row+","+ col+")");

        try {
            //custom OutOfBoardException: if the coordinates are off the chess board
            //then this exception will be thrown
            if (row >= 8 || row < 0 || col >= 8 || col < 0)
                throw new OutOfBoardException("Invalid Move Off The Board!");

                //throws an exception if there is a piece in the space this piece is trying to move to
            if (!ChessPiece.getTile(row, col).equals("---")) {
                if (Character.isUpperCase((ChessPiece.getTile(row, col).charAt(1))) && Character.isUpperCase(this.getPieceType())) {
                    throw new PathWayException("You already have a piece there!");
                } else if (Character.isLowerCase(ChessPiece.getTile(row, col).charAt(1)) && Character.isLowerCase(this.getPieceType())) {
                    throw new PathWayException("There piece there!");
                } else if (Character.isUpperCase(ChessPiece.getTile(row, col).charAt(1)) && Character.isLowerCase(this.getPieceType())) {
                    if (this.teamColor.equalsIgnoreCase("white") && Math.abs(this.getColumn() - col) == 2 && Math.abs(this.getRow() - row) == 1) {
                        System.out.println("Attack Move!");;
                        this.setBoardLocation(row, col);
                        System.out.println(this.getMove() + "Valid Move!");
                    } else if (this.teamColor.equalsIgnoreCase("white") && Math.abs(this.getColumn() - col) == 1 && Math.abs(this.getRow() - row) == 2) {
                        System.out.println("Attack Move!");
                        this.setBoardLocation(row, col);
                        System.out.println(this.getMove() + "Valid Move!");
                    } else
                        throw new IllegalMoveException("Invalid Move For Knights(white)!");
                } else if (Character.isLowerCase(ChessPiece.getTile(row, col).charAt(1)) && Character.isUpperCase(this.getPieceType())) {
                    if (this.teamColor.equalsIgnoreCase("black") && Math.abs(this.getColumn() - col) == 2 && Math.abs(this.getRow() - row) == 1) {
                        System.out.println("Attack Move!");
                        this.setBoardLocation(row, col);
                        System.out.println(this.getMove() + "Valid Move!");
                    } else if (this.teamColor.equalsIgnoreCase("black") && Math.abs(this.getColumn() - col) == 1 && Math.abs(this.getRow() - row) == 2) {
                        System.out.println("Attack Move!");
                        this.setBoardLocation(row, col);
                        System.out.println(this.getMove() + "Valid Move!");
                    } else
                        throw new IllegalMoveException("Invalid Move For Knights(black)!");
                }

            }
            if(ChessPiece.getTile(row, col).equals("---"))
            {
                if(this.teamColor.equalsIgnoreCase("white") && Math.abs(this.getColumn() - col) == 2 && Math.abs(this.getRow() - row) == 1)
                {
                    this.setBoardLocation(row, col);
                    System.out.println(this.getMove() + "Valid Move!");
                }
                else if(this.teamColor.equalsIgnoreCase("white") && Math.abs(this.getColumn() - col) == 1 && Math.abs(this.getRow() - row) == 2)
                {
                    this.setBoardLocation(row, col);
                    System.out.println(this.getMove() + "Valid Move!");
                }
                else if(this.teamColor.equalsIgnoreCase("black") && Math.abs(this.getColumn() - col) == 2 && Math.abs(this.getRow() - row) == 1)
                {
                    this.setBoardLocation(row, col);
                    System.out.println(this.getMove() + "Valid Move!");
                }
                else if(this.teamColor.equalsIgnoreCase("black") && Math.abs(this.getColumn() - col) == 1 && Math.abs(this.getRow() - row) == 2)
                {
                    this.setBoardLocation(row, col);
                    System.out.println(this.getMove() + "Valid Move!");
                }
                else {
                    throw new IllegalMoveException("Invalid Move For Knights");
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


