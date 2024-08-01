package com.example.bookshelf.ui.booklist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookshelf.databinding.BookItemBinding
import com.example.bookshelf.domain.model.books.Book

class BooksAdapter(private val books: MutableList<Book>, private val interaction: OnInteraction): RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = BookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[holder.adapterPosition]
        holder.onBind(book, position)
    }

    override fun getItemCount(): Int = books.size

    inner class BookViewHolder(val binding: BookItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(book: Book, position: Int) {
            binding.book = book
            binding.edit.setOnClickListener {
                interaction.onEditClick(book, position)
            }
            binding.viewBook.setOnClickListener {
                interaction.onItemClick(book, position)
            }
            binding.executePendingBindings()
        }
    }

    interface OnInteraction {
        fun onItemClick(book: Book, position: Int)
        fun onEditClick(book: Book, position: Int)
    }
}