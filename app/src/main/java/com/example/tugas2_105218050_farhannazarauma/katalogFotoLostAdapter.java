package com.example.tugas2_105218050_farhannazarauma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class katalogFotoLostAdapter extends RecyclerView.Adapter<katalogFotoLostAdapter.KatalogFotoViewHolder> {

    private LayoutInflater mInflater;

    public katalogFotoLostAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public KatalogFotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = mInflater.inflate(R.layout.katalog_foto_item,parent, false);

        return new KatalogFotoViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull KatalogFotoViewHolder holder, int position) {
        KatalogFoto katalogFoto = KatalogFotoUtil.getKatalogFotoAt(position);
        holder.ivKatalogFoto.setImageResource (katalogFoto.getResId());
        holder.tvFilename.setText (katalogFoto.getFilename ());
    }

    @Override
    public int getItemCount() {

        return KatalogFotoUtil.getKatalogFotoList().size();
    }

    class KatalogFotoViewHolder extends RecyclerView.ViewHolder{

        final Button btncetak;
        final Button[] btnUkuranArray;
        final ImageView ivKatalogFoto;
        final TextView tvFilename;
        private katalogFotoLostAdapter mAdapter;

        private int[] resBtnUkuranArray = {
                R.id.buttonR3,
                R.id.buttonR4,
                R.id.buttonR8,
                R.id.buttonR10,
        };

        public KatalogFotoViewHolder(@NonNull View itemView, katalogFotoLostAdapter _mAdapter) {
            super(itemView);
            mAdapter = _mAdapter;

            btncetak = itemView.findViewById(R.id.buttoncetak);

            ivKatalogFoto= itemView.findViewById(R.id.iv_keranjang);

            tvFilename = itemView.findViewById(R.id.tv_filenamefotolog);

            btnUkuranArray = new Button[resBtnUkuranArray.length];

            for(int i=0;i<resBtnUkuranArray.length;i++){
                btnUkuranArray[i] = itemView.findViewById(resBtnUkuranArray[i]);

                btnUkuranArray[i].setOnClickListener(view -> {
                        Button btn = (Button) view;
                        int itemPos = getLayoutPosition();
                        OrderFotoUtil.addOrder(KatalogFotoUtil.getKatalogFotoAt(itemPos), btn.getText().toString());
            });




            }
        }
    }
}