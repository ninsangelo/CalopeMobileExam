package com.mobileexam.calope.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.mobileexam.calope.viewmodel.CharacterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailScreen(navController: NavController, characterId: Int, viewModel: CharacterViewModel) {
    val character by remember { derivedStateOf { viewModel.getCharacterById(characterId) } }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Character Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        character?.let {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = rememberImagePainter(it.image), // Fetch image from API
                    contentDescription = "Character Image",
                    modifier = Modifier.size(200.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Name: ${it.name}", style = MaterialTheme.typography.headlineSmall)
                Text(text = "Status: ${it.status}")
                Text(text = "Species: ${it.species}")
                Text(text = "Gender: ${it.gender}")
                Text(text = "Type: ${it.type ?: "N/A"}")
                Text(text = "Origin: ${it.origin.name}")
                Text(text = "Location: ${it.location.name}")
            }
        } ?: run {
            Text("Character not found", style = MaterialTheme.typography.headlineMedium)
        }
    }
}
