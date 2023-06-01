package uz.gita.mycontactcompose.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.mycontactcompose.R
import uz.gita.mycontactcompose.ui.theme.MyContactComposeTheme

/**
 *    Created by Kamolov Samandar on 26.05.2023 at 17:23
 */

@Composable
fun ContactItem(
    @DrawableRes image: Int = R.drawable.photo_man,
    firstName: String,
    lastName: String,
    phone: String,
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 5.dp),
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
                    text = "$lastName $firstName",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = phone,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}

@Composable
@Preview
fun Item(){
    MyContactComposeTheme {
//        ContactItem(firstName = "Samandar", lastName = "Kamalov", phone = "+998900334407")
    }
}