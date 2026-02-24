package com.example.visualcash.presentation.auth.login.content

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AlternateEmail
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visualcash.core.ui.theme.FacebookBlue
import com.example.visualcash.core.ui.theme.GoogleColor
import com.example.visualcash.core.ui.theme.VisualCashTheme
import com.example.visualcash.presentation.auth.login.state.LoginState
import com.example.visualcash.presentation.components.ZetaButton
import com.example.visualcash.presentation.components.ZetaClickableTextRow
import com.example.visualcash.presentation.components.ZetaDividerWithText
import com.example.visualcash.presentation.components.ZetaOutlinedTextField
import com.example.visualcash.presentation.components.ZetaSocialButton

@Composable
fun LoginContent(
    state: LoginState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onPasswordVisibilityToggle: () -> Unit,
    onLoginClick: () -> Unit,
    onGoogleClick: () -> Unit,
    onFacebookClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onRegisterClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .systemBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(48.dp))

        Box(
            modifier = Modifier
                .size(80.dp)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(20.dp),
                ),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "VC",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onPrimary,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Visual Cash",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onBackground,
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Inteligencia Financiera Profesional",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )

        Spacer(modifier = Modifier.height(32.dp))

        Surface(
            shape = RoundedCornerShape(24.dp),
            color = MaterialTheme.colorScheme.surface,
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                ZetaOutlinedTextField(
                    value = state.email,
                    onValueChange = onEmailChanged,
                    label = "CORREO ELECTRÓNICO",
                    placeholder = "tu@email.com",
                    leadingIcon = Icons.Outlined.AlternateEmail,
                    keyboardType = KeyboardType.Email,
                )

                Spacer(modifier = Modifier.height(16.dp))

                ZetaOutlinedTextField(
                    value = state.password,
                    onValueChange = onPasswordChanged,
                    label = "CONTRASEÑA",
                    placeholder = "••••••••",
                    leadingIcon = Icons.Outlined.Lock,
                    isPassword = true,
                    isPasswordVisible = state.isPasswordVisible,
                    onVisibilityToggle = onPasswordVisibilityToggle,
                    keyboardType = KeyboardType.Password,
                )

                Spacer(modifier = Modifier.height(4.dp))

                TextButton(
                    onClick = onForgotPasswordClick,
                    modifier = Modifier.align(Alignment.End),
                    contentPadding = PaddingValues(horizontal = 0.dp, vertical = 4.dp),
                ) {
                    Text(
                        text = "¿Olvidaste tu contraseña?",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary,
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                ZetaButton(
                    text = "Iniciar Sesión",
                    onClick = onLoginClick,
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        ZetaDividerWithText(
            text = "O CONECTA DE FORMA SEGURA",
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(24.dp))

        ZetaSocialButton(
            text = "Continuar con Facebook",
            onClick = onFacebookClick,
            modifier = Modifier.fillMaxWidth(),
            icon = {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(
                            color = FacebookBlue,
                            shape = RoundedCornerShape(12.dp),
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "f",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            },
        )

        Spacer(modifier = Modifier.height(12.dp))

        ZetaSocialButton(
            text = "Continuar con Google",
            onClick = onGoogleClick,
            modifier = Modifier.fillMaxWidth(),
            icon = {
                Text(
                    text = "G",
                    color = GoogleColor,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
            },
        )

        Spacer(modifier = Modifier.height(32.dp))

        ZetaClickableTextRow(
            leadingText = "¿Eres nuevo en Visual Cash?",
            clickableText = "Crear cuenta",
            onClick = onRegisterClick,
        )

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginContentPreview() {
    VisualCashTheme {
        LoginContent(
            state = LoginState(),
            onEmailChanged = {},
            onPasswordChanged = {},
            onPasswordVisibilityToggle = {},
            onLoginClick = {},
            onGoogleClick = {},
            onFacebookClick = {},
            onForgotPasswordClick = {},
            onRegisterClick = {},
        )
    }
}
