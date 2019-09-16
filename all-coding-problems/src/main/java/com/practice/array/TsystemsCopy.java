package com.practice.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class TsystemsCopy {

	public static void main(String[] args) {
		
		String link = "Yahoo.in";
		String keyword = "Yahoo";
		Map<String, Boolean> visitedLinks = new HashMap<String, Boolean>();
		TsystemsCopy obj =  new TsystemsCopy();
		obj.traverseLinks(visitedLinks, link, keyword);
		for(String str: visitedLinks.keySet()) {
			System.out.println(str);
		}
	}

	public void traverseLinks(Map<String, Boolean> visited, String link, String keyword){
		
		visited.put(link, true);
		List<String> relevantLinks = null;
		try {
			relevantLinks = getRelevantLinksFromURL(link, keyword);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//File htmlContent = getHTMLContentFromURL(link);
		//List<String> relevantLinks = listRelevantLinks(htmlContent);
		if(relevantLinks != null && !relevantLinks.isEmpty()) {
			for(String url: relevantLinks) {
				if(!visited.containsKey(url)) {
					traverseLinks(visited, link, keyword);
				}
			}
		}
		
	}

	private List<String> listRelevantLinks(File file) {
		// TODO Auto-generated method stub
		return null;
	}

	public File getHTMLContentFromURL(String link) {
		
		URL url;
		String fileName = "D:\\content\file.html";
		File file = new File(fileName);
		try {
			// get URL content
			url = new URL(link);
			URLConnection conn = url.openConnection();

			BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));
			String inputLine;
			if (!file.exists()) {
				file.createNewFile();
			}
			//use FileWriter to write file
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			while ((inputLine = br.readLine()) != null) {
				bw.write(inputLine);
			}
			bw.close();
			br.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}
	
	public List<String> getRelevantLinksFromURL(String url, String keyword) throws IOException {
		List<String> list = new ArrayList<String>();
		Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");

        for (Element link : links) {
        	if(link.text().contains(keyword)) {
        		list.add(link.text());
        	}
        }
        
        return list;

	}
}
