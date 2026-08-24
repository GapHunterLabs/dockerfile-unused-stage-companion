package dev.gaphunter.dockerfileunusedstagecompanion.inspection

import com.intellij.testFramework.fixtures.BasePlatformTestCase

class UnusedStageInspectionTest : BasePlatformTestCase() {

    override fun setUp() {
        super.setUp()
        myFixture.enableInspections(UnusedStageInspection::class.java)
    }

    fun `test an unreferenced intermediate stage produces a warning`() {
        myFixture.configureByText(
            "Dockerfile",
            """
            FROM golang:1.21 AS builder
            RUN go build -o app

            FROM alpine:3.19
            COPY app /app
            """.trimIndent(),
        )
        val highlights = myFixture.doHighlighting()
        assertTrue(highlights.any { it.description?.contains("builder") == true })
    }

    fun `test a referenced stage produces no warning`() {
        myFixture.configureByText(
            "Dockerfile",
            """
            FROM golang:1.21 AS builder
            RUN go build -o app

            FROM alpine:3.19
            COPY --from=builder /app /app
            """.trimIndent(),
        )
        val highlights = myFixture.doHighlighting()
        assertTrue(highlights.none { it.description?.contains("builder") == true })
    }

    fun `test a non-Dockerfile file is never scanned`() {
        myFixture.configureByText(
            "Notes.java",
            "String x = \"FROM golang AS builder\";",
        )
        val highlights = myFixture.doHighlighting()
        assertTrue(highlights.none { it.description?.contains("builder") == true })
    }
}
