package com.example.tugas2_105218050_farhannazarauma;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class OrderFotoListAdapter extends RecyclerView.Adapter<OrderFotoListAdapter.OrderFotoViewHolder>{

    private LayoutInflater mInflater;

    public OrderFotoListAdapter(Context context){

        mInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public OrderFotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.order_foto_item, parent, false);

        return new OrderFotoViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderFotoViewHolder holder, int position) {
        OrderFoto order = OrderFotoUtil.getOrderAt(position);
        KatalogFoto katalogFoto = order.getKatalogFoto();
        holder.ivOrderFoto.setImageResource (katalogFoto.getResId());
        holder.tvFilenameOrderFoto.setText (katalogFoto.getFilename());
        holder.tvukuran.setText (order.getUkuran ());
        holder.tvNumOrder.setText (order.getNumOrder ()+" ");
        holder.tvsubtotal.setText (idrFormatter.format(order.getHargasubtotal()));

    }


    @Override
    public int getItemCount() {
        return OrderFotoUtil.getOrderCount();
    }

    class OrderFotoViewHolder extends RecyclerView.ViewHolder{
        final TextView tvFilenameOrderFoto, tvukuran, tvNumOrder, tvsubtotal;
        final Button btnDel, btnIncorder, btnDecOrder;
        final ImageView ivOrderFoto;
        OrderFotoListAdapter mAdapter;

        public OrderFotoViewHolder (@NonNull View itemView, OrderFotoListAdapter _mAdapter){
            super(itemView);
            mAdapter = _mAdapter;
            tvFilenameOrderFoto = itemView.findViewById(R.id.tv_filenamefotolog);
            tvukuran = itemView.findViewById(R.id.tv_Ukurantxt);
            tvNumOrder = itemView.findViewById(R.id.tv_foto_number);
            tvsubtotal = itemView.findViewById(R.id.tv_sub_price);


            btnDel = itemView.findViewById(R.id.btn_delete);
            btnDel.setOnClickListener(view -> {
                int itemPos = getLayoutPosition();
                OrderFotoUtil.removeOrderAt(itemPos);
            });

            btnIncorder = itemView.findViewById(R.id.btn_tambah);
            btnIncorder.setOnClickListener(view -> {
                int itemPos = getLayoutPosition();
                OrderFotoUtil.addoneToOrder(itemPos);
                notifyItemChanged(itemPos);
            });

            btnDecOrder = itemView.findViewById(R.id.btn_kurang);



            ivOrderFoto = itemView.findViewById(R.id.iv_keranjang);
        }
    }

}
