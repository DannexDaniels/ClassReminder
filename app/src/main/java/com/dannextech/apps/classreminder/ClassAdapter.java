package com.dannextech.apps.classreminder;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ViewHolder>{
    private ClassModel[] classModel;
    private Context context;

    public ClassAdapter(ClassModel[] classModel, Context context) {
        this.classModel = classModel;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.class_details,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.tvName.setText(classModel[i].getcName());
        viewHolder.tvDate.setText(classModel[i].getcDate());
        viewHolder.tvTime.setText(classModel[i].getcTime());

        viewHolder.cvClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
                editor.putString("name",classModel[i].getcName());
                editor.putString("code",classModel[i].getcCode());
                editor.putString("venue",classModel[i].getcVenue());
                editor.putString("time",classModel[i].getcTime());
                editor.putString("date",classModel[i].getcDate());
                editor.putString("reminder",classModel[i].getcReminder());
                editor.apply();

                context.startActivity(new Intent(context, ClassDetails.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return classModel.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDate, tvTime;
        CardView cvClass;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tvClassDate);
            tvTime = itemView.findViewById(R.id.tvClassTime);
            tvName = itemView.findViewById(R.id.tvClassName);
            cvClass = itemView.findViewById(R.id.cvClass);
        }
    }
}
