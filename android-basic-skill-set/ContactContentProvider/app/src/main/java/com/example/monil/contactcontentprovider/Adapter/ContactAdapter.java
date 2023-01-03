package com.example.monil.contactcontentprovider.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.monil.contactcontentprovider.R;
import com.example.monil.contactcontentprovider.Utils.AppConstatnts;
import com.example.monil.contactcontentprovider.model.Contact;

import java.util.ArrayList;

/**
 * Created by Volansys on 30/1/18.
 */
public class ContactAdapter extends BaseAdapter {
    Context context;
    private ArrayList<Contact> arrayList;

    public ContactAdapter( Context context,ArrayList<Contact> arrayList ) {
        this.arrayList = arrayList;
        this.context=context;
    }

    @Override
    public int getCount() {

        return arrayList.size();
    }

    @Override
    public Contact getItem(int position) {

        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Contact model = arrayList.get(position);
        ViewHodler holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.person_list, parent, false);
            holder = new ViewHodler();
            holder.contactImage = (ImageView) convertView
                    .findViewById(R.id.contactImage);
            holder.contactName = (TextView) convertView
                    .findViewById(R.id.contactName);
            holder.contactEmail = (TextView) convertView
                    .findViewById(R.id.contactEmail);
            holder.contactNumber = (TextView) convertView
                    .findViewById(R.id.contactNumber);

            convertView.setTag(holder);
        } else {
            holder = (ViewHodler) convertView.getTag();
        }

        // Set items to all view
        if (!model.getContactName().equals("")
                && model.getContactName() != null) {
            holder.contactName.setText(model.getContactName());
        } else {
            holder.contactName.setText(AppConstatnts.KEY_NAME_MESSAGE);
        }
        if (!model.getContactEmail().equals("")
                && model.getContactEmail() != null) {
            holder.contactEmail.setText(AppConstatnts.KEY_EMAIL
                    + model.getContactEmail());
        } else {
            holder.contactEmail.setText(AppConstatnts.KEY_EMAIL+ AppConstatnts.KEY_EMAIL_MESSAGE);
        }

        if (!model.getContactNumber().equals("")
                && model.getContactNumber() != null) {
            holder.contactNumber.setText(AppConstatnts.KEY_CONTACT
                    + model.getContactNumber());
        } else {
            holder.contactNumber.setText(AppConstatnts.KEY_CONTACT
                    + AppConstatnts.KEY_NUMBER_MESSAGE);
        }

        // Bitmap for imageview
        Bitmap image = null;
        if (!model.getContactPhoto().equals("")
                && model.getContactPhoto() != null) {
            image = BitmapFactory.decodeFile(model.getContactPhoto());// decode

            if (image != null)
                holder.contactImage.setImageBitmap(image);// Set image if bitmap
            else {
                image = BitmapFactory.decodeResource(context.getResources(),
                        R.drawable.ic_launcher_background);// if bitmap is null then set
                holder.contactImage.setImageBitmap(image);
            }
        } else {
            image = BitmapFactory.decodeResource(context.getResources(),
                    R.drawable.ic_launcher_background);
            holder.contactImage.setImageBitmap(image);
        }
        return convertView;
    }
    private class ViewHodler {
        ImageView contactImage;
        TextView contactName, contactNumber, contactEmail;
    }
}
