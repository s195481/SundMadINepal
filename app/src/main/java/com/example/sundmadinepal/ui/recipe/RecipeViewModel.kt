package com.example.sundmadinepal.ui.recipe

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sundmadinepal.di.ServiceLocator
import com.example.sundmadinepal.R
import com.example.sundmadinepal.model.AssetRepository
import com.example.sundmadinepal.model.db.AppDatabase
import com.example.sundmadinepal.model.model.Recipe
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class RecipeViewModel(private val db: AppDatabase) : ViewModel() {

    fun getRecipes() {
        val recipeList = listOf(
            db.recipeDao().loadById("Dahl_v1"),
        )
    }

    object DataProvider {

        // TODO Giver ikke de rigtige strings til RecipeListItem i MainActivity. De kan ikke findes i frontenden og det giver ingen mening. Se evt. vedlagt error code.
        /*
        E/e.sundmadinepa: No package ID 7f found for ID 0x7f100046.

    --------- beginning of crash
E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.example.sundmadinepal, PID: 3012
    java.lang.ExceptionInInitializerError
        at com.example.sundmadinepal.MainActivityKt.RecipesComposable(MainActivity.kt:487)
        at com.example.sundmadinepal.ComposableSingletons$MainActivityKt$lambda-1$1$1$2.invoke(MainActivity.kt:56)
        at com.example.sundmadinepal.ComposableSingletons$MainActivityKt$lambda-1$1$1$2.invoke(MainActivity.kt:56)
        at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:116)
        at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:34)
        at androidx.navigation.compose.NavHostKt$NavHost$4$1.invoke(NavHost.kt:150)
        at androidx.navigation.compose.NavHostKt$NavHost$4$1.invoke(NavHost.kt:149)
        at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:107)
        at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:34)
        at androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider(CompositionLocal.kt:215)
        at androidx.compose.runtime.saveable.SaveableStateHolderImpl.SaveableStateProvider(SaveableStateHolder.kt:84)
        at androidx.navigation.compose.NavBackStackEntryProviderKt.SaveableStateProvider(NavBackStackEntryProvider.kt:59)
        at androidx.navigation.compose.NavBackStackEntryProviderKt.access$SaveableStateProvider(NavBackStackEntryProvider.kt:1)
        at androidx.navigation.compose.NavBackStackEntryProviderKt$LocalOwnersProvider$1.invoke(NavBackStackEntryProvider.kt:51)
        at androidx.navigation.compose.NavBackStackEntryProviderKt$LocalOwnersProvider$1.invoke(NavBackStackEntryProvider.kt:50)
        at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:107)
        at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:34)
        at androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider(CompositionLocal.kt:215)
        at androidx.navigation.compose.NavBackStackEntryProviderKt.LocalOwnersProvider(NavBackStackEntryProvider.kt:46)
        at androidx.navigation.compose.NavHostKt$NavHost$4.invoke(NavHost.kt:149)
        at androidx.navigation.compose.NavHostKt$NavHost$4.invoke(NavHost.kt:142)
        at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:116)
        at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:34)
        at androidx.compose.animation.CrossfadeKt$Crossfade$1$1.invoke(Crossfade.kt:74)
        at androidx.compose.animation.CrossfadeKt$Crossfade$1$1.invoke(Crossfade.kt:69)
        at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:107)
        at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:34)
        at androidx.compose.animation.CrossfadeKt.Crossfade(Crossfade.kt:86)
        at androidx.navigation.compose.NavHostKt.NavHost(NavHost.kt:142)
        at androidx.navigation.compose.NavHostKt$NavHost$5.invoke(Unknown Source:13)
        at androidx.navigation.compose.NavHostKt$NavHost$5.invoke(Unknown Source:10)
        at androidx.compose.runtime.RecomposeScopeImpl.compose(RecomposeScopeImpl.kt:140)
        at androidx.compose.runtime.ComposerImpl.recomposeToGroupEnd(Composer.kt:2156)
        at androidx.compose.runtime.ComposerImpl.skipCurrentGroup(Composer.kt:2399)
        at androidx.compose.runtime.ComposerImpl$doCompose$2$5.invoke(Composer.kt:2580)
        at androidx.compose.runtime.ComposerImpl$doCompose$2$5.invoke(Composer.kt:2566)
        at androidx.compose.runtime.SnapshotStateKt.observeDerivedStateRecalculations(SnapshotState.kt:540)
        at androidx.compose.runtime.ComposerImpl.doCompose(Composer.kt:2566)
        at androidx.compose.runtime.ComposerImpl.recompose$runtime_release(Composer.kt:2542)
        at androidx.compose.runtime.CompositionImpl.recompose(Composition.kt:614)
        at androidx.compose.runtime.Recomposer.performRecompose(Recomposer.kt:764)
        at androidx.compose.runtime.Recomposer.access$performRecompose(Recomposer.kt:103)
        at androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2$2.invoke(Recomposer.kt:447)
E/AndroidRuntime:     at androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2$2.invoke(Recomposer.kt:416)
        at androidx.compose.ui.platform.AndroidUiFrameClock$withFrameNanos$2$callback$1.doFrame(AndroidUiFrameClock.android.kt:34)
        at androidx.compose.ui.platform.AndroidUiDispatcher.performFrameDispatch(AndroidUiDispatcher.android.kt:109)
        at androidx.compose.ui.platform.AndroidUiDispatcher.access$performFrameDispatch(AndroidUiDispatcher.android.kt:41)
        at androidx.compose.ui.platform.AndroidUiDispatcher$dispatchCallback$1.doFrame(AndroidUiDispatcher.android.kt:69)
        at android.view.Choreographer$CallbackRecord.run(Choreographer.java:970)
        at android.view.Choreographer.doCallbacks(Choreographer.java:796)
        at android.view.Choreographer.doFrame(Choreographer.java:727)
        at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:957)
        at android.os.Handler.handleCallback(Handler.java:938)
        at android.os.Handler.dispatchMessage(Handler.java:99)
        at android.os.Looper.loop(Looper.java:223)
        at android.app.ActivityThread.main(ActivityThread.java:7656)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:592)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:947)
     Caused by: android.content.res.Resources$NotFoundException: String resource ID #0x7f100046
        at android.content.res.Resources.getText(Resources.java:444)
        at android.content.res.Resources.getString(Resources.java:537)
        at com.example.sundmadinepal.ui.recipe.RecipeViewModel$DataProvider.<clinit>(RecipeViewModel.kt:22)
        	... 59 more
I/Process: Sending signal. PID: 3012 SIG: 9

         */
        //val Jaulo: String = Resources.getSystem().getString(R.string.jaulo_title_string)
        //val Flour: String = Resources.getSystem().getString(R.string.nutritionalflour_title_string)

        val recipeList = listOf(
            //ServiceLocator.recipeRepository.getAsset("Dahl_v1")
            // TODO Har lige lavet alt nedunder til Strings - bare så det kan blive loaded og der kan laves UI
            Recipe(
                id = "jaulo",
                name = "Jaulo",
                ingredients = "",
                procedure = "jaulo",
                picture = "jaulo",
                pictureID = R.drawable.p0
            ),
            Recipe(
                id = "nutritionalflour",
                name = "Flour",
                ingredients = "",
                procedure = "nutritionalflour",
                picture = "nutritionalflour",
                pictureID = R.drawable.p1
            )/*,
            Recipe(
                id = "Dahl_v2",
                name = "Dahl_v2",
                ingredients = "Beans 2",
                procedure = "Cook 2",
                picture = ""
            ),
            Recipe(
                id = "Dahl_v3",
                name = "Dahl_v3",
                ingredients = "Beans 3",
                procedure = "Cook 3",
                picture = ""
            ),
            Recipe(
                id = "Dahl_v4",
                name = "Dahl_v4",
                ingredients = "Beans 4",
                procedure = "Cook 4",
                picture = ""
            ),
            Recipe(
                id = "Dahl_v5",
                name = "Dahl_v5",
                ingredients = "Beans 5",
                procedure = "Cook 5",
                picture = ""
            ),
            Recipe(
                id = "Dahl_v6",
                name = "Dahl_v6",
                ingredients = "Beans 6",
                procedure = "Cook 6",
                picture = ""
            ),*/
            // TODO recipeRepository.getAsset("Dahl_v1"),
            // recipeRepository.getAsset("Dahl_v1"),
        )
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}