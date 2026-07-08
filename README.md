# ☕ CafeApp V1

> **"Tu Café Favorito, En Un Clic"**  
> Aplicación móvil Android para pedidos de café, desarrollada con Jetpack Compose y Clean Architecture.

---

## 📱 Plataforma

| | |
|---|---|
| **Plataforma** | Android |
| **Lenguaje** | Kotlin |
| **UI** | Jetpack Compose |
| **Min SDK** | 24 (Android 7.0) |
| **Target SDK** | 36 |
| **Arquitectura** | Clean Architecture (Domain / Data / Presentation) |

---

## 🖼️ Pantallas

| Principal | Iniciar Sesión | Registro |
|:---------:|:--------------:|:--------:|
| Pantalla de bienvenida con logo animado | Login con validación de campos | Registro con checkbox de términos |

---

## 🗂️ Estructura del Proyecto

```
com.app.cafeappv1/
│
├── MainActivity.kt                         # Entry point de la app
│
├── ui/
│   └── theme/
│       ├── Color.kt                        # Paleta de colores (dorado, oscuro, café)
│       └── Theme.kt                        # CafeAppV1Theme con darkColorScheme
│
└── presentation/
    ├── components/
    │   └── CoffeeCupLogo.kt               # Logo animado dibujado con Canvas
    │
    ├── navigation/
    │   └── Navegacion.kt                  # NavHost con rutas: principal, login, registro
    │
    ├── screens/
    │   ├── PrincipalScreen.kt             # Pantalla de bienvenida
    │   ├── LoginScreen.kt                 # Pantalla de inicio de sesión
    │   └── RegistroScreen.kt              # Pantalla de registro
    │
    ├── state/
    │   ├── AuthUIState.kt                 # Estado de la UI (correo, contraseña, errores...)
    │   └── AuthUIEvent.kt                 # Eventos sellados (Snackbar, Navigate)
    │
    └── viewmodel/
        └── AuthViewModel.kt               # Lógica de negocio con StateFlow + SharedFlow
```

---

## 🏛️ Arquitectura

El proyecto sigue el patrón **Clean Architecture** con separación en capas:

```
Presentation  ──►  Domain  ──►  Data
    │                              │
ViewModel                       Room DB
UIState                         DataStore
UIEvent                         Repository
Screens                         Mapper
```

- **Presentation** — Screens, ViewModel, State, Events
- **Domain** — Models, Repository interfaces, Use Cases *(próximas iteraciones)*
- **Data** — Room, DAOs, Entities, Mappers, DataStore *(próximas iteraciones)*
- **DI** — AppModule manual sin Hilt

---

## ⚙️ Dependencias principales

```kotlin
// Jetpack Compose
androidx.compose.bom
androidx.activity.compose

// Navigation
androidx.navigation:navigation-compose

// ViewModel
androidx.lifecycle:lifecycle-viewmodel-compose

// Coroutines
org.jetbrains.kotlinx:kotlinx-coroutines-android

// Material Icons Extended
androidx.compose.material:material-icons-extended
```

---

## 🚀 Cómo clonar y correr el proyecto

### 1. Clonar el repositorio

```bash
git clone https://github.com/AnonymousLas/cafeAppV1.git
```

### 2. Abrir en Android Studio

- Abre **Android Studio**
- Selecciona **Open** → busca la carpeta `cafeAppV1`
- Espera que Gradle sincronice

### 3. Correr la app

- Conecta un dispositivo físico **o** inicia un emulador (API 24+)
- Presiona ▶️ **Run**

---

## 🤝 Colaborar

### Agregar cambios

```bash
git add .
git commit -m "descripción del cambio"
git push
```

### Traer cambios de otro colaborador

```bash
git pull
```

### Crear una rama para trabajar sin afectar main

```bash
git checkout -b nombre-de-tu-rama
# ... haces tus cambios ...
git push origin nombre-de-tu-rama
```

---

## 🗺️ Roadmap

- [x] Pantalla Principal con logo animado
- [x] Pantalla Login con validaciones
- [x] Pantalla Registro con términos
- [ ] Home — catálogo de productos
- [ ] Carrito de pedidos
- [ ] Room DB — persistencia local
- [ ] DataStore — sesión de usuario

---

## 👥 Autores

| Usuario | Rol |
|---|---|
| [@AnonymousLas](https://github.com/AnonymousLas) | Desarrollador |

---

*Proyecto desarrollado para curso de Desarrollo Móvil — Android con Jetpack Compose*
