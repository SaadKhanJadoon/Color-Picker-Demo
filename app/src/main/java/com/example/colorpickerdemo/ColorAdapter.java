package com.example.colorpickerdemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorHolder> {
    Context context;
    List<Integer> colors;
    ColorInterface colorInterface;

    public ColorAdapter(List<Integer> colorPickerColors, Context context, ColorInterface colorInterface) {
        this.context = context;
        this.colors = colorPickerColors;
        this.colorInterface = colorInterface;
    }

    @NonNull
    @Override
    public ColorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coloradapter, parent, false);
        return new ColorHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorHolder holder, int position) {
        holder.colorPickerView.setBackgroundColor(colors.get(position));
    }



    @Override
    public int getItemCount() {
        return colors.size();
    }

    public class ColorHolder extends RecyclerView.ViewHolder {
        public View colorPickerView;
        public ColorHolder(@NonNull View itemView) {
            super(itemView);
            colorPickerView = itemView.findViewById(R.id.color_picker_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (colorInterface != null)
                        colorInterface.selectedColor(colors.get(getAdapterPosition()));
                    Log.e("TAG", "onClick: "+getAdapterPosition() );
                }
            });
        }
    }
}
