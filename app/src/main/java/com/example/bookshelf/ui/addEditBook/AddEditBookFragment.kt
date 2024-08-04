package com.example.bookshelf.ui.addEditBook

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.bookshelf.databinding.FragmentAddEditBookBinding
import com.example.bookshelf.domain.model.books.Book
import com.example.bookshelf.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddEditBookFragment : Fragment() {

    private var _binding: FragmentAddEditBookBinding? = null
    private val binding get() = _binding!!
    private val mainViewModel by activityViewModels<MainViewModel>()
    private val addEditBookViewModel by viewModels<AddEditBookViewModel>()
    private var bookId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            bookId = it.getString("bookId", "")
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddEditBookBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
        initObserver()
    }

    private fun initObserver() {
        addEditBookViewModel.bookState.observe(viewLifecycleOwner) {
            when (it) {
                is AddEditBookState.Loading -> {
//                    binding.progressBar.visibility = View.VISIBLE
                }
                is AddEditBookState.Empty -> {

                }
                is AddEditBookState.AddBookSuccess -> {
                    Log.d("TAG", "AddBookSuccess BookId: ${it.bookId}")
//                    binding.progressBar.visibility = View.GONE
                }
                is AddEditBookState.EditBookSuccess -> {
                    Log.d("TAG", "EditBookSuccess: ${it.book}")
                }
                is AddEditBookState.GetBookDetailsSuccess -> {
                    Log.d("TAG", "GetBookDetailsSuccess: ${it.book}")
                    updateUI(book = it.book)
                }
                is AddEditBookState.Error -> {

                }
            }
        }
        if (bookId.isNotEmpty()) addEditBookViewModel.getBooksById(bookId.toInt())
    }

    private fun initListener() {
        binding.submit.setOnClickListener {
            if (bookId.isNotEmpty()){
//                addEditBookViewModel.updateBook()
            } else {
                Book(
                    title = binding.titleTxt.text.toString(),
                    description = binding.descTxt.text.toString(),
                    publisher = binding.publisherTxt.text.toString(),
                    author = binding.authorTxt.text.toString(),
                    year = binding.publishedYearTxt.text.toString()
                ).also {
                    addEditBookViewModel.addBook(it)
                }
            }
        }
    }

    private fun updateUI(book: Book) {
        binding.titleTxt.setText(book.title)
        binding.descTxt.setText(book.description)
        binding.authorTxt.setText(book.author)
        binding.publisherTxt.setText(book.publisher)
        binding.publishedYearTxt.setText(book.year)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
        _binding = null
    }

}