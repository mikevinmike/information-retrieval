package i2r.hlt;

import i2r.hlt.wrapper.TerrierWrapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/** This class shows how to index the collection. Load it into the memory.
 * Finally prints the size of the vocabulary (lexicon size).
 * 
 * @author parth
 *
 */
public class Indexing {
	TerrierWrapper terrier;
	static String terrier_home;
	static String path_to_data;
	static String lang;
	String indexPath;
	
	public static Indexing create() throws IOException {
		
		Path currentRelativePath = Paths.get("");
		String pathName = currentRelativePath.toAbsolutePath().toString();
		
		// Set following two variables with full path
		terrier_home = pathName + "/terrier-3.5";
		path_to_data = pathName + "/data";
		lang = "";
		
		Indexing index = new Indexing();
		index.terrier = new TerrierWrapper(terrier_home);
		
		// This is the place where the index will be created
		index.indexPath = pathName + "/index";
		
		return index;
	}
	public void loadIndex() throws IOException { 
		
		// Prefix is useful where there will be multiple indexes at the same directory for example, 
		// different languages.
		String prefix = "en";
		
		// This module indexes the collection if it is already not indexed.
		terrier.setIndex(indexPath, prefix);
		if(!new File(indexPath+prefix+".docid.map").exists()) {
			System.out.print("The index is not present, so indexing the collection...");
			terrier.prepareIndex(path_to_data, "sgm", "en", true, true);
			System.out.println("Done!");
		}
		
		// After index is created or already present, it is loaded into memory by following command
		terrier.loadIndex(indexPath, prefix, lang);
		
		
		// It prints the total dimension = total tokens in the index.
		System.out.println(terrier.getDimension());
	}
	public void printPostingsOfInvertedIndex() throws IOException {
		terrier.printPostingsOfInvertedIndex();
	}
}