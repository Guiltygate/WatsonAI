/*
 * Written by Eric Ames
 * Java implementation of C4.5 for CSSE413.
 */
package kmad;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Random;

/**320 columns
 *
 * @author amesen
 */
public class J48 {
	static ArrayList<SpecTuple> output = new ArrayList<SpecTuple>();
	static ArrayList<Candidate> candidates;
	static ArrayList<ArrayList<Integer>> attributes;
	static boolean prepruning;
	static boolean postpruning;
	static File inFile;
	static int precision;
	final static File training = new File("TGMC training-sample.csv");
	static J48DecisionTree tree;
	
	//Base constructer, takes a data file location, numeric precision factor, and pre/post pruning options
	public J48(File data, int precision, boolean pre, boolean post, ArrayList<Candidate> cands){
		prepruning = pre;
		postpruning = post;
		candidates = cands;
		inFile = data;
		this.precision = precision;
		
	}
	
	public static void process(){
		//read in first question set, which will be training (not actual file format, check)
		readIn(true);
		
		//Preprocess the training data so that the tree can be built
		preProcess();
		
		//Build a decision tree based on the given training data
		buildDecisionTree();
		
		//Loop for each question, reading in only the candidates for the
		//current question.
		for(int i=0; i<8; i++){
			readIn(false);
			processSingleQuestion();
		}
	}
	
	//Reads candidates for 1 question
	public static void readIn(boolean isTraining){
		//cands will be built here if not passed in, still being discussed with group
		//Ask Ian for help with IO
		
		if(isTraining){
			//read in File training
		}else{
			//read in File inFile
		}
		
	}
	
	//Builds a new decision tree based on the given training set
	public static void buildDecisionTree(){
		tree = new J48DecisionTree(attributes, precision);
	}
	
	//Takes the training dataset read in by readIn and switches the columns and rows into
	//a new ArrayList containing each column as an entry. ONLY NEEDED FOR TRAINING DATA.
	public static void preProcess(){
		//Ask Ian what the hell we're doing with Candidates
	}
	
	//Runs a single question through the tree, using actual data (not training)
	public static void processSingleQuestion(){
		tree.analyze(candidates);
	}
	
}
