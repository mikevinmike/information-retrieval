package at.ac.fhkufstein;

import i2r.hlt.Indexing;

import java.io.IOException;

public class InformationRetrieval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Indexing indexing = Indexing.create();
			indexing.loadIndex();
			indexing.printPostingsOfInvertedIndex();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
