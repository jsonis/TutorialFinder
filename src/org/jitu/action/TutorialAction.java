/**
 * 
 */
package org.jitu.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jitu.dao.CountryLanguage;

/**
 * @author jsonis
 *
 */
public class TutorialAction {

	private TutorialServiceFinder tutorialServiceFinder = null;
	
	private String bestTutorialSite;
	
	private List<CountryLanguage> lstCountryLanguage= new ArrayList<CountryLanguage>();
	
	public String execute(){
		tutorialServiceFinder = new TutorialServiceFinder();
		//String bestSite = tutorialServiceFinder.getBestTutorialSite();
		//System.out.println("@@ best Site:"+bestSite);
		//setBestTutorialSite(bestSite);
		this.lstCountryLanguage = (List<CountryLanguage>) tutorialServiceFinder.getAllCountryLanguage();
		setLstCountryLanguage(lstCountryLanguage);
		Iterator itr = lstCountryLanguage.iterator();
		while(itr.hasNext()){
			CountryLanguage CL = (CountryLanguage) itr.next();
			//System.out.println("@@ best Site:"+CL.getCountryCode());
		}
		//System.out.println("@@ best Site:"+lstCountryLanguage.size());
		return "success";
	}

	/**
	 * @return the bestTutorialSite
	 */
	public String getBestTutorialSite() {
		return bestTutorialSite;
	}

	/**
	 * @param bestTutorialSite the bestTutorialSite to set
	 */
	public void setBestTutorialSite(String bestTutorialSite) {
		this.bestTutorialSite = bestTutorialSite;
	}

	/**
	 * @return the lstCountryLanguage
	 */
	public List<CountryLanguage> getLstCountryLanguage() {
		return lstCountryLanguage;
	}

	/**
	 * @param lstCountryLanguage the lstCountryLanguage to set
	 */
	public void setLstCountryLanguage(List<CountryLanguage> lstCountryLanguage) {
		this.lstCountryLanguage = lstCountryLanguage;
	}
}
