package com.example.monil.mvvmdemo;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.ObservableField;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Volansys on 9/4/18.
 */
public class ProductViewModel extends BaseObservable {

    public ObservableField<String> mproducts = new ObservableField<>();
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> price = new ObservableField<>("");
    public ObservableField<String> quantity = new ObservableField<>("");
    private Context mContext;

    public ProductViewModel(Context context) {
        mContext = context;
    }

    @BindingAdapter({"android:textColor"})
    public static void setColor(TextView view, String color) {
            view.setTextColor(Color.parseColor("#63f421"));
            view.setTextSize(20);

    }

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        return new ColorDrawable(color);
    }
    @Bindable
    public String getProducts() {
        return mproducts.toString();
    }

    public void addProducts(Product product) {
        mproducts.set("\nName : " + product.getName() +
                "\nPrice : " + product.getPrice() +
                "\nQuantity : " + product.getQuantity());
        notifyPropertyChanged(com.example.monil.mvvmdemo.BR.products);
    }

    public View.OnClickListener onAddListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProducts(new Product(name.get(), price.get(), quantity.get()));
            }
        };
    }
}
