# Cleaning Schedule Backup Sync
> This project was created to backup the [Home Page Api Cleaning Schedule database](https://home-page-api.ryan-brock.com/cleaning-schedule) <br/>
> [Live - Cleaning Schedule Website](https://cleaning-schedule.ryan-brock.com/)

---

## 📚 Table of Contents

- [What's My Purpose?](#-whats-my-purpose)
- [How to Use](#-how-to-use)
- [Technologies](#-technologies)
- [Getting Started (Local Setup)](#-getting-started-local-setup)
  - [Run Locally](#run-locally)
  - [Build](#build)

---

## 🧠 What's My Purpose?

This is a kotlin command line application was created to backup the [Home Page Api Cleaning Schedule database](https://home-page-api.ryan-brock.com/cleaning-schedule) with [cleaning-schedule-database](https://github.com/rbrock44/cleaning-schedule-database).

---

## 🚦 How to Use

There's a [dailyRun.sh](/scripts/dailyRun.sh) file that should be hooked up to a cron job or task scheduler. It's dependend on [cleaning-schedule-database](https://github.com/rbrock44/cleaning-schedule-database) and this repo being in the `c:\workspace` directory and will update the database on the interval set
---

## 🛠 Technologies

- Framework: `Kotlin 1.7`
- Testing: `JUnit`

---

## 🚀 Getting Started (Local Setup)

* Install [jdk8](https://openjdk.org/projects/jdk8/)
* Clone [repo](https://github.com/rbrock44/cleaning-schedule-backup-sync)

---

### Run Locally

```
gradlew run
```

---

### Build

Run `gradlew build` to build the project. The build artifacts will be stored in the `build/` directory.

---
