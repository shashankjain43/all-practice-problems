package com.practice.array;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Tsystems {

	public static void main(String[] args) {
		
		String link = "https://in.Yahoo.com/";
		String keyword = "Yahoo";
		Set<String> visitedLinks = new TreeSet<String>();
		Tsystems obj =  new Tsystems();
		obj.traverseLinks(visitedLinks, link, keyword);
		System.out.println("Size: "+visitedLinks.size());
		for(String str: visitedLinks) {
			System.out.println(str);
		}
	}

	public void traverseLinks(Set<String> visited, String link, String keyword){
		
		visited.add(link);
		Set<String> relevantLinks = getRelevantLinksFromURL(link, keyword);
		if(relevantLinks != null && !relevantLinks.isEmpty()) {
			for(String url: relevantLinks) {
				if(!visited.contains(url)) {
					traverseLinks(visited, url, keyword);
				}
			}
		}
	}

	public Set<String> getRelevantLinksFromURL(String url, String keyword)  {
		Set<String> list = new HashSet<String>();
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			Elements links = doc.select("a");

	        for (Element link : links) {
	        	if(link.attr("abs:href").contains(keyword)) {
	        		//System.out.println(link.attr("abs:href"));
	        		list.add(link.attr("abs:href"));
	        	}
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return list;
	}
}
