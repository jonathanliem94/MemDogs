package com.jonl.memdogs.ui.memorytest

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.jonl.memdogs.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemoryTestScreen(
    vm: MemoryTestViewModel
) {
    val viewState by vm.uiState.collectAsStateWithLifecycle()
    var answerShown by rememberSaveable { mutableStateOf(false) }
    Scaffold(
        modifier = Modifier.fillMaxHeight(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.MemoryTestTitle),
                        textAlign = TextAlign.Center,
                    )
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.MemoryTestQuery),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 8.dp),
                )
                AsyncImage(
                    model = viewState.imageUri,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxHeight(0.75f)
                )
                AnimatedVisibility(answerShown) {
                    Text(
                        text = String.format(stringResource(R.string.MemoryTestAnswer), viewState.breedName),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 8.dp),
                    )
                }
                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(vertical = 8.dp),
                ){
                    Button(
                        onClick = { answerShown = !answerShown },
                        modifier = Modifier.padding(horizontal = 4.dp),
                    ) {
                        Text(
                            text = stringResource(R.string.MemoryTestShowAnswer)
                        )
                    }
                    Button(
                        onClick = {
                            vm.refresh()
                            answerShown = false
                        },
                        modifier = Modifier.padding(horizontal = 4.dp),
                    ) {
                        Text(
                            text = stringResource(R.string.MemoryTestNextImage)
                        )
                    }
                }
            }
        }
    )
}