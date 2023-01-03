package com.example.monil.volleyexample.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.monil.volleyexample.Model.Person;
import com.example.monil.volleyexample.R;

import java.util.ArrayList;

/**
 * Created by Volansys on 3/1/18.
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private ArrayList<Person> personArrayList = new ArrayList<>();
    public ImageLoader imageLoader;
   
    public PersonAdapter(ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person = personArrayList.get(position);
        holder.id.setText(person.getId());
        holder.name.setText(person.getName());
        holder.mobile.setText(person.getMobile());
        holder.city.setText(person.getCity());

        String url = person.getImage().trim();

        imageLoader = CustomVolleyRequest.getInstance(holder.imageView.getContext())
                .getImageLoader();
        imageLoader.get(url, ImageLoader.getImageListener(holder.imageView,
                R.drawable.ic_launcher_background, android.R.drawable.ic_dialog_alert));
        holder.imageView.setImageUrl(url, imageLoader);

        holder.date.setText(person.getDate());
        holder.company.setText(person.getCompany());
        holder.profile.setText(person.getProfessional());
        holder.gender.setText(person.getGender());
    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView id, name, mobile,city,img,date,company,profile,gender;
        public NetworkImageView imageView;

        public ViewHolder(View view) {
            super(view);
            id = (TextView) view.findViewById(R.id.idTv);
            name = (TextView) view.findViewById(R.id.name);
            mobile = (TextView) view.findViewById(R.id.mobile);
            city = (TextView) view.findViewById(R.id.city);

            date = (TextView) view.findViewById(R.id.date);
            company = (TextView) view.findViewById(R.id.company);
            profile = (TextView) view.findViewById(R.id.profile);
            gender = (TextView) view.findViewById(R.id.gender);
            imageView = (NetworkImageView) view.findViewById(R.id.img);


        }
    }
}

