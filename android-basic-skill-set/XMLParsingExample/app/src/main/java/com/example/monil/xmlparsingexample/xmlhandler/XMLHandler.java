

package com.example.monil.xmlparsingexample.xmlhandler;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.example.monil.xmlparsingexample.model.CountryCodeModel;

/**
 * @author ravi sharma
 *
 */
public class XMLHandler extends DefaultHandler {

	boolean bCountryCode = false;
	boolean bCountryName = false;
	boolean bCountryShortCode = false;

	ArrayList<CountryCodeModel> countryCodeList = new ArrayList<CountryCodeModel>();

	private CountryCodeModel countryCode = null;

	public ArrayList<CountryCodeModel> getList() {

		return countryCodeList;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
							 Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("value")) {
			bCountryCode = true;
		} else if (qName.equalsIgnoreCase("country")) {
			bCountryName = true;
			countryCode = new CountryCodeModel();
		} else if (qName.equalsIgnoreCase("alpha3")) {
			bCountryShortCode = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		if (qName.equalsIgnoreCase("alpha3")) {
			countryCodeList.add(countryCode);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (bCountryCode) {
			bCountryCode = false;
			countryCode.setCountryCode(new String(ch, start, length));
		} else if (bCountryName) {
			bCountryName = false;
			countryCode.setCountryName(new String(ch, start, length));
		} else if (bCountryShortCode) {
			bCountryShortCode = false;
			countryCode.setCountryShortCode(new String(ch, start, length));
		}
	}

}

