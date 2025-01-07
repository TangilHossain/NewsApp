package com.shawonshagor0.newsapp.uis.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.shawonshagor0.newsapp.R
import com.shawonshagor0.newsapp.databinding.FragmentArticleBinding
import com.shawonshagor0.newsapp.uis.NewsActivity
import com.shawonshagor0.newsapp.uis.NewsViewModel

class ArticleFragment : Fragment(R.layout.fragment_article) {
    lateinit var newsViewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()
    lateinit var binding: FragmentArticleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)

        newsViewModel = (activity as NewsActivity).newsViewModel
        val article = args.article

        binding.webView.apply {
            webViewClient = webViewClient
            article.url?.let{
                loadUrl(it)
            }

        }

        binding.fab.setOnClickListener{
            newsViewModel.addToFavourites(article)
            Snackbar.make(view, "Article saved successfully", Snackbar.LENGTH_SHORT).show()
        }
    }

}