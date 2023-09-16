package kr.co.donghyun.amplify_simplequery.query

import com.amplifyframework.api.graphql.SimpleGraphQLRequest
import com.amplifyframework.core.model.Model
import com.amplifyframework.rx.RxAmplify
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kr.co.donghyun.amplify_simplequery.util.QueryList
import kr.co.donghyun.amplify_simplequery.util.getListSimpleRequest
import java.lang.Exception

abstract class PaginationCustomQuery{
    abstract val document : String
    abstract val limitPerItemCount : Int

    val compositeDisposable = CompositeDisposable()

    var page = 1

    inline fun <reified T : Model, reified R : QueryList<T>> getPaginationList(noinline onResult : (List<T>) -> Unit, noinline onError : (Throwable) -> Unit) {
        try {
            compositeDisposable.add(
                RxAmplify.API.query(getListSimpleRequest<T, R>(document))
                    .doOnSuccess { response ->
                        val queriedData = (response.data.items?.toMutableList() ?: mutableListOf())

                        if((limitPerItemCount * page) < queriedData.size) {
                            getMorePaginationList(
                                queriedData.toList(),
                                getListSimpleRequest<T, R>(document),
                                onResult,
                                onError
                            )
                        }else{
                            onResult(queriedData)
                        }
                    }
                    .doOnError(onError)
                    .subscribe()
            )
        }catch (e : Exception) {
            onError(e)
        }
    }

    fun <T : Model, R : QueryList<T>> getMorePaginationList(beforeList: List<T>, request: SimpleGraphQLRequest<R>, onResult: (List<T>) -> Unit, onError: (Throwable) -> Unit) {
        try {
            compositeDisposable.add(
                RxAmplify.API.query(request)
                    .doOnSuccess { response ->
                        val queriedData = (response.data.items?.toMutableList() ?: mutableListOf()).apply { addAll(beforeList) }

                        if((limitPerItemCount * page) < queriedData.size) {
                            getMorePaginationList(
                                queriedData.toList(),
                                request,
                                onResult,
                                onError
                            )
                        }else{
                            onResult(queriedData)
                        }
                    }
                    .doOnError(onError)
                    .subscribe()
            )
        }catch (e : Exception) {
            onError(e)
        }
    }

    inline fun <reified T, reified U> areTypesEqual(): Boolean {
        return T::class == U::class
    }
}