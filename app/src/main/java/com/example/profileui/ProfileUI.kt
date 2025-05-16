package com.example.profileui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyUi(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        TopBar(name = "Rehan Pervaiz")
        Spacer(modifier = Modifier.height(5.dp))
        StatBar()
        Description(profileName = "Muhammad Rehan", description = "This is a description\n" + "I'm a Software Engineer", url = "www.google.com", followedBy = listOf("Rehan","Rehan", "Aliya"), otherCount = 17)

    }
}

@Composable
fun TopBar(name: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back Arrow Icons",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "notification icon",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.baseline_more_vert_24),
            contentDescription = "menu icon",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )


    }

}

@Composable
fun StatBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RoundIcon(
            image = painterResource(id = R.drawable.rehan), modifier = Modifier
                .size(100.dp)
                .weight(3f)
        )
        StatSection(modifier = Modifier.weight(7f))

    }
}

@Composable
fun RoundIcon(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Icon(
        painter = image,
        contentDescription = null,
        tint = Color.Unspecified,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .clip(CircleShape)
            .border(
                width = 3.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)

    )
}

@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ShowStates(numberText = "2", text = "Posts")
        ShowStates(numberText = "2", text = "Follower")
        ShowStates(numberText = "2", text = "Following")
    }
}

@Composable
fun ShowStates(numberText: String, text: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
            fontSize = 15.sp
        )
    }
}

@Composable
fun Description(
    profileName: String,
    description: String,
    url: String,
    followedBy : List<String>,
    otherCount : Int,
    modifier: Modifier = Modifier
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = profileName,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        )
        Text(
            text = description,
            style = TextStyle(
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            style = TextStyle(
                fontWeight = FontWeight.Bold,

                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        )
        if(followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )

                    append("Followed By: ")
                    followedBy.forEachIndexed { index, s ->
                        pushStyle(boldStyle)
                        append(s)
                        pop()
                        if(index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if(otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                style = TextStyle(
                    letterSpacing = letterSpacing,
                    lineHeight = lineHeight
                )

            )
        }


    }
}