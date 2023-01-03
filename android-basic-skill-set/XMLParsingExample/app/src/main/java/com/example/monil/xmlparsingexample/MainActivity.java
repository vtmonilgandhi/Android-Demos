package com.example.monil.xmlparsingexample;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

import com.example.monil.xmlparsingexample.adapter.CountryListAdapter;
import com.example.monil.xmlparsingexample.model.CountryCodeModel;
import com.example.monil.xmlparsingexample.xmlhandler.XMLHandler;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<CountryCodeModel> countryCodeList = new ArrayList<CountryCodeModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listView);
        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            parser.parse(getResources().openRawResource(R.raw.country_name_isd2), handler);
            countryCodeList = handler.getList();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Resources.NotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        CountryListAdapter adapter = new CountryListAdapter(
                MainActivity.this, countryCodeList);
        listView.setAdapter(adapter);

    }
}
