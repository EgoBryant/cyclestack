# CycleStack — PROJECT_RULES.md

# Project Vision

CycleStack is a premium Android application for tracking supplement cycles.

The goal is not simply to store data.

The goal is to build the best supplement tracker available on Google Play.

The application should feel:

- minimal
- premium
- calm
- modern
- fast
- effortless

Inspired by:

- Google Health
- TickTick
- Apple Health
- Notion
- Finch
- Calm

---

# Technology

Language

- Kotlin

UI

- Jetpack Compose
- Material 3

Architecture

- MVVM (introduced gradually)

Future

- Room
- Navigation Compose
- WorkManager
- DataStore
- Hilt
- Kotlin Coroutines
- Flow

---

# Development Principles

Always prefer:

✔ small commits

✔ reusable components

✔ readable code

✔ consistency

✔ simple architecture

Avoid:

✘ duplicated UI

✘ duplicated business logic

✘ unnecessary abstractions

✘ overengineering

✘ large refactoring unless requested

---

# File Modification Rules

Unless explicitly requested:

Do NOT

- rename packages

- rename files

- move files

- modify unrelated files

- change Gradle configuration

- introduce new libraries

Each task should modify as few files as possible.

Target:

1–5 modified files.

---

# UI Philosophy

The application should NOT look like a tutorial project.

The application should feel like a polished 2026 product.

Use:

- generous spacing

- rounded corners

- large typography

- clean layouts

- minimal visual noise

Every screen should be usable with one hand.

---

# Design System

Always use reusable components.

Preferred components:

PrimaryButton

SecondaryButton

AppCard

AppTopBar

ScreenHeader

AppTextField

SectionTitle

EmptyState

LoadingView

Do NOT duplicate UI.

If similar UI appears twice,

extract a reusable component.

---

# Spacing

Never hardcode spacing.

Use AppDimensions.

Example:

ScreenPadding

CardPadding

SectionSpacing

FieldSpacing

ButtonHeight

Small

Medium

Large

---

# Colors

The application should use calm colors.

Avoid saturated Material defaults.

Primary

Forest Green

#3E7B5D

Secondary

Soft Mint

#DDEFE5

Background

#FAFAFA

Cards

White

---

# Typography

Hierarchy matters.

Large title

Screen title

Section title

Body

Caption

Avoid random font sizes.

---

# Components

Components should be:

Reusable

Small

Focused

Easy to preview

If a composable exceeds roughly 150 lines,

consider splitting it.

---

# Screens

Each screen should have one responsibility.

Example:

TodayScreen

AddSupplementScreen

InventoryScreen

SettingsScreen

Avoid putting unrelated UI together.

---

# State

For now

remember()

Later

ViewModel

StateFlow

Room

Never introduce ViewModels unless requested.

---

# Business Logic

UI first.

Persistence later.

Notifications later.

AI later.

Keep features incremental.

---

# Git Workflow

Every completed task:

Build

Run

Test

Commit

Push

Small commits are preferred.

Commit message examples:

Create Today screen

Add reusable AppCard

Implement Add Supplement screen

Improve UI spacing

Extract PrimaryButton

---

# AI Assistant Rules

When implementing a task:

1.

Read these rules first.

2.

Modify as few files as possible.

3.

Create reusable UI.

4.

Do not refactor unrelated code.

5.

Explain every modified file.

6.

If something is unclear,

ask instead of guessing.

7.

Prefer consistency over cleverness.

---

# Code Quality

Prefer

simple

clean

predictable

code.

Readable code is more important than smart code.

---

# Goal

Every change should move CycleStack closer to becoming

the best supplement tracking app on Android.