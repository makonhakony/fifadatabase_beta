package com.example.hakony.fifadatabase;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class PlayerAdapter extends ArrayAdapter<Player> {
    private ArrayList<Player> playerArrayList;
    private LayoutInflater vi;
    int Resource;

    public PlayerAdapter(Context context, int resource, ArrayList<Player> objects) {
        super(context, resource, objects);
        vi = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resource = resource;
        playerArrayList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder holder;
        if (v == null) {
            holder = new ViewHolder();
            v = vi.inflate(Resource, null);
            holder.ivAvatar = (ImageView) v.findViewById(R.id.avatarImage);
            holder.tvName = (TextView) v.findViewById(R.id.playerName);
            holder.tvPos = (TextView) v.findViewById(R.id.Position);
            holder.ivLogo = (ImageView) v.findViewById(R.id.logo);
            holder.ivSkill = (ImageView) v.findViewById(R.id.Skill);
            holder.tvPos1 = (TextView) v.findViewById(R.id.Position1);
            holder.tvPos1val = (TextView) v.findViewById(R.id.Position1Val);
            holder.ivClub = (ImageView) v.findViewById(R.id.club);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        Picasso.get().load(playerArrayList.get(position).getAvatar()).error(R.drawable.error).fit().into(holder.ivAvatar);
        Picasso.get().load(playerArrayList.get(position).getClub()).error(R.drawable.error).fit().into(holder.ivClub);
//        new DownloadImageTask (holder.ivAvatar).execute(playerArrayList.get(position).getAvatar());
//        new DownloadImageTask (holder.ivClub).execute(playerArrayList.get(position).getClub());
//        if (playerArrayList.get(position).getNation_squad_id()!="-1")
//            new DownloadImageTask (holder.ivNational).execute(playerArrayList.get(position).getNational());
        holder.tvName.setText(playerArrayList.get(position).getName());
        holder.tvPos.setText(playerArrayList.get(position).getPos());
        holder.tvPos1.setText(playerArrayList.get(position).getPos1());
        holder.tvPos1val.setText(playerArrayList.get(position).getPos1val());
        switch (playerArrayList.get(position).getYear_short()) {
            case "NHD":
                holder.ivLogo.setImageResource(R.drawable.nhd);
                break;
            case "LIVE":
                holder.ivLogo.setImageResource(R.drawable.live);
                break;
            case "TB":
                holder.ivLogo.setImageResource(R.drawable.tb);
                break;
            case "18TOTY":
                holder.ivLogo.setImageResource(R.drawable.toty);
                break;
        }
        switch (playerArrayList.get(position).getSkill_level()) {
            case "1":
                holder.ivSkill.setImageResource(R.drawable.onestar);
                break;
            case "2":
                holder.ivSkill.setImageResource(R.drawable.twostar);
                break;
            case "3":
                holder.ivSkill.setImageResource(R.drawable.threestar);
                break;
            case "4":
                holder.ivSkill.setImageResource(R.drawable.fourstar);
                break;
            case "5":
                holder.ivSkill.setImageResource(R.drawable.fivestar);
                break;
        }
        return v;
    }

    static class ViewHolder {
        public ImageView ivAvatar;
        public TextView tvName;
        public TextView tvPos;
        public ImageView ivLogo;
        public ImageView ivSkill;
        public TextView tvPos1;
        public TextView tvPos1val;
        public ImageView ivClub;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmView) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return mIcon11;
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                constraint = constraint.toString().toLowerCase();
                FilterResults results = new FilterResults();

                if (constraint != null && constraint.toString().length() > 0) {
                    ArrayList<Player> founded = new ArrayList<>();
                    for (Player item : playerArrayList) {
                        if (item.getName().toLowerCase().contains(constraint)) {
                            founded.add(item);
                        }
                    }
                    results.values = founded;
                    results.count = founded.size();
                } else {
                    results.values = playerArrayList;
                    results.count = playerArrayList.size();
                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                clear();
                for (Player item : (ArrayList<Player>) results.values) {
                    add(item);
                }
                notifyDataSetChanged();
            }
        };
    }
}