# MemDogs
[![CI](https://github.com/jonathanliem94/MemDogs/actions/workflows/ci_cd.yml/badge.svg)](https://github.com/jonathanliem94/MemDogs/actions/workflows/ci_cd.yml)

## Use Case
An app to help remember/identify which dog is what breed

### API used
https://dog.ceo/dog-api/about

## Details
- Single Activity
- Compose UI
- Material UI
- HTTP Client: [Retrofit](https://github.com/square/retrofit)
- Logging: [Timber](https://github.com/JakeWharton/timber)
- Image Loading: [Coil](https://github.com/coil-kt/coil)
- Dependency Injection: [Hilt](https://dagger.dev/hilt/)
- Barebones CI with Github Actions
- Unit testing with JUnit
- Instrumented testing with [Maestro](https://www.maestro.dev/)

To run instrumented tests, install Maestro and run:
`maestro test maestro/test.yaml`

## Improvement
- Handle case when APIs error out
- Improve Reference List UI
- Improve Memory Test UI
  - Loader UI when image loads
  - Multiple ways to guess dog breeds: MCQ or Input text
