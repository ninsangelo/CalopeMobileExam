package com.mobileexam.calope.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mobileexam.calope.CharacterTopAppBar
import com.mobileexam.calope.viewmodel.CharacterViewModel
import com.mobileexam.calope.data.Character


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterListScreen(navController: NavController, viewModel: CharacterViewModel) {
    val characterList by viewModel.characterList.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Character List") })
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(characterList) { character ->
                CharacterItem(character, Modifier) {
                    navController.navigate("character_detail/${character.id}")
                }
            }
        }
    }
}


@Composable
fun CharacterItem(character: Character, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = character.name, style = MaterialTheme.typography.bodyLarge)
            Text(text = character.status, style = MaterialTheme.typography.bodyMedium)
            Text(text = character.species, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
