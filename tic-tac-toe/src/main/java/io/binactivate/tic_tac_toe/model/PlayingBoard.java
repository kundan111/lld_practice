package io.binactivate.tic_tac_toe.model;


import io.binactivate.tic_tac_toe.exceptions.CellAlreadyFilledException;
import io.binactivate.tic_tac_toe.exceptions.IllegalBoardDimension;

public class PlayingBoard {

    private int row;
    private int col;
    private char[][] board;

    public PlayingBoard(int row, int col) {



        if(row <= 0 || col <= 0)
        {
            throw new IllegalBoardDimension("Invalid board dimension given");
        }
        if(row != col)
        {
            throw new IllegalBoardDimension("Invalid board dimension given");
        }

        this.row = row;
        this.col = col;

        board = new char[row][col];
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                board[i][j] = '.';
            }
        }
        
    }

    public boolean isBoardWon(int row, int col, char c)
    {
        return isAnyDiagonalWon(c) || isThisColWon(col, c) || isThisRowWon(row, c);
    }

    public boolean isCellWithinRange(int x, int y)
    {
        return ((x >= 0 && x < row) && (y >= 0 && y < col));
    }

    public boolean isCellEmpty(int x, int y)
    {
        if(!isCellWithinRange(x,y))
        {
            throw new IllegalBoardDimension("Invalid board dimension given");
        }

        return board[x][y] == '.';
    }

    public boolean isThisRowWon(int rowNum, char c)
    {
        for(int i = 0; i < col; i++)
        {
            if(board[rowNum][i] != c)
            {
                return false;
            }
        }
        return true;
    }


    public boolean isThisColWon(int colNum, char c)
    {
        for(int i = 0; i < row; i++)
        {
            if(board[i][colNum] != c)
            {
                return false;
            }
        }
        return true;
    }

    public boolean isAnyDiagonalWon(char c)
    {
        return isfirstDiagonalWon(c) || isSecondDiagonalWon(c);
    }

    public boolean isfirstDiagonalWon(char c)
    {
        for(int i = 0; i < row; i++)
        {
            if(board[i][i] != c)
            {
                return false;
            }
        }


        return true;
    }

    boolean isSecondDiagonalWon(char c)
    {
        for(int i = 0; i < row; i++)
        {
            if(board[i][row-i-1] != c)
            {
                return false;
            }
        }
        return true;
    }

    public void fillWith (int x, int y, char c)
    {
        if(!isCellWithinRange(x, y))
        {
            throw new IllegalBoardDimension("Invalid board dimension given");
        }
        if(board[x][y] != '.')
        {
            throw new CellAlreadyFilledException("cell Already Filled");
        }
        board[x][y] = c;
    }


    public void displayBoard()
    {
        System.out.println("\n========================\n");
        for(char[] row: board)
        {
            for(char c : row)
            {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println("\n========================\n");
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public int getTotalNumberOfCellsInBoard()
    {
        return row*col;
    }

    

    
}
