package kr.co.donghyun.amplify_simplequery.util

import com.amplifyframework.core.model.Model
import kotlin.reflect.KClass

class QueryList<T : Model> {
    val items: Iterable<T>? = null
    val nextToken: String? = null
}