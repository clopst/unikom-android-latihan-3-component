package unikom.dimasnurfauzi.pahlawanindonesia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import unikom.dimasnurfauzi.pahlawanindonesia.R
import unikom.dimasnurfauzi.pahlawanindonesia.model.Hero

class ListHeroAdapter (
    private val listHero: ArrayList<Hero>,
            private val onItemClick: (Hero) -> Unit): RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

                private lateinit var onItemClickCallback: OnItemClickCallback

                fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
                    this.onItemClickCallback = onItemClickCallback
                }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHeroAdapter.ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listHero[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener { onItemClick(listHero[position]) }
    }

    override fun getItemCount(): Int = listHero.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_photo)
        var tvName: TextView = itemView.findViewById(R.id.text_name)
        var tvDescription: TextView = itemView.findViewById(R.id.text_description)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }


    }
