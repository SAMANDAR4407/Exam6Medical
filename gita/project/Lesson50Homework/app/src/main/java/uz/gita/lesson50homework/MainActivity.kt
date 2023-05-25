package uz.gita.lesson50homework

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.lesson50homework.data.Task2Data
import uz.gita.lesson50homework.ui.theme.Lesson50HomeworkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lesson50HomeworkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val data = listOf(
                        Task2Data(R.drawable.plane, "Plane", "Airport"),
                        Task2Data(R.drawable.cat, "Cat", "Pet house"),
                        Task2Data(R.drawable.bug, "Bug", "Insect"),
                        Task2Data(R.drawable.desert, "Desert", "Sahara"),
                        Task2Data(R.drawable.windows, "Windows", "Microsoft"),
                        Task2Data(R.drawable.cat, "Cat", "Pet house"),
                        Task2Data(R.drawable.bug, "Bug", "Insect"),
                        Task2Data(R.drawable.desert, "Desert", "Sahara"),
                        Task2Data(R.drawable.windows, "Windows", "Microsoft")
                    ).shuffled()
                    Task2(data)
                }
            }
        }
    }
}


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
        
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp)
            .padding(vertical = 14.dp)
        ){
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
        
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .height(0.dp)
            .weight(1f)) {
            items(data){ task2Data ->
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
fun Task2Item(
    @DrawableRes
    image: Int,
    title: String,
    venue: String
){
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

        Column(modifier = Modifier
            .width(0.dp)
            .weight(1f)) {
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

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lesson50HomeworkTheme {
        Surface(
            color = MaterialTheme.colors.surface
        ) {
            val data = listOf(
                Task2Data(R.drawable.plane, "Plane", "Airport"),
                Task2Data(R.drawable.cat, "Cat", "Pet house"),
                Task2Data(R.drawable.bug, "Bug", "Insect"),
                Task2Data(R.drawable.desert, "Desert", "Sahara"),
                Task2Data(R.drawable.windows, "Windows", "Microsoft"),
                Task2Data(R.drawable.cat, "Cat", "Pet house"),
                Task2Data(R.drawable.bug, "Bug", "Insect"),
                Task2Data(R.drawable.desert, "Desert", "Sahara"),
                Task2Data(R.drawable.windows, "Windows", "Microsoft")
            ).shuffled()
//        Task1()
            Task2(data)
//        Task2Item(title = "First", venue = "First")
        }
    }
}