package p.vikpo.homecontrol.presenters.adapters.itemchooser;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChooserViewHolder extends RecyclerView.ViewHolder
{
    private ChooserLayout layout;

    ChooserViewHolder(@NonNull ChooserLayout layout)
    {
        super(layout);
        this.layout = layout;
    }


    void bind(String name)
    {

    }
}
