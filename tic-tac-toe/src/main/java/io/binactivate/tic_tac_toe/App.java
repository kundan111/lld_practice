package io.binactivate.tic_tac_toe;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

import io.binactivate.tic_tac_toe.model.PlayingBoard;
import io.binactivate.tic_tac_toe.model.User;
import io.binactivate.tic_tac_toe.service.UserService;

/**
 * Hello world!
 *
 */
// https://workat.tech/machine-coding/practice/design-tic-tac-toe-smyfi9x064ry
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        FileReader fr = new FileReader("src\\main\\java\\resources\\tic-tac-toe-ascii.txt");    
        
        int i;    
        while((i=fr.read())!=-1)    
        {

            System.out.print((char)i);    
        }
        fr.close();   
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter dimension of tic-tac-toe board: ");
        int row = sc.nextInt();
        int col = row;

        // create a new Board
        PlayingBoard pb = new PlayingBoard(row, col);

        // Enter number of users
        System.out.println("Enter number of players: ");
        int numberOfUsers = sc.nextInt();

        int count = 0;
        while (numberOfUsers-- > 0) {
            System.out.println("Enter details for user " + ++count + " :\n");
            
            System.out.print("Enter name: ");
            String name = sc.next();
            
            System.out.print("Enter playing symbol: ");
            char symbol = sc.next().charAt(0);

            while(!('A' <= symbol && symbol <= 'Z'))
            {
                System.out.println("Enter symbol between A And Z");
                System.out.print("Enter playing symbol: ");
                symbol = sc.next().charAt(0);
            }

            // create user

            UserService.creatUser(name, symbol);

            System.out.println("\n=======================\n");
        }


        System.out.println("\n\n\n======================== Starting Game ========================\n\n\n");

        pb.displayBoard();


        int totalNumbersofCells = pb.getTotalNumberOfCellsInBoard();
        int turns = 1;

        HashMap<Character, User> allUsers = UserService.getAllUsers();
        
        ArrayList<User> al = new ArrayList<>();
        
        for(Entry<Character, User> entry :  allUsers.entrySet())
        {
            al.add(entry.getValue());
        }
        

        int curentTurn = 0;

        System.out.println(al.get(curentTurn).getName() + "'s turn \n");
        

        System.out.println("Enter row number: ");
        int curRowInp = sc.nextInt();
        System.out.println("Enter col number: ");
        int curColInp = sc.nextInt();

        char curSymbol = al.get(curentTurn).getPlayingSymbol();


        pb.fillWith(curRowInp, curColInp, curSymbol);
        pb.displayBoard();
        User lastUser = al.get(curentTurn);
        while(turns != totalNumbersofCells && !pb.isBoardWon(curRowInp, curColInp, curSymbol))
        {
            turns++;
            curentTurn++;
            if(curentTurn == al.size())
            {
                curentTurn = 0;
            }
            lastUser = al.get(curentTurn);
            System.out.println(al.get(curentTurn).getName() + "'s turn \n");

            System.out.println("Enter row number: ");
            curRowInp = sc.nextInt();
            System.out.println("Enter col number: ");
            curColInp = sc.nextInt();
            curSymbol = al.get(curentTurn).getPlayingSymbol();
            pb.fillWith(curRowInp, curColInp, curSymbol);
            pb.displayBoard();
            
        }

        if(pb.isBoardWon(curRowInp, curColInp, curSymbol))
        {
            System.out.println(lastUser.getName() + " won..........");

        }else{
            System.out.println("No one won ...........");
        }

        

        

        sc.close();


        /*
        PlayingBoard pb = new PlayingBoard(8, 8);
        
        Scanner sc = new Scanner(System.in);

        
            System.out.println("Enter row Num: ");
            int row = sc.nextInt();
            
            System.out.println("Enter col Num: ");
            int col = sc.nextInt();

            System.out.println("Enter symbol: ");
            char c =  sc.next().charAt(0);


            pb.fillWith(row, col, c);
            while (!pb.isBoardWon(row, col, c)) {
                    pb.displayBoard();
                    System.out.println("Enter row Num: ");
                    row = sc.nextInt();
                    System.out.println("Enter col Num: ");
                    col = sc.nextInt();
                    System.out.println("Enter symbol: ");
                    c =  sc.next().charAt(0);
                    pb.fillWith(row, col, c);
                }
                pb.displayBoard();           

        sc.close();
        */
        
    }
}
