package Interviews;

/*
 * Asked in Arista 
 * 
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.Map.Entry;

class Result {
	// This method is called on "register-client" input.
	public static void registerClient(int clientId, int windowSize) {
		// Implement this
		// Hash Map for clients
		if (!Solution.clients.containsKey(clientId)) {
			Solution.clients.put(clientId, windowSize);
		}
	}

	// This method is called on "new-message" input. Use the provided
	// Solution.sendMessage() method to send a message to the client. The
	// `more` argument to sendMessage should be false when called from this
	// method.
	public static void newMessage(int clientId, int msgId, int msgAge) {
		// Implement this
		// check if client is registered, else leave it be
		if (Solution.clients.containsKey(clientId)) {
			HashMap<Integer, Integer> currQue = new HashMap<Integer, Integer>(); 
			// When a new message comes, check the message window, based on count call
			// sendMessage or queue it
			int currWindowSize = Solution.clients.get(clientId);
			if (currWindowSize > 0) {
				Solution.sendMessage(clientId, msgId, msgAge, false);
				currWindowSize--;
				Solution.clients.put(clientId, currWindowSize);
			} else {
				if (Solution.messageQue.containsKey(clientId)) {
					// When queuing, need to check if we have any previou message with same msg id,
					// if so, the max age should be considered and replaced accordingly.

					 currQue = Solution.messageQue.get(clientId);
					if(currQue.containsKey(msgId)) {
						int currMsgAge = currQue.get(msgId); 
						currQue.put(msgId, Math.max(msgAge,currMsgAge));
					}else {
						currQue.put(msgId, msgAge);
					}
					// Queue needs to be a sorted on for should be quick delete as well ..

					if(currQue.size() >= Solution.MAX_MSG_PER_CLIENT) {
						for(Entry curr : currQue.entrySet()) {
							currQue.remove(curr.getKey()); 
							break;  
						}
					}
					
					
				}else {
					
					currQue.put(msgId, msgAge); 
					
				}
				Solution.messageQue.put(clientId, currQue);
			}

		}

	}

	// This method is called on "adjust-window" input. Use the provided
	// Solution.sendMessage() method to send a message to the client. If
	// multiple messages have to be sent due to message window adjustment, the
	// `more` argument to sendMessage() should be false for the last message
	// (and true for all others).
	public static void adjustWindow(int clientId, int windowSize) {
		// Implement this
		
		// check if client is registered, else leave it be
		if (Solution.clients.containsKey(clientId)) {
			// when adjust comes, get number of message windows, 
			Solution.clients.put(clientId, windowSize);
			// check the queue and send out messages.
			HashMap<Integer, Integer> currQue = Solution.messageQue.get(clientId);
			HashMap<Integer, Integer> currQueDup = (HashMap<Integer, Integer>) currQue.clone(); 
			for(Entry curr : currQue.entrySet()) {
				if(windowSize > 1) {
				// TODO: when the last message of currQue comes, then call sendMessage with false 					
				Solution.sendMessage(clientId, (int)curr.getKey(), currQue.get(curr.getKey()) ,  true);
				currQueDup.remove((int)curr.getKey()); 
				windowSize--; 
				}else if(windowSize ==1 ) {
					Solution.sendMessage(clientId, (int)curr.getKey(), currQue.get(curr.getKey()) ,  false);
					currQueDup.remove((int)curr.getKey()); 
					windowSize--;
				}else {
					break; 
				}
			}
			
			Solution.messageQue.put(clientId, currQueDup); 
			Solution.clients.put(clientId, windowSize);
		}
		
	}

}

public class Solution {
	// Actions
	public static final String REGISTER_CLIENT = "register-client";
	public static final String NEW_MSG = "new-message";
	public static final String ADJUST_WINDOW = "adjust-window";
	public static final String EXIT = "exit";
	public static final int MAX_MSG_PER_CLIENT = 100;
	public static HashMap<Integer, Integer> clients = new HashMap<Integer, Integer>();

	public static HashMap<Integer, HashMap<Integer, Integer>> messageQue = new HashMap<Integer, HashMap<Integer, Integer>>();
	private static BufferedWriter bufferedWriter;

	// This method is used to send a message to a client.
	// params:
	// clientId - client identifier
	// msgId - message identifier
	// msgAge - message Age
	// more - true if more messages are to be sent to the client as part of
	// processing the current command.
	public static void sendMessage(int clientId, int msgId, int msgAge, boolean more) {
		try {
			// bufferedWriter.write("(" + clientId + ", " + msgId + ", " + msgAge + ")" +
			// (more?" ":"\n"));
			System.out.println("(" + clientId + ", " + msgId + ", " + msgAge + ")" + (more ? " " : "\n"));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static void main(String[] args) throws IOException {
		// bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));
		try (Scanner scanner = new Scanner(System.in)) {
			Scanner s = scanner.useDelimiter("\\s+");
			boolean exit = false;
			while (!exit) {
				String cmd = s.next();
				if (!cmd.isEmpty()) {
					switch (cmd) {
					case REGISTER_CLIENT:
						Result.registerClient(s.nextInt(), s.nextInt());
						break;
					case NEW_MSG:
						Result.newMessage(s.nextInt(), s.nextInt(), s.nextInt());
						break;
					case ADJUST_WINDOW:
						Result.adjustWindow(s.nextInt(), s.nextInt());
						break;
					case EXIT:
						exit = true;
						break;
					default:
						System.out.println("Unknown input " + cmd);
						break;
					}
				}
			}
		} finally {
			// bufferedWriter.close();
		}
	}
}
