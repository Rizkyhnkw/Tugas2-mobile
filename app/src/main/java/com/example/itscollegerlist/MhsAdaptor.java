package com.example.itscollegerlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MhsAdaptor extends BaseAdapter {
    private Context context;
    private ArrayList<Mahasiswa> member = new ArrayList<>();

    public void setMember(ArrayList<Mahasiswa> member) {
        this.member = member;
    }

    public MhsAdaptor(Context context) {
        this.context = context;
    }
    @Override
    public int getCount() {
        return member.size();
    }

    @Override
    public Object getItem(int position) {
        return member.get(position);
    }


    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_mhs, viewGroup, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag(); //Efisiensi memori
        }

        Mahasiswa mhs = member.get(position);
        viewHolder.bind(mhs);
        return convertView;
    }

    private class ViewHolder{
        private TextView tvNama, tvNim, tvProdi;
        private ImageView imgPhoto;
        public ViewHolder(View itemView) {
            tvNama = itemView.findViewById(R.id.tv_namasiswa);
            tvNim = itemView.findViewById(R.id.tv_nim);
            tvProdi = itemView.findViewById(R.id.tv_prodi);
            imgPhoto = itemView.findViewById(R.id.img_photo);
        }
        public void bind(Mahasiswa mhs){
            tvNama.setText(mhs.getNama());
            tvNim.setText(mhs.getNim());
            tvProdi.setText(mhs.getProdi());
            imgPhoto.setImageResource(mhs.getPhoto());
        }
    }
}
