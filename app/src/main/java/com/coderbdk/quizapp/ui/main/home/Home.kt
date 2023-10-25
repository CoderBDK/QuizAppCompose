package com.coderbdk.quizapp.ui.main.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coderbdk.quizapp.R
import com.coderbdk.quizapp.ui.main.home.item.ItemQuiz
import com.coderbdk.quizapp.ui.main.home.item.ItemStudy
import com.coderbdk.quizapp.ui.theme.BackgroundColor
import com.coderbdk.quizapp.ui.theme.CardColorRank

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .padding(10.dp, 10.dp, 10.dp, 10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.weight(1f, true),
            ) {
                Text(
                    text = "${stringResource(id = R.string.HI)}Hi, Abdullah",
                    fontSize = 25.sp,
                    style = TextStyle(
                        color = Color(0xff642900),
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                Text(
                    text = "Great to see you again!"
                )
            }
            Image(
                painterResource(R.drawable.profile),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(45.dp)
                    .height(45.dp)
            )

            /*
            * IconButton(
                onClick = { }) {
                Icon(
                    Icons.Filled.Face,
                    contentDescription = "Face",
                    tint = CardColorRank
                )
            }*/
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 15.dp, 0.dp, 0.dp)
                .height(IntrinsicSize.Min),
            colors = CardDefaults.cardColors(
                containerColor = CardColorRank,
            ),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painterResource(R.drawable.exp_point),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(65.dp)
                            .height(65.dp)
                    )
                    /*
                    IconButton(
                        modifier = Modifier
                            .padding(15.dp)
                            .size(50.dp),
                        onClick = { }) {
                        Icon(
                            Icons.Rounded.Favorite,
                            contentDescription = "Face",
                            modifier = Modifier
                                .size(50.dp),
                            tint = BackgroundColor
                        )
                    }*/

                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "2899",
                            fontSize = 20.sp,
                            color = BackgroundColor,
                            fontWeight = FontWeight.ExtraBold
                        )
                        Text(
                            text = "Exp. Points",
                            color = BackgroundColor,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }
                }
                Divider(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp),
                    color = Color(0x23414141)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    /*IconButton(
                        modifier = Modifier
                            .padding(15.dp)
                            .size(50.dp),
                        onClick = { }) {
                        Icon(

                            Icons.Filled.DateRange,
                            contentDescription = "Face",
                            modifier = Modifier
                                .size(50.dp),
                            tint = BackgroundColor,
                            )

                    }*/
                    Image(
                        painterResource(R.drawable.trophy),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(65.dp)
                            .height(65.dp)
                    )
                    Column(
                        modifier = Modifier
                            .padding(0.dp)
                    ) {
                        Text(
                            text = "26",
                            fontSize = 20.sp,
                            color = BackgroundColor,
                            fontWeight = FontWeight.ExtraBold
                        )
                        Text(
                            text = "Ranking",
                            color = BackgroundColor,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }


        // item
        ItemQuiz()
        Text(
            text = "Continue studying",
            modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp),
            color = Color(0xff642900)
        )
        ItemStudy("Math", 12, Color(0xffe2573f))
        ItemStudy("History", 6, Color(0xfffe9c1b))
        ItemStudy("Biology", 20, Color(0xff44a47a))
        ItemStudy("Math", 12, Color(0xffe2573f))
        ItemStudy("History", 6, Color(0xfffe9c1b))
        ItemStudy("Biology", 20, Color(0xff44a47a))
        ItemStudy("Math", 12, Color(0xffe2573f))
        ItemStudy("History", 6, Color(0xfffe9c1b))
        ItemStudy("Biology", 20, Color(0xff44a47a))
    }
}

@Composable
fun CircularProgress(color: Color, percent: Float) {
    Box(
        contentAlignment = Alignment.Center,
    ) {
        Canvas(
            modifier = Modifier
                .width(65.dp)
                .height(85.dp)
                .padding(0.dp, 0.dp, 25.dp),
            onDraw = {
                // progress bg
                drawArc(
                    color = Color.White,
                    -90f,
                    360 * 0.5f,
                    useCenter = false,
                    style = Stroke(
                        15f,
                        cap = StrokeCap.Round
                    ),
                    topLeft = Offset(-125f, 0f)
                )
                // progress indicator
                drawArc(

                    color = color,
                    -90f,
                    360 * percent,
                    useCenter = false,
                    style = Stroke(
                        15f,
                        cap = StrokeCap.Round
                    ),
                    topLeft = Offset(-125f, 0f)
                )
            })

        Text(
            text = "3h",
            color = BackgroundColor,
            modifier = Modifier.padding(0.dp, 0.dp, 30.dp)
        )
    }

}

