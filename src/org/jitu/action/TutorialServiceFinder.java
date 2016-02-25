/**
 * 
 */
package org.jitu.action;

import java.util.ArrayList;
import java.util.List;

import org.jitu.dao.CountryLanguage;
import org.jitu.dao.CountryLanguageDao;

/**
 * @author jsonis
 *
 */
public class TutorialServiceFinder {

	public String getBestTutorialSite(){
		CountryLanguageDao countryLanguageDao = new CountryLanguageDao();
		return countryLanguageDao.findCountryLanguage("IND");
	}
	
	public List<?> getAllCountryLanguage(){
		CountryLanguageDao countryLanguageDao = new CountryLanguageDao();
		return countryLanguageDao.getAllCountryLanguage();
	}
}
