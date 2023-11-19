package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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

@Composable
private fun MyApp(modifier: Modifier = Modifier) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "screen1") {
            composable(route = "screen1") {
                Screen1(onClickButton = { navController.navigate("screen2") })
            }
            composable(route = "screen2") {
                Screen2(onClickButton = { navController.navigateUp() })
            }
        }



        //rootDraw()
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

    Screen1()
}

@Composable
fun Screen1(onClickButton: ()->Unit = {}) {
    Column {
        Text(text = "Screen 1")
        Button(onClick = onClickButton) {
            Text(text = "Go to Screen 2")
        }
    }
}

@Composable
fun Screen2(onClickButton: ()->Unit = {}) {
    Column {
        Text(text = "Screen 2")
        Button(onClick = onClickButton) {
            Text(text = "Back to Screen 1")
        }
    }
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
        Button(
            onClick = {




            }
        ) {
            Text(text = "遷移です!")
        }
    }
}

private fun onClickTransition() {



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