package HackerRank;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamAppender {
	public static void main(String[] args) {
		String stringArr[] = { "Sandal ", "Teak ", "Pine " };
		Stream<String> stringStream = Arrays.stream(stringArr);
		//stringStream.forEach(e -> e + " Wood").filter(e -> e.equals("Teak Wood")).forEach(e -> System.out.println(e));
	}
}