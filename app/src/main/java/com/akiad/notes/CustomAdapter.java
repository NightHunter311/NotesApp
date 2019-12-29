package com.akiad.notes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    View.OnClickListener mOnClickListener;
    ArrayList notes;
    Context context;

    public CustomAdapter(Context context, ArrayList notes) {
        this.context = context;
        this.notes = notes;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.note.setText(notes.get(position).toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), NotesView.class);
                intent.putExtra("101", notes.get(position).toString());
                view.getContext().startActivity(intent);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Snackbar.make(v, "Do you wanna delete?", Snackbar.LENGTH_LONG)
                        .setAction("Delete", mOnClickListener = new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(v.getContext(), NotesView.class);
                                intent.putExtra("101", notes.get(position).toString());
                                notes.remove(notes.get(position));
                                notifyDataSetChanged();
                                Toast.makeText(v.getContext(), "Deleted", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
                return true;

            }
        });

    }

    public int getItemCount() {
        if(notes == null){
            return 0;
        }
        else return notes.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView note;

        public MyViewHolder(View itemView) {
            super(itemView);
            note = (TextView) itemView.findViewById(R.id.note);
        }
    }
}
  /*  public void saveArrayList(ArrayList<String> list, String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();     // This line is IMPORTANT !!!
    }

    public ArrayList<String> getArrayList(String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        return gson.fromJson(json, type);
    }
}
*/