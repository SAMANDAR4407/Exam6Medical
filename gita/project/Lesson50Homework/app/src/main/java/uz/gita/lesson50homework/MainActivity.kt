package uz.gita.lesson50homework

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.lesson50homework.data.Task2Data
import uz.gita.lesson50homework.data.Task2List
import uz.gita.lesson50homework.data.Task3Data
import uz.gita.lesson50homework.ui.theme.Lesson50HomeworkTheme
import uz.gita.lesson50homework.ui.theme.RootBgTask3
import uz.gita.lesson50homework.ui.theme.RootBgTask4
import uz.gita.lesson50homework.ui.theme.Yellowish
import kotlin.math.exp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lesson50HomeworkTheme {
                Surface() {
                    Task2(Task2List.listData)
                }
            }
        }
    }
}
/*

private val DarkColor = darkColors(
    surface = Color.Gray,
    onSurface = Color.DarkGray,
    primary = Color.Cyan,
    onPrimary = Color.LightGray
)
private val LightColor = lightColors(
    surface = Color.Blue,
    onSurface = Color.White,
    primary = Color.Magenta,
    onPrimary = Color.Green
)

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var shouldShow by rememberSaveable { mutableStateOf(true) }
    Surface(modifier) {
        Scaffold(
            bottomBar = {
                BottomNavigation(modifier) {
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                Icons.Default.Spa,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = "Home")
                        },
                        selected = true,
                        onClick = {  }
                    )
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                Icons.Default.AccountCircle,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = "Profile")
                        },
                        selected = false,
                        onClick = {  }
                    )
                }
            }
        ) { paddingValues ->
            if (shouldShow) OnBoardScreen(modifier.padding(paddingValues),onClick = { shouldShow = false })
            else Codelabs1(modifier.padding(paddingValues))
        }
    }
}

@Composable
fun OnBoardScreen(modifier: Modifier = Modifier, onClick: () -> Unit) {

    Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Welcome to Basics")
        Button(onClick = onClick, modifier.padding(24.dp)) {
            Text(text = "Continue")
        }
    }
}

@Composable
fun Codelab1(modifier: Modifier = Modifier, name: String) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(name)
    }
}

@Composable
fun CardContent(name: String) {

    var expanded by remember { mutableStateOf(false) }

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
            ) {
                Text(text = "Hello, ")
                Text(text = name,
                    style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.ExtraBold))
                if (expanded) {
                    Text(
                        text = ("Composem ipsum color sit lazy, "+
                                "padding theme elit, sed  do bouncy.").repeat(4)
                    )
                }
            }
            IconButton(onClick = { expanded = !expanded }) {
                Icon(imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if (expanded) "show less" else "show more")
            }
        }
    }
}

@Composable
fun Codelabs1(modifier: Modifier = Modifier, names: List<String> = List(100) { "$it" }) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(names) { name ->
            Codelab1(name = name)
        }
    }
}
*/


// homeworks

@Composable
fun Task1() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "17:31",
            color = Color.Black,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 45.dp)
                .padding(top = 10.dp)
        )
        Text(
            text = "Wednesday",
            color = Color.Black,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(horizontal = 55.dp)
                .padding(top = 10.dp)
        )
        Text(
            text = "24 May 2023",
            color = Color.LightGray,
            fontSize = 10.sp,
            modifier = Modifier
                .padding(horizontal = 35.dp)
                .padding(top = 5.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(20.dp)
        ) {
            Card() {
                Image(
                    modifier = Modifier
                        .size(65.dp)
                        .padding(horizontal = 20.dp)
                        .padding(vertical = 16.dp),
                    painter = painterResource(id = R.drawable.message),
                    contentDescription = null
                )
            }

            Card() {
                Image(
                    modifier = Modifier
                        .size(65.dp)
                        .padding(horizontal = 20.dp)
                        .padding(vertical = 16.dp),
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = null
                )
            }

        }
        Icon(
            painter = painterResource(id = R.drawable.ic_more),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
        )
    }
}

