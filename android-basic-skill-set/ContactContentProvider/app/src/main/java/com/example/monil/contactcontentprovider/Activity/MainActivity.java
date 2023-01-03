package com.example.monil.contactcontentprovider.Activity;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;
import android.widget.Toast;

import com.example.monil.contactcontentprovider.Adapter.ContactAdapter;
import com.example.monil.contactcontentprovider.R;
import com.example.monil.contactcontentprovider.Utils.AppConstatnts;
import com.example.monil.contactcontentprovider.model.Contact;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private static ListView contact_listview;
    private static ArrayList<Contact> arrayList;
    private static ContactAdapter adapter;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        prepareViews();
        setListeners();
        new LoadContacts().execute();
    }

    @Override
    protected void initComponent() {
        contact_listview = (ListView) findViewById(R.id.contact_listview);
    }

    @Override
    protected void prepareViews() {

    }

    @Override
    protected void setListeners() {

    }

    private ArrayList<Contact> readContacts() {
        ArrayList<Contact> contactList = new ArrayList<Contact>();

        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        Cursor contactsCursor = getContentResolver().query(uri, null, null,
                null, ContactsContract.Contacts.DISPLAY_NAME + " ASC ");

        if (contactsCursor.moveToFirst()) {
            do {
                long contctId = contactsCursor.getLong(contactsCursor
                        .getColumnIndex("_ID"));
                Uri dataUri = ContactsContract.Data.CONTENT_URI;

                Cursor dataCursor = getContentResolver().query(dataUri, null,
                        ContactsContract.Data.CONTACT_ID + " = " + contctId,
                        null, null);

                String displayName = "";

                String mobilePhone = "";
                String photoPath = "" + R.drawable.ic_launcher_background;
                byte[] photoByte = null;
                String homeEmail = "";
                String companyName = "";
                String title = "";
                String contactNumbers = "";
                String contactEmailAddresses = "";


                if (dataCursor.moveToFirst()) {
                    displayName = dataCursor.getString(dataCursor
                            .getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));// get

                    do {


                        if (dataCursor
                                .getString(
                                        dataCursor.getColumnIndex("mimetype"))
                                .equals(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)) {


                            switch (dataCursor.getInt(dataCursor
                                    .getColumnIndex("data2"))) {

                                case ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE:
                                    mobilePhone = dataCursor.getString(dataCursor
                                            .getColumnIndex("data1"));
                                    contactNumbers += "Mobile Phone : "
                                            + mobilePhone + "n";
                                    break;

                            }
                        }
                        if (dataCursor
                                .getString(
                                        dataCursor.getColumnIndex("mimetype"))
                                .equals(ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE)) {

                            switch (dataCursor.getInt(dataCursor
                                    .getColumnIndex("data2"))) {
                                case ContactsContract.CommonDataKinds.Email.TYPE_HOME:
                                    homeEmail = dataCursor.getString(dataCursor
                                            .getColumnIndex("data1"));
                                    contactEmailAddresses += "Home Email : "
                                            + homeEmail + "n";
                                    break;
                            }
                        }

                        if (dataCursor
                                .getString(
                                        dataCursor.getColumnIndex("mimetype"))
                                .equals(ContactsContract.CommonDataKinds.Photo.CONTENT_ITEM_TYPE)) {
                            photoByte = dataCursor.getBlob(dataCursor
                                    .getColumnIndex("data15")); // get photo in

                            if (photoByte != null) {


                                Bitmap bitmap = BitmapFactory.decodeByteArray(
                                        photoByte, 0, photoByte.length);
                                File cacheDirectory = getBaseContext()
                                        .getCacheDir();
                                File tmp = new File(cacheDirectory.getPath()
                                        + "/_androhub" + contctId + ".png");
                                try {
                                    FileOutputStream fileOutputStream = new FileOutputStream(
                                            tmp);
                                    bitmap.compress(Bitmap.CompressFormat.PNG,
                                            100, fileOutputStream);
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                } catch (Exception e) {

                                    e.printStackTrace();
                                }
                                photoPath = tmp.getPath();

                            }

                        }

                    } while (dataCursor.moveToNext());


                    contactList.add(new Contact(Long.toString(contctId),
                            displayName, contactNumbers, contactEmailAddresses,
                            photoPath));
                }

            } while (contactsCursor.moveToNext());
        }
        return contactList;
    }

    private class LoadContacts extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            pd= ProgressDialog.show(MainActivity.this, AppConstatnts.KEY_TITLE,AppConstatnts.KEY_MESSAGE);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            arrayList = readContacts();
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {

            super.onPostExecute(result);
            if (arrayList != null && arrayList.size() > 0) {

                getSupportActionBar().setSubtitle(
                        arrayList.size() + " Contacts");
                adapter = null;
                if (adapter == null) {
                    adapter = new ContactAdapter(MainActivity.this, arrayList);
                    contact_listview.setAdapter(adapter);
                }
                adapter.notifyDataSetChanged();
            } else {

                Toast.makeText(MainActivity.this, AppConstatnts.KEY_ERROR,
                        Toast.LENGTH_LONG).show();
            }

            if (pd.isShowing())
                pd.dismiss();
        }
    }
}
