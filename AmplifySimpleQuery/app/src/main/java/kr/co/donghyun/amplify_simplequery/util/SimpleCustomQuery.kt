package kr.co.donghyun.amplify_simplequery.util

import com.amplifyframework.api.aws.GsonVariablesSerializer
import com.amplifyframework.api.graphql.SimpleGraphQLRequest
import com.amplifyframework.core.model.Model
import com.amplifyframework.util.TypeMaker


// YOU MUST IMPLEMENTATION MODEL

inline fun <reified T : Model> getSingleSimpleRequest(document : String) : SimpleGraphQLRequest<T> = SimpleGraphQLRequest<T>(
    document,
    TypeMaker.getParameterizedType(T::class.java),
    GsonVariablesSerializer()
)

inline fun <reified T : Model, reified R> getListSimpleRequest(document : String) : SimpleGraphQLRequest<R> = SimpleGraphQLRequest<R>(
    document,
    TypeMaker.getParameterizedType(R::class.java, T::class.java),
    GsonVariablesSerializer()
)