
package com.example.profildeveloppeur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profildeveloppeur.ui.theme.ProfilDeveloppeurTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ProfilDeveloppeurTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    ProfilDevScreen(
                        name = "Henri Martin",
                        poste = "Développeur Android Junior",
                        description = "Étudiant en informatique, passionné par le développement d'applications mobiles avec Kotlin et Jetpack Compose.",
                        competences = listOf(
                            "Kotlin",
                            "Jetpack Compose",
                            "Android Studio",
                            "Git"
                        ),
                        contact = "henri.martin@email.com",
                        disponibilite = "Disponible pour un stage",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ProfilDevScreen(
    name: String,
    poste: String,
    description: String,
    competences: List<String>,
    contact: String,
    disponibilite: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {

            ProfilHeader(
                name = name,
                poste = poste,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            ProfilDescription(
                description = description,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Text(
                text = "Mes compétences"
            )

            Column(
                modifier = Modifier.padding(
                    top = 8.dp,
                    bottom = 20.dp
                )
            ) {
                competences.forEach { competence ->
                    SkillItem(
                        competence = competence,
                        modifier = Modifier.padding(bottom = 6.dp)
                    )
                }
            }

            ContactInfo(
                contact = contact,
                disponibilite = disponibilite,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            ContactButton(
                text = "Me contacter",
                onClick = {
                }
            )
        }
    }
}

@Composable
fun ProfilHeader(
    name: String,
    poste: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = name
        )

        Text(
            text = poste,
            color = Color.Gray
        )
    }
}

@Composable
fun ProfilDescription(
    description: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "À propos"
        )

        Text(
            text = description,
            modifier = Modifier.padding(top = 8.dp),
            color = Color.DarkGray
        )
    }
}

@Composable
fun SkillItem(
    competence: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = Color(0xFFF0F0F0)
    ) {
        Text(
            text = competence,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun ContactInfo(
    contact: String,
    disponibilite: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Contact"
        )

        Text(
            text = contact,
            modifier = Modifier.padding(top = 8.dp)
        )

        Text(
            text = disponibilite,
            modifier = Modifier.padding(top = 8.dp),
            color = Color(0xFF24834A)
        )
    }
}

@Composable
fun ContactButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilDevPreview() {
    ProfilDeveloppeurTheme {
        ProfilDevScreen(
            name = "Henri Martin",
            poste = "Développeur Android Junior",
            description = "Étudiant en informatique, passionné par le développement mobile.",
            competences = listOf(
                "Kotlin",
                "Jetpack Compose",
                "Android Studio",
                "Git"
            ),
            contact = "henri.martin@email.com",
            disponibilite = "Disponible pour un stage"
        )
    }
}

