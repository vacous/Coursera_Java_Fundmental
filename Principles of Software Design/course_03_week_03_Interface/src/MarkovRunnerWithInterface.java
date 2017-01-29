
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*; 

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size, boolean if_use_seed,int seed_num) {
        markov.setTraining(text);
        if (if_use_seed)
        {
            markov.getRandomText(seed_num);
        }
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
			String st= markov.getRandomText(size);
			printOut(st);
		}
    }
    
    public void runMarkov() {
        FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 500;
		
//        MarkovZero mz = new MarkovZero();
//        runModel(mz, st, size, false, -1);
//    
//        MarkovOne mOne = new MarkovOne();
//        runModel(mOne, st, size, false, -1);
//        
//        MarkovModel mThree = new MarkovModel(3);
//        runModel(mThree, st, size, false, -1);
//        
//        MarkovFour mFour = new MarkovFour();
//        runModel(mFour, st, size, false, -1);
//        
        EfficientMarkovModel m_efficient = new EfficientMarkovModel(6);
        runModel(m_efficient, st, size, true, 38);
    }

	private void printOut(String s){
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}
	
}
