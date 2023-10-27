package com.coderbdk.quizapp.ui.quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coderbdk.quizapp.ui.theme.BackgroundColor
import com.coderbdk.quizapp.ui.theme.CardColorQuiz
import com.coderbdk.quizapp.ui.theme.CardColorRank
import com.coderbdk.quizapp.ui.theme.QuizAppTheme

class QuizActivity : ComponentActivity() {

    private val activity = this
    private val questionList = listOf<QData>(
        QData(
            "1 + 2 ?",
            listOf("3", "5", "4", "6"),
            1
        ),
        QData(
            "1 - 2 ?",
            listOf("3", "-1", "4", "6", "7"),
            2
        ),
        QData(
            "1 * 2 ?",
            listOf("3", "-1", "2", "6"),
            3
        ),
        QData(
            "12 / 2 ?",
            listOf("3", "-1", "2", "6"),
            4
        )
    )

    data class QData(
        val question: String,
        val option: List<String>,
        val correctAnsPosition: Int,

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            QuizAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainUI(
                        quizSubjectName = intent.getStringExtra("name") ?: "Not found"
                    )
                }
            }
        }
    }

    @Composable
    fun MainUI(quizSubjectName: String) {
        var nextCount = remember {
            mutableIntStateOf(0)
        }
        val isReset = remember {
            mutableStateOf(false)
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor)
        ) {
            Column(
                modifier = Modifier
                    .padding(15.dp, 0.dp, 15.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth(1f)

                ) {
                    IconButton(
                        modifier = Modifier
                            .size(50.dp),
                        onClick = {
                            activity.finish()
                        }) {
                        Icon(
                            Icons.Filled.KeyboardArrowLeft,
                            contentDescription = "Face",
                            tint = Color(0xff642900),
                        )
                    }

                    Text(
                        modifier = Modifier.weight(1f),
                        text = "$quizSubjectName Quiz",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color(0xff642900),
                            fontWeight = FontWeight.ExtraBold
                        )
                    )
                    Text(
                        text = "Skip",
                        style = TextStyle(
                            color = Color(0xfff0a671),
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .clickable {
                                if (nextCount.intValue < questionList.size - 1) {
                                    nextCount.intValue++
                                    isReset.value = true
                                }
                            }
                    )
                }

                LinearProgress(nextCount.intValue * 1f / questionList.size)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 5.dp, bottom = 10.dp)
                ) {
                    Text(
                        text = "${nextCount.intValue}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = CardColorQuiz
                    )
                    Text(
                        text = "/${questionList.size}",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = CardColorRank
                    )
                }

                if(nextCount.intValue < questionList.size){
                    Text(
                        text = questionList[nextCount.intValue].question,
                        fontSize = 30.sp,
                        style = TextStyle(
                            color = Color(0xff642900),
                            fontWeight = FontWeight.ExtraBold
                        ),
                        modifier = Modifier.padding(bottom = 15.dp)
                    )
                    val qData = questionList[nextCount.intValue]
                    for ((i, option) in qData.option.withIndex()) {
                        QuestionItem(option, i + 1, qData.correctAnsPosition, isReset, nextCount)
                    }
                }else{
                    Text(text = "Completed", fontSize = 28.sp, fontWeight = FontWeight.ExtraBold, color = CardColorRank)
                }


                /*QuestionItem(2,1)
                QuestionItem(3,1)
                QuestionItem(4,1)*/
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun QuestionItem(
        option: String,
        position: Int,
        correctAnsPosition: Int,
        isReset: MutableState<Boolean>,
        nextCount: MutableIntState,
    ) {

        val isAnsCorrect = remember {
            mutableStateOf(false)
        }
        if (isReset.value) {
            isAnsCorrect.value = false
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isAnsCorrect.value) CardColorQuiz else CardColorRank,
            ),
            onClick = {
                if (position == correctAnsPosition) {
                    isAnsCorrect.value = true
                    isReset.value = false
                }
            }
        ) {
            Row(
                Modifier
                    .padding(start = 20.dp, top = 15.dp, bottom = 15.dp),
                verticalAlignment = Alignment.CenterVertically,


                ) {

                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = option,
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    if (isAnsCorrect.value) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(
                                onClick = { /*TODO*/ },
                            ) {
                                Icon(
                                    Icons.Filled.Face,
                                    contentDescription = "Right Arrow",
                                    tint = Color(0xFF104E3A),
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                            Text(
                                text = "See explanation",
                                color = Color(0xFF104E3A),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                }
                IconButton(onClick = {
                    if (isAnsCorrect.value) {
                        if (nextCount.value < questionList.size) {
                            nextCount.value++
                            isReset.value = true
                        }
                    }
                }) {
                    Icon(
                        imageVector = if (isAnsCorrect.value) Icons.Filled.Check else Icons.Filled.KeyboardArrowRight,
                        contentDescription = "Right Arrow",
                        tint = Color.White
                    )
                }

            }
        }
    }

    @Composable
    fun LinearProgress(percent: Float) {
        Box(
            modifier = Modifier
                .height(8.dp)
                .fillMaxWidth()
                .background(color = Color(0xfff6d4ac), shape = RoundedCornerShape(10f))
        ) {
            Box(
                modifier = Modifier
                    .height(8.dp)
                    .fillMaxWidth(percent)
                    .background(color = CardColorQuiz, shape = RoundedCornerShape(10f))
            ) {

            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Preview() {
        MainUI(
            quizSubjectName = "Hello"
        )
    }
}



