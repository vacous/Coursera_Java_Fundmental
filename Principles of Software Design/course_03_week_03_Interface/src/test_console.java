import edu.duke.FileResource;

public class test_console {
	public static void main(String[] args)
	{
		FileResource quiz_file = new FileResource("data/confucius.txt");
		String input_string = quiz_file.asString();
		input_string = input_string.replace('\n', ' ');
//		String input_string = "Is there a ere, there is a test";
		System.out.println("Question 2: ");
		EfficientMarkovModel test_model_char = new EfficientMarkovModel(5);
		test_model_char.setTraining(input_string);
		test_model_char.setRandom(531);
		test_model_char.map_builder();

	}
}
