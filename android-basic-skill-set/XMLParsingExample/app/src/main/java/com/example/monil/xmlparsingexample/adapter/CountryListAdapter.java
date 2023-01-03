package com.example.monil.xmlparsingexample.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.monil.xmlparsingexample.R;
import com.example.monil.xmlparsingexample.model.CountryCodeModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CountryListAdapter extends ArrayAdapter<CountryCodeModel> {
	Context context;
	ArrayList<CountryCodeModel> countryData = new ArrayList<CountryCodeModel>();

	public CountryListAdapter(Context context,ArrayList<CountryCodeModel> objects) {
		super(context, R.layout.list_item, objects);
		this.context = context;
		this.countryData = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.list_item, null);
			viewHolder = new ViewHolder();
			viewHolder.code = (TextView) convertView.findViewById(R.id.code);
			viewHolder.shortName = (TextView) convertView
					.findViewById(R.id.shortName);
			viewHolder.name = (TextView) convertView.findViewById(R.id.name);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		CountryCodeModel data = getItem(position);

		viewHolder.code.setText(data.getCountryCode());
		viewHolder.name.setText(data.getCountryName());
		viewHolder.shortName.setText(data.getCountryShortCode());

		return convertView;
	}

	private static class ViewHolder {
		private TextView name;
		private TextView code;
		private TextView shortName;
	}

}
