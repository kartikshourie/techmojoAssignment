package com.twitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import twitter4j.TwitterException;

public class TenTrendingTwitterHashTags {

	public static void main(String[] args) throws IOException, TwitterException {
		Scanner input = new Scanner(System.in);
		Map<String, Integer> map = new HashMap<String, Integer>();
		int count = 1;
		List<Entry<String, Integer>> sortedEntries = null;
		while(true) {
			count = 1;
			String line = input.nextLine();
			String[] tweet = line.split(" ");
			for (int j = 0; j < tweet.length; j++) {
				if (tweet[j].contains("#")) {
					if (!map.containsKey(tweet[j].substring(1))) {
						map.put(tweet[j].substring(1), count);
					} else {
						count = map.get(tweet[j].substring(1));
						count++;
						map.put(tweet[j].substring(1), count);
					}

				}
			}
			sortedEntries = new ArrayList<Entry<String, Integer>>(map.entrySet());
			Collections.sort(sortedEntries, new Comparator<Entry<String, Integer>>() {
				@Override
				public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
					return e2.getValue().compareTo(e1.getValue());
				}
			});
			if(sortedEntries.size()==10) {
				break;
			}

		}
		

		for (Map.Entry<String, Integer> m : sortedEntries) {
			System.out.println(m.getKey());
		}
	}

}
