package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {

                MyApp(modifier = Modifier.fillMaxSize())



            }
        }
    }
}

/**
 * Unit関数
 */
private fun Sample() {
    var i:Int = 0
    for(idx in 0..100) {
        Log.d("TAG", "$idx")
    }

    var ary = arrayOf(1,2,3,4,5)
    var list = listOf<String>("にゃも","めめ")

    var mp = mapOf("1" to "アリス", "nene" to "ねね")

    i = 0
    while (i<10) {
        i++
    }

    repeat(10) {
        Log.d("TAG", "repeat!!")
    }

    repeat(ary.size) {
        Log.d("TAG", "$it")
    }
}

private fun GetValue(no:Int) : Int{
    return no
}

/**
 *
 */
private fun searchValue(target:Int ,tbl:IntArray): Int {
    for (idx in 0 .. tbl.size) {
        if(tbl[idx] == target) {
            return idx
        }
    }

    return -1
}

@Composable
private fun MyApp(modifier: Modifier = Modifier) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        rootDraw()
    }
}

@Composable
fun rootDraw() {
    var text by remember { mutableStateOf("") }
    var name = remember {
        mutableStateOf("パイパイ")
    }
    val polarBear = remember { mutableStateListOf<Int>() }

    DrawImageSample()
    drawColum()
//    drawFooter()
    drawFooterChange(name)
    drawButton()

    changeText(name)
    drawName(name)

}

@Composable
fun drawName(name: MutableState<String>) {
    Text(text = name.value)
}

var num = 234

@Composable
fun drawCnt() {

    Text(text = "$num")
}

@Composable
fun drawName(name: String) {
    Text(text = name)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun drawInput() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        var text by remember { mutableStateOf("") }
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.padding(20.dp),
            label = { Text(text = "Label") }
        )
    }
}

@Composable
fun drawButton() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var count by remember { mutableStateOf(0) }
        Text(
            text = "Tap count: $count",
            modifier = Modifier.padding(20.dp)
        )
        Button(
            onClick = { count++ }
        ) {
            Text(text = "Count up!")
        }
    }
}

@Composable
fun drawColum() {
    Column() {
         Text(text = "ノエル")
        Text(text = "スイカ")
        Text(text = "マリン")
    }
}

@Composable
fun drawFooter() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ){
        Image(
            painter = painterResource(R.drawable.noel),
            contentDescription = "ノエちゃん",
            modifier = Modifier
                .border(1.dp, Color.Green)
                .clickable { Log.d("TAG", "ノエちゃん") },
            contentScale = ContentScale.Fit,

        )
        Image(
            painter = painterResource(R.drawable.noel),
            contentDescription = "ノエちゃん",
            modifier = Modifier.border(1.dp, Color.Red),
            contentScale = ContentScale.Fit
        )
        Image(
            painter = painterResource(R.drawable.noel),
            contentDescription = "ノエちゃん",
            modifier = Modifier.border(1.dp, Color.Yellow),
            contentScale = ContentScale.Fit
        )

        Image(
            painter = painterResource(R.drawable.noel),
            contentDescription = "ノエちゃん",
            modifier = Modifier.border(1.dp, Color.Red),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun drawFooterChange(name: MutableState<String>) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ){
        Image(
            painter = painterResource(R.drawable.noel),
            contentDescription = "ノエちゃん",
            modifier = Modifier
                .border(1.dp, Color.Green)
                .clickable { Log.d("TAG", "ノエちゃん")
                    name.value = "ノエちゃん"
                           },
            contentScale = ContentScale.Fit,

            )
        Image(
            painter = painterResource(R.drawable.noel),
            contentDescription = "ノエちゃん",
            modifier = Modifier.border(1.dp, Color.Blue).clickable { Log.d("TAG", "ノエちゃん")
                name.value = "マリン"
            },
            contentScale = ContentScale.Fit
        )
        Image(
            painter = painterResource(R.drawable.noel),
            contentDescription = "ノエちゃん",
            modifier = Modifier.border(1.dp, Color.Yellow),
            contentScale = ContentScale.Fit
        )

        Image(
            painter = painterResource(R.drawable.noel),
            contentDescription = "ノエちゃん",
            modifier = Modifier.border(1.dp, Color.Red),
            contentScale = ContentScale.Fit
        )
    }
}



private fun changeText(message: MutableState<String>) {
    message.value = "world from Compose"
}

@Composable
fun drawBox() {
   Box {
       Image(
           painter = painterResource(R.drawable.noel),
           contentDescription = "ノエちゃん",
           modifier = Modifier.border(1.dp, Color.Red),
           contentScale = ContentScale.Fit
       )
       Text(
           text = "ノエちゃんのスイカ!",
           color = Color.Blue,
           modifier = Modifier.offset(x = 10.dp, y = 80.dp)
       )
   }
}


@Composable
fun DrawImageSample(){
    Image(
        painter = painterResource(R.drawable.noel),
        contentDescription = "ノエちゃん",
        modifier = Modifier.border(1.dp, Color.Red),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun TestText(name: String,modifier: Modifier = Modifier) {
    Column {
        val story = "昔々あるところにおじいさんとおばあさんがいました。" +
                "おじいさんは山へ柴刈りに、おばあさんは川へ洗濯に行きました。" +
                "おばあさんが川で洗濯をしていると、大きな桃がどんぶらこどんぶらこと流れてきました。"
        Text(text = story, color = Color.Red)
        Text(text = story, color = Color.Blue, maxLines = 2)
        Text(text = story, color = Color.Black, maxLines = 1 , modifier = modifier)
    }


    Row {
       val storyRow = "にゃ〜も!!"
       var num = 0
       val NAME_MATERIAL = "裕一"
       Text(text = storyRow)
        Text(text = storyRow)
        Text(text = storyRow)
    }

}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
private fun GreetingColor(name: String) {
    Surface(color = MaterialTheme.colorScheme.primary) {
        Text(text = "Hello $name!", modifier = Modifier.padding(4.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewa() {
    MyApplicationTheme {
        GreetingColor("にゃも")
    }
}