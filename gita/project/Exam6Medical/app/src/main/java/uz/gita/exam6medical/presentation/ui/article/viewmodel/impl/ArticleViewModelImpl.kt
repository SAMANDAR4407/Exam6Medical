package uz.gita.exam6medical.presentation.ui.article.viewmodel.impl

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.exam6medical.presentation.ui.article.viewmodel.ArticleViewModel
import javax.inject.Inject

@HiltViewModel
class ArticleViewModelImpl @Inject constructor(

) : ArticleViewModel, ViewModel() {
}