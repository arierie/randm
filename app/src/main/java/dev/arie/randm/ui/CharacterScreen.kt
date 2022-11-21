package dev.arie.randm.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dev.arie.randm.model.Characters

@Composable
fun CharacterScreen(state: State<Characters>) {
    LazyColumn {
        item {
            TopAppBar(
                title = {
                    Text(text = "Rick & Morty")
                },
                backgroundColor = Color(0xFFFAFAFA),
            )
        }
        items(state.value.characters) {
            CharacterRow(it)
        }
    }
}

@Composable
fun CharacterRow(character: dev.arie.randm.model.Character) {
    Box(modifier = Modifier.padding(16.dp)) {
        Card(
            modifier = Modifier
                .background(color = Color(0xFFFAFAFA)),
            border = BorderStroke(1.dp, Color(0xFFD6D6D6))
        ) {
            Column {
                Text(
                    text = character.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)
                )
                Text(
                    text = character.origin.name,
                    fontSize = 8.sp,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                )
                AsyncImage(
                    model = character.image,
                    contentDescription = character.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.FillWidth
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
                ) {
                    Text(text = character.species, fontSize = 10.sp, modifier = Modifier.padding(end = 8.dp))
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(Color.Gray)
                    )
                    Text(
                        text = character.status,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                    )
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(Color.Gray)
                    )
                    Text(text = character.type, fontSize = 10.sp, modifier = Modifier.padding(start = 8.dp))
                }
            }
        }
    }
}
