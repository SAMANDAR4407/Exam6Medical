package uz.gita.exam6medical.presentation.adapter

import android.media.browse.MediaBrowser.ItemCallback
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.gita.exam6medical.data.model.common.DoctorData
import uz.gita.exam6medical.databinding.ItemDoctorBinding

/**
 *    Created by Kamolov Samandar on 28.05.2023 at 6:37
 */

class MyAdapter : ListAdapter<DoctorData, MyAdapter.Holder>(MyDiffUtil){
    private var clickListener: ((data: DoctorData) -> Unit)? = null
    fun setClickListener(block: (data: DoctorData) -> Unit){
        clickListener = block
    }

    object MyDiffUtil: DiffUtil.ItemCallback<DoctorData>(){
        override fun areItemsTheSame(oldItem: DoctorData, newItem: DoctorData): Boolean = oldItem == newItem
        override fun areContentsTheSame(oldItem: DoctorData, newItem: DoctorData): Boolean = oldItem.fullName == newItem.fullName
    }

    inner class Holder(private val binding: ItemDoctorBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                clickListener!!.invoke(currentList[adapterPosition])
            }
        }
        fun bind(data: DoctorData){
            binding.apply {
                name.text = data.fullName
                workAddress.text = data.hospital
                specialty.text = data.specialty
                rating.text = data.rating
                reviewCount.text = "(${data.reviews} reviews)"
                Glide.with(image).load(data.imageUrl).into(image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(ItemDoctorBinding.inflate(LayoutInflater.from(parent.context),parent, false))

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(currentList[position])
    }
}