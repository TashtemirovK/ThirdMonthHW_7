package com.example.thirdmonthhw_7

class PersonAdapter(
    private val personList: List<Persons>,
    private val onClick: (person: Persons) -> Unit
) : Adapter<PersonAdapter.PersonViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(
            ItemPersonBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount() = personList.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind()
    }


    inner class PersonViewHolder(private val binding: ItemPersonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val item = personList[adapterPosition]

            binding.apply {
                tvName.text = item.name
                tvStatus.text = item.status
                imgPerson.setImageResource(item.image)
            }
            itemView.setOnClickListener {
                onClick.invoke(item)
            }
        }
    }

}