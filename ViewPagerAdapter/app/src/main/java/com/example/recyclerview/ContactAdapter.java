package com.example.recyclerview;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private Context mContext;
    private List<Contact> mData;
    private Dialog myDialog;

    public ContactAdapter(Context mContext, List<Contact> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_contact, parent, false);
        final ContactViewHolder contactViewHolder = new ContactViewHolder(view);

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_contact);
        contactViewHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialog_name = myDialog.findViewById(R.id.dialog_name_id);
                TextView phone = myDialog.findViewById(R.id.dialog_phone_id);
                ImageView imageView = myDialog.findViewById(R.id.dialog_img);

                dialog_name.setText(mData.get(contactViewHolder.getLayoutPosition()).getNome());
                phone.setText(mData.get(contactViewHolder.getLayoutPosition()).getPhone());
                imageView.setImageResource(mData.get(contactViewHolder.getLayoutPosition()).getPhoto());
                myDialog.show();
            }
        });
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

        holder.tv_name.setText(mData.get(position).getNome());
        holder.tv_phone.setText(mData.get(position).getPhone());
        holder.img.setImageResource(mData.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ContactViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout item_contact;
        private TextView tv_name, tv_phone;
        private ImageView img;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            item_contact = itemView.findViewById(R.id.contact_item);
            tv_name = itemView.findViewById(R.id.name_contact);
            tv_phone = itemView.findViewById(R.id.phone_contact);
            img = itemView.findViewById(R.id.img_contact);
        }
    }
}
