package com.muradakhundov.hpmoviecharacterapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.muradakhundov.hpmoviecharacterapp.domain.model.Characters

@Composable
fun CharacterItem(modifier: Modifier, characters: Characters) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Card(elevation = CardDefaults.cardElevation(8.dp), shape = RoundedCornerShape(8.dp)) {
            Column(
                modifier = modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = characters.image,
                    contentDescription = "",
                    modifier = modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .clip(RectangleShape),
                    contentScale = ContentScale.Crop
                )
                Text(text = characters.actor , fontWeight =  FontWeight.Bold)
                Text(text = characters.name)
                Spacer(modifier = modifier.padding(4.dp))
            }

        }
    }
}