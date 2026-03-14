# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Selenium + Cucumber BDD test automation project for [veo.az](https://veo.az/), a video creation platform. Tests are written in Java 17 using the Page Object Model (POM) pattern.

## Commands

**Run all tests:**
```bash
mvn clean test
```

**Run a single feature via its Runner class (e.g., Login):**
```bash
mvn test -Dtest=LoginRunner
```

**Run the full suite (all features in order):**
```bash
mvn test -Dtest=VeoAz
```

**Run headless (used in CI):**
```bash
HEADLESS=true mvn clean test
```

## Architecture

### Layer Structure

```
config/         - WebDriver singleton, Cucumber Hooks, ExtentReports manager
pages/          - Page Object classes (one per page/feature area)
stepDefinition/ - Cucumber step implementations (one per feature)
runners/        - JUnit @CucumberOptions runners (one per feature)
suite/          - VeoAz.java aggregates all runners into one full suite
src/test/java/features/ - Gherkin .feature files (one per runner)
```

### Key Design Decisions

- **`WebDriverManager`** (config package) is a singleton that returns a shared `ChromeDriver`. It reads `HEADLESS=true` env var to run headlessly in CI.
- **`BasePage`** is the superclass for all page objects. It wraps common Selenium actions (`waitAndClick`, `waitAndSendKeys`, `scrollToElement`, etc.) with explicit `WebDriverWait` (10s default) and JS fallbacks.
- **`ExtentManager`** generates an HTML report at `target/ExtentReport.html`. `Hooks.java` logs pass/fail per scenario via `@Before`/`@After`.
- **`SoftAssert`** (TestNG) is used in step definitions — assertions accumulate but don't fail immediately mid-step.
- Each feature has exactly one corresponding: `.feature` file → `*Step.java` → `*Page.java` → `*Runner.java`.

### Adding a New Feature

1. Create `src/test/java/features/Foo.feature` with a tag (`@Foo`).
2. Create `pages/FooPage.java` extending `BasePage`.
3. Create `stepDefinition/FooStep.java` with `@Given`/`@When`/`@Then` methods.
4. Create `runners/FooRunner.java` with `@CucumberOptions` pointing to the feature and glue `{"stepDefinition","config"}`.
5. Add `FooRunner.class` to the `@Suite.SuiteClasses` list in `suite/VeoAz.java`.

### Reports

- **ExtentReports HTML:** `target/ExtentReport.html`
- **Cucumber JSON:** `target/cucumber-reports/json/`
- **Cucumber HTML:** `target/cucumber-reports/html/`
