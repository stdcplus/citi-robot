package com.example.demo.nlp.tools;

import com.example.demo.nlp.NLPConfig;
import opennlp.tools.lemmatizer.DictionaryLemmatizer;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

import java.io.IOException;
import java.io.InputStream;

public class CBLemmatizer {
	public static String[] tags(String[] tokens) {
		try {
			InputStream posModelIn = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(NLPConfig.POS_MAXENT);

			POSModel posModel = new POSModel(posModelIn);
			POSTaggerME posTagger = new POSTaggerME(posModel);
			String tags[] = posTagger.tag(tokens);
			return tags;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String[] lemmatize(String[] tokens, String[] tags) {
		try {
			InputStream dictLemmatizer = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(NLPConfig.LIMMATIZER);
			DictionaryLemmatizer lemmatizer = new DictionaryLemmatizer(dictLemmatizer);
			
			String[] lemmas = lemmatizer.lemmatize(tokens, tags);
			return lemmas;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
