package HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
 * Complete the 'lastStoneWeight' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY weights as parameter.
 */

public class CrashingStone {
	public static void main(String[] args) throws IOException {
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//		int weightsCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//		List<Integer> weights = new ArrayList<>();
//
//		for (int i = 0; i < weightsCount; i++) {
//			int weightsItem = Integer.parseInt(bufferedReader.readLine().trim());
//			weights.add(weightsItem);
//		}
//
//		int result = lastStoneWeight(weights);
//
//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();
//
//		bufferedReader.close();
//		bufferedWriter.close();

		List<Integer> weights = new ArrayList<Integer>();
		weights.add(46188086);
		weights.add(339992587);
		weights.add(742976890);
		weights.add(801915058);
		weights.add(393898202);
		weights.add(717833291);
		weights.add(843435009);
		weights.add(361066046);
		weights.add(884145908);
		weights.add(668431192);
		weights.add(586679703);
		weights.add(792103686);
		weights.add(85425451);
		weights.add(246993674);
		weights.add(134274127);
		weights.add(586374055);
		weights.add(923288873);
		weights.add(292845117);
		weights.add(399188845);
		weights.add(842456591);
		weights.add(410257930);
		weights.add(333998862);
		weights.add(16561419);
		weights.add(624279391);
		weights.add(459765367);
		weights.add(969764608);
		weights.add(508221973);
		weights.add(82956997);
		weights.add(437034793);
		weights.add(553121267);
		weights.add(554066040);
		weights.add(199416087);

		System.out.println(lastStoneWeightV2(weights));
		;

	}

	public static int lastStoneWeightV2(List<Integer> weights) {
		int runningSum = 0;
		if (weights.size() > 0) {
			PriorityQueue<Integer> weightQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
			for (int i = 0; i < weights.size(); i++) {
				weightQueue.offer(weights.get(i));
			}
			while (weightQueue.size() > 1) {
				int top = weightQueue.poll();
				int secondTop = weightQueue.poll();
				if (top != secondTop) {
					int running = Math.abs(top - secondTop);
					weightQueue.offer(running);
				}
			}
			runningSum = weightQueue.size() == 1 ? weightQueue.poll() : 0;
		}
		return runningSum;
	}

	public static int lastStoneWeight(List<Integer> weights) {
		// Write your code here
		int runningSum = 0;
		if (weights.size() > 0) {
			runningSum = weights.get(weights.size() - 1);
			for (int i = weights.size() - 2; i > 0; i--) {
				if (runningSum != 0) {
					runningSum = runningSum - weights.get(i);
				} else {
					runningSum = weights.get(i);
				}
			}
		}
		return runningSum;
	}
}
