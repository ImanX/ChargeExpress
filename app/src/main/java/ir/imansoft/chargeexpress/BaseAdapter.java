package ir.imansoft.chargeexpress;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Android ZarinPal SDK Library v0.1 Project.
 * Created by ImanX on 12/2/16.
 * Copyright Alireza Tarazani All Rights Reserved.
 */
public abstract class BaseAdapter<Element, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private List<Element> elementList;
    private int           size;
    private Context       context;


    @LayoutRes
    public abstract int getLayout();

    public abstract VH onCreteViewHolder(View view);

    public abstract void onBind(Element element, VH vh, int position);

    public BaseAdapter(List<Element> elementList) {
        this.elementList = elementList;
        this.size = elementList.size();
    }

    public Context getContext() {
        return this.context;
    }

    public List<Element> getElementList() {
        return this.elementList;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {

        return onCreteViewHolder(LayoutInflater.from(parent.getContext()).inflate(getLayout(), null));
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        Element item = this.elementList.get(position);
        onBind(item , holder , position);
    }

    @Override
    public int getItemCount() {
        return (this.elementList == null) ? 0 : this.size;
    }
}
