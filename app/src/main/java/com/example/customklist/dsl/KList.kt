package com.example.customklist.dsl

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@DslMarker
annotation class KListDsl

@KListDsl
class KListBuilder {
    private var padding: Dp = 0.dp
    private var enableDividers: Boolean = false
    private val sections = mutableListOf<KListSection<*>>()

    fun padding(value: Dp) {
        padding = value
    }

    fun dividers(enabled: Boolean = true) {
        enableDividers = enabled
    }

    fun <T : Any> section(
        header: String,
        items: List<T>,
        onClick: ((T) -> Unit)? = null,
        content: @Composable (T) -> Unit
    ) {
        sections.add(KListSection(header, items, content, onClick))
    }

    @SuppressLint("ComposableNaming")
    @Composable
    fun render() {
        LazyColumn(modifier = Modifier.padding(padding)) {
            sections.forEach { rawSection ->
                @Suppress("UNCHECKED_CAST")
                val section = rawSection as KListSection<Any>

                item {
                    Text(
                        text = section.header,
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp,horizontal = 10.dp),
                    )
                }

                items(section.items) { item ->
                    AnimatedVisibility(
                        visible = true,
                        enter = fadeIn(animationSpec = tween(300)),
                        exit = fadeOut(animationSpec = tween(300))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .then(
                                    if (section.onClick != null)
                                        Modifier.clickable { section.onClick.invoke(item) }
                                    else Modifier
                                )
                        ) {
                            section.itemContent(item)
                            if (enableDividers) HorizontalDivider()
                        }
                    }
                }
            }
        }
    }
}

@Immutable
data class KListSection<T : Any>(
    val header: String,
    val items: List<T>,
    val itemContent: @Composable (T) -> Unit,
    val onClick: ((T) -> Unit)? = null
)

@Composable
fun KList(content: KListBuilder.() -> Unit) {
    val builder = KListBuilder().apply(content)
    builder.render()
}