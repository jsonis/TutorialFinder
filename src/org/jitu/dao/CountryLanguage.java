/**
 * 
 */
package org.jitu.dao;

import java.io.Serializable;

/**
 * @author jsonis
 *
 */
public class CountryLanguage implements Serializable {

	private String countryCode;
	private String language;
	private String percentage;
	private boolean isOffical;
	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @return the percentage
	 */
	public String getPercentage() {
		return percentage;
	}
	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	/**
	 * @return the isOffical
	 */
	public boolean isOffical() {
		return isOffical;
	}
	/**
	 * @param isOffical the isOffical to set
	 */
	public void setOffical(boolean isOffical) {
		this.isOffical = isOffical;
	}
	
	public CountryLanguage(String countryCode, String language,
			String percentage, boolean isOffical) {
		super();
		this.countryCode = countryCode;
		this.language = language;
		this.percentage = percentage;
		this.isOffical = isOffical;
	}
	
	public CountryLanguage() {
		
	}
	
	
}