@Composable
fun Task2(data: List<Task2Data>) {
    Column() {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(top = 30.dp)
                .padding(start = 20.dp),
            text = "Activity",
            fontSize = 30.sp,
            color = MaterialTheme.colors.onBackground
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
                .padding(vertical = 14.dp)
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 15.dp),
                text = "Visits".uppercase(),
                color = MaterialTheme.colors.onBackground,
                fontSize = 16.sp
            )
            Text(
                modifier = Modifier.padding(horizontal = 15.dp),
                text = "Following".uppercase(),
                color = MaterialTheme.colors.onBackground,
                fontSize = 16.sp
            )
            Text(
                modifier = Modifier.padding(horizontal = 15.dp),
                text = "You".uppercase(),
                color = MaterialTheme.colors.onBackground,
                fontSize = 16.sp
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.dp)
                .weight(1f)
        ) {
            items(data) { task2Data ->
                Task2Item(image = task2Data.image, title = task2Data.title, venue = task2Data.venue)
            }
        }

        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.height(80.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.explore),
                modifier = Modifier.padding(25.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground),
                contentDescription = null
            )
            Image(
                painter = painterResource(id = R.drawable.map),
                modifier = Modifier.padding(25.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground),
                contentDescription = null
            )
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_add_circle),
                modifier = Modifier
                    .padding(25.dp)
                    .scale(3f),
                colorFilter = ColorFilter.tint(Color.Red),
                contentDescription = null
            )
            Image(
                painter = painterResource(id = R.drawable.bell),
                modifier = Modifier.padding(25.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground),
                contentDescription = null
            )
            Image(
                painter = painterResource(id = R.drawable.profile),
                modifier = Modifier.padding(25.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground),
                contentDescription = null
            )
        }
    }
}

@Composable
fun Task2Item(@DrawableRes image: Int, title: String, venue: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(vertical = 5.dp)
    ) {
        Card(
            shape = RoundedCornerShape(20.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
                contentDescription = null
            )
        }

        Spacer(modifier = Modifier.width(20.dp))

        Column(
            modifier = Modifier
                .width(0.dp)
                .weight(1f)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = MaterialTheme.colors.onBackground,
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = venue,
                fontSize = 12.sp,
                color = MaterialTheme.colors.onBackground,
            )
        }

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_add_circle),
            modifier = Modifier.size(60.dp),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground),
            contentDescription = null
        )
    }
}

@Composable
fun Task3(data: List<Task3Data>) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(RootBgTask3)
    ) {
        Column() {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 25.dp)
            ) {
                Image(
                    modifier = Modifier.padding(start = 30.dp),
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground),
                    contentDescription = null
                )

                Text(
                    modifier = Modifier.padding(start = 67.dp),
                    fontSize = 20.sp,
                    color = MaterialTheme.colors.onBackground,
                    text = "Payment Method",
                )
            }

            LazyColumn(modifier = Modifier.padding(horizontal = 20.dp)) {
                items(data) { item ->
                    Task3Item(image = item.image, title = item.title, number = item.number)
                }
            }

            Card(
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .padding(vertical = 40.dp)
                    .fillMaxWidth()
                    .height(70.dp),
                shape = RoundedCornerShape(20.dp),
                backgroundColor = Yellowish
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(id = R.drawable.ic_bookmark),
                        contentDescription = null
                    )

                    Text(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .weight(1f)
                            .width(0.dp),
                        text = "Promo Code",
                        color = Color.White,
                        fontSize = 18.sp
                    )

                    Button(
                        modifier = Modifier
                            .width(90.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(15.dp),
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        onClick = {  }
                    ) {
                        Text(text = "Apply", color = Color.White, textAlign = TextAlign.Center, fontSize = 18.sp)
                    }
                }
            }

            Row(
                modifier = Modifier.padding(horizontal = 25.dp),
                horizontalArrangement = Arrangement.spacedBy(160.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "Transfer Amount",
                        color = Color.Gray,
                        fontSize = 17.sp
                    )
                    Text(
                        modifier = Modifier.padding(bottom = 35.dp),
                        text = "Additional Cost",
                        color = Color.Gray,
                        fontSize = 17.sp
                    )
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "Total",
                        color = Color.Gray,
                        fontSize = 17.sp
                    )
                }
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "$7.20",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Text(
                        modifier = Modifier.padding(bottom = 35.dp),
                        text = "$0.5",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "$7.25",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp)
                    .padding(vertical = 30.dp)
                    .height(70.dp),
                shape = RoundedCornerShape(20.dp),
                onClick = {  },
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(
                    text = "Pay",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 19.sp
                )
            }
        }
    }
}

