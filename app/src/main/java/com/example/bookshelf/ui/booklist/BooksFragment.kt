package com.example.bookshelf.ui.booklist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.bookshelf.R
import com.example.bookshelf.databinding.FragmentBooksBinding
import com.example.bookshelf.domain.model.books.Book
import com.example.bookshelf.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BooksFragment : Fragment() {

    private var _binding: FragmentBooksBinding? = null
    private val binding get() = _binding!!
    private val mainViewModel by activityViewModels<MainViewModel>()
    private val booksViewModel by viewModels<BooksViewModel>()
    private var booksAdapter: BooksAdapter? = null
    private var books = mutableListOf<Book>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBooksBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initObservers()
    }

    private fun initObservers() {
        booksViewModel.bookState.observe(viewLifecycleOwner) {
            when (it) {
                is BooksState.Loading -> {
//                    binding.progressBar.visibility = View.VISIBLE
                }
                is BooksState.Empty -> {

                }
                is BooksState.NetworkRefresh -> {
                    booksViewModel.getBooks()
                }
                is BooksState.Success -> {
                    Log.d("TAG", "initObservers: ${it.books}")
//                    binding.progressBar.visibility = View.GONE
                    if (!it.books.isNullOrEmpty()){
                        books.clear()
                        books.addAll(it.books)
                        booksAdapter?.notifyDataSetChanged()
                    } else {
                        booksViewModel.refreshBook()
                    }
                }
                is BooksState.Error -> {

                }
            }
        }
    }

    private fun initAdapter() {
        booksAdapter = BooksAdapter(books, object : BooksAdapter.OnInteraction{
            override fun onEditClick(book: Book, position: Int) {

            }

            override fun onItemClick(book: Book, position: Int) {

            }
        })
        binding.rvBooks.adapter = booksAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
        _binding = null
    }


}