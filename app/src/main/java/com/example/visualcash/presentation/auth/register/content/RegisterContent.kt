package com.example.visualcash.presentation.auth.register.content

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Shield
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visualcash.core.ui.theme.FacebookBlue
import com.example.visualcash.core.ui.theme.GoogleColor
import com.example.visualcash.core.ui.theme.ZetaBlue
import com.example.visualcash.core.ui.theme.VisualCashTheme
import com.example.visualcash.presentation.auth.register.state.RegisterState
import com.example.visualcash.presentation.components.ZetaButton
import com.example.visualcash.presentation.components.ZetaClickableTextRow
import com.example.visualcash.presentation.components.ZetaDividerWithText
import com.example.visualcash.presentation.components.ZetaOutlinedTextField
import com.example.visualcash.presentation.components.ZetaSocialButton

@Composable
fun RegisterContent(
    state: RegisterState,
    onFullNameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onConfirmPasswordChanged: (String) -> Unit,
    onPasswordVisibilityToggle: () -> Unit,
    onConfirmPasswordVisibilityToggle: () -> Unit,
    onTermsAcceptedChanged: (Boolean) -> Unit,
    onRegisterClick: () -> Unit,
    onGoogleClick: () -> Unit,
    onFacebookClick: () -> Unit,
    onBackClick: () -> Unit,
    onHelpClick: () -> Unit,
    onLoginClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .systemBarsPadding()
            .verticalScroll(rememberScrollState()),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Volver",
                    tint = MaterialTheme.colorScheme.onBackground,
                )
            }
            TextButton(onClick = onHelpClick) {
                Text(
                    text = "Ayuda",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.labelLarge,
                )
            }
        }

        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            Text(
                text = "Crear Cuenta",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onBackground,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Únete a miles que gestionan su patrimonio de forma inteligente.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )

            Spacer(modifier = Modifier.height(28.dp))

            Surface(
                shape = RoundedCornerShape(24.dp),
                color = MaterialTheme.colorScheme.surface,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                modifier = Modifier.fillMaxWidth(),
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    ZetaOutlinedTextField(
                        value = state.fullName,
                        onValueChange = onFullNameChanged,
                        label = "Nombre Completo",
                        placeholder = "Juan Pérez",
                        leadingIcon = Icons.Outlined.Person,
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    ZetaOutlinedTextField(
                        value = state.email,
                        onValueChange = onEmailChanged,
                        label = "Correo Electrónico",
                        placeholder = "nombre@ejemplo.com",
                        leadingIcon = Icons.Outlined.Email,
                        keyboardType = KeyboardType.Email,
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    ZetaOutlinedTextField(
                        value = state.password,
                        onValueChange = onPasswordChanged,
                        label = "Contraseña",
                        placeholder = "••••••••",
                        leadingIcon = Icons.Outlined.Lock,
                        isPassword = true,
                        isPasswordVisible = state.isPasswordVisible,
                        onVisibilityToggle = onPasswordVisibilityToggle,
                        keyboardType = KeyboardType.Password,
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    ZetaOutlinedTextField(
                        value = state.confirmPassword,
                        onValueChange = onConfirmPasswordChanged,
                        label = "Confirmar Contraseña",
                        placeholder = "••••••••",
                        leadingIcon = Icons.Outlined.Shield,
                        isPassword = true,
                        isPasswordVisible = state.isConfirmPasswordVisible,
                        onVisibilityToggle = onConfirmPasswordVisibilityToggle,
                        keyboardType = KeyboardType.Password,
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(verticalAlignment = Alignment.Top) {
                        Checkbox(
                            checked = state.isTermsAccepted,
                            onCheckedChange = onTermsAcceptedChanged,
                            colors = CheckboxDefaults.colors(
                                checkedColor = MaterialTheme.colorScheme.primary,
                                uncheckedColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                checkmarkColor = MaterialTheme.colorScheme.onPrimary,
                            ),
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = buildAnnotatedString {
                                append("Al registrarte, aceptas nuestros ")
                                withStyle(SpanStyle(color = ZetaBlue)) {
                                    append("Términos de Servicio")
                                }
                                append(" y ")
                                withStyle(SpanStyle(color = ZetaBlue)) {
                                    append("Política de Privacidad")
                                }
                                append(".")
                            },
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(top = 14.dp),
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    ZetaButton(
                        text = "Registrarse",
                        onClick = onRegisterClick,
                        enabled = state.isTermsAccepted,
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            ZetaDividerWithText(
                text = "O REGISTRARSE CON",
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                ZetaSocialButton(
                    text = "Google",
                    onClick = onGoogleClick,
                    modifier = Modifier.weight(1f),
                    icon = {
                        Text(
                            text = "G",
                            color = GoogleColor,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    },
                )
                ZetaSocialButton(
                    text = "Facebook",
                    onClick = onFacebookClick,
                    modifier = Modifier.weight(1f),
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
            }

            Spacer(modifier = Modifier.height(28.dp))

            ZetaClickableTextRow(
                leadingText = "¿Ya tienes una cuenta?",
                clickableText = "Iniciar sesión",
                onClick = onLoginClick,
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RegisterContentPreview() {
    VisualCashTheme {
        RegisterContent(
            state = RegisterState(),
            onFullNameChanged = {},
            onEmailChanged = {},
            onPasswordChanged = {},
            onConfirmPasswordChanged = {},
            onPasswordVisibilityToggle = {},
            onConfirmPasswordVisibilityToggle = {},
            onTermsAcceptedChanged = {},
            onRegisterClick = {},
            onGoogleClick = {},
            onFacebookClick = {},
            onBackClick = {},
            onHelpClick = {},
            onLoginClick = {},
        )
    }
}
