package com.coderbdk.quizapp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coderbdk.quizapp.R
import com.coderbdk.quizapp.ui.theme.CardColorGreen
import com.coderbdk.quizapp.ui.theme.QuizAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainUI()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainUI() {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    BottomBarItem(this)
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { /* do something */ },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(Icons.Filled.Add, "Localized description")
                    }
                }
            )
        }
    ) {
        Main(it)
    }
}

@Composable
fun BottomBarItem(rowScope: RowScope) {
    rowScope.apply {
        IconButton(
            modifier = Modifier.weight(1f, true),
            onClick = { }) {
            Icon(
                Icons.Filled.Home,
                contentDescription = "Home",
            )
        }
        IconButton(
            modifier = Modifier.weight(1f, true),
            onClick = { }) {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Person",
            )
        }
        IconButton(
            modifier = Modifier.weight(1f, true),
            onClick = { }) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "Favorite",
            )
        }
    }
}

@Composable
fun Main(it: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Row {
            Column(
                modifier = Modifier.weight(1f, true),
            ) {
                Text(
                    text = "${stringResource(id = R.string.HI)}Hi, Abdullah",
                    fontSize = 25.sp
                )
                Text(
                    text = "Grate to see you again!"
                )
            }

            IconButton(
                onClick = { }) {
                Icon(
                    Icons.Filled.Face,
                    contentDescription = "Face"
                )
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 15.dp, 0.dp, 0.dp),
        ) {
            Row {
                Row {
                    IconButton(
                        modifier = Modifier
                            .padding(15.dp)
                            .size(50.dp),
                        onClick = { }) {
                        Icon(
                            Icons.Filled.Face,
                            contentDescription = "Face",
                            modifier = Modifier
                                .size(50.dp),

                            )
                    }
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "2899",
                            fontSize = 25.sp
                        )
                        Text(
                            text = "Exp. Points"
                        )
                    }
                }
                Row {
                    IconButton(
                        modifier = Modifier
                            .padding(15.dp)
                            .size(50.dp),
                        onClick = { }) {
                        Icon(
                            Icons.Filled.Face,
                            contentDescription = "Face",
                            modifier = Modifier
                                .size(50.dp),

                            )
                    }
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "26",
                            fontSize = 25.sp
                        )
                        Text(
                            text = "Ranking"
                        )
                    }
                }
            }
        }

        Text(
            text = "Practice more",
            modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = CardColorGreen,
            ),
        ) {
            Row {
                Row(
                    Modifier.padding(10.dp, 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(onClick = { /*TODO*/ }) {

                    }
                    Column(
                        Modifier.padding(10.dp)
                    ) {
                        Text(
                            text = "Daily Quiz",
                            fontSize = 18.sp
                        )
                        Text(
                            text = "20 mixed questions",
                            fontSize = 14.sp
                        )
                    }

                }
                Row(
                    modifier = Modifier.padding(0.dp, 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        modifier = Modifier.size(15.dp),
                        onClick = { }) {
                        Icon(
                            Icons.Filled.Face,
                            contentDescription = "Face",
                        )
                    }
                    Text(
                        textAlign = TextAlign.Center,
                        text = "100 participated",
                        fontSize = 12.sp,
                        modifier = Modifier.padding(5.dp)
                    )

                }
                Row(
                    modifier = Modifier.weight(1f)
                ) {
                    IconButton(
                        onClick = { },
                        modifier = Modifier.padding(0.dp, 15.dp)
                    ) {
                        Icon(
                            Icons.Filled.KeyboardArrowRight,
                            contentDescription = "AR"
                        )
                    }
                }
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuizAppTheme {
        MainUI()
    }
}