package at.ac.fhkufstein;

import i2r.hlt.Indexing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InformationRetrieval {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Indexing indexing = Indexing.create();
            indexing.loadIndex();
            startUI(indexing);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void startUI(Indexing indexing) {
        String input = "";
        Scanner sc = new Scanner(System.in);
        while(!input.equals("quit")) {
            System.out.println("");
            System.out.println("Insert the number of the feature you wish to start, you can exit by typing in \"quit\"");
            System.out.println("1) print postings of inverted index");
            System.out.println("2) start query mode (exit by submit empty search)");
            input = sc.nextLine();
            if(input.equals("1")) {
                printPostingsOfInvertedIndex(indexing);
            } else if(input.equals("2")) {
                startQueryMode(indexing);
            }
        }
    }
    
    public static void printPostingsOfInvertedIndex(Indexing indexing) {
        try {        
            indexing.printPostingsOfInvertedIndex();
        } catch (IOException ex) {
            Logger.getLogger(InformationRetrieval.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void startQueryMode(Indexing indexing) {
        String term;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\nsearch: ");
            term = sc.nextLine();
            if(term.equals("")) {
                break;
            }
            try {
                ArrayList<QueryResult> queryResults = indexing.query(term);
                System.out.println("found term in " + queryResults.size() + " docs");
                for (QueryResult result : queryResults) {
                    System.out.println(result);
                }
            } catch (IOException ex) {
                System.err.println("Error: could not search for term \"" + term + "\"");
            }
            System.out.println("==========================");

        }

    }

}
