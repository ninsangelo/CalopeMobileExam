package com.mobileexam.calope

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobileexam.calope.data.Character
import com.mobileexam.calope.data.character
import com.mobileexam.calope.ui.theme.CalopeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CharacterApp()
        }
    }
}

@Composable
fun CharacterApp() {
    Scaffold(
        topBar = { CharacterTopAppBar() }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(character) { character ->
                CharacterItem(character, Modifier.padding(8.dp))
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
fun CharacterItem(character: Character, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false)}
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { expanded = !expanded }
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
                Image(
                    painter = painterResource(character.imageResourceId),
                    contentDescription = null,
                    modifier = modifier
                        .size(80.dp)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(8.dp))
                CharacterInformation(character)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "More details")

            if(expanded){
                CharacterInformations(character)
            }
        }
    }
}


@Composable
fun CharacterInformation(character: Character, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = character.name, style = MaterialTheme.typography.bodyLarge)
        Text(text = character.status, style = MaterialTheme.typography.bodyMedium)
        Text(text = character.specie, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun CharacterInformations(character: Character, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = character.type, style = MaterialTheme.typography.bodyMedium)
        Text(text = character.gender, style = MaterialTheme.typography.bodyMedium)
        Text(text = character.location, style = MaterialTheme.typography.bodyMedium)
        Text(text = character.origin, style = MaterialTheme.typography.bodyMedium)
    }
}



//Light theme

@Preview
@Composable
fun CharacterPreview() {
    CalopeTheme(darkTheme = false) {
        CharacterApp()
    }
}

// Dark theme
@Preview
@Composable
fun CharacterDarkThemePreview() {
    CalopeTheme(darkTheme = true) {
        CharacterApp()
    }
}