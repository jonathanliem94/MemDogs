package com.jonl.memdogs.ui.referencelist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jonl.memdogs.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReferenceListScreen(
    vm: ReferenceListViewModel
) {
    val viewState by vm.uiState.collectAsStateWithLifecycle()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.ReferenceListTitle),
                        textAlign = TextAlign.Center,
                    )
                }
            )
                 },
        content = { paddingValues ->
            RecyclerViewDogItems(viewState.items, paddingValues)
        }
    )
}

@Composable
fun RecyclerViewDogItems(
    items: List<String>,
    paddingValues: PaddingValues,
) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = stringResource(R.string.ReferenceListDesc),
                fontWeight = FontWeight.Bold
            )
        }
        items(items) {
            Text(
                text = it
            )
        }
    }
}