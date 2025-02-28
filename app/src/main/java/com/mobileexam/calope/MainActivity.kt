package com.mobileexam.calope

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobileexam.calope.data.Character
import com.mobileexam.calope.ui.theme.CalopeTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.mobileexam.calope.ui.CharacterListScreen
import com.mobileexam.calope.ui.CharacterDetailScreen
import com.mobileexam.calope.viewmodel.CharacterViewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import coil.compose.AsyncImage


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val characterViewModel: CharacterViewModel = viewModel()

            // Pass navController to CharacterApp
            CharacterApp(viewModel = characterViewModel, navController = navController)

            NavHost(navController, startDestination = "character_list") {
                composable("character_list") {
                    CharacterListScreen(navController, characterViewModel)
                }
                composable("character_detail/{characterId}") { backStackEntry ->
                    val characterId = backStackEntry.arguments?.getString("characterId")?.toIntOrNull() ?: -1
                    CharacterDetailScreen(navController, characterId, characterViewModel)
                }
            }
        }
    }
}


@Composable
fun CharacterApp(viewModel: CharacterViewModel, navController: NavController) {
    val characterList by viewModel.characterList.collectAsState()

    Scaffold(
        topBar = { CharacterTopAppBar() }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(characterList) { character -> // This line was missing!
                CharacterItem(character = character, navController = navController)
            }
        }
    }
}







@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = { Text(text = "The Characters", style = MaterialTheme.typography.headlineLarge) },
        modifier = modifier
    )
}

@Composable
fun CharacterItem(character: Character, navController: NavController, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // ✅ Wrapping AsyncImage in Box with a default placeholder
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(MaterialTheme.shapes.medium)
                ) {
                    AsyncImage(
                        model = character.image.ifEmpty { "https://via.placeholder.com/80" },
                        contentDescription = character.name,
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))

                Column {
                    Text(text = character.name, style = MaterialTheme.typography.bodyLarge)
                    Text(text = character.status, style = MaterialTheme.typography.bodyMedium)
                    Text(text = character.species, style = MaterialTheme.typography.bodyMedium)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // ✅ Making sure "More details" is always visible
            Text(
                text = if (expanded) "Less details" else "More details",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable { expanded = !expanded }
            )

            // ✅ Expanding section with character details
            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Gender: ${character.gender}", style = MaterialTheme.typography.bodyMedium)
                Text(text = "Origin: ${character.origin}", style = MaterialTheme.typography.bodyMedium)
                Text(text = "Location: ${character.location}", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}




@Composable
fun CharacterInformation(character: Character, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = character.name, style = MaterialTheme.typography.bodyLarge)
        Text(text = character.status, style = MaterialTheme.typography.bodyMedium)
        Text(text = character.species, style = MaterialTheme.typography.bodyMedium)
    }
}



// Light theme preview
@Preview
@Composable
fun CharacterPreview() {
    val mockViewModel = CharacterViewModel()
    CalopeTheme(darkTheme = false) {
        CharacterApp(viewModel = mockViewModel, navController = rememberNavController())
    }
}

// Dark theme preview
@Preview
@Composable
fun CharacterDarkThemePreview() {
    val mockViewModel = CharacterViewModel()
    CalopeTheme(darkTheme = false) {
        CharacterApp(viewModel = mockViewModel, navController = rememberNavController())
    }
}