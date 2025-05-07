package adapters;
import static android.os.Build.VERSION_CODES.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import models.Depense;


public class AdapteurDepense extends BaseAdapter {

    private Context context;
    private List<Depense> expenses;

    public AdapteurDepense(Context context, List<Depense> expenses) {
        this.context = context;
        this.expenses = expenses;
    }

    @Override
    public int getCount() {
        return expenses.size();
    }

    @Override
    public Object getItem(int i) {
        return expenses.get(i);
    }

    @Override
    public long getItemId(int i) {
        return expenses.get(i).getId();
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R, viewGroup, false);

        TextView textAmount = view.findViewById(R);
        TextView textDescription = view.findViewById(R);

        Depense expense = expenses.get(i);

        textAmount.setText("Montant: " + expense.getAmount() + " €");
        textDescription.setText("Description: " + expense.getDescription());

        return view;
    }
}