@Composable
fun Task3Item(@DrawableRes image: Int, title: String, number: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        shape = RoundedCornerShape(20.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(85.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(start = 30.dp)
                    .width(60.dp)
                    .height(60.dp),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(30.dp))

            Column(
                modifier = Modifier
                    .width(0.dp)
                    .weight(1f)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.onBackground,
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = number,
                    fontSize = 14.sp,
                    color = MaterialTheme.colors.onBackground
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 10.dp)
                    .width(40.dp),
                contentAlignment = Alignment.Center
            ) {
                RadioButton(selected = true, onClick = {})
            }
        }
    }
}

@Composable
fun Task4(modifier: Modifier = Modifier, placeholder: String = "Type here", value: String, onValueChange: (String) -> Unit) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(RootBgTask4),
    ) {
        Column(
            modifier = modifier
                .padding(20.dp)
                .fillMaxSize()
        ) {
            Image(
                modifier = modifier
                    .scale(1.5f)
                    .align(Alignment.End),
                painter = painterResource(id = R.drawable.ic_more),
                contentDescription = null
            )
            Spacer(
                modifier = modifier
                    .fillMaxWidth()
                    .height(40.dp)
            )
            Image(
                modifier = modifier
                    .size(150.dp)
                    .padding(bottom = 5.dp)
                    .align(Alignment.CenterHorizontally),
                colorFilter = ColorFilter.tint(Color.White),
                painter = painterResource(id = R.drawable.target),
                contentDescription = null
            )
            Text(
                color = Color.White,
                fontSize = 40.sp,
                modifier = modifier.align(Alignment.CenterHorizontally),
                text = "mygoals",
            )

            Spacer(modifier = modifier.height(50.dp))

            Text(
                modifier = modifier.padding(start = 30.dp),
                color = Color.White,
                fontSize = 14.sp,
                text = "Email",
            )
            BasicTextField(
                value = value,
                onValueChange = { newText ->
                    onValueChange.invoke(newText)
                },
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                ),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(horizontal = 25.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(size = 5.dp)
                            )
                            .padding(horizontal = 16.dp, vertical = 12.dp), // inner padding
                    ) {
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.LightGray
                            )
                        }
                        innerTextField()
                    }
                }
            )

            Spacer(modifier = modifier.height(30.dp))

            Text(
                modifier = modifier.padding(start = 30.dp),
                color = Color.White,
                fontSize = 14.sp,
                text = "Password",
            )

            BasicTextField(
                value = value,
                onValueChange = { newText ->
                    onValueChange.invoke(newText)
                },
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                ),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(horizontal = 25.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(size = 5.dp)
                            )
                            .padding(horizontal = 16.dp, vertical = 12.dp), // inner padding
                    ) {
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.LightGray
                            )
                        }
                        innerTextField()
                    }
                }
            )

            Text(
                text = "Forgot password?",
                fontSize = 12.sp,
                color = Color.White,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 14.dp)
            )

            Spacer(modifier = modifier.height(20.dp))

            Button(
                onClick = {  },
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .width(180.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(Color(0xFF95EBAE))
            ) {
                Text(text = "Log In", color = Color.DarkGray, fontSize = 17.sp, textAlign = TextAlign.Center)
            }
            
            Spacer(modifier = modifier
                .height(0.dp)
                .weight(1f))

            Text(
                text = "Don't have an account?",
                fontSize = 12.sp,
                color = Color.White,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Create an Account",
                fontSize = 15.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 10.dp)
            )
        }
    }
}

//@Preview(uiMode = UI_MODE_NIGHT_YES)
//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lesson50HomeworkTheme {
        Surface(
            color = MaterialTheme.colors.surface
        ) {

        }
    }
}

@Preview
@Composable
fun ItemPreview() {
    Lesson50HomeworkTheme() {
        Surface() {
            Task2(Task2List.listData)
        }
    }
}