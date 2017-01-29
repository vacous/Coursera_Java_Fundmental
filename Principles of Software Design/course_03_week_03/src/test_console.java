import edu.duke.FileResource;

public class test_console {
	public static void main(String[] args)
	{
//		MarkovOne test_one = new MarkovOne();
//		String address = "data/confucius.txt";
//		FileResource file_resource = new FileResource(address);
//		String input_string = file_resource.asString();
//		test_one.setRandom(42);
//		test_one.setTraining(input_string);
//		String test_string = test_one.getRandomText(500);
//		System.out.println(test_string);
		
		MarkovRunner test_runner = new MarkovRunner();
//		test_runner.runMarkovOne();
//		test_runner.runMarkovFour();
		test_runner.runMarkovModel(6);
	}

}
