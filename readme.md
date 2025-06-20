# 🔗 KList - Custom DSL for Declarative List UI in Jetpack Compose

This project showcases a custom `KList` DSL inspired by Jetpack Compose's `Modifier` chaining pattern. It allows you to build scalable, reusable, and declarative list UIs using a fluent Kotlin API.

## 📱 Demo

```kotlin
KList {
    padding(16.dp)
    dividers()
    section("Top Gainers", coinList) { coin ->
        KListItem(coin)
    }
}
```

## 🚀 Features

- ✅ **Fluent DSL**: Chain configuration like `padding`, `header`, `section`, and `dividers`
- ✅ **Composable Sections**: Support for multiple data sections with headers
- ✅ **Safe Generics**: Type-safe implementation, no runtime `ClassCastException`
- ✅ **Animated Items**: Items appear with a smooth fade-in animation
- ✅ **Optional Click Handlers**
- ✅ **Reusable Item Components** via `KListItem`

---

## 🧱 Project Structure

```
com.example.customlist
├── components
│   └── KListItem.kt       # Reusable composable for list items
├── dsl
│   └── KList.kt           # Core builder class for the DSL
├── screens
│   └── KListDemo.kt       # Demo screen using the KList DSL
├── ui
│   └── theme              # Theme files (Color.kt, Theme.kt, Type.kt)
└── MainActivity.kt        # Entry point
```

---

## 📦 Modules

### `KList.kt`

- Provides the builder DSL
- Supports:
  - `.padding(...)`
  - `.dividers()`
  - `.section(...)`
- Internally uses `LazyColumn`

### `KListItem.kt`

- A reusable composable that renders individual list items (e.g., a coin or product)

### `KListDemo.kt`

- Demonstrates usage of `KList` with mock data
- Ideal for preview and testing

---

## 🧪 Example Data

```kotlin
val coinList = listOf(
    Coin("Bitcoin", "$65,000"),
    Coin("Ethereum", "$4,000"),
    Coin("Solana", "$150")
)


### 💡 Future Improvements

- 🔘 Add support for grid layouts (`LazyVerticalGrid`)
- 🔘 Add item animations for insertion/deletion
- 🔘 Section collapsing/expanding
- 🔘 Builder support for empty state and loading state


