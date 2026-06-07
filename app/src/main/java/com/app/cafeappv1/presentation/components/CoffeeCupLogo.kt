package com.app.cafeappv1.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun CoffeeCupLogo(
    modifier: Modifier = Modifier.size(180.dp),
    steamAlpha: Float = 0.7f
) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val cx = w / 2f

        // ── PLATILLO ─────────────────────────────────────────────
        drawOval(
            color = Color(0xFF4A2C0A).copy(alpha = 0.5f),
            topLeft = Offset(cx - w * 0.32f, h * 0.78f),
            size = Size(w * 0.64f, h * 0.14f)
        )

        // ── TAZA (cuerpo exterior) ────────────────────────────────
        val cupPath = Path().apply {
            moveTo(cx - w * 0.30f, h * 0.50f)
            quadraticBezierTo(cx - w * 0.33f, h * 0.70f, cx - w * 0.20f, h * 0.78f)
            quadraticBezierTo(cx, h * 0.85f, cx + w * 0.20f, h * 0.78f)
            quadraticBezierTo(cx + w * 0.33f, h * 0.70f, cx + w * 0.30f, h * 0.50f)
            close()
        }
        drawPath(cupPath, color = Color(0xFF7B3F00))

        // ── TAZA (cuerpo interior / reflejo) ─────────────────────
        val cupInner = Path().apply {
            moveTo(cx - w * 0.24f, h * 0.50f)
            quadraticBezierTo(cx - w * 0.27f, h * 0.68f, cx - w * 0.14f, h * 0.76f)
            quadraticBezierTo(cx, h * 0.82f, cx + w * 0.14f, h * 0.76f)
            quadraticBezierTo(cx + w * 0.27f, h * 0.68f, cx + w * 0.24f, h * 0.50f)
            close()
        }
        drawPath(cupInner, color = Color(0xFFA0522D))

        // ── SOMBRA SUPERIOR DENTRO ────────────────────────────────
        val shadowPath = Path().apply {
            moveTo(cx - w * 0.24f, h * 0.50f)
            quadraticBezierTo(cx, h * 0.58f, cx + w * 0.24f, h * 0.50f)
            close()
        }
        drawPath(shadowPath, color = Color(0xFF8B4513).copy(alpha = 0.6f))

        // ── BORDE SUPERIOR (elipse del borde de la taza) ─────────
        drawOval(
            color = Color(0xFFC1772F),
            topLeft = Offset(cx - w * 0.30f, h * 0.44f),
            size = Size(w * 0.60f, h * 0.12f)
        )
        drawOval(
            color = Color(0xFFD4933A),
            topLeft = Offset(cx - w * 0.24f, h * 0.46f),
            size = Size(w * 0.48f, h * 0.08f)
        )

        // ── ASA ───────────────────────────────────────────────────
        drawArc(
            color = Color(0xFF7B3F00),
            startAngle = -90f,
            sweepAngle = 180f,
            useCenter = false,
            topLeft = Offset(cx + w * 0.24f, h * 0.54f),
            size = Size(w * 0.18f, h * 0.20f),
            style = Stroke(width = w * 0.05f, cap = StrokeCap.Round)
        )

        // ── VAPOR (3 líneas animadas) ─────────────────────────────
        val steamColor = Color(0xFFF5C542).copy(alpha = steamAlpha)
        val steamStroke = Stroke(width = 3.dp.toPx(), cap = StrokeCap.Round)

        // Vapor izquierdo
        val s1 = Path().apply {
            moveTo(cx - w * 0.14f, h * 0.38f)
            cubicTo(cx - w * 0.18f, h * 0.28f, cx - w * 0.10f, h * 0.22f, cx - w * 0.14f, h * 0.12f)
        }
        drawPath(s1, color = steamColor, style = steamStroke)

        // Vapor centro
        val s2 = Path().apply {
            moveTo(cx, h * 0.35f)
            cubicTo(cx - w * 0.04f, h * 0.24f, cx + w * 0.04f, h * 0.16f, cx, h * 0.06f)
        }
        drawPath(s2, color = steamColor.copy(alpha = steamAlpha * 0.85f), style = steamStroke)

        // Vapor derecho
        val s3 = Path().apply {
            moveTo(cx + w * 0.12f, h * 0.38f)
            cubicTo(cx + w * 0.16f, h * 0.28f, cx + w * 0.08f, h * 0.22f, cx + w * 0.12f, h * 0.12f)
        }
        drawPath(s3, color = steamColor.copy(alpha = steamAlpha * 0.7f), style = steamStroke)

        // ── GRANOS DE CAFÉ (decoración base) ─────────────────────
        drawOval(
            color = Color(0xFFC9A24A).copy(alpha = 0.35f),
            topLeft = Offset(cx - w * 0.22f, h * 0.84f),
            size = Size(w * 0.44f, h * 0.09f)
        )
    }
}
