package com.example.portfolio

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio.ui.theme.PortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PortfolioTheme {
                Portfolio()
            }
        }
    }
}

@Composable
fun Portfolio(modifier: Modifier = Modifier) {

    val isOpen = remember {
        mutableStateOf(false)
    }

    Surface(
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {  //A Canvas

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(12.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Image(
                painter = painterResource(id = R.drawable.cool_dude),
                contentDescription = "profile img",
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Sarthak Verma", style = TextStyle(
                    color = Color.Green,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(text = "Android Developer", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(12.dp))

            Row {
                Image(
                    painter = painterResource(id = R.drawable.instagram),
                    contentDescription = "insta-logo",
                    modifier = Modifier.size(18.dp)
                )

                Text(
                    text = "/SarthakRoxx",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row {
                Image(
                    painter = painterResource(id = R.drawable.github),
                    contentDescription = "github-logo",
                    modifier = Modifier.size(18.dp)
                )

                Text(
                    text = "/Lightning-McType",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(onClick = { isOpen.value = !isOpen.value }) {
                Text(text = "My Projects")
            }

            if (isOpen.value) {
                LazyColumn {
                    items(getProjectList()) {
                        ProjectItem(project = it)
                    }
                }
            }
        }
    }
}

@Composable
fun ProjectItem(project: Project, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.cool_dude),
            contentDescription = "profile img",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )

        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(text = project.name, style = MaterialTheme.typography.titleSmall)
            Text(text = project.desc, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

fun getProjectList(): List<Project> {
    return listOf(
        Project(name = "Social Media App", desc = "Connect with your friends"),
        Project(name = "Music Player App", desc = "Listen music endlessly"),
        Project(name = "Gaming Media", desc = "NFS Lover"),
        Project(name = "Social Media App", desc = "Connect with your friends"),
        Project(name = "Music Player App", desc = "Listen music endlessly"),
        Project(name = "Gaming Media", desc = "NFS Lover"),
        Project(name = "Social Media App", desc = "Connect with your friends"),
        Project(name = "Music Player App", desc = "Listen music endlessly"),
        Project(name = "Gaming Media", desc = "NFS Lover"),
        Project(name = "Social Media App", desc = "Connect with your friends"),
        Project(name = "Music Player App", desc = "Listen music endlessly"),
        Project(name = "Gaming Media", desc = "NFS Lover")
    )
}

data class Project(
    val name: String,
    val desc: String
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    PortfolioTheme {
        Portfolio()
    }
}