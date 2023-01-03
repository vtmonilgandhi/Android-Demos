package com.example.monil.volleygsonexample.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.monil.volleygsonexample.Model.Clients;
import com.example.monil.volleygsonexample.R;

import java.util.ArrayList;

/**
 * Created by monil on 25/1/18.
 */

public class ClientsAdapter  extends RecyclerView.Adapter<ClientsAdapter.ViewHolder> {

        ArrayList<Clients> Clients;

public ClientsAdapter(ArrayList<Clients> Clients) {
        this.Clients = Clients;
        }

@Override
public ClientsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.clients_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

        }

@Override
public void onBindViewHolder(ClientsAdapter.ViewHolder holder, int position) {
    Clients clients = Clients.get(position);
        holder.id.setText(clients.getId());
        holder.company.setText(clients.getCompany());

        }

@Override
public int getItemCount() {
        return Clients.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView id, company;


    public ViewHolder(View view) {
        super(view);
        id = (TextView) view.findViewById(R.id.idTv);
        company = (TextView) view.findViewById(R.id.companyTv);



    }
}
}

