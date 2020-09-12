package com.example.demo.nlp;

import com.example.demo.nlp.tools.CBLemmatizer;
import com.example.demo.nlp.tools.CBTokenizer;

import java.util.HashMap;
import java.util.Map;

public class NLPProcessor {
	public static Map<String, String> findVBNNpair(String input){

		String[] tokens = CBTokenizer.tokens(input);
		String[] tags = CBLemmatizer.tags(tokens);
		String[] lemmas = CBLemmatizer.lemmatize(tokens, tags);
		
		Map<String, String> map = findVBNNpair(tokens, tags, lemmas);
		
		return map;
	}
	
	public static Map<String, String> findVBNNpair(String[] tokens, String[] tags, String[] lemmas){
		Map<String, String> map = new HashMap<String, String>();
		String VB="";
		String VBIN = "";
		String NN = "";
		for(int i= 0;i < tags.length;i++) {
			if(tags[i].startsWith("VB")) {
				VB = lemmas[i].equals("O")?tokens[i]:lemmas[i];
				if(!"".equals(NN))
					map.put(VB, NN);
			}
			if(tags[i].equals("NN")) {
				NN = tokens[i];
				if(!"".equals(VB)) {
					map.put(VB, NN);
				}
				if(!"".equals(VBIN)) {
					map.put(VBIN, NN);
				}
			}
		}
		return map;
	}
	
}
