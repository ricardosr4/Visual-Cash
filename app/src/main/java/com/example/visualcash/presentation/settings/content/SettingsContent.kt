package com.example.visualcash.presentation.settings.content

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Payments
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Shield
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.visualcash.core.model.Currency
import com.example.visualcash.core.ui.theme.VisualCashTheme
import com.example.visualcash.presentation.components.ZetaCurrencySelector
import com.example.visualcash.presentation.components.ZetaSettingsItem
import com.example.visualcash.presentation.settings.state.SettingsState

@Composable
fun SettingsContent(
    state: SettingsState,
    onDoneClick: () -> Unit,
    onChangePasswordClick: () -> Unit,
    onSecurityClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onCurrencyClick: () -> Unit,
    onCurrencySelected: (Currency) -> Unit,
    onCurrencySelectorDismiss: () -> Unit,
    onLanguageClick: () -> Unit,
    onDarkModeToggle: (Boolean) -> Unit,
    onHelpCenterClick: () -> Unit,
    onContactClick: () -> Unit,
    onLogoutClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState()),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 12.dp, top = 16.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Ajustes",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onBackground,
            )
            TextButton(onClick = onDoneClick) {
                Text(
                    text = "Hecho",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.labelLarge,
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        ProfileCard(
            userName = state.userName,
            membershipType = state.membershipType,
            userEmail = state.userEmail,
        )

        Spacer(modifier = Modifier.height(28.dp))

        SectionLabel("CUENTA")

        SettingsCard {
            ZetaSettingsItem(
                icon = Icons.Outlined.Lock,
                iconTint = Color(0xFF22C55E),
                iconBackground = Color(0xFF0D2818),
                title = "Cambiar contraseña",
                onClick = onChangePasswordClick,
            )
            SettingsDivider()
            ZetaSettingsItem(
                icon = Icons.Outlined.Shield,
                iconTint = Color(0xFFF97316),
                iconBackground = Color(0xFF2D1A0A),
                title = "Seguridad",
                onClick = onSecurityClick,
            )
            SettingsDivider()
            ZetaSettingsItem(
                icon = Icons.Outlined.Notifications,
                iconTint = Color(0xFFFBBF24),
                iconBackground = Color(0xFF2D2A0A),
                title = "Notificaciones",
                trailingText = if (state.isNotificationsEnabled) "Activado" else "Desactivado",
                onClick = onNotificationsClick,
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        SectionLabel("PREFERENCIAS")

        SettingsCard {
            ZetaSettingsItem(
                icon = Icons.Outlined.Payments,
                iconTint = Color(0xFF3B82F6),
                iconBackground = Color(0xFF0A1A2D),
                title = "Moneda",
                trailingText = state.selectedCurrency.label,
                onClick = onCurrencyClick,
            )
            SettingsDivider()
            ZetaSettingsItem(
                icon = Icons.Outlined.Language,
                iconTint = Color(0xFF14B8A6),
                iconBackground = Color(0xFF0A2D2A),
                title = "Idioma",
                trailingText = state.selectedLanguage,
                onClick = onLanguageClick,
            )
            SettingsDivider()
            ZetaSettingsItem(
                icon = Icons.Outlined.DarkMode,
                iconTint = Color(0xFF8B5CF6),
                iconBackground = Color(0xFF1A0A2D),
                title = "Modo Oscuro",
                showChevron = false,
                onClick = { onDarkModeToggle(!state.isDarkModeEnabled) },
                trailingContent = {
                    Switch(
                        checked = state.isDarkModeEnabled,
                        onCheckedChange = onDarkModeToggle,
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,
                            checkedTrackColor = MaterialTheme.colorScheme.primary,
                            uncheckedThumbColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            uncheckedTrackColor = MaterialTheme.colorScheme.surfaceVariant,
                        ),
                    )
                },
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        SectionLabel("AYUDA Y SOPORTE")

        SettingsCard {
            ZetaSettingsItem(
                icon = Icons.Outlined.HelpOutline,
                iconTint = Color(0xFF94A3B8),
                iconBackground = Color(0xFF1C2A3A),
                title = "Centro de ayuda",
                onClick = onHelpCenterClick,
            )
            SettingsDivider()
            ZetaSettingsItem(
                icon = Icons.Outlined.MailOutline,
                iconTint = Color(0xFF94A3B8),
                iconBackground = Color(0xFF1C2A3A),
                title = "Contacto",
                onClick = onContactClick,
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onLogoutClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFEF4444).copy(alpha = 0.15f),
                contentColor = Color(0xFFEF4444),
            ),
        ) {
            Text(
                text = "Cerrar Sesión",
                style = MaterialTheme.typography.labelLarge,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "VISUAL CASH ${state.appVersion}",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )

        Spacer(modifier = Modifier.height(32.dp))
    }

    ZetaCurrencySelector(
        isVisible = state.isCurrencySelectorVisible,
        selectedCurrency = state.selectedCurrency,
        onCurrencySelected = onCurrencySelected,
        onDismiss = onCurrencySelectorDismiss,
    )
}

@Composable
private fun ProfileCard(
    userName: String,
    membershipType: String,
    userEmail: String,
) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .background(
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            shape = CircleShape,
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(28.dp),
                    )
                }
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.BottomEnd)
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = CircleShape,
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(12.dp),
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = userName,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                )
                Text(
                    text = membershipType,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                Text(
                    text = userEmail,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}

@Composable
private fun SectionLabel(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
    )
}

@Composable
private fun SettingsCard(
    content: @Composable () -> Unit,
) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
    ) {
        Column {
            content()
        }
    }
}

@Composable
private fun SettingsDivider() {
    HorizontalDivider(
        color = MaterialTheme.colorScheme.outlineVariant,
        modifier = Modifier.padding(horizontal = 16.dp),
    )
}

@Preview(showBackground = true)
@Composable
private fun SettingsContentPreview() {
    VisualCashTheme {
        SettingsContent(
            state = SettingsState(),
            onDoneClick = {},
            onChangePasswordClick = {},
            onSecurityClick = {},
            onNotificationsClick = {},
            onCurrencyClick = {},
            onCurrencySelected = {},
            onCurrencySelectorDismiss = {},
            onLanguageClick = {},
            onDarkModeToggle = {},
            onHelpCenterClick = {},
            onContactClick = {},
            onLogoutClick = {},
        )
    }
}
