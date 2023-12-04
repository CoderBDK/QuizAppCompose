package com.coderbdk.quizapp.ui.main.home.item

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coderbdk.quizapp.ui.main.home.CircularProgress
import com.coderbdk.quizapp.ui.quiz.QuizActivity
import com.coderbdk.quizapp.ui.theme.BackgroundColor
import com.coderbdk.quizapp.ui.theme.CardColorQuiz
import com.coderbdk.quizapp.ui.theme.CardColorStudy
import com.coderbdk.quizapp.ui.theme.QuizAppTheme

@Composable
fun ItemStudy(className: String, name: String, leftQn: Int, color: Color) {

    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 0.dp, 0.dp, 10.dp)
            .clickable {
                quizActivity(context, name)
            },
        colors = CardDefaults.cardColors(
            containerColor = CardColorStudy,
        ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp, 20.dp, 10.dp, 20.dp)
        ) {
            DrawRoundText(className, color)
            Column(
                Modifier.weight(1f),
            ) {
                Text(
                    text = name,
                    color = Color(0xff642900),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "$leftQn question left", style = TextStyle(
                        color = Color(0xFF966E53), fontWeight = FontWeight.Bold
                    )
                )
            }
            IconButton(modifier = Modifier.size(50.dp), onClick = {
                quizActivity(context, name)
            }) {
                Icon(
                    Icons.Filled.KeyboardArrowRight,
                    contentDescription = "Face",
                    tint = Color(0xff642900),
                )
            }
        }

    }
}

fun quizActivity(context: Context, name: String) {
    val intent = Intent(context, QuizActivity::class.java)
    intent.putExtra("name", name)
    context.startActivity(intent)
}

@Composable
fun DrawRoundText(subjectClass: String, color: Color) {
    Box(
        Modifier
            .padding(0.dp, 0.dp, 10.dp, 0.dp)
            .background(BackgroundColor, shape = RoundedCornerShape(25f))
    ) {
        Column(
            Modifier.padding(15.dp, 5.dp, 15.dp, 5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = subjectClass, style = TextStyle(
                    color = color, fontWeight = FontWeight.Bold, fontSize = 25.sp
                )
            )
            Text(
                text = "class", style = TextStyle(
                    color = color,
                )
            )
        }

    }

}

@Composable
fun ItemQuiz() {
    Text(
        text = "Practice more",
        modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp),
        color = Color(0xff642900)
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        colors = CardDefaults.cardColors(
            containerColor = CardColorQuiz,
        ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(
                Modifier.padding(0.dp, 10.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                CircularProgress(color = CardColorQuiz, 0.1f)
                Column(
                    Modifier.padding(0.dp)
                ) {
                    Text(
                        text = "Daily Quiz", fontSize = 18.sp, color = BackgroundColor
                    )
                    Text(
                        text = "20 mixed questions", fontSize = 14.sp, color = BackgroundColor
                    )
                }

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(10.dp),
                horizontalAlignment = Alignment.End,

                ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,

                    ) {
                    IconButton(modifier = Modifier.size(15.dp), onClick = { }) {
                        Icon(
                            Icons.Filled.Face, contentDescription = "Face", tint = BackgroundColor
                        )
                    }
                    Text(
                        modifier = Modifier.padding(5.dp, 0.dp),
                        textAlign = TextAlign.Center,
                        text = "100 participated",
                        fontSize = 12.sp,
                        color = BackgroundColor
                    )
                }

                IconButton(
                    onClick = { },
                ) {
                    Icon(
                        Icons.Filled.KeyboardArrowRight,
                        contentDescription = "AR",
                        tint = BackgroundColor
                    )
                }
            }


        }

    }
}

//@Preview(showBackground = true)
@Composable
fun AppPreview() {
    QuizAppTheme {
        ItemQuiz()
    }
}
