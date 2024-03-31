rootProject.name = "demo"

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

include(
    "domain",
    "app:core",
    "app:planner",
    "app:user"
)