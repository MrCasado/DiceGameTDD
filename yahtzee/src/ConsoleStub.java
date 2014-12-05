import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ConsoleStub implements ConsoleInterface {

	private String prompt = " $: ";
	
	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public void writeLineToConSoleWithPrompt(String output)
	{
		System.out.print(output + prompt);
	}
	
	public void writeLineToConSoleWithNewLine(String output)
	{
		System.out.println(output);
	}
	
	public String readLineFromConsole()
	{
		return "testline";
	}
	
	
	
}
