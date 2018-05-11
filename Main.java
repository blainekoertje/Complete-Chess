import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean gameOver = false;
        int turnCounter = 0;
        Scanner scan = new Scanner(System.in);
        ArrayList<ChessPiece> locationList = new ArrayList<ChessPiece>();
        ChessBoard newBoard = new ChessBoard();

        System.out.println("Welcome to Chess!");

        Rook leftRook = new Rook(0, 0, "white");
        locationList.add(leftRook);
        Rook rightRook = new Rook(7, 0, "white");
        locationList.add(rightRook);
        Knight leftKnight = new Knight(1, 0, "white");
        locationList.add(leftKnight);
        Knight rightKnight = new Knight(6, 0, "white");
        locationList.add(rightKnight);
        Bishop leftBishop = new Bishop(2, 0, "white");
        locationList.add(leftBishop);
        Bishop rightBishop = new Bishop(5, 0, "white");
        locationList.add(rightBishop);
        King king = new King(4, 0, "white");
        locationList.add(king);
        Queen queen = new Queen(3, 0, "white");
        locationList.add(queen);
        Pawn pawn0 = new Pawn(0, 1, "white");
        locationList.add(pawn0);
        Pawn pawn1 = new Pawn(1, 1, "white");
        locationList.add(pawn1);
        Pawn pawn2 = new Pawn(2, 1, "white");
        locationList.add(pawn2);
        Pawn pawn3 = new Pawn(3, 1, "white");
        locationList.add(pawn3);
        Pawn pawn4 = new Pawn(4, 1, "white");
        locationList.add(pawn4);
        Pawn pawn5 = new Pawn(5, 1, "white");
        locationList.add(pawn5);
        Pawn pawn6 = new Pawn(6, 1, "white");
        locationList.add(pawn6);
        Pawn pawn7 = new Pawn(7, 1, "white");
        locationList.add(pawn7);

        Rook RIGHTROOK = new Rook(7, 7, "black");
        locationList.add(RIGHTROOK);
        Rook LEFTROOK = new Rook(0, 7, "black");
        locationList.add(LEFTROOK);
        Knight RIGHTKNIGHT = new Knight(6, 7, "black");
        locationList.add(RIGHTKNIGHT);
        Knight LEFTKNIGHT = new Knight(1, 7, "black");
        locationList.add(LEFTKNIGHT);
        Bishop LEFTBISHOP = new Bishop(2, 7, "black");
        locationList.add(LEFTBISHOP);
        Bishop RIGHTBISHOP = new Bishop(5, 7, "black");
        locationList.add(RIGHTBISHOP);
        King KING = new King(4, 7, "black");
        locationList.add(KING);
        Queen QUEEN = new Queen(3, 7, "black");
        locationList.add(QUEEN);
        Pawn PAWN0 = new Pawn(0, 6, "black");
        locationList.add(PAWN0);
        Pawn PAWN1 = new Pawn(1, 6, "black");
        locationList.add(PAWN1);
        Pawn PAWN2 = new Pawn(2, 6, "black");
        locationList.add(PAWN2);
        Pawn PAWN3 = new Pawn(3, 6, "black");
        locationList.add(PAWN3);
        Pawn PAWN4 = new Pawn(4, 6, "black");
        locationList.add(PAWN4);
        Pawn PAWN5 = new Pawn(5, 6, "black");
        locationList.add(PAWN5);
        Pawn PAWN6 = new Pawn(6, 6, "black");
        locationList.add(PAWN6);
        Pawn PAWN7 = new Pawn(7, 6, "black");
        locationList.add(PAWN7);
        System.out.println(newBoard.toString());



        while (!gameOver) {

            if(turnCounter % 2 == 0) {
                System.out.println("Turn Counter: " + turnCounter);
                System.out.println("It's White's Turn");
                System.out.print("Enter coordinates of piece you'd like to move(current x current y new x new y): ");
                String line = scan.nextLine();
                String[] stringArray = line.split(" ");
                int[] coordinates = new int[stringArray.length];

                for (int i = 0; i < stringArray.length; i++) {
                    coordinates[i] = Integer.parseInt(stringArray[i]);
                }
                if (!newBoard.getTile(coordinates[0], coordinates[1]).equals("---")) {
                    for (int j = 0; j < locationList.size(); j++) {
                        if (locationList.get(j).getRow() == coordinates[0] && locationList.get(j).getColumn() == coordinates[1] && locationList.get(j).teamColor.equalsIgnoreCase("white")) {
                            for (int k = 0; k < locationList.size(); k++) {
                                if (locationList.get(k).getRow() == coordinates[2] && locationList.get(k).getColumn() == coordinates[3] && locationList.get(k).getPieceName().equalsIgnoreCase("king")) {
                                    locationList.get(j).move(coordinates[2], coordinates[3]);
                                    gameOver = true;
                                    System.out.println("Black King Is In Check!");
                                    System.out.println("White Team Wins!");
                                    System.exit(0);
                                }
                            }
                            locationList.get(j).move(coordinates[2], coordinates[3]);
                            turnCounter++;
                            System.out.println(newBoard.toString());
                        }
                    }
                    for (int d = 0; d < locationList.size(); d++) {
                        if (locationList.get(d).getColumn() == 7) {
                            if (locationList.get(d).getPieceName().equalsIgnoreCase("pawn")) {
                                if (locationList.get(d).teamColor.equalsIgnoreCase("white") && locationList.get(d).getColumn() == 7) {
                                    int tempRowWhite = locationList.get(d).getRow();
                                    int tempColWhite = locationList.get(d).getColumn();
                                    locationList.remove(d);
                                    Queen pawnToWhite = new Queen(tempRowWhite, tempColWhite, "white");
                                    locationList.set(d, pawnToWhite);
                                    newBoard.setTile("-q-", tempRowWhite, tempColWhite);

                                }
                            }
                        }
                    }

                } else {
                    System.out.println("It's Black's Turn!");
                }
                System.out.println("Turn Counter: " + turnCounter);
            }
            if(turnCounter % 2 == 1)
            {
                System.out.println("It's Blacks Turn!");
                System.out.print("Enter coordinates of piece you'd like to move(current x current y new x new y): ");
                String line = scan.nextLine();
                String[] stringArray = line.split(" ");
                int[] coordinates = new int[stringArray.length];

                for (int i = 0; i < stringArray.length; i++) {
                    coordinates[i] = Integer.parseInt(stringArray[i]);
                }

                if (!newBoard.getTile(coordinates[0], coordinates[1]).equals("---")) {
                    for (int index = 0; index < locationList.size(); index++) {
                        if (locationList.get(index).getRow() == coordinates[0] && locationList.get(index).getColumn() == coordinates[1] && locationList.get(index).teamColor.equalsIgnoreCase("black")) {
                            for(int n = 0; n < locationList.size(); n++)
                            {
                                if(locationList.get(n).getRow() == coordinates[2] && locationList.get(n).getColumn() == coordinates[3] && locationList.get(n).getPieceName().equalsIgnoreCase("king"))
                                {
                                    locationList.get(index).move(coordinates[2], coordinates[3]);
                                    gameOver = true;
                                    System.out.println("White King Is In Check!");
                                    System.out.println("Black Team Wins!");
                                    System.exit(0);
                                }
                            }
                            locationList.get(index).move(coordinates[2], coordinates[3]);
                            turnCounter++;
                            System.out.println(newBoard.toString());
                        }
                    }
                    for(int i = 0; i < locationList.size(); i++)
                    {
                        if(locationList.get(i).getColumn() == 0)
                        {
                            if(locationList.get(i).getPieceName().equalsIgnoreCase("pawn"))
                            {
                                if(locationList.get(i).teamColor.equalsIgnoreCase("black") && locationList.get(i).getColumn() == 0)
                                {
                                    int temporaryRow = locationList.get(i).getRow();
                                    int temporaryColumn = locationList.get(i).getColumn();
                                    locationList.remove(i);
                                    Queen pawnToQueenBlack = new Queen(temporaryRow, temporaryColumn, "black");
                                    locationList.set(i, pawnToQueenBlack);
                                    newBoard.setTile("-Q-",temporaryRow, temporaryColumn);
                                }
                            }
                        }
                    }
                }
                else
                    {
                        System.out.println("It's White's Turn!");
                    }
                }
            }
    }
}